package com.example.callerapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    lateinit var userNameEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var loginButton: Button
    lateinit var registerTextView:TextView
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        userNameEditText=findViewById(R.id.userName)
        passwordEditText=findViewById(R.id.password)
        loginButton=findViewById(R.id.loginButton)
        registerTextView = findViewById(R.id.registerTextView)
        sharedPreferences = getSharedPreferences("userDetails", MODE_PRIVATE)

        registerTextView.setOnClickListener {
            val intent=Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            val username=userNameEditText.text.toString()
            val password=passwordEditText.text.toString()
            validate(username, password)
        }
    }
    fun validate(username:String,password:String)
    {
        val validateusername=sharedPreferences.getString("username","")
        val validatepassword=sharedPreferences.getString("password","")

        if(username==validateusername&& password==validatepassword) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"Login successful",Toast.LENGTH_SHORT).show()
        }
        else
            Toast.makeText(this,"Invalid Login",Toast.LENGTH_SHORT).show()
    }
}