package com.example.traningtraking.rickAndMorty

import com.example.example.Personaje
import retrofit2.Call
import retrofit2.http.GET

/**
 *
 * */
public interface RickAndMortyAPI {
    @GET("character")
    fun getPersonajes(): Call<Personaje>
}