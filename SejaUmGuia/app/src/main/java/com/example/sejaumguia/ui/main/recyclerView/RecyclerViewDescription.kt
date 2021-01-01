package com.example.sejaumguia.ui.main.recyclerView

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.sejaumguia.R
import com.example.sejaumguia.ui.main.model.RandomChuckNorris
import com.example.sejaumguia.ui.main.recyclerView.ValuesToPutData.descriptionData
import com.example.sejaumguia.ui.main.view.fragment.ui.DescriptionFragment
import com.example.sejaumguia.ui.main.view.fragment.ui.WebViewFragment
import com.squareup.picasso.Picasso

class RecyclerViewDescription(val data: ArrayList<RandomChuckNorris>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_description, null)

        return RecyclerDescriptionMain(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as RecyclerDescriptionMain).bind(data[position])


    }

    class RecyclerDescriptionMain(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: RandomChuckNorris) {
            val image = itemView.findViewById<ImageView>(R.id.logoDescription)
            val textDescription = itemView.findViewById<TextView>(R.id.descriptionImage)
            val linkToRedirect = itemView.findViewById<TextView>(R.id.linkToRedirectJoke)
            val createdDescription = itemView.findViewById<TextView>(R.id.createdDescription)


            Picasso.get().load(data.icon_url).into(image)
            textDescription.text = data.value
            linkToRedirect.text = data.url
            createdDescription.text = data.created_at

            val actionWebView = itemView.findViewById<ImageView>(R.id.imageView)

                actionWebView.setOnClickListener { descriptionTransaction(itemView, data.url)}

                linkToRedirect.setOnClickListener { descriptionTransaction(itemView, data.url)}

        }

        fun descriptionTransaction(itemView: View, data: String?) {
            val manager: FragmentManager = (itemView.context as AppCompatActivity).supportFragmentManager
            getDataUrl.urlGet = data!!
            val fragmentManager: FragmentManager = manager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, WebViewFragment()).commit()

        }
    }

        override fun getItemCount(): Int = data.size
    }

object getDataUrl {
    var urlGet = ""
}