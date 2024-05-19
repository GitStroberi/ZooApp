package com.example.zooapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zooapp.adapters.AnimalListAdapter
import com.example.zooapp.models.Animal

class ZooListFragment : Fragment() {
    private val itemList = ArrayList<Animal>()
    private val adapter = AnimalListAdapter(itemList)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_zoo_list, container, false)

    override fun onViewCreated(view: android.view.View, savedInstanceState: android.os.Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAnimalList()
        getAnimalList()
    }

    private fun setupAnimalList() {
        // Call the API to get the list of animals
        val layoutManager = LinearLayoutManager(context)

        view?.findViewById<RecyclerView>(R.id.rvZooList)?.apply {
            this.layoutManager = layoutManager
            this.adapter = this@ZooListFragment.adapter
        }
    }

    private fun getAnimalList() {
        // hardcoding the list of animals
        itemList.add(Animal("Lion", "Africa"))
        itemList.add(Animal("Tiger", "Asia"))
        itemList.add(Animal("Penguin", "Antarctica"))
        itemList.add(Animal("Kangaroo", "Australia"))
        itemList.add(Animal("Elephant", "Africa"))
        itemList.add(Animal("Grizzly Bear", "North America"))
        itemList.add(Animal("Panda", "Asia"))
        itemList.add(Animal("Zebra", "Africa"))
        itemList.add(Animal("Koala", "Australia"))
        itemList.add(Animal("Wolf", "Europe"))
        itemList.add(Animal("Polar Bear", "Antarctica"))
        itemList.add(Animal("Giraffe", "Africa"))
        itemList.add(Animal("Jaguar", "South America"))
        itemList.add(Animal("Sloth", "South America"))
        itemList.add(Animal("Gorilla", "Africa"))
        itemList.add(Animal("Orangutan", "Asia"))
        itemList.add(Animal("Emperor Penguin", "Antarctica"))
        itemList.add(Animal("Wallaby", "Australia"))
        itemList.add(Animal("Hippopotamus", "Africa"))
        itemList.add(Animal("Black Bear", "North America"))
        itemList.add(Animal("Red Panda", "Asia"))
        itemList.add(Animal("Cheetah", "Africa"))
        itemList.add(Animal("Wombat", "Australia"))
        itemList.add(Animal("Fox", "Europe"))
        itemList.add(Animal("Arctic Fox", "Antarctica"))
        itemList.add(Animal("Chimpanzee", "Africa"))
        itemList.add(Animal("Siberian Tiger", "Asia"))
        itemList.add(Animal("Puffin", "Antarctica"))
        itemList.add(Animal("Brown Bear", "North America"))
        itemList.add(Animal("Polar Fox", "Antarctica"))
        itemList.add(Animal("Platypus", "Australia"))
        itemList.add(Animal("Toucan", "South America"))
        itemList.add(Animal("Llama", "South America"))
        itemList.add(Animal("Hedgehog", "Europe"))
        itemList.add(Animal("Rhinoceros", "Africa"))
        itemList.add(Animal("Koala", "Australia"))
        itemList.add(Animal("Gibbon", "Asia"))
        itemList.add(Animal("Caracal", "Africa"))
        itemList.add(Animal("Sloth Bear", "Asia"))
        itemList.add(Animal("Moose", "North America"))
        itemList.add(Animal("Meerkat", "Africa"))
        itemList.add(Animal("Red Kangaroo", "Australia"))
        itemList.add(Animal("Galapagos Penguin", "South America"))
        itemList.add(Animal("Alpaca", "South America"))
        itemList.add(Animal("Pangolin", "Asia"))
        itemList.add(Animal("Leopard", "Africa"))
        itemList.add(Animal("Sun Bear", "Asia"))
        itemList.add(Animal("Snow Leopard", "Asia"))
        itemList.add(Animal("Capybara", "South America"))
        itemList.add(Animal("Cassowary", "Australia"))
        itemList.add(Animal("Gazelle", "Africa"))
        itemList.add(Animal("Komodo Dragon", "Asia"))
        itemList.add(Animal("Armadillo", "South America"))
    }
}