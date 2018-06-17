package com.example.monel.kotlinsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val firstIndexOfWhitespace = firstWhitespace("j kgakkg")
        Log.d(TAG, "DEBUG--:firstWhitespace->$firstIndexOfWhitespace")

    }

    private fun first(str: String, predicate: (Char) -> Boolean): Int {
        // ローカル関数goを定義
        // 末尾再帰として最適化 -> tailrec
        tailrec fun go(str: String, index: Int): Int =
                when {
                    str.isEmpty() -> 1
                    predicate(str.first()) -> index
                    else -> go(str.drop(1), index + 1)
                }
        return go(str, 0)
    }

    private fun firstWhitespace(str: String): Int {
        val isWhitespace: (Char) -> Boolean = {
            it.isWhitespace()
        }
        return first(str, isWhitespace)
    }

    // 今回の例ではisWhitespaceという名前をわざわざつける必要がないので
    // 以下のようにする
//    private fun firstWhitespace(str: String): Int = first(str, {it.isWhitespace()})


    // 引数の最後にラムダ式があるときに限ってラムダ式を引数リストの外にだせる
    // 構文糖衣(シンタックスシュガー)が提供されている
    // 構文糖衣とはなんぞや？調べておく
//    private fun firstWhitespace(str: String): Int = first(str) {it.isWhitespace()}


}
