package com.sarthak.pseudo

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

    @Mock
    private val crashlyticsWrapper = Mockito.mock(CrashlyticsWrapper::class.java)
    private val analyticsWrapper = Mockito.mock(AnalyticsWrapper::class.java)
    private val exception: Exception = Mockito.mock(Exception::class.java)
    private val firebaseCrashlytics = Mockito.mock(FirebaseCrashlytics::class.java)

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
}