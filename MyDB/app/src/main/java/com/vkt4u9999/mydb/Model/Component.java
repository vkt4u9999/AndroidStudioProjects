package com.vkt4u9999.mydb.Model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "components")

public class Component {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name= "component_id")
    private long id;

    @ColumnInfo(name= "component_name")
    private String name;

    @ColumnInfo(name= "component_price")
    private String price;

    @Ignore
    public Component(){

    }

    @Ignore
    public Component(String name, String price){
        this.id=id;
        this.name=name;
        this.price=price;
    }

    public  Component(long id, String name, String price){
        this.name=name;
        this.price=price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
