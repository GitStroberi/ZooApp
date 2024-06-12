package com.example.zooapp.data.repository

import androidx.lifecycle.LiveData
import com.example.zooapp.data.database.AnimalEntity
import com.example.zooapp.data.database.ZooDao

class ZooRepository(private val zooDao: ZooDao) {
    val allAnimals: LiveData<List<AnimalEntity>> = zooDao.getAllAnimals()

    suspend fun insert(animal: AnimalEntity) {
        zooDao.insert(animal)
    }

    suspend fun delete(animal: AnimalEntity) {
        zooDao.delete(animal)
    }

    suspend fun updateAnimal(animal: AnimalEntity) {
        zooDao.insert(animal)
    }

    suspend fun getAnimalCountByName(name: String): Int {
        return zooDao.getAnimalCountByName(name)
    }

    suspend fun getAnimalByName(name: String): AnimalEntity? {
        return zooDao.getAnimalByName(name)
    }
}