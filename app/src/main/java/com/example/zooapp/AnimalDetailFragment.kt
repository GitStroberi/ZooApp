package com.example.zooapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.zooapp.models.Animal

class AnimalDetailFragment : Fragment() {

    val arguments: AnimalDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_animal_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animalName : String = arguments.animalName
        val animalContinent : String = arguments.animalContinent

        view.findViewById<android.widget.TextView>(R.id.tvAnimalName).text = animalName
        view.findViewById<android.widget.TextView>(R.id.tvAnimalContinent).text = animalContinent

        //set background color of the cell based on the continent
        when (animalContinent) {
            "Africa" -> view.setBackgroundColor(view.resources.getColor(R.color.yellow))
            "Asia" -> view.setBackgroundColor(view.resources.getColor(R.color.red))
            "Europe" -> view.setBackgroundColor(view.resources.getColor(R.color.green))
            "North America" -> view.setBackgroundColor(view.resources.getColor(R.color.brown))
            "South America" -> view.setBackgroundColor(view.resources.getColor(R.color.orange))
            "Australia" -> view.setBackgroundColor(view.resources.getColor(R.color.purple))
            "Antarctica" -> view.setBackgroundColor(view.resources.getColor(R.color.blue))
            else -> view.setBackgroundColor(view.resources.getColor(R.color.white))
        }
    }
}