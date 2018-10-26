package com.example.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.greendao.dao.ExampleEntityDao;
import com.example.greendao.dao.StudentEntityDao;
import com.example.greendao.entity.StudentEntity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv;
    private Button btnInsert;
    private Button btnDelete;
    private Button btnUpdate;
    private Button btnSelect;
    private ExampleEntityDao exampleEntityDao;
    private StudentEntityDao studentEntityDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exampleEntityDao = MyApplication.getInstances().getDaoSession().getExampleEntityDao();
        studentEntityDao = MyApplication.getInstances().getDaoSession().getStudentEntityDao();
        initUI();
    }

    private void initUI() {
        btnInsert = (Button) findViewById(R.id.btnInsert);
        tv = (TextView) findViewById(R.id.tv);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnSelect = (Button) findViewById(R.id.btnQuery);
        btnDelete.setOnClickListener(this);
        btnInsert.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnSelect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnInsert:
                StudentEntity studentEntity1 = new StudentEntity(new Long(1234), "张1", 120);
                StudentEntity studentEntity2 = new StudentEntity(new Long(456), "张2", 200);
                StudentEntity studentEntity3 = new StudentEntity(new Long(789), "张3", 250);
                long insert1 = studentEntityDao.insert(studentEntity1);
                long insert2 = studentEntityDao.insert(studentEntity2);
                long insert3 = studentEntityDao.insert(studentEntity3);
                tv.setText("insert1:" + insert1 + "\n" + "insert2:" + insert2 + "\n" + "insert3:" + insert3);
                break;
            case R.id.btnUpdate:
                StudentEntity queryResult = studentEntityDao.queryBuilder().where(StudentEntityDao.Properties.Id.eq(1234)).build().unique();
                if (queryResult != null) {
                    queryResult.age = 999;
                }
                studentEntityDao.update(queryResult);
                StudentEntity queryResult1 = studentEntityDao.queryBuilder().where(StudentEntityDao.Properties.Id.eq(1234)).build().unique();
                tv.setText(queryResult1.toString());
                break;
            case R.id.btnDelete:
                studentEntityDao.delete(studentEntityDao.queryBuilder().where(StudentEntityDao.Properties.Id.eq(1234)).build().unique());
                StudentEntity s = studentEntityDao.queryBuilder().where(StudentEntityDao.Properties.Id.eq(1234)).build().unique();
                if(s!=null) {
                    tv.setText(s.toString() + "");
                }else {
                    tv.setText("null");
                }
                break;
            case R.id.btnQuery:
                List<StudentEntity> list = studentEntityDao.queryBuilder()
                        .where(StudentEntityDao.Properties.Id.notEq(1))
                        .orderAsc(StudentEntityDao.Properties.Id)
                        .limit(2)
                        .build().list();
                String result = "";
                for (int i = 0; i < list.size(); i++) {
                    result = result + "\n" + list.get(i).toString();
                }
                tv.setText(result);
                break;
        }
    }
}
