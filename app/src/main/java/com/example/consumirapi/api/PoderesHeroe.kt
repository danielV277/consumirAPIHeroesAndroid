package com.example.consumirapi.api

import com.google.gson.annotations.SerializedName

data class PoderesHeroe(
    @SerializedName("intelligence") val inteligencia:String,
    @SerializedName("strength") val fuerza:String,
    @SerializedName("speed") val velocidad:String,
    @SerializedName("power") val poder:String,
    @SerializedName("combat") val combate:String

)
