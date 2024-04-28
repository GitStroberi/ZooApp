package com.example.zooapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zooapp.R
import com.example.zooapp.models.Animal

class AnimalListAdapter(
    private val animals: List<Animal>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount() = animals.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AnimalViewHolder(inflater.inflate(R.layout.item_zoo_cell, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? AnimalViewHolder)?.bind(animals[position])
    }

    inner class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val animalNameTextView: TextView
        private val animalContinentTextView: TextView

        init {
            animalNameTextView = view.findViewById(R.id.tvAnimalName)
            animalContinentTextView = view.findViewById(R.id.tvContinentName)
        }

        fun bind(animal: Animal) {
            animalNameTextView.text = animal.name
            animalContinentTextView.text = animal.continent

            /**
            Europe: Green background + N and CO aligned to the left.
            Africa: Yellow background + N and CO aligned to the left separated by a black line;
            Asia: Red background + N and CO aligned horizontally, separated by a black line;
            North America: Brown background + N and CO aligned to the right;
            South America: Orange background + N and CO aligned to the right, separated by a black line;
            Australia: Purple background + N and CO aligned in the center;
            Antarctica: Blue background + N and CO aligned in the center, separated by a black line.
             */

            when(animal.continent) {
                "Africa" -> animalContinentTextView.setBackgroundResource(R.color.yellow)
                "Asia" -> animalContinentTextView.setBackgroundResource(R.color.red)
                "Europe" -> animalContinentTextView.setBackgroundResource(R.color.green)
                "North America" -> animalContinentTextView.setBackgroundResource(R.color.brown)
                "South America" -> animalContinentTextView.setBackgroundResource(R.color.orange)
                "Australia" -> animalContinentTextView.setBackgroundResource(R.color.purple)
                "Antarctica" -> animalContinentTextView.setBackgroundResource(R.color.blue)
            }

            when(animal.continent) {
                "Africa" -> {
                    animalNameTextView.textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                    animalContinentTextView.textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                }
                "Asia" -> {
                    animalNameTextView.textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                    animalContinentTextView.textAlignment = View.TEXT_ALIGNMENT_VIEW_END
                }
                "Europe" -> {
                    animalNameTextView.textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                    animalContinentTextView.textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                }
                "North America" -> {
                    animalNameTextView.textAlignment = View.TEXT_ALIGNMENT_VIEW_END
                    animalContinentTextView.textAlignment = View.TEXT_ALIGNMENT_VIEW_END
                }
                "South America" -> {
                    animalNameTextView.textAlignment = View.TEXT_ALIGNMENT_VIEW_END
                    animalContinentTextView.textAlignment = View.TEXT_ALIGNMENT_VIEW_START
                }
                "Australia" -> {
                    animalNameTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
                    animalContinentTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
                }
                "Antarctica" -> {
                    animalNameTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
                    animalContinentTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
                }
            }
        }
    }
}