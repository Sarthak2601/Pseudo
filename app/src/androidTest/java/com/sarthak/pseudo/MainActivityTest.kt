package com.sarthak.pseudo

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import org.junit.After
import org.junit.Before


import org.junit.Assert.*
import org.junit.Test

class MainActivityTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testCrashlyticsCall(){
        ActivityScenario.launch<MainActivity>(MainActivity::class.java).use{
            Espresso.onView(ViewMatchers.withId(R.id.button)).perform(click())
        }
    }
}