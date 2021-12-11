package com.example.whiterabbitmachinetest.features.employeecollection.views

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.whiterabbitmachinetest.features.employeecollection.models.EmployeeCollection
import com.example.whiterabbitmachinetest.features.employeecollection.models.EmployeeDetails
import com.example.whiterabbitmachinetest.features.employeecollection.services.EmployeeCollectionService

class EmployeeCollectionViewModel : ViewModel() {
    val empty = MutableLiveData<Boolean>().apply { value = false }
    val dataLoading = MutableLiveData<Boolean>().apply { value = false }
    val toastMessage = MutableLiveData<String>()
    val employeeListLive = MutableLiveData<List<EmployeeCollection>>()

    fun fetchEmployeeList(ctx: Context) {
        dataLoading.value = true
        EmployeeCollectionService.getInstance(ctx).getEmployeeCollection { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                employeeListLive.value = response
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }
}