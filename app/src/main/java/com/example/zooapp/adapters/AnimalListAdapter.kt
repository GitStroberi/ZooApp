package com.example.zooapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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

        //set the background color of the cell based on the continent
        when (viewType) {
            VIEW_TYPE_AFRICA -> view.setBackgroundColor(view.resources.getColor(R.color.yellow))
            VIEW_TYPE_ASIA -> view.setBackgroundColor(view.resources.getColor(R.color.red))
            VIEW_TYPE_EUROPE -> view.setBackgroundColor(view.resources.getColor(R.color.green))
            VIEW_TYPE_NORTH_AMERICA -> view.setBackgroundColor(view.resources.getColor(R.color.brown))
            VIEW_TYPE_SOUTH_AMERICA -> view.setBackgroundColor(view.resources.getColor(R.color.orange))
            VIEW_TYPE_AUSTRALIA -> view.setBackgroundColor(view.resources.getColor(R.color.purple))
            VIEW_TYPE_ANTARCTICA -> view.setBackgroundColor(view.resources.getColor(R.color.blue))
            else -> view.setBackgroundColor(view.resources.getColor(R.color.white))
        }

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
        val cell = view.findViewById<View>(R.id.cell)

        init {
            animalNameTextView = view.findViewById(R.id.tvAnimalName)
            animalContinentTextView = view.findViewById(R.id.tvContinentName)

            view.setOnClickListener {
                val animal = animals[adapterPosition]
                //navigate to the detail screen
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