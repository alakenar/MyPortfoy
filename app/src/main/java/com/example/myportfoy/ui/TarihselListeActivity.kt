package com.example.myportfoy.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.adapter.KayitAdapter
import com.example.myportfoy.adapter.NotlarAdapter
import com.example.myportfoy.databinding.ActivityTarihselListeBinding
import com.example.myportfoy.model.VerilerKayit
import com.example.myportfoy.model.VerilerNot
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class TarihselListeActivity : AppCompatActivity() {

    private lateinit var tlistebind: ActivityTarihselListeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tlistebind = ActivityTarihselListeBinding.inflate(layoutInflater)
        setContentView(tlistebind.root)

        val cal = Calendar.getInstance();
        val dateOnly = SimpleDateFormat("dd/MM/yyyy");
        val date= dateOnly.format(cal.getTime())

        veriGetir(date)
        veriAl(date)


        tlistebind.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val date = Calendar.getInstance()
            date.set(year, month, dayOfMonth)

            val dateOnly = SimpleDateFormat("dd/MM/yyyy");
            val date1= dateOnly.format(date.getTime())

            veriGetir(date1)
            veriAl(date1)
        }

    }

    private fun veriGetir(time: String) {

        lateinit var database: DatabaseReference

        database = FirebaseDatabase.getInstance().reference.child("YeniKayıt")

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val posts = ArrayList<VerilerKayit>()

                dataSnapshot.children.forEach {
                    it.getValue(VerilerKayit::class.java)?.let {

                        if (it.olusturmaTarihi == time.toString())
                            posts.add(it)
                        Log.d("veriler", posts.toString())
                    }

                }
                val adapter = KayitAdapter(posts) {

                    val intent =
                        Intent(this@TarihselListeActivity, KayitDetayActivity::class.java)
                    intent.putExtra("veri", it)
                    startActivity(intent)

                }

                tlistebind.recyclerviewKayit.adapter = adapter
                adapter.notifyDataSetChanged()

            }

            override fun onCancelled(error: DatabaseError) {
            }
        })


    }

    private fun veriAl(time:String) {

        lateinit var database: DatabaseReference

        database = FirebaseDatabase.getInstance().reference.child("Notlar")

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val posts = ArrayList<VerilerNot>()


                dataSnapshot.children.forEach {
                    it.getValue(VerilerNot::class.java)?.let {

                        if (it.olusturmaTarihi2==time.toString())
                        posts.add(it)
                        Log.d("veriler", posts.toString())
                    }

                }
                val adapter = NotlarAdapter(posts) {

                    val intent =
                        Intent(this@TarihselListeActivity, NotDetayActivity::class.java)
                    intent.putExtra("veri", it)
                    startActivity(intent)

                }
                tlistebind.recyclerviewNot.adapter = adapter
                adapter.notifyDataSetChanged()

            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

    }
}