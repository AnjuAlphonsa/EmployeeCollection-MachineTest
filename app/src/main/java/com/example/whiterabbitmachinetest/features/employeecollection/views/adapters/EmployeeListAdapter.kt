package com.example.whiterabbitmachinetest.features.employeecollection.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whiterabbitmachinetest.databinding.LayoutEmployeeItemBinding
import com.example.whiterabbitmachinetest.features.employeecollection.models.EmployeeCollection
import com.example.whiterabbitmachinetest.features.employeecollection.models.EmployeeDetails
import com.example.whiterabbitmachinetest.features.employeecollection.views.EmployeeCollectionViewModel

class EmployeeListAdapter(private val repoListViewModel: EmployeeCollectionViewModel) : RecyclerView.Adapter<EmployeeListHolder>() {
    var repoList: List<EmployeeCollection> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeListHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = LayoutEmployeeItemBinding.inflate(inflater, parent, false)
        return EmployeeListHolder(dataBinding, repoListViewModel)
    }

    override fun getItemCount() = repoList.size

    override fun onBindViewHolder(holder: EmployeeListHolder, position: Int) {
        holder.setup(repoList[position])
    }

    fun updateRepoList(repoList: List<EmployeeCollection>) {
        this.repoList = repoList
        notifyDataSetChanged()
    }
}