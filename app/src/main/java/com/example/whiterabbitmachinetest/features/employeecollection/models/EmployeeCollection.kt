package com.example.whiterabbitmachinetest.features.employeecollection.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "employee_collection")
data class EmployeeCollection(
    @PrimaryKey val id: Int,
    @ColumnInfo(name="name") val name: String,
    @ColumnInfo(name="username") val username:String,
    @ColumnInfo(name="email") val email:String,
    @ColumnInfo(name="profile_image") val profile_image:String?,
    @ColumnInfo(name="address_street") val street:String,
    @ColumnInfo(name="address_suite") val suite:String,
    @ColumnInfo(name="address_city") val city:String,
    @ColumnInfo(name="address_zipcode") val zipcode:String,
    @ColumnInfo(name="address_lat") val lat: String,
    @ColumnInfo(name="address_lng") val lng: String,
    @ColumnInfo(name="phone") val phone:String?,
    @ColumnInfo(name="website") val website:String?,
    @ColumnInfo(name="company_name") val companyName:String?,
    @ColumnInfo(name="company_catchPhrase") val catchPhrase:String?,
    @ColumnInfo(name="company_bs") val bs:String?
):Serializable
