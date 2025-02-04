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

class RegisterActivity : AppCompatActivity() {

    lateinit var userNameEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var saveButton: Button
    lateinit var emailEditText: EditText
    lateinit var ageEditText:EditText
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userNameEditText=findViewById(R.id.userName)
        passwordEditText=findViewById(R.id.password)
        saveButton=findViewById(R.id.saveButton)
        emailEditText = findViewById(R.id.email)
        ageEditText=findViewById(R.id.age)
        sharedPreferences = getSharedPreferences("userDetails", MODE_PRIVATE)
        saveButton.setOnClickListener {
            init()
            //val intent= Intent(this,LoginActivity::class.java)
            //startActivity(intent)
        }
    }
    fun init()
    {
        val username=userNameEditText.text.toString()
        val password=passwordEditText.text.toString()
        val email=emailEditText.text.toString()
        val age=ageEditText.text.toString().toInt()
        val editor=sharedPreferences.edit()
        editor.putString("username",username)
        editor.putString("password",password)
        editor.putString("email",email)
        editor.putInt("age",age)
        editor.apply()
        Toast.makeText(this,"saved successfully",Toast.LENGTH_SHORT).show()
        finish()
    }
}