package com.vkt4u9999.mydb.Data;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.vkt4u9999.mydb.Model.Component;

import java.util.List;

@Dao
public interface ComponentDAO  {

@Insert
public long addComponent(Component component);

@Update
    public void updateComponent(Component component);

@Delete
    public void deleteComponent(Component component);

    @Query("select * from components")
    public List<Component> getAllComponents();

    @Query("select * from components where component_id ==:component_id ")
    public Component getComponent(long component_id);
}
