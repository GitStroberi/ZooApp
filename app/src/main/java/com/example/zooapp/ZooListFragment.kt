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
    }
}