package com.example.whiterabbitmachinetest.features.employeecollection.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.whiterabbitmachinetest.BR
import com.example.whiterabbitmachinetest.R
import com.example.whiterabbitmachinetest.databinding.FragmentEmployeeDetailBinding
import com.example.whiterabbitmachinetest.databinding.FragmentEmployeeListBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_employee_item.*

/**
 * A simple [Fragment] subclass.
 */
class EmployeeDetailFragment : Fragment() {
    private lateinit var viewDataBinding: FragmentEmployeeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = FragmentEmployeeDetailBinding.inflate(inflater, container, false)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.let { EmployeeDetailFragmentArgs.fromBundle(it).data }
        viewDataBinding.setVariable(BR.itemData, data)
        viewDataBinding.executePendingBindings()

        Picasso.get().load(data?.profile_image).placeholder(R.drawable.avatar_placeholder)
            .into(item_avatar)
    }

}