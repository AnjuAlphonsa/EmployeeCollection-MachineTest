package com.example.whiterabbitmachinetest.features.employeecollection.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whiterabbitmachinetest.databinding.FragmentEmployeeListBinding
import com.example.whiterabbitmachinetest.features.employeecollection.views.EmployeeCollectionViewModel
import com.example.whiterabbitmachinetest.features.employeecollection.views.adapters.EmployeeListAdapter
import kotlinx.android.synthetic.main.fragment_employee_list.*

/**
 * A simple [Fragment] subclass.
 */
class EmployeeListFragment : Fragment() {
    private lateinit var viewDataBinding: FragmentEmployeeListBinding
    private lateinit var adapter: EmployeeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = FragmentEmployeeListBinding.inflate(inflater, container, false).apply {
            viewmodel = ViewModelProviders.of(this@EmployeeListFragment)
                .get(EmployeeCollectionViewModel::class.java)
            lifecycleOwner = viewLifecycleOwner
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let { viewDataBinding.viewmodel?.fetchEmployeeList(it) }

        setupAdapter()
        setupObservers()
    }

    private fun setupObservers() {
        viewDataBinding.viewmodel?.employeeListLive?.observe(viewLifecycleOwner, Observer {
            adapter.updateRepoList(it)
        })

        viewDataBinding.viewmodel?.dataLoading?.observe(viewLifecycleOwner, Observer {
            progress_bar.visibility = if (it) View.VISIBLE else View.GONE
        })
    }

    private fun setupAdapter() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            adapter = EmployeeListAdapter(viewDataBinding.viewmodel!!)
            val layoutManager = LinearLayoutManager(activity)
            employee_list.layoutManager = layoutManager
            employee_list.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    layoutManager.orientation
                )
            )
            employee_list.adapter = adapter
        }
    }

}