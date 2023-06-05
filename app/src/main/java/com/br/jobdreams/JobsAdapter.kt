package com.br.jobdreams

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JobsAdapter(private val jobList:ArrayList<Job>) : RecyclerView.Adapter<JobsAdapter.JobsAdapterHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobsAdapterHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.custom_view,
        parent,false)

        return JobsAdapterHolder(itemView)
    }

    override fun getItemCount(): Int {
        return jobList.size
    }

    override fun onBindViewHolder(holder: JobsAdapterHolder, position: Int) {
        val currentitem = jobList[position]

        holder.emprego.text = currentitem.emprego
        holder.salario.text = currentitem.salario
        holder.desc.text = currentitem.desc


    }

    class JobsAdapterHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val emprego : TextView = itemView.findViewById(R.id.jobjob)
        val salario : TextView = itemView.findViewById(R.id.salariojob)
        val desc : TextView = itemView.findViewById(R.id.descjob)

    }

}