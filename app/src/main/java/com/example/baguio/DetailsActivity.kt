package com.example.baguio

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.baguio.models.Place

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragement_details)

        val place = intent.getParcelableExtra<Place>("place") ?: return

        val imageView = findViewById<ImageView>(R.id.placeImageView)
        val descriptionView = findViewById<TextView>(R.id.placeDescriptionTextView)

        imageView.setImageResource(place.detailImage)
        descriptionView.text = place.description
    }
}


