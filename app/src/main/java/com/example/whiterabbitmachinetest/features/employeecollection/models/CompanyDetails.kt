package com.example.whiterabbitmachinetest.features.employeecollection.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CompanyDetails(
    @SerializedName("name") val companyName:String,
    @SerializedName("catchPhrase") val catchPhrase:String,
    @SerializedName("bs") val bs:String
):Serializable
