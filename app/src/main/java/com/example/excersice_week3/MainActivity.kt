package com.example.excersice_week3

import Data
import DataCenter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.excersice_week3.R.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = DataAdapter(getData(), this)
        recyclerview.hasFixedSize()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar,menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var id : Int = item.itemId
        if (id == R.id.linear_layout_action){
            Toast.makeText(this, "Linear", Toast.LENGTH_SHORT).show()
        }

        if (id == R.id.grid_layout_action){
            Toast.makeText(this, "grid", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }


    fun getData() : List<Data> {
        val datas =  Gson().fromJson<List<Data>>(DataCenter.getMovieJsonString(),object : TypeToken<List<Data>>() {}.type)
        return datas;
    }


}
