package com.example.myportfoy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myportfoy.databinding.KisiselNotlarListeBinding
import com.google.firebase.database.*

class KisiselNotlarListe: AppCompatActivity() {


    private lateinit var knotlarlistebind: KisiselNotlarListeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        knotlarlistebind = KisiselNotlarListeBinding.inflate(layoutInflater)
        setContentView(knotlarlistebind.root)

        knotlarlistebind.recyclerview.apply {
            this.layoutManager = LinearLayoutManager(this@KisiselNotlarListe)

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
                            Intent(this@KisiselNotlarListe, NotDetay::class.java)
                    intent.putExtra("veri", it)
                    startActivity(intent)

                }
                knotlarlistebind.recyclerview.adapter = adapter
                adapter.notifyDataSetChanged()

            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

    }

    }
