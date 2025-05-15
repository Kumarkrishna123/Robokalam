package com.example.robokalam.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.robokalam.Model.Portfolio
import com.example.robokalam.R

class PortfolioAdapter(private val list: List<Portfolio>) : RecyclerView.Adapter<PortfolioAdapter.PortViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PortViewHolder {
        return PortViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_portfolio ,parent , false)
        )
    }

    override fun onBindViewHolder(
        holder: PortViewHolder,
        position: Int
    ) {
       val item = list.get(position)
        holder.name.text = item.name
        holder.college.text = item.collage
        holder.skills.text = item.skill
        holder.title.text = item.projectTittle
        holder.description.text = item.description

    }

    override fun getItemCount(): Int  = list.size

    inner class PortViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val name = itemView.findViewById<TextView>(R.id.nameText)
        val college = itemView.findViewById<TextView>(R.id.collegeText)
        val skills = itemView.findViewById<TextView>(R.id.skillsText)
        val title = itemView.findViewById<TextView>(R.id.projectTitleText)
        val description = itemView.findViewById<TextView>(R.id.projectDescriptionText)
    }



}