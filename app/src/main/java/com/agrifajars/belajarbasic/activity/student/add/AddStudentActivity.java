package com.agrifajars.belajarbasic.activity.student.add;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.agrifajars.belajarbasic.R;
import com.agrifajars.belajarbasic.database.DataHelper;
import com.agrifajars.belajarbasic.database.table.StudentEntity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddStudentActivity extends AppCompatActivity {

    @BindView(R.id.etNis)
    EditText etNis;
    @BindView(R.id.etNama)
    EditText etNama;
    @BindView(R.id.btnSave)
    Button btnSave;

    private DataHelper dataHelper;
    private StudentEntity studentEntity, datas;
    private String DB_NAME = "school";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_add);
        ButterKnife.bind(this);

        dataHelper = Room.databaseBuilder(this, DataHelper.class, DB_NAME)
                .allowMainThreadQueries()
                .build();

        datas = (StudentEntity) getIntent().getSerializableExtra("datas");

        if (datas != null){
            etNis.setText(datas.getNis());
            etNama.setText(datas.getName());

            btnSave.setText("Update");
        }
    }

    @OnClick(R.id.btnSave)
    public void onViewClicked() {
        if (datas != null){
            datas.setNis(etNis.getText().toString());
            datas.setName(etNama.getText().toString());

            dataHelper.studentDao().update(datas);
            Toast.makeText(this, "Berhasil Merubah Data !", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            studentEntity = new StudentEntity();
            studentEntity.setNis(etNis.getText().toString());
            studentEntity.setName(etNama.getText().toString());

            EditText etNis = (EditText) findViewById(R.id.etNis);
            String strNis = etNis.getText().toString();

            EditText etName = (EditText) findViewById(R.id.etNama);
            String strName = etName.getText().toString();

            if(TextUtils.isEmpty(strNis) && TextUtils.isEmpty(strName)){
                etNis.setError("ISI DULU !");
                etName.setError("ISI DULU !");
                return;
            } else if(TextUtils.isEmpty(strNis) || TextUtils.isEmpty(strName)){
                etNis.setError("Nis / Nama Kosong !!!");
                etName.setError("Nis / Nama Kosong !!!");
                return;
            } else {
                dataHelper.studentDao().insert(studentEntity);
                Toast.makeText(this, "Berhasil Menambahkan Data !", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}
