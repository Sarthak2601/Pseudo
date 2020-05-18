package com.sarthak.pseudo

import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.google.firebase.crashlytics.FirebaseCrashlytics
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import java.lang.Exception

class MainActivityTest {

    private val eventValue:String = "Button Press"
    private val buttonId: Int = R.id.buttonAnalytics
    private val screenName: String = "Main Screen"

    @Mock
    private val crashlyticsWrapper = Mockito.mock(CrashlyticsWrapper::class.java)
    private val analyticsWrapper = Mockito.mock(AnalyticsWrapper::class.java)
    private val exception: Exception = Mockito.mock(Exception::class.java)
    private val firebaseCrashlytics = Mockito.mock(FirebaseCrashlytics::class.java)
    private val context = Mockito.mock(Context::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testCrashlyticsCall(){
        ActivityScenario.launch<MainActivity>(MainActivity::class.java).use{
            onView(withId(R.id.button)).perform(click())
            Mockito.verify(crashlyticsWrapper, Mockito.atLeastOnce()).logException(exception, firebaseCrashlytics)
        }
    }

    @Test
    fun testAnalyticsCall(){
        ActivityScenario.launch<MainActivity>(MainActivity::class.java).use{
            onView(withId(R.id.buttonAnalytics)).perform(click())
            Mockito.verify(analyticsWrapper, Mockito.atLeastOnce()).event_recording_button_click(eventValue,buttonId,screenName, context)
        }
    }
}