package com.example.callerapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Duration of the splash screen (e.g., 3000 milliseconds = 3 seconds)
        val splashScreenDuration = 3000L

        Handler(Looper.getMainLooper()).postDelayed({
            // Start the main activity after the splash screen
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, splashScreenDuration)
    }
}