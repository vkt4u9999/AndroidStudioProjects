package com.vkt4u9999.carsdb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import Data.DatabaseHandler;
import Model.Car;
import Utils.Util;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DatabaseHandler databaseHandler=new DatabaseHandler(this);

        Log.i("CARSCOUNT",String.valueOf(databaseHandler.getCarsCount()) );

       /* databaseHandler.addCar(new Car("Toyota","30000"));
        databaseHandler.addCar(new Car("Opel","25000"));
        databaseHandler.addCar(new Car("Mazda","32000"));
        databaseHandler.addCar(new Car("Mercedes","50000"));*/

        List<Car> carList= databaseHandler.getAllCars();

        //Car deletingCar= databaseHandler.getCar(7);
        //databaseHandler.deleteCar(deletingCar);

        for (Car car : carList){
            Log.i("Car Info", "ID "+ car.getId()+ " name "+ car.getName()+ " price "+ car.getPrice());
        }

/*
        Car car= databaseHandler.getCar(1);


        car.setName("Tesla");
        car.setPrice("50000");

        databaseHandler.updateCar(car);
        Log.i("Car Info", "ID "+ car.getId()+ ", name "+ car.getName()+ " price "+ car.getPrice());*/
    }
}