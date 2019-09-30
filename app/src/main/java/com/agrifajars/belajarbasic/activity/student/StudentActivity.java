package com.agrifajars.belajarbasic.activity.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import com.agrifajars.belajarbasic.MainActivity;
import com.agrifajars.belajarbasic.R;
import com.agrifajars.belajarbasic.activity.student.add.AddStudentActivity;
import com.agrifajars.belajarbasic.adapter.StudentEntityAdapter;
import com.agrifajars.belajarbasic.database.DataHelper;
import com.agrifajars.belajarbasic.helper.DataConfig;
import com.agrifajars.belajarbasic.model.Student;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StudentActivity extends AppCompatActivity {

    private Student student;
    private ArrayList<Student> list;
    private StudentEntityAdapter studentEntityAdapter;
    private DataHelper dataHelper;
    private Intent intent;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.btnGoToAdd)
    Button btnGoToAdd;
    @BindView(R.id.btnLogOut)
    Button btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        ButterKnife.bind(this);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
//        Toast.makeText(this, dataHelper.studentDao().select().get(0).getName(), Toast.LENGTH_SHORT).show();
//        student = new Student( "Agri fajar", "Islam", "L");
//        list = new ArrayList<>();
//
//        list.add(new Student("Jhon Thor", "Islam", "L"));
//        list.add(new Student("Jhon Thol", "Nudha", "p"));
//        list.add(new Student("Jhon jot", "kristen", "L"));
//
//        studentAdapter = new StudentAdapter(list);
//        recyclerView.setLayoutManager(new LinearLayoutManager( this));
//        recyclerView.setAdapter(studentAdapter);
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    protected void onResume() {
        super.onResume();
        dataHelper = Room.databaseBuilder(this, DataHelper.class, "school")
                .allowMainThreadQueries()
                .build();

        studentEntityAdapter = new StudentEntityAdapter(this, dataHelper.studentDao().select());
        recyclerView.setAdapter(studentEntityAdapter);
    }

    @OnClick({R.id.btnGoToAdd, R.id.btnLogOut})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnGoToAdd:
                startActivity(new Intent(this, AddStudentActivity.class));
                break;
            case R.id.btnLogOut:
                DataConfig.setLogout(this);
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
        }
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.example_menu, menu);
//
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) searchItem.getActionView();
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                studentEntityAdapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//
//        return true;
//    }
}