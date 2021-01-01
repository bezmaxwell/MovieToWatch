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
import com.example.sejaumguia.databinding.DescriptionFragmentBinding
import com.example.sejaumguia.ui.main.interfaceImplementation.RecyclerViewImplementation
import com.example.sejaumguia.ui.main.model.RandomChuckNorris
import com.example.sejaumguia.ui.main.recyclerView.RecyclerViewDescription
import com.example.sejaumguia.ui.main.retrofit.RandomChuckNorrisRetrofit
import com.example.sejaumguia.ui.main.view.main.MainActivity
import com.example.sejaumguia.ui.main.view.main.MainActivity.Companion.currentFragment
import com.example.sejaumguia.ui.main.view.fragment.viewModel.DescriptionViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class DescriptionFragment : Fragment(), RecyclerViewImplementation {

    private lateinit var mBinding: DescriptionFragmentBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<DescriptionViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).mainComponent.inject(this)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        mBinding  = DescriptionFragmentBinding.inflate(inflater, container, false)
        currentFragment="Fragment_2"

        RandomChuckNorrisRetrofit().getRandomChuckNorrisDescription()
        recyclerView(mBinding.root)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    @SuppressLint("CheckResult")
   override fun recyclerView(view: View) {

       val mRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerDescription)!!
        val mLayout = LinearLayoutManager(activity)

        val progressBar = view.findViewById<FrameLayout>(R.id.progressRecyclerDescription)

        val arrayList:ArrayList<RandomChuckNorris> = ArrayList()

        val random = RandomChuckNorrisRetrofit()
        random.getRandomChuckNorrisDescription()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ randomValue ->
                    arrayList.add(randomValue)

                    mRecyclerView.apply {
                        mRecyclerView.layoutManager = mLayout
                        mRecyclerView.adapter = RecyclerViewDescription(arrayList)

                    }
                    progressBar.visibility = View.INVISIBLE

                })

    }
}