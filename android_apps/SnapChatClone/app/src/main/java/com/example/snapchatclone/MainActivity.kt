package com.example.snapchatclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    var userNameEditText:EditText?=null
    var emailEditText : EditText?=null
    var passwordEditText : EditText?=null
    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userNameEditText = findViewById(R.id.userNameEditText)
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText)

        if(mAuth.currentUser != null){
            login()
        }
    }

    fun goClicked(view: View){
        //Check if we can login the user

        mAuth.signInWithEmailAndPassword(emailEditText?.text.toString(), passwordEditText?.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    login();
                } else {
                    // Sign up user
                    mAuth.createUserWithEmailAndPassword(emailEditText?.text.toString(), passwordEditText?.text.toString())
                        .addOnCompleteListener(this) { task ->
                            if(task.isSuccessful){
                                //Add to database
                                FirebaseDatabase.getInstance().getReference().child("users").child(task.result!!.user?.uid!!).child("email").setValue(emailEditText?.text.toString())
                                FirebaseDatabase.getInstance().getReference().child("users").child(task.result!!.user?.uid!!).child("userName").setValue(userNameEditText?.text.toString())
                                login()
                            }else{
                                Toast.makeText(this,"Login failed. Try again", Toast.LENGTH_SHORT).show()
                            }
                        }
                }
            }
    }

    fun login(){
        //Move to next activity
        val intent = Intent(this, SnapsActivity::class.java)
        startActivity(intent)
    }
}