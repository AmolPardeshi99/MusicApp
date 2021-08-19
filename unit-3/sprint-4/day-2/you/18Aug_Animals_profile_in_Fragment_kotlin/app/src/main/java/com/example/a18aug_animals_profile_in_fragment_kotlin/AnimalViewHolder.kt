package com.example.a18aug_animals_profile_in_fragment_kotlin

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData(animal: Animal){
        itemView.apply {
            tvAnimalName.text = animal.name
            Glide.with(ivAnimal).load(animal.url).into(ivAnimal)
            //ivAnimal.setImageResource(animal.getImageId())
        }
    }

}