package com.sarthak.pseudo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.MalformedJsonException
import android.widget.Toast
import com.google.firebase.crashlytics.FirebaseCrashlytics
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val crashlyticsWrapper : CrashlyticsWrapper = CrashlyticsWrapper()
    val exception: Exception = Exception()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseCrashlytics.getInstance()
        button.setOnClickListener {
            try {
                throw Exception("Test Malformed Exception Enabled")
            }
            catch (exception: Exception){
                crashlyticsWrapper.logException(exception)
                Log.i("EXCEPTION", exception.toString())
            }
        }

    }
}