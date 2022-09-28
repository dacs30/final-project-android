package com.example.final_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.final_project.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

private lateinit var binding: ActivityMainBinding
private lateinit var firebaseAuth: FirebaseAuth


class MainActivity : AppCompatActivity() {

    lateinit var signout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        val email:String = intent.getStringExtra("USER_EMAIL").toString()

        binding.email.setText(email)

        binding.signout.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            intent.putExtra("LAST_USER_LOGGED", email)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            firebaseAuth.signOut()
            finish()
        }



    }
}