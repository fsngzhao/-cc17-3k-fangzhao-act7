package com.example.baguio.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.baguio.DetailsActivity
import com.example.baguio.R
import com.example.baguio.models.Place

class PlaceAdapter(context: Context, places: List<Place>) :
    ArrayAdapter<Place>(context, 0, places) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val place = getItem(position)
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.list_itme_place, parent, false)

        val imageView = view.findViewById<ImageView>(R.id.categoryIcon)
        val textView = view.findViewById<TextView>(R.id.placeName)

        imageView.setImageResource(place?.image ?: 0)
        textView.text = place?.name

        imageView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("place", place)
            context.startActivity(intent)
        }
        textView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("place", place)
            context.startActivity(intent)
        }

        return view
    }
}

