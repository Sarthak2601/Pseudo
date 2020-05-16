package com.sarthak.pseudo

import android.content.Context
import android.util.Log
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore
import java.lang.Exception


class CrashlyticsWrapper {

    val firebaseCrashlytics: FirebaseCrashlytics = FirebaseCrashlytics.getInstance()

    fun logException(exception: Exception){
        firebaseCrashlytics.recordException(exception)
        Log.i("LOGGING", "Record Exception")
    }

    fun logMessage(message: String, firebaseCrashlytics: FirebaseCrashlytics){
        firebaseCrashlytics.log(message)
    }

}