package com.sarthak.pseudo

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

class AnalyticsWrapper {
    private var bundle: Bundle = Bundle()
    private var eventValue:String? = null
    private var buttonId: Int? = null
    private var screenName: String? = null

    private fun event_reporting(bundle: Bundle, context: Context, title: String){
        eventValue = bundle.getString("Event_value")
        buttonId = bundle.getInt("Button_id")
        screenName = bundle.getString("Screen_name")

        FirebaseAnalytics.getInstance(context).logEvent(title, bundle)
    }

    fun event_recording_button_click(eventValue:String, buttonId: Int, screenName: String, context: Context){
        val title = "Button_Click"
        bundle = bundleMaker(eventValue, buttonId, screenName)
        event_reporting(bundle, context, title)
    }

    private fun bundleMaker(eventValue:String, buttonId: Int, screenName: String): Bundle{

        var bundle = Bundle()
        bundle.putString("Event_value",eventValue)
        bundle.putInt("Button_id",buttonId)
        bundle.putString("Screen_name",screenName)
        return bundle

    }
}