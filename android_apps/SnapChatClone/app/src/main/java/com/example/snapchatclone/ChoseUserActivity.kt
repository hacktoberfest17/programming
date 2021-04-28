package com.example.snapchatclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.firebase.FirebaseError
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

class ChoseUserActivity : AppCompatActivity() {
    var chooseUserListView: ListView? = null
    var emailsArrayList:ArrayList<String> = ArrayList()
    var userNameArrayList:ArrayList<String> = ArrayList()
    var keys:ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chose_user)

        chooseUserListView = findViewById(R.id.chooseUserListView)
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,userNameArrayList)
        chooseUserListView?.adapter = arrayAdapter

        var userName = "";
        FirebaseDatabase.getInstance().getReference().child("users").addChildEventListener(object :ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                userName = snapshot?.child("userName")?.value as String
                userNameArrayList.add(userName)
                keys.add(snapshot.key.toString())
                arrayAdapter.notifyDataSetChanged()
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onChildRemoved(snapshot: DataSnapshot) {}
            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onCancelled(error: DatabaseError) {}
        })
        chooseUserListView?.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val snapMap: Any = mapOf("from" to userName, "imageName" to intent.getStringExtra("imageName"), "imageUrl" to intent.getStringExtra("imageUrl"), "message" to intent.getStringExtra("message")) as Any
            FirebaseDatabase.getInstance().getReference().child("users").child(keys.get(position)).child("snaps").push().setValue(snapMap)

            val intent = Intent(this,SnapsActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

    }



}

