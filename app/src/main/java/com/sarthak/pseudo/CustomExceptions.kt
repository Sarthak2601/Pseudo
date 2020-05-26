package com.sarthak.pseudo

import com.google.firebase.crashlytics.FirebaseCrashlytics

class CustomExceptions {

    private var errorMessage : String? = "null"
    private var errorSize : Int = 10
    private var declaringClass : String? = "null"
    private var methodName : String? = "null"
    private var fileName : String? = "null"
    private var lineNumber : Int = -1
    private var crashlyticsWrapper = CrashlyticsWrapper()

    private var errorStackTrace: Array<StackTraceElement> = Array(errorSize, init = {
            i: Int -> StackTraceElement(declaringClass,methodName,fileName,lineNumber) })
    private var cause: Throwable? = null

    fun createException(firebaseCrashlytics: FirebaseCrashlytics){
        var exception : Exception = Exception(errorMessage, cause)
        exception.stackTrace = errorStackTrace
        /*try {
            throw exception
        }
        catch (exception : Exception){
            exception.printStackTrace()
            crashlyticsWrapper.logException(exception, "TESTING", firebaseCrashlytics)
        }*/
        throw exception
    }

    fun storeException(message: String?, errorStackTrace: Array<StackTraceElement>, cause: Throwable?){
        this.errorMessage = message
        this.errorSize = errorStackTrace.size-1

        for(i in 0..errorSize){
            this.declaringClass = errorStackTrace[i].className
            this.methodName = errorStackTrace[i].methodName
            this.fileName = errorStackTrace[i].fileName
            this.lineNumber = errorStackTrace[i].lineNumber
            this.errorStackTrace[i]  = errorStackTrace[i]
        }
        this.cause = cause
    }
}