package com.sarthak.pseudo

import android.util.Log
import com.google.firebase.crashlytics.FirebaseCrashlytics
import java.lang.Exception


public open class CrashlyticsWrapper {

    val firebaseCrashlytics: FirebaseCrashlytics = FirebaseCrashlytics.getInstance()

    fun logException(exception: Exception, logMessage: String, firebaseCrashlytics: FirebaseCrashlytics ){
        logMessage(logMessage, firebaseCrashlytics)
        firebaseCrashlytics.recordException(exception)
        Log.i("LOGGING", "Record Exception")
    }

    fun logMessage(message: String, firebaseCrashlytics: FirebaseCrashlytics){
        firebaseCrashlytics.log(message)
    }

}

