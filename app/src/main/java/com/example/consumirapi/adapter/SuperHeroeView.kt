package com.example.consumirapi.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.consumirapi.R
import com.example.consumirapi.api.PoderesHeroe
import com.example.consumirapi.api.PostApiService
import com.example.consumirapi.api.SuperHeroe
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor



class SuperHeroeView(view:View):RecyclerView.ViewHolder(view) {
    val urlBase2 = "https://akabab.github.io/superhero-api/api/"

    val logging = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY) // O LEVEL.BASIC para menos detalles
    }

    val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    val tvNombreHeroe = view.findViewById<TextView>(R.id.tvNombreHeroe)
    val tvNombreReal = view.findViewById<TextView>(R.id.tvNombreReal)

    val ivFoto = view.findViewById<ImageView>(R.id.ivHeroe)

    val retrofit = Retrofit.Builder()
        .baseUrl(urlBase2)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(PostApiService::class.java)

    fun render(superHeroeModel: SuperHeroe){
        tvNombreHeroe.text = superHeroeModel.superHeroe
        tvNombreReal.text = superHeroeModel.biography.asJsonObject.get("fullName").asString

        Glide.with(ivFoto.context).load(superHeroeModel.images.asJsonObject.get("sm").asString).into(ivFoto)
        ivFoto.tag = superHeroeModel.id
        ivFoto.setOnClickListener{

            val lifecycleOwner = ivFoto.findViewTreeLifecycleOwner()

            lifecycleOwner?.let { owner ->
                owner.lifecycleScope.launch {
                    try {
                        val heroId = ivFoto.tag.toString()
                        val poder = service.getHeroeId(heroId)
                        Toast.makeText(ivFoto.context, poder.toString(), Toast.LENGTH_LONG).show()
                    } catch (e:Exception){
                        Toast.makeText(ivFoto.context,"Error: ${e.message}",Toast.LENGTH_LONG).show()
                    }
                }

            }

            //val response = service.getHeroeId(ivFoto.tag.toString())

            //Toast.makeText(ivFoto.context,superHeroeModel.biography.toString(),Toast.LENGTH_LONG).show()
        }
        println("render  "+superHeroeModel.id+"  "+superHeroeModel.biography.asJsonObject.get("fullName").asString+"  "+superHeroeModel.images.toString())
    }

}