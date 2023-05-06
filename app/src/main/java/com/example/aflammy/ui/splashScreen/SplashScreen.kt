package com.example.aflammy.ui.splashScreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.aflammy.R
import com.example.aflammy.ui.main.MainActivity


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.setDisplayShowHomeEnabled(false);
        supportActionBar?.hide();

        Handler().postDelayed(Runnable { //This method will be executed once the timer is over
            // Start your app main activity
            val i = Intent(this@SplashScreen, OnBoardingScreen::class.java)
            startActivity(i)
            // close this activity
            finish()
        }, 3000)
    }


}