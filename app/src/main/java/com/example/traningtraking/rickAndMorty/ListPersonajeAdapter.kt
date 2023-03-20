package com.example.traningtraking.rickAndMorty

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.example.Personaje
import com.example.example.Results
import com.example.traningtraking.LisAdapterUser
import com.example.traningtraking.R
import com.example.traningtraking.User
import com.squareup.picasso.Picasso

class ListPersonajeAdapter(var users: List<Results>,var eve:Evento): RecyclerView.Adapter<ListPersonajeAdapter.ViewHolder>() {

    lateinit var context:Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.user,parent,false);
        context = parent.context;
        return ViewHolder(v);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text= users.get(position).name
        Picasso.get().load(users.get(position).image).into(holder.imName)
        holder.cvRM.setOnClickListener(View.OnClickListener {
            eve.onclick(users.get(position).id!!)
            Toast.makeText(context,users.get(position).name,Toast.LENGTH_LONG).show();
        })
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvName: TextView
        var imName: ImageView
        var cvRM: CardView
        init {
            tvName = itemView.findViewById(R.id.tv_name);
            imName = itemView.findViewById(R.id.im_personaje);
            cvRM = itemView.findViewById(R.id.cv_rm);
        }
    }
}