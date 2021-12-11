package com.example.whiterabbitmachinetest.features.employeecollection.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.whiterabbitmachinetest.features.employeecollection.constants.Employee
import com.example.whiterabbitmachinetest.features.employeecollection.models.EmployeeCollection
import com.example.whiterabbitmachinetest.features.employeecollection.models.EmployeeDetails

@Database(entities = [EmployeeCollection::class], version = 1)
abstract class EmployeeDatabase : RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao

    companion object {
        private var instance: EmployeeDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): EmployeeDatabase {
            if (instance == null)
                instance = Room.databaseBuilder(
                    ctx.applicationContext, EmployeeDatabase::class.java,
                    Employee.DB_NAME
                )
                    .allowMainThreadQueries()
                    .build()

            return instance!!

        }
    }
}