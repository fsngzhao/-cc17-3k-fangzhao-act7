package com.example.baguio

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.baguio.adapters.PlaceAdapter
import com.example.baguio.models.Place

class RecommendationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragement_recommendations)

        val categoryIndex = intent.getIntExtra("category", 0)
        val places = getPlacesByCategory(categoryIndex)

        val adapter = PlaceAdapter(this, places)
        val listView = findViewById<ListView>(R.id.recommendationListView)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("place", places[position])
            startActivity(intent)
        }
    }

    private fun getPlacesByCategory(categoryIndex: Int): List<Place> {
        return when (categoryIndex) {
            0 -> listOf(
                Place("That Little Cafe", R.drawable.cafe1, R.drawable.cafe1_detail, "That little cafe is inside The Orchard Hotel Baguio. The coffee here is decent, the staff are nice, and the atmosphere, especially on the terrace, is really amazing. They also have a buffet for merienda."),
                Place("HOMU Cafe", R.drawable.cafe2, R.drawable.cafe2_detail, "Homu Cafe fulfills everyone's expectations and desires. It is affordable, especially for students, and has Wi-Fi.Homu Café has a beautiful environment that appeals to most people these days."),
                Place("The TERMINAL Cafe", R.drawable.cafe3, R.drawable.cafe3_detail, "Amazing place to have coffe at terminal."),
                Place("R & B Cafe and library", R.drawable.cafe4, R.drawable.cafe4_detail, "The store opens at 8am and is very cozy. There are plenty of books on the shelves to read to pass the time. The menu has a wide variety of choices and the food is very good. The service is good and the ambience is nice. Around the cathedral."),
                Place("Quoted Cafe", R.drawable.cafe5, R.drawable.cafe5_detail, "It's quiet and not too crowded. There are many desserts to try, the red velvet cake is a great choice.")
            )
            1 -> listOf(
                Place("GOOD TASTE Restaurant", R.drawable.restaurant1, R.drawable.restaurant1_detail, "The flavors are very good and the dishes are large enough for family dinners to share a meal together."),
                Place("Hernan's Kitchen", R.drawable.restaurant2, R.drawable.restaurant2_detail, "Food was good and service was excellent. Second floor has a great view of the area. Recommend Lechon Manok and Inihaw na Tuna."),
                Place("HOTEL 456 Restaurant", R.drawable.restaurant3, R.drawable.restaurant3_detail, "There was hot pot as well as a la carte Chinese food that was delicious and the coffee was a great deal."),
                Place("Olive Restaurant", R.drawable.restaurant4, R.drawable.restaurant4_detail, "Inside the Venus hotel at the reception still located are the restaurant with an nice indoor terrace to the street and the Burnham park with nice options for food internationally and local kitchen.\n" +
                        "Has good prices in relation and best place inside baguiocity.")
            )
            2 -> listOf(
                Place("BUNHAM Park", R.drawable.park1, R.drawable.park1_detail, "Beautiful scenery,Baguio's most famous attractions."),
                Place("RIZAL Park", R.drawable.park2, R.drawable.park2_detail, "Beautiful park and lots of people with cute dogs. Great for hanging out or waiting for a friend when you think the burnham park is too big and tired of walking."),
                Place("SUNSHINE Park", R.drawable.park3,R.drawable.park3_detail,"Just below sm baguio.its nice to have a rest here because its not crowded.the area is wide and has chairs to sit.its a oravtice area of students and dancers.you can get a cup of coffee and donut from crispy cream because its just across tje street" )
            )
            3 -> listOf(
                Place("BAGUIO City Public Market", R.drawable.market1, R.drawable.market1_detail, "If you're looking for a place to buy pasalubong in Baguio, you can visit here. There are a lot of stores to choose from."),
                Place("The MARKETPLACE", R.drawable.market2, R.drawable.market2_detail, "Brands and meats that we didn't have access to here in Baguio are now readily available. Love the bright and easy to.maneuver layout. Staff sre all helpful and friendly. Its conveniently located and parking is always available."),
                Place("BAUIO SM", R.drawable.market3, R.drawable.market3_detail, "The supermarket is huge and has a wide variety of goods. It really is a one stop shop for everything you need, the staff are very helpful and many shoppers will shop here.")
            )
            else -> emptyList()
        }
    }
}
