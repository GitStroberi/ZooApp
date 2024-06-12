package com.example.zooapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.zooapp.data.database.AnimalEntity
import com.example.zooapp.data.database.ZooDatabase
import com.example.zooapp.data.repository.ZooRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class ZooViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ZooRepository
    val allAnimals: LiveData<List<AnimalEntity>>
    private val _errorChannel = MutableSharedFlow<AddAnimalError>()
    val errorChannel: SharedFlow<AddAnimalError> = _errorChannel.asSharedFlow()

    init {
        val zooDao = ZooDatabase.getDatabase(application).zooDao()
        repository = ZooRepository(zooDao)
        allAnimals = repository.allAnimals
    }

    fun addAnimal(name: String, continent: String) {
        viewModelScope.launch {
            // Input validation: Ensure both fields are filled and the continent is valid
            if (name.isBlank() || continent.isBlank()) {
                _errorChannel.emit(AddAnimalError.EmptyFields)
                return@launch
            }

            val validContinents = listOf("Africa", "Asia", "Europe", "North America", "South America", "Australia", "Antarctica")
            if (!validContinents.contains(continent)) {
                _errorChannel.emit(AddAnimalError.InvalidContinent)
                return@launch
            }

            // Check for duplicates
            val existingAnimal = repository.getAnimalByName(name)
            try {
                if (existingAnimal != null) {
                    // Update the existing animal with the new continent
                    val updatedAnimal = existingAnimal.copy(continent = continent)
                    repository.updateAnimal(updatedAnimal)
                } else {
                    // Insert a new animal if it doesn't exist
                    repository.insert(AnimalEntity(name = name, continent = continent))
                }
            } catch (e: Exception) {
                _errorChannel.emit(AddAnimalError.UnknownError)
            }
        }
    }

    fun deleteAnimal(animal: AnimalEntity) = viewModelScope.launch {
        repository.delete(animal)
    }

    sealed class AddAnimalError {
        object EmptyFields : AddAnimalError()
        object InvalidContinent : AddAnimalError()
        // object DuplicateAnimal : AddAnimalError()
        object UnknownError : AddAnimalError()
    }
}