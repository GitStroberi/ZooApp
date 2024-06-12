package com.example.zooapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.zooapp.data.database.AnimalEntity
import com.example.zooapp.data.database.ZooDatabase
import com.example.zooapp.data.repository.ZooRepository
import kotlinx.coroutines.launch

class ZooViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ZooRepository
    val allAnimals: LiveData<List<AnimalEntity>>

    init {
        val zooDao = ZooDatabase.getDatabase(application).zooDao()
        repository = ZooRepository(zooDao)
        allAnimals = repository.allAnimals
    }

    fun addAnimal(name: String, continent: String) {
        viewModelScope.launch {
            // Check for duplicates
            val count = repository.getAnimalCountByName(name)
            if (count > 0) {
                // Handle duplicate (show a message or take other action)
                return@launch
            }

            // Check if continent is valid
            val validContinents = listOf("Africa", "Asia", "Europe", "North America", "South America", "Australia", "Antarctica")
            if (continent.isEmpty() || !validContinents.contains(continent)) {
                // Handle invalid continent (show a message or take other action)
                return@launch
            }

            // Insert animal if valid
            repository.insert(AnimalEntity(name = name, continent = continent))
        }
    }

    fun deleteAnimal(animal: AnimalEntity) = viewModelScope.launch {
        repository.delete(animal)
    }
}