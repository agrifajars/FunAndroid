package com.agrifajars.belajarbasic.database;

import com.agrifajars.belajarbasic.database.query.StudentDao;
import com.agrifajars.belajarbasic.database.table.StudentEntity;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {StudentEntity.class}, version = 1)

public abstract class DataHelper extends RoomDatabase {
    public abstract StudentDao studentDao();
}
