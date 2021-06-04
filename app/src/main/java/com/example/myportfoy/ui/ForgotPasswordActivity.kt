package com.example.myportfoy.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myportfoy.databinding.ActivityForgotPasswordBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class ForgotPasswordActivity :AppCompatActivity(){

    private lateinit var passwordbind: ActivityForgotPasswordBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        passwordbind = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(passwordbind.root)


        passwordbind.passButton.setOnClickListener {

            val email = passwordbind.forgotpassText.text.toString().trim { it <= ' ' }

            if (email.isEmpty()) {
                Toast.makeText(
                    this@ForgotPasswordActivity,
                    "Lütfen e-mail adresinizi giriniz.",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->

                        if (task.isSuccessful) {
                            Toast.makeText(
                                this@ForgotPasswordActivity,
                                "Lütfen e-mail  adresinizi kontrol edin ve parolanızı sıfırlayın.",
                                Toast.LENGTH_LONG
                            ).show()

                            finish()
                        } else {
                            Toast.makeText(
                                this@ForgotPasswordActivity,
                                task.exception!!.message.toString(),
                                Toast.LENGTH_LONG
                            ).show()

                        }
                    }
            }
        }
    }
}