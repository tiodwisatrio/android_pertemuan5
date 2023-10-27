package com.tiodwisatrio.simpleactivityintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    // Explicit Intent
    val explicitButton = findViewById<Button>(R.id.explicitButton)
    explicitButton.setOnClickListener() {
        val explicitIntent = Intent(this, SecondActivity::class.java)
        startActivity(explicitIntent)
    }


    // Implicit Intent
        val url = "https://www.apple.com"
        val implicitButton = findViewById<Button>(R.id.implicitButton)
        implicitButton.setOnClickListener() {
            val implicitIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(implicitIntent)
        }


    // Passing Data with Explicit Intent
        val sendButton = findViewById<Button>(R.id.sendButton)
        sendButton.setOnClickListener() {
            sendData()
        }

    }

    private fun sendData() {
        val editTextNama = findViewById<EditText>(R.id.editTextNama)
        val message = editTextNama.text.toString()
        val intent = Intent(this, SecondActivity::class.java).also {
            it.putExtra("EXTRA_MESSAGE", message)
            startActivity(it)
        }
    }
}