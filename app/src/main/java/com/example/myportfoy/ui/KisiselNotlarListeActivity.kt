package com.example.myportfoy.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myportfoy.adapter.NotlarAdapter
import com.example.myportfoy.databinding.ActivityKisiselNotlarListeBinding
import com.example.myportfoy.model.VerilerNot
import com.google.firebase.database.*

class KisiselNotlarListeActivity: AppCompatActivity() {


    private lateinit var knotlarlistebind: ActivityKisiselNotlarListeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        knotlarlistebind = ActivityKisiselNotlarListeBinding.inflate(layoutInflater)
        setContentView(knotlarlistebind.root)

        knotlarlistebind.recyclerviewNot.apply {
            this.layoutManager = LinearLayoutManager(this@KisiselNotlarListeActivity)

        }

        veriAl();

    }

    private fun veriAl() {

        lateinit var database: DatabaseReference

        database = FirebaseDatabase.getInstance().reference.child("Notlar")

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val posts = ArrayList<VerilerNot>()

                dataSnapshot.children.forEach {
                    it.getValue(VerilerNot::class.java)?.let {

                        posts.add(it)
                        Log.d("veriler", posts.toString())
                    }

                }
                val adapter = NotlarAdapter(posts) {

                    val intent =
                            Intent(this@KisiselNotlarListeActivity, NotDetayActivity::class.java)
                    intent.putExtra("veri", it)
                    startActivity(intent)

                }
                knotlarlistebind.recyclerviewNot.adapter = adapter
                adapter.notifyDataSetChanged()

            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

    }

    }
