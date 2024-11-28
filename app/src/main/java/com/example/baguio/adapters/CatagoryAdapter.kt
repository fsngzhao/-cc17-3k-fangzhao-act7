package com.example.baguio.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.baguio.models.Category

class CategoryAdapter(context: Context, categories: List<Category>) :
    ArrayAdapter<Category>(context, 0, categories) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val category = getItem(position)
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.text = category?.name
        textView.setCompoundDrawablesWithIntrinsicBounds(category?.icon ?: 0, 0, 0, 0)
        textView.compoundDrawablePadding = 16
        return view
    }
}
