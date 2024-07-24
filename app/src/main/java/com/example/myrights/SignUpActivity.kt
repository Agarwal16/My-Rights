package com.example.myrights

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myrights.model.HelperClass
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {
    private var signupName: EditText? = null
    private var signupUsername: EditText? = null
    private var signupEmail: EditText? = null
    private var signupPassword: EditText? = null
    private var loginRedirectText: TextView? = null
    private var signupButton: Button? = null
    private var database: FirebaseDatabase? = null
    private var reference: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        signupName = findViewById<EditText>(R.id.signup_name)
        signupEmail = findViewById<EditText>(R.id.signup_email)
        signupUsername = findViewById<EditText>(R.id.signup_username)
        signupPassword = findViewById<EditText>(R.id.signup_password)
        loginRedirectText = findViewById<TextView>(R.id.loginRedirectText)
        signupButton = findViewById<Button>(R.id.signup_button)

        signupButton?.setOnClickListener(View.OnClickListener {
            database = FirebaseDatabase.getInstance()
            reference = database!!.getReference("users")
            val name = signupName?.getText().toString()
            val email = signupEmail?.getText().toString()
            val username = signupUsername?.getText().toString()
            val password = signupPassword?.getText().toString()
            val helperClass = HelperClass(name, email, username, password)
            reference!!.child(username).setValue(helperClass)
            Toast.makeText(this@SignUpActivity, "You have signup successfully!", Toast.LENGTH_SHORT)
                .show()
            val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)
        })
        loginRedirectText?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)
        })
    }
}