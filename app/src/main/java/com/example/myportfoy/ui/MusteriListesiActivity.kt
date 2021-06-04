package com.example.myportfoy.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myportfoy.adapter.KayitAdapter
import com.example.myportfoy.databinding.ActivityMusteriListesiBinding
import com.example.myportfoy.model.VerilerKayit
import com.google.firebase.database.*

class MusteriListesiActivity: AppCompatActivity() {

    private lateinit var mlistesibind: ActivityMusteriListesiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mlistesibind = ActivityMusteriListesiBinding.inflate(layoutInflater)
        setContentView(mlistesibind.root)


        mlistesibind.recyclerviewKayit.apply {
            this.layoutManager = LinearLayoutManager(this@MusteriListesiActivity)

        }

        veriGetir();

        }

        private fun veriGetir() {

            lateinit var database: DatabaseReference

            database = FirebaseDatabase.getInstance().reference.child("YeniKayıt")

            database.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val posts = ArrayList<VerilerKayit>()

                    dataSnapshot.children.forEach {
                       it.getValue(VerilerKayit::class.java)?.let {

                            posts.add(it)
                            Log.d("veriler", posts.toString())
                        }

                    }
                    val adapter = KayitAdapter(posts) {

                        val intent =
                                Intent(this@MusteriListesiActivity, KayitDetayActivity::class.java)
                        intent.putExtra("veri", it)
                        startActivity(intent)

                    }
                    mlistesibind.recyclerviewKayit.adapter = adapter
                    adapter.notifyDataSetChanged()

                }

                override fun onCancelled(error: DatabaseError) {
                }
            })

        }
}