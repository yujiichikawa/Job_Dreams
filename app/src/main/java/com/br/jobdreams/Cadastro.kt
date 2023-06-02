package com.br.jobdreams

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

class Cadastro : AppCompatActivity() {

    private lateinit var firestore : FirebaseFirestore

    init {
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        findViewById<Button>(R.id.cadastrar).setOnClickListener {
            val emprego = findViewById<EditText>(R.id.empregocad).text.toString()
            val salario = findViewById<EditText>(R.id.salariocad).text.toString()
            val desc = findViewById<EditText>(R.id.desccad).text.toString()

            val job = Job(emprego = emprego,salario = salario,desc = desc)

            save(job)
        }
    }

    fun save(job: Job){
        val document = firestore.collection("job").document()

        val handle = document.set(job)
        handle.addOnSuccessListener {
            Toast.makeText(this,"Emprego adicionado nas nuvens", Toast.LENGTH_SHORT).show()
        }

        handle.addOnFailureListener{
            Toast.makeText(this,"Emprego não pode ir para as nuvens por algum motivo", Toast.LENGTH_SHORT).show()
        }
    }

}