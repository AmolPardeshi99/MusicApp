package com.example.a18aug_animals_profile_in_fragment_kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter(private val animalList: List<Animal>) :
    RecyclerView.Adapter<AnimalViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val model = animalList[position]
        holder.setData(model)
    }

    override fun getItemCount(): Int {
        return animalList.size
    }
}