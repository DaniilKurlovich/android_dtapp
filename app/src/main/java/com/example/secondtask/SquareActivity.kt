package com.example.secondtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main2.*

class SquareActivity : AppCompatActivity() {
    val TAG = "SquareActivity"
    companion object {
        const val TOTAL_COUNT = "total_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate called.")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        showSquare()
    }

    fun showSquare() {
        val count = intent.getIntExtra(TOTAL_COUNT, 0)
        val square = count * count;
        textView2.text = getString(R.string.text_second_activity, square)
        Log.d(TAG, "onCreate MainActivity called. Square value is $square")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "$TAG: onStart()");
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "$TAG: onResume()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "$TAG: onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "$TAG: onDestroy()")
    }

}