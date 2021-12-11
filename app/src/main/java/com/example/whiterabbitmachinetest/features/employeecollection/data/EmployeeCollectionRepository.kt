package com.example.whiterabbitmachinetest.features.employeecollection.data

import android.content.Context
import com.example.whiterabbitmachinetest.features.employeecollection.models.EmployeeCollection
import com.example.whiterabbitmachinetest.features.employeecollection.models.EmployeeDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EmployeeCollectionRepository(ctx: Context) {
    fun getStatus(): Boolean {
        return mPrefsManager.isAlreadyEmployeeFetched()
    }

    fun getEmployeeCollection(): List<EmployeeCollection>? {
        return dbDao.getAll()
    }

    fun insertEmployeeCollection(it: List<EmployeeDetails>) {
            for (details in it) {
                val employeeCollection = EmployeeCollection(
                    details.id,
                    details.name,
                    details.username,
                    details.email,
                    details.profile_image,
                    details.address.street,
                    details.address.suite,
                    details.address.city,
                    details.address.zipcode,
                    details.address.geo.lat,
                    details.address.geo.lng,
                    details.phone,
                    details.website,
                    if(details.company==null) null else details.company.companyName,
                    if(details.company==null) null else details.company.catchPhrase,
                    if(details.company==null) null else details.company.bs
                )
                    dbDao.insert(employeeCollection)
            }
    }

    fun setStatus() {
        mPrefsManager.setEmployeeFetchStatus(true)
    }


    private val mPrefsManager = PreferenceManager(ctx)
    private val dbDao: EmployeeDao = EmployeeDatabase.getInstance(ctx).employeeDao()
}