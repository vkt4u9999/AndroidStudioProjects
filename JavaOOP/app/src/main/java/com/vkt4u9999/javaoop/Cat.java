package com.vkt4u9999.javaoop;

import android.util.Log;

public class Cat extends Animal implements Movable {

    static int weight = 0;
    static int age = 0;
    static String color = "black";


    public Cat(int weight, int age, String color) {
        this.weight = weight;
        this.age = age;
        this.color = color;
    }

    @Override
    void breathe() {

    }

    public void talk() {
        Log.i("talk", "I'm talking with u!!");
    }

    public Cat() {

    }

    void catchMouse() {

        class Mouse {
            int weight;
            int age;
            String color;

            public Mouse(int weight, int age, String color) {
                this.weight = weight;
                this.age = age;
                this.color = color;
            }
        }
        Mouse mouse = new Mouse(1, 3, "white");

        if (mouse.weight <= Cat.weight && mouse.age < Cat.age) {
            Log.i("catch", " Im eat uuuuuuuu!!!Meow!!!");
        } else {
            Log.i("catch", " I cant eat u ");
        }
    }

}


