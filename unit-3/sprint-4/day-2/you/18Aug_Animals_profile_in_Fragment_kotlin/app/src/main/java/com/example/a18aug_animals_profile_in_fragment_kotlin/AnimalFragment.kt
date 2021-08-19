package com.example.a18aug_animals_profile_in_fragment_kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_animal.*


class AnimalFragment : Fragment() {
    private val animalList: ArrayList<Animal> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_animal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buildList()
        setRecyclerview()
    }

    private fun setRecyclerview() {
        val animalAdapter = AnimalAdapter(animalList)
        val gridLayoutManager = GridLayoutManager(context, 1)
        recyclerview.adapter = animalAdapter
        recyclerview.layoutManager = gridLayoutManager
    }

    private fun buildList() {
        var t = 70
        while (t-- > 0) {
            val animal1 = Animal("Tiger","https://images.pexels.com/photos/145939/pexels-photo-145939.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260")
                animalList.add(animal1)
            val animal2 = Animal("Cat","https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500")
            animalList.add(animal2)
            val animal3 = Animal("Reindeer","https://images.pexels.com/photos/34231/antler-antler-carrier-fallow-deer-hirsch.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940")
            animalList.add(animal3)
            val animal4 = Animal("Duck","https://images.pexels.com/photos/162140/duckling-birds-yellow-fluffy-162140.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940")
            animalList.add(animal4)
            val animal5 = Animal("Lion","https://images.pexels.com/photos/247502/pexels-photo-247502.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940")
            animalList.add(animal5)
            val animal6 = Animal("Giraffe","https://images.pexels.com/photos/67552/giraffe-tall-mammal-africa-67552.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940")
            animalList.add(animal6)
            val animal7 = Animal("Wolf","https://images.pexels.com/photos/434090/pexels-photo-434090.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940")
            animalList.add(animal7)
            val animal8 = Animal("Dog","https://images.pexels.com/photos/1108099/pexels-photo-1108099.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940")
            animalList.add(animal8)
            val animal9 = Animal("Penguin","https://images.pexels.com/photos/86405/penguin-funny-blue-water-86405.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940")
            animalList.add(animal9)
            val animal = Animal("Yak","https://images.pexels.com/photos/144234/bull-landscape-nature-mammal-144234.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940")
            animalList.add(animal)

        }

    }


}