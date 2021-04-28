package com.example.snapchatclone

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL


class ViewSnapActivity : AppCompatActivity() {
    var messageTextView: TextView? = null
    var mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_snap)

        messageTextView = findViewById(R.id.messageTextView)
        var snapsImageView: ImageView = findViewById(R.id.snapImageView)

        messageTextView?.text = intent.getStringExtra("message")

        var url = intent.getStringExtra("imageUrl")
        Glide.with(this).load(url).dontAnimate().dontTransform().into(snapsImageView)
         //   Glide.with(.getContext()).load(url).placeholder(R.drawable.default_profile).dontAnimate().into(view);
    }

        /*val task = ImageDownoader()
        val myImage: Bitmap
        try {
            myImage = task.execute(intent.getStringExtra("imageUrl")).get()
            snapsImageView?.setImageBitmap(myImage)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    inner class ImageDownoader : AsyncTask<String, Void, Bitmap>() {
        override fun doInBackground(vararg urls: String?): Bitmap? {
            try {
                val url = URL(urls[0])
                val connection = url.openConnection() as HttpURLConnection
                connection.connect()
                val `is` = connection.inputStream
                return BitmapFactory.decodeStream(`is`)
            } catch (e: Exception) {
                e.printStackTrace()
                return null
            }
        }
    }*/

    override fun onBackPressed() {
        super.onBackPressed()

        intent.getStringExtra("snapKey")?.let { FirebaseDatabase.getInstance().getReference().child("users").child(mAuth?.currentUser!!.uid).child("snaps").child(it).removeValue() }
        intent.getStringExtra("imageName")?.let { FirebaseStorage.getInstance().getReference().child("Images").child(it).delete() }
    }
}
