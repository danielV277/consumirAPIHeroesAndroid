package com.example.consumirapi.api
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class SuperHeroe(
    @SerializedName("id") val id:String,
    @SerializedName("name") val superHeroe: String,
    @SerializedName("biography") val biography: JsonElement,
    @SerializedName("images") val images: JsonElement
){
    public final val foto: String
    public final val nombreReal: String


    init {
        nombreReal = biography.asJsonObject.get("fullName").asString
        foto = images.asJsonObject.get("sm").asString
        //println("SuperHeroe  "+nombreReal+"  "+foto+"  "+biography.toString())
    }

}



    /*
    "intelligence": 38,
    "strength": 100,
"speed": 17,
"durability": 80,
"power": 24,
"combat": 64
)*/

/*data class Biography(
    @SerializedName("fullName") val nombreReal: String
)

data class Images(
    @SerializedName("sm") val foto: String
)
*/