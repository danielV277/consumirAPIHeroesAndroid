package com.example.consumirapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.consumirapi.R
//import com.example.consumirapi.api.Biography
//import com.example.consumirapi.api.Images
import com.example.consumirapi.api.SuperHeroe

class SuperHeroeAdapter(private val superHeroeList:List<SuperHeroe>):RecyclerView.Adapter<SuperHeroeView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroeView {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SuperHeroeView(layoutInflater.inflate(R.layout.item_superheroe,parent, false))
    }

    override fun getItemCount(): Int {
        return superHeroeList.size
    }

    override fun onBindViewHolder(holder: SuperHeroeView, position: Int) {
        val item = superHeroeList[position]
        holder.render(item)
    }
}