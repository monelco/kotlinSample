package com.example.monel.kotlinsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ints: List<Long> = listOf<Long>(1,2,3)
        val sumInts1 = sum1(ints)
        val sumInts2 = sum2(ints)

        Log.d(TAG, "DEBUG--:sumInts1->$sumInts1")
        Log.d(TAG, "DEBUG--:sumInts2->$sumInts2")

    }

    private fun sum1(numbers: List<Long>): Long {
        var sum = 0L
        for (n in numbers) {
            sum += n
        }
        return sum
    }

    private fun sum2(numbers: List<Long>): Long =
            if (numbers.isEmpty()) 0
            else numbers.first() + sum2(numbers.drop(1))

//    private fun succ(i: Int): Int = i + 1
//
//    private fun hello(name: String = "World"): String {
//        return "Hello, $name"
//    }

//    private fun sum(ints: Array<Int>): Int {
//        var sum = 0
//        for (i in ints) {
//            sum += 1
//        }
//        return sum
//    }

//    private fun sum(vararg ints: Int): Int {
//        var sum = 0
//        for (i in ints) {
//            sum += 1
//        }
//        return sum
//    }

}
