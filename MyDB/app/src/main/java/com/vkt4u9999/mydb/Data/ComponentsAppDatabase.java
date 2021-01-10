package com.vkt4u9999.mydb.Data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.vkt4u9999.mydb.Model.Component;

@Database(entities = {Component.class}, version = 1)
public abstract class ComponentsAppDatabase extends RoomDatabase {
    public abstract ComponentDAO getComponentDAO();
}
