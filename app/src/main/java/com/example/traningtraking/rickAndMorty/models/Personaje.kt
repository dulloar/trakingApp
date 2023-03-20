package com.example.example

import com.google.gson.annotations.SerializedName


data class Personaje (

  @SerializedName("info"    ) var info    : Info?              = Info(),
  @SerializedName("results" ) var results : ArrayList<Results> = arrayListOf()

)