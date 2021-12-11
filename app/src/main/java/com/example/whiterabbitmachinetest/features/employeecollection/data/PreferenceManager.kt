package com.example.whiterabbitmachinetest.features.employeecollection.data

import android.content.Context
import android.content.SharedPreferences
import com.example.whiterabbitmachinetest.features.employeecollection.constants.Employee

class PreferenceManager(ctx: Context) {
    fun isAlreadyEmployeeFetched(): Boolean {
        return sharedPreferences.getBoolean(Employee.PREFS_IS_HAVE_EMPLOYEES,false)
    }

    fun setEmployeeFetchStatus(status: Boolean) {
        editor.putBoolean(Employee.PREFS_IS_HAVE_EMPLOYEES,status)
        editor.commit()
    }

    private var sharedPreferences: SharedPreferences = ctx.getSharedPreferences(
        Employee.PREFS_NAME,
        Context.MODE_PRIVATE
    )
    private val editor:SharedPreferences.Editor =  sharedPreferences.edit()
}