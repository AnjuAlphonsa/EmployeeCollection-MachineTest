package com.example.whiterabbitmachinetest.features.employeecollection.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Address(
    @SerializedName("street") val street:String,
    @SerializedName("suite") val suite:String,
    @SerializedName("city") val city:String,
    @SerializedName("zipcode") val zipcode:String,
    @SerializedName("geo") val geo:Geo
):Serializable
