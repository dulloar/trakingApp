package com.example.traningtraking.rickAndMorty

import com.example.example.Personaje
import com.example.example.Results
import retrofit2.Call
import retrofit2.http.GET

/**
 *
 * */
public interface RickAndMortyAPI {
    @GET("character")
    fun getPersonajes(): Call<Personaje>
    @GET("character/{id}")
    fun getPersonaje(id:Int): Call<Results>
}