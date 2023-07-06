package com.example.myrights

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import com.example.myrights.databinding.ActivityProfileBinding
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Profile : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var reference: DatabaseReference
    private val PICK_IMAGE_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cameraIcon.setOnClickListener {
            val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST)
        }

        binding.editButton.setOnClickListener {
            passUserData()
        }

        showAllUserData()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val imageUri = data.data
            binding.profileImage.setImageURI(imageUri)
        }
    }

    private fun showAllUserData() {
        val intent = intent
        val nameUser = intent.getStringExtra("name")
        val emailUser = intent.getStringExtra("email")
        val usernameUser = intent.getStringExtra("username")

        binding.titleName.text = nameUser
        binding.titleUsername.text = usernameUser
        binding.profileName.text = nameUser
        binding.profileEmail.text = emailUser
        binding.profileUsername.text = usernameUser
    }

    private fun passUserData() {
        val userUsername = binding.profileUsername.text.toString().trim()

        reference = Firebase.database.getReference("users")
        val query = reference.orderByChild("username").equalTo(userUsername)

        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val userSnapshot = snapshot.children.first()

                    val nameFromDB = userSnapshot.child("name").getValue(String::class.java)
                    val emailFromDB = userSnapshot.child("email").getValue(String::class.java)
                    val usernameFromDB = userSnapshot.child("username").getValue(String::class.java)

                    val intent = Intent(this@Profile, EditProfile::class.java)
                    intent.putExtra("name", nameFromDB)
                    intent.putExtra("email", emailFromDB)
                    intent.putExtra("username", usernameFromDB)
                    startActivity(intent)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle the error
            }
        })
    }



}
