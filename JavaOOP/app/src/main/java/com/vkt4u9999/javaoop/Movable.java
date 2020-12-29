package com.vkt4u9999.javaoop;

import android.util.Log;

public interface Movable {

    int moveSpeed= 100;

    default void catGrow(){
        Log.i("catGrow","The cat is grow high!");
    }
}
