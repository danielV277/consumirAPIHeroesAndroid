package com.example.consumirapi

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.consumirapi.adapter.SuperHeroeAdapter
import com.example.consumirapi.api.PostApiService
import com.example.consumirapi.api.SuperHeroe
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val urlBase = "https://akabab.github.io/superhero-api/api/"
    var superHeroeList = listOf<SuperHeroe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        getData()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }



    private fun getData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(urlBase)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(PostApiService::class.java)

        lifecycleScope.launch{
            val response = service.getHeroesPost()
            superHeroeList = response
            response.forEach{
                println(it)
            }

            runOnUiThread{
                initReclyclerView(response)
                //val tvNombreHeroe = findViewById<TextView>(R.id.tvNombreHeroe)
                //tvNombreHeroe.text = response.first().superHeroe
            }
        }


    }

    private fun initReclyclerView(heroesList:List<SuperHeroe>){
        val manager = LinearLayoutManager(this)
        val  decoration = DividerItemDecoration(this,manager.orientation)

        val recycleView = findViewById<RecyclerView>(R.id.recView)
        recycleView.layoutManager = manager
        recycleView.adapter = SuperHeroeAdapter(heroesList)
        //recycleView.adapter = SuperHeroeAdapter(Data.superheroesList,Data.biografiaList,Data.imagesList)
        recycleView.addItemDecoration(decoration)
    }
}