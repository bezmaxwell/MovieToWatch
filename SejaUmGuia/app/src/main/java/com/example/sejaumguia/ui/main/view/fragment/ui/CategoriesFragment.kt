package com.example.sejaumguia.ui.main.view.fragment.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sejaumguia.R
import com.example.sejaumguia.databinding.CategoriesFragmentBinding
import com.example.sejaumguia.ui.main.interfaceImplementation.RecyclerViewImplementation
import com.example.sejaumguia.ui.main.model.Categories
import com.example.sejaumguia.ui.main.recyclerView.RecyclerViewCategories
import com.example.sejaumguia.ui.main.retrofit.CategoriesRetrofit
import com.example.sejaumguia.ui.main.view.main.MainActivity
import com.example.sejaumguia.ui.main.view.main.MainActivity.Companion.currentFragment
import com.example.sejaumguia.ui.main.view.fragment.viewModel.CategoriesViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class CategoriesFragment : Fragment(), RecyclerViewImplementation {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<CategoriesViewModel> { viewModelFactory }


    private lateinit var mBinding: CategoriesFragmentBinding


    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity() as MainActivity).mainComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        mBinding = CategoriesFragmentBinding.inflate(layoutInflater, container, false)
        currentFragment = "Fragment_1"

        CategoriesRetrofit( ).getCategories()
        recyclerView(mBinding.root)

        return mBinding.root
    }


    @SuppressLint("CheckResult")
    override fun recyclerView(view: View) {

        val mRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerCategories)!!
        val mLayout = LinearLayoutManager(activity)

        val progressBar = view.findViewById<FrameLayout>(R.id.progressRecyclerCategories)

        val arrayCategories: ArrayList<Categories> = ArrayList()
        val categories = CategoriesRetrofit()
        categories.getCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ cat ->
                arrayCategories.add(cat)

                mRecyclerView.apply {
                    mRecyclerView.setHasFixedSize(true)
                    mRecyclerView.layoutManager = mLayout
                    progressBar.visibility = View.INVISIBLE
                    mRecyclerView.adapter = RecyclerViewCategories(arrayCategories)
                }
            },
                { e -> e.printStackTrace() })

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

         val teste = viewModel.getItems().value?.idCategories

    }

}


