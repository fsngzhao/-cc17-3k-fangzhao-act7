package com.example.baguio

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.baguio.adapters.CategoryAdapter
import com.example.baguio.models.Category

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Baguio"

        val categories = listOf(
            Category("Coffee Shops", R.drawable.cafe),
            Category("Restaurants", R.drawable.restaurant),
            Category("Parks", R.drawable.park),
            Category("Shopping Malls", R.drawable.market)
        )

        val adapter = CategoryAdapter(this, categories)
        val listView = findViewById<ListView>(R.id.categoryListView)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, RecommendationsActivity::class.java)
            intent.putExtra("category", position)
            startActivity(intent)
        }
    }
}
