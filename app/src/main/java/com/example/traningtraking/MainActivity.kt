package com.example.traningtraking

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.example.Personaje
import com.example.traningtraking.rickAndMorty.Evento
import com.example.traningtraking.rickAndMorty.ListPersonajeAdapter
import com.example.traningtraking.rickAndMorty.RickAndMortyAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val f = ListRMFragment.newInstance("","")
        val fragment = supportFragmentManager.beginTransaction();
        var context = this
        val e = object : Evento {
            override fun onclick(id:Int) {
                fragment.detach(f)
                fragment.replace(R.id.fl,PersonajeFragment.newInstance(id),"Personaje")
                fragment.addToBackStack("Personaje");
               //fragment.commitAllowingStateLoss();
            }
        }
        f.setEvento(e)


        fragment.replace(R.id.fl,f,"Lista")
        fragment.addToBackStack("Lista");
        fragment.commitAllowingStateLoss();






    }
}