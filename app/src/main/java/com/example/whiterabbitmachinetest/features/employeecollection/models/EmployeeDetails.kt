package com.example.whiterabbitmachinetest.features.employeecollection.models

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class EmployeeDetails(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("username") val username:String,
    @SerializedName("email") val email:String,
    @SerializedName("profile_image") val profile_image:String?,
    @SerializedName("address") val address:Address,
    @SerializedName("phone") val phone:String?,
    @SerializedName("website") val website:String?,
    @SerializedName("company") val company:CompanyDetails?
):Serializable
