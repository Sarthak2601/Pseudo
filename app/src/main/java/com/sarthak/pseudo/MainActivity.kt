package com.sarthak.pseudo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.MalformedJsonException
import android.widget.Button
import android.widget.Toast
import com.google.firebase.crashlytics.FirebaseCrashlytics
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.Exception

class MainActivity : AppCompatActivity() {

    private val crashlyticsWrapper : CrashlyticsWrapper = CrashlyticsWrapper()
    private val analyticsWrapper = AnalyticsWrapper()
    private val customExceptions = CustomExceptions()
    val exception: Exception = Exception()

    private val eventValue:String = "Button Press"
    private val buttonId: Int = R.id.buttonAnalytics
    private val screenName: String = "Main Screen"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firebaseCrashlytics = FirebaseCrashlytics.getInstance()
        button.setOnClickListener {
            try {
                throw Exception("Test Malformed Exception Enabled")
            }
            catch (exception: Exception){
                crashlyticsWrapper.logException(exception, firebaseCrashlytics)
                Log.i("EXCEPTION", exception.toString())
            }
        }
        buttonAnalytics.setOnClickListener {
            analyticsWrapper.event_recording_button_click(eventValue, buttonId, screenName, this)
        }

        buttonException.setOnClickListener {
           try {
               throw Exception()
           }
           catch (exception : Exception){
               customExceptions.storeException(exception.message, exception.stackTrace, exception.cause)
           }
        }

        buttonExceptionDisplay.setOnClickListener {
            customExceptions.createException()
        }
    }
}
