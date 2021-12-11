package com.example.whiterabbitmachinetest.features.employeecollection.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.whiterabbitmachinetest.features.employeecollection.models.EmployeeCollection

@Dao
interface EmployeeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data: EmployeeCollection)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(objects: List<EmployeeCollection>)

    @Query("SELECT * FROM employee_collection")
    fun getAll(): List<EmployeeCollection>
}