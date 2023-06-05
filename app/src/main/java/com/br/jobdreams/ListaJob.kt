package com.br.jobdreams

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class ListaJob : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference
    private lateinit var jobRecyclerview : RecyclerView
    private lateinit var jobArrayList : ArrayList<Job>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_job)

        jobRecyclerview = findViewById(R.id.recyclerView)
        jobRecyclerview.layoutManager = LinearLayoutManager(this)
        jobRecyclerview.setHasFixedSize(true)

        jobArrayList = arrayListOf<Job>()

        getJobData()

    }

    private fun getJobData() {

        dbref = FirebaseDatabase.getInstance().getReference("job")

        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){

                    for (jobSnapshot in snapshot.children){
                        val job = jobSnapshot.getValue(Job::class.java)
                        jobArrayList.add(job!!)
                    }
                    jobRecyclerview.adapter = JobsAdapter(jobArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }
}