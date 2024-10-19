package com.example.consumirapi.api
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class SuperHeroe(
    @SerializedName("name") val superHeroe: String,
    @SerializedName("biography") val biography: JsonElement,
    @SerializedName("images") val images: JsonElement
){
    public val foto: String
    public val nombreReal: String

    init {
        nombreReal = biography.asJsonObject.get("fullName").asString
        foto = images.asJsonObject.get("sm").asString
    }

}

/*data class Biography(
    @SerializedName("fullName") val nombreReal: String
)

data class Images(
    @SerializedName("sm") val foto: String
)
*/