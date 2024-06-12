package com.example.zooapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ZooDao {
    @Query("SELECT * FROM animals ORDER BY name ASC")
    fun getAllAnimals(): LiveData<List<AnimalEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(animal: AnimalEntity)

    @Delete
    suspend fun delete(animal: AnimalEntity)

    @Query("SELECT COUNT(*) FROM animals WHERE LOWER(name) = LOWER(:name)")
    suspend fun getAnimalCountByName(name: String): Int
}