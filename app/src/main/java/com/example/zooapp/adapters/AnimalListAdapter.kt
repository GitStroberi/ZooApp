package com.example.zooapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.zooapp.R
import com.example.zooapp.ZooListFragmentDirections
import com.example.zooapp.models.Animal

class AnimalListAdapter(
    private val animals: List<Animal>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount() = animals.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val layoutId = when (viewType) {
            VIEW_TYPE_AFRICA -> R.layout.africa_cell
            VIEW_TYPE_ASIA -> R.layout.asia_cell
            VIEW_TYPE_EUROPE -> R.layout.europe_cell
            VIEW_TYPE_NORTH_AMERICA -> R.layout.n_america_cell
            VIEW_TYPE_SOUTH_AMERICA -> R.layout.s_america_cell
            VIEW_TYPE_AUSTRALIA -> R.layout.australia_cell
            VIEW_TYPE_ANTARCTICA -> R.layout.antarctica_cell
            else -> R.layout.item_zoo_cell
        }
        val view = inflater.inflate(layoutId, parent, false)

        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val animal = animals[position]
        (holder as AnimalViewHolder).bind(animal)
    }

    override fun getItemViewType(position: Int): Int {
        val continent = animals[position].continent
        return when (continent) {
            "Africa" -> VIEW_TYPE_AFRICA
            "Asia" -> VIEW_TYPE_ASIA
            "Europe" -> VIEW_TYPE_EUROPE
            "North America" -> VIEW_TYPE_NORTH_AMERICA
            "South America" -> VIEW_TYPE_SOUTH_AMERICA
            "Australia" -> VIEW_TYPE_AUSTRALIA
            "Antarctica" -> VIEW_TYPE_ANTARCTICA
            else -> VIEW_TYPE_DEFAULT
        }
    }

    inner class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val animalNameTextView: TextView
        private val animalContinentTextView: TextView
        private val cardView: CardView

        init {
            animalNameTextView = view.findViewById(R.id.tvAnimalName)
            animalContinentTextView = view.findViewById(R.id.tvContinentName)
            cardView = view.findViewById(R.id.cardView)

            view.setOnClickListener {
                val animal = animals[adapterPosition]
                val action = ZooListFragmentDirections.actionZooListFragmentToAnimalDetailFragment(
                    animal.name ?: "",
                    animal.continent ?: ""
                )
                view.findNavController().navigate(action)
            }
        }

        fun bind(animal: Animal) {
            animalNameTextView.text = animal.name
            animalContinentTextView.text = animal.continent

            // Set background color for the CardView based on the continent
            when (animal.continent) {
                "Africa" -> cardView.setCardBackgroundColor(cardView.context.getColor(R.color.yellow))
                "Asia" -> cardView.setCardBackgroundColor(cardView.context.getColor(R.color.red))
                "Europe" -> cardView.setCardBackgroundColor(cardView.context.getColor(R.color.green))
                "North America" -> cardView.setCardBackgroundColor(cardView.context.getColor(R.color.brown))
                "South America" -> cardView.setCardBackgroundColor(cardView.context.getColor(R.color.orange))
                "Australia" -> cardView.setCardBackgroundColor(cardView.context.getColor(R.color.purple_200))
                "Antarctica" -> cardView.setCardBackgroundColor(cardView.context.getColor(R.color.blue))
                else -> cardView.setCardBackgroundColor(cardView.context.getColor(R.color.white))
            }
        }
    }

    companion object {
        private const val VIEW_TYPE_DEFAULT = 0
        private const val VIEW_TYPE_AFRICA = 1
        private const val VIEW_TYPE_ASIA = 2
        private const val VIEW_TYPE_EUROPE = 3
        private const val VIEW_TYPE_NORTH_AMERICA = 4
        private const val VIEW_TYPE_SOUTH_AMERICA = 5
        private const val VIEW_TYPE_AUSTRALIA = 6
        private const val VIEW_TYPE_ANTARCTICA = 7
    }
}