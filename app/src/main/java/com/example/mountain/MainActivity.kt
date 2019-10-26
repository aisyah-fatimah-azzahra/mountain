package com.example.mountain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.mountain_list)
        initDATA()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerViewAdapter(this, items)

    }

    private fun initDATA(){
        val name = resources.getStringArray(R.array.mountain_name)
        val image = resources.obtainTypedArray(R.array.mountain_image)

        items.clear()

        for (i in name.indices) {
            items.add(
                Item(name[i],
                    image.getResourceId(i, 0))
            )
        }
        image.recycle()
    }
}
