package com.agrifajars.belajarbasic.database.query;

import com.agrifajars.belajarbasic.database.table.StudentEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface StudentDao {

    @Query("Select * from studententity")
    List<StudentEntity> select();

    @Insert
    void insert(StudentEntity entity);

    @Update
    void update(StudentEntity entity);

    @Delete
    void delete(StudentEntity entity);

}
