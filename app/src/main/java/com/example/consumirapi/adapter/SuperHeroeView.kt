package com.example.consumirapi.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.consumirapi.R
import com.example.consumirapi.api.SuperHeroe


class SuperHeroeView(view:View):RecyclerView.ViewHolder(view) {

    val tvNombreHeroe = view.findViewById<TextView>(R.id.tvNombreHeroe)
    val tvNombreReal = view.findViewById<TextView>(R.id.tvNombreReal)

    val ivFoto = view.findViewById<ImageView>(R.id.ivHeroe)

    fun render(superHeroeModel: SuperHeroe){
        tvNombreHeroe.text = superHeroeModel.superHeroe
        tvNombreReal.text = superHeroeModel.nombreReal
        Glide.with(ivFoto.context).load(superHeroeModel.foto).into(ivFoto)
        ivFoto.setOnClickListener{
            Toast.makeText(ivFoto.context,superHeroeModel.nombreReal,Toast.LENGTH_LONG).show()
        }
    }

}