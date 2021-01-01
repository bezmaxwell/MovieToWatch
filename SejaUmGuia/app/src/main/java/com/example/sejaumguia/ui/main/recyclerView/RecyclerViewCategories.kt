package com.example.sejaumguia.ui.main.recyclerView

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sejaumguia.R
import com.example.sejaumguia.ui.main.model.Categories
import com.example.sejaumguia.ui.main.recyclerView.ValuesToPutData.descriptionData
import com.example.sejaumguia.ui.main.view.fragment.ui.CategoriesFragment
import com.example.sejaumguia.ui.main.view.fragment.ui.DescriptionFragment
import java.util.*


class RecyclerViewCategories(private val categories: List<Categories>):RecyclerView.Adapter<RecyclerView.ViewHolder>()  {

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.recycler_categories, null)
        return  RecyclerCategoriesMain(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RecyclerCategoriesMain)
        holder.categories.text = categories.get(position).idCategories.toString()
        holder.categories.setOnClickListener {

            val myFrag: Fragment = DescriptionFragment()
            descriptionData = categories.get(position).idCategories.toString()

            val fragmentManager: FragmentManager = (holder.itemView.context as AppCompatActivity).supportFragmentManager
            fragmentManager.beginTransaction().replace(R.id.container, myFrag).commit()

        }

    }

    inner class RecyclerCategoriesMain(itemview: View):RecyclerView.ViewHolder(itemview) {

        var categories:TextView

        init { categories = itemView.findViewById(R.id.textViewCategories) }

    }

    override fun getItemCount(): Int = categories.size


}

object ValuesToPutData { var descriptionData = "DescriptionFragment" }