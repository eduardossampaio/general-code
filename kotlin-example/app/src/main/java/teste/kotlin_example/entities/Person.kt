package teste.kotlin_example.entities

import android.util.Log

/**
 * Created by Eduardo on 18/05/2017.
 */
class Person {
    var name = null;
    var age = null;

    fun sayName(){
        Log.d("KOTLIN","${name}");
    }
}