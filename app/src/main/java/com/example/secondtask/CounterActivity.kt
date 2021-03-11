package com.example.secondtask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class CounterActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var MAIN_COUNTER: Counter

    data class Counter(val count: Int = 0) {
        operator fun plus(increment: Int): Counter {
            return Counter(count + increment)
        }
        operator fun inc(): Counter {
            return plus(1)
        }
    }

    fun showSecondActivity(view: View) {
        val squareIntent = Intent(this, SquareActivity::class.java)
        squareIntent.putExtra(SquareActivity.TOTAL_COUNT, MAIN_COUNTER.count)
        startActivity(squareIntent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate MainActivity called.")

        if (savedInstanceState?.containsKey("GLOBAL_COUNT") == true) {
            MAIN_COUNTER = Counter(savedInstanceState["GLOBAL_COUNT"] as Int)
            MAIN_COUNTER++
        } else {
            MAIN_COUNTER = Counter()
        }

        Log.d(TAG,"Count value ${MAIN_COUNTER.count}")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.text = MAIN_COUNTER.count.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putInt("GLOBAL_COUNT", MAIN_COUNTER.count)
        }
        super.onSaveInstanceState(outState)
        Log.i(TAG, "Counter was saved in bundle. $outState")
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


