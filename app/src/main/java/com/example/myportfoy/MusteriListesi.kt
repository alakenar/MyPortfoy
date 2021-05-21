package com.example.myportfoy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myportfoy.databinding.MusteriListesiBinding
import com.google.firebase.database.*

class MusteriListesi: AppCompatActivity() {

    private lateinit var mlistesibind: MusteriListesiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mlistesibind = MusteriListesiBinding.inflate(layoutInflater)
        setContentView(mlistesibind.root)


        mlistesibind.recyclerview.apply {
            this.layoutManager = LinearLayoutManager(this@MusteriListesi)

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
                                Intent(this@MusteriListesi, KayitDetay::class.java)
                        intent.putExtra("veri", it)
                        startActivity(intent)

                    }
                    mlistesibind.recyclerview.adapter = adapter
                    adapter.notifyDataSetChanged()

                }

                override fun onCancelled(error: DatabaseError) {
                }
            })

        }
}