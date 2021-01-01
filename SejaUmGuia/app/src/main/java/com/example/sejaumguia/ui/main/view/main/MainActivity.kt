package com.example.sejaumguia.ui.main.view.main

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import com.example.sejaumguia.R
import com.example.sejaumguia.ui.main.model.Categories
import com.example.sejaumguia.ui.main.view.app.MyApp
import com.example.sejaumguia.ui.main.view.fragment.di.MainComponent
import com.example.sejaumguia.ui.main.view.fragment.ui.CategoriesFragment
import com.example.sejaumguia.ui.main.view.fragment.ui.DescriptionFragment
import javax.inject.Inject
import kotlin.math.log

class MainActivity : AppCompatActivity() {


    lateinit var mainComponent: MainComponent

    companion object {
       lateinit var currentFragment: String
       val fragment1 = "Fragment_1"
       val fragment2 = "Fragment_2"
       val fragment3 = "Fragment_3"
   }

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent = (applicationContext as MyApp).appComponent.mainComponent().create()


        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, CategoriesFragment()).commitNow()
        }

        val users = Observer<String> { newName ->
            val name = findViewById<TextView>(R.id.message)
            name.text = newName
        }


    }

    override fun onBackPressed() { displayPreviousFragment(currentFragment) }


     private  fun displayPreviousFragment(currentFragment: String?) {

        var fragment: Fragment? = null

         when (currentFragment) {

            fragment1 -> moveTaskToBack(true)
            fragment2 -> fragment = CategoriesFragment()
            fragment3 -> fragment = DescriptionFragment()
        }

        if (fragment != null) {

            val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
            ft.replace(R.id.container, fragment)
            ft.commit()
        }
    }
}