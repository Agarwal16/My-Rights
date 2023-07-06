package com.example.myrights

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class EditProfile : AppCompatActivity() {
    var editName: EditText? = null
    var editEmail: EditText? = null
    var editUsername: EditText? = null
    var editPassword: EditText? = null
    var saveButton: Button? = null
    var nameUser: String? = null
    var emailUser: String? = null
    var usernameUser: String? = null
    var passwordUser: String? = null
    var reference: DatabaseReference? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        reference = FirebaseDatabase.getInstance().getReference("users")
        editName = findViewById<EditText>(R.id.editName)
        editEmail = findViewById<EditText>(R.id.editEmail)
        editUsername = findViewById<EditText>(R.id.editUsername)
        editPassword = findViewById<EditText>(R.id.editPassword)
        saveButton = findViewById<Button>(R.id.saveButton)
        showData()
        saveButton?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if (isNameChanged || isPasswordChanged || isEmailChanged) {
                    Toast.makeText(this@EditProfile, "Saved", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@EditProfile, "No Changes Found", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }

    private val isNameChanged: Boolean
        private get() = if (nameUser != editName!!.text.toString()) {
            reference!!.child(usernameUser!!).child("name").setValue(editName!!.text.toString())
            nameUser = editName!!.text.toString()
            true
        } else {
            false
        }
    private val isEmailChanged: Boolean
        private get() {
            return if (emailUser != editEmail!!.text.toString()) {
                reference!!.child(usernameUser!!).child("email")
                    .setValue(editEmail!!.text.toString())
                emailUser = editEmail!!.text.toString()
                true
            } else {
                false
            }
        }
    private val isPasswordChanged: Boolean
        private get() {
            return if (passwordUser != editPassword!!.text.toString()) {
                reference!!.child(usernameUser!!).child("password")
                    .setValue(editPassword!!.text.toString())
                passwordUser = editPassword!!.text.toString()
                true
            } else {
                false
            }
        }

    fun showData() {
        val intent = intent
        nameUser = intent.getStringExtra("name")
        emailUser = intent.getStringExtra("email")
        usernameUser = intent.getStringExtra("username")
        passwordUser = intent.getStringExtra("password")
        editName!!.setText(nameUser)
        editEmail!!.setText(emailUser)
        editUsername!!.setText(usernameUser)
        editPassword!!.setText(passwordUser)
    }
}