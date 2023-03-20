package com.example.traningtraking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LisAdapterUser(var users: List<User>) : RecyclerView.Adapter<LisAdapterUser.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.user,parent,false);

        return ViewHolder(v);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text= users.get(position).firstName
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var tvName: TextView
        init {
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}