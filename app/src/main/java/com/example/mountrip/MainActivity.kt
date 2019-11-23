package com.example.mountrip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.user_registrasi.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var handler:DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = DatabaseHelper(this)

        showHome()

        registrasi.setOnClickListener {
            showRegistrasi()
        }

        login.setOnClickListener {
            showLogIn()
        }

        save.setOnClickListener {
            handler.insertUserData(name.text.toString(), email.text.toString(), password_register.text.toString())
             showHome()
        }

        login_button.setOnClickListener {
            if (handler.userPresent(login_email.text.toString(), login_password.text.toString()))
                Toast.makeText(this,"Login Success", Toast.LENGTH_SHORT).show()
             else
                Toast.makeText(this,"Username or Password is Incorrect", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showRegistrasi(){
        registrasi_layout.visibility=View.VISIBLE
        login_layout.visibility=View.GONE
        home_li.visibility=View.GONE
    }

    private fun showLogIn() {
        registrasi_layout.visibility=View.GONE
        login_layout.visibility=View.VISIBLE
        home_li.visibility=View.GONE
    }

    private fun showHome(){
        registrasi_layout.visibility=View.GONE
        login_layout.visibility=View.GONE
        home_li.visibility=View.VISIBLE
    }
}
