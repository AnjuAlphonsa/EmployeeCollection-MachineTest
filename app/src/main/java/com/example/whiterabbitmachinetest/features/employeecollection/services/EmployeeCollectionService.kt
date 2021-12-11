package com.example.whiterabbitmachinetest.features.employeecollection.services

import android.content.Context
import com.example.whiterabbitmachinetest.features.employeecollection.data.EmployeeCollectionRepository
import com.example.whiterabbitmachinetest.features.employeecollection.data.EmployeeDao
import com.example.whiterabbitmachinetest.features.employeecollection.data.EmployeeDatabase
import com.example.whiterabbitmachinetest.features.employeecollection.data.PreferenceManager
import com.example.whiterabbitmachinetest.features.employeecollection.models.EmployeeCollection
import com.example.whiterabbitmachinetest.features.employeecollection.models.EmployeeDetails

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmployeeCollectionService(ctx: Context) {
    private val datasource= EmployeeCollectionRepository(ctx)

    fun getEmployeeCollection(onResult: (isSuccess: Boolean, response: List<EmployeeCollection>?) -> Unit) {
        if (datasource.getStatus()) {
            onResult(true, datasource.getEmployeeCollection())
        } else {
            ApiInterface.create().getEmployees().enqueue(object : Callback<List<EmployeeDetails>> {
                override fun onResponse(
                    call: Call<List<EmployeeDetails>>?,
                    response: Response<List<EmployeeDetails>>?
                ) {
                    if (response != null && response.isSuccessful) {
                        response.body()?.let {
                            datasource.insertEmployeeCollection(it)
                            datasource.setStatus()
                            getEmployeeCollection(onResult)
                        }
                    } else
                        onResult(false, null)
                }

                override fun onFailure(call: Call<List<EmployeeDetails>>?, t: Throwable?) {
                    onResult(false, null)
                }

            })
        }
    }


    companion object {
        private var INSTANCE: EmployeeCollectionService? = null
        fun getInstance(ctx: Context) = INSTANCE
            ?: EmployeeCollectionService(ctx).also {
                INSTANCE = it
            }
    }
}