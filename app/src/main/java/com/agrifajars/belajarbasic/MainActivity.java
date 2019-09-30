package com.agrifajars.belajarbasic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.agrifajars.belajarbasic.activity.student.StudentActivity;
import com.agrifajars.belajarbasic.helper.DataConfig;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;
//    @BindView(R.id.etEmail)
//    TextInputLayout etEmail;
//    @BindView(R.id.etPassword)
//    TextInputLayout etPassword;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

//    @OnClick(R.id.btnLogin)
//    public void onViewClicked() {
//        DataConfig.setLogin(this);
//        intent = new Intent(MainActivity.this, StudentActivity.class);
//        startActivity(intent);
//    }

    @OnClick({R.id.etEmail, R.id.etPassword, R.id.btnLogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                if (etEmail.getText().toString().isEmpty() && etPassword.getText().toString().isEmpty()){
                    Toast.makeText(this, "Kosong Tjuy", Toast.LENGTH_SHORT).show();
                }else{
                    DataConfig.setLogin(this);
                    intent = new Intent(MainActivity.this, StudentActivity.class);
                    Toast.makeText(this, "Selamat Datang!", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                break;
        }
    }
}
