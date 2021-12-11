package com.example.whiterabbitmachinetest.features.employeecollection.views.adapters

import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.whiterabbitmachinetest.BR
import com.example.whiterabbitmachinetest.R
import com.example.whiterabbitmachinetest.features.employeecollection.models.EmployeeCollection
import com.example.whiterabbitmachinetest.features.employeecollection.models.EmployeeDetails
import com.example.whiterabbitmachinetest.features.employeecollection.views.EmployeeCollectionViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_employee_item.view.*
import org.jetbrains.anko.bundleOf
import org.jetbrains.anko.sdk27.coroutines.onClick

class EmployeeListHolder constructor(
    private val dataBinding: ViewDataBinding,
    private val employeeCollectionViewModel: EmployeeCollectionViewModel
) : RecyclerView.ViewHolder(dataBinding.root) {

    val avatarImage = itemView.item_avatar
    val employeeView = itemView.item_employee_view
    fun setup(itemData: EmployeeCollection) {
        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()

        Picasso.get().load(itemData.profile_image).placeholder(R.drawable.avatar_placeholder)
            .into(avatarImage);

        employeeView.onClick {
            val bundle = bundleOf("data" to itemData)
            itemView.findNavController()
                .navigate(R.id.action_employeeListFragment_to_employeeDetailFragment, bundle)
        }
    }
}