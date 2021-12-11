package com.example.whiterabbitmachinetest.features.employeecollection.services

import com.example.whiterabbitmachinetest.features.employeecollection.models.EmployeeDetails
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("v2/5d565297300000680030a986")
    fun getEmployees() : Call<List<EmployeeDetails>>

    companion object {

        private var BASE_URL = "https://www.mocky.io/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}