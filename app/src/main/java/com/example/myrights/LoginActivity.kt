package com.example.myrights

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class LoginActivity : AppCompatActivity() {
    var loginUsername: EditText? = null
    var loginPassword: EditText? = null
    var loginButton: Button? = null
    var signupRedirectText: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginUsername = findViewById<EditText>(R.id.login_username)
        loginPassword = findViewById<EditText>(R.id.login_password)
        loginButton = findViewById<Button>(R.id.login_button)
        signupRedirectText = findViewById<TextView>(R.id.signupRedirectText)
        loginButton?.setOnClickListener(View.OnClickListener {
            if (!validateUsername() or !validatePassword()) {
            } else {
                checkUser()
            }
        })
        signupRedirectText?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)
        })
    }

    fun validateUsername(): Boolean {
        val `val` = loginUsername!!.text.toString()
        return if (`val`.isEmpty()) {
            loginUsername!!.error = "Username cannot be empty"
            false
        } else {
            loginUsername!!.error = null
            true
        }
    }

    fun validatePassword(): Boolean {
        val `val` = loginPassword!!.text.toString()
        return if (`val`.isEmpty()) {
            loginPassword!!.error = "Password cannot be empty"
            false
        } else {
            loginPassword!!.error = null
            true
        }
    }

    fun checkUser() {
        val userUsername = loginUsername!!.text.toString().trim { it <= ' ' }
        val userPassword = loginPassword!!.text.toString().trim { it <= ' ' }
        val reference = FirebaseDatabase.getInstance().getReference("users")
        val checkUserDatabase = reference.orderByChild("username").equalTo(userUsername)
        checkUserDatabase.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    loginUsername!!.error = null
                    val passwordFromDB = snapshot.child(userUsername).child("password").getValue(
                        String::class.java
                    )
                    if (passwordFromDB == userPassword) {
                        loginUsername!!.error = null
                        val nameFromDB = snapshot.child(userUsername).child("name").getValue(
                            String::class.java
                        )
                        val emailFromDB = snapshot.child(userUsername).child("email").getValue(
                            String::class.java
                        )
                        val usernameFromDB =
                            snapshot.child(userUsername).child("username").getValue(
                                String::class.java
                            )
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.putExtra("name", nameFromDB)
                        intent.putExtra("email", emailFromDB)
                        intent.putExtra("username", usernameFromDB)
                        intent.putExtra("password", passwordFromDB)
                        startActivity(intent)
                    } else {
                        loginPassword!!.error = "Invalid Credentials"
                        loginPassword!!.requestFocus()
                    }
                } else {
                    loginUsername!!.error = "User does not exist"
                    loginUsername!!.requestFocus()
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}