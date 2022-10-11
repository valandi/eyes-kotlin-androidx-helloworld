package com.example.helloworld

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.applitools.eyes.android.components.androidx.AndroidXComponentsProvider

import com.applitools.eyes.android.espresso.Eyes
import com.applitools.eyes.android.espresso.fluent.Target
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun beforeTest() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun useAppContext() {
        val eyes = Eyes()
        eyes.componentsProvider = AndroidXComponentsProvider()

        try {
            eyes.open("Hello World!", "My first Espresso Android test!");
            eyes.check(Target.window().withName("Hello World"))
        }
        finally {
            eyes.close()
            eyes.abortIfNotClosed()
        }
    }

    @After
    fun cleanup() {
        scenario.close()
    }
}