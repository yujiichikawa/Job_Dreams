package com.br.jobdreams

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.cadastrar).setOnClickListener {
            val intent = Intent(this,Cadastro::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.listaCadastro).setOnClickListener {
            val intent = Intent(this,ListaConta::class.java)
            startActivity(intent)
        }
    }
}