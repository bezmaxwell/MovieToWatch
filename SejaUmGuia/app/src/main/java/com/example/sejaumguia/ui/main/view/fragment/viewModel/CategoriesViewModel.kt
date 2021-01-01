package com.example.sejaumguia.ui.main.view.fragment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sejaumguia.ui.main.model.Categories
import com.example.sejaumguia.ui.main.model.Repository
import javax.inject.Inject

class CategoriesViewModel @Inject constructor(private val repository:Repository) : ViewModel() {

    private val _categories by lazy { MutableLiveData<Categories>() }
    private val _stringSend by lazy {MutableLiveData<String>()}


    fun getItems(): MutableLiveData<Categories> { return _categories }

    fun getString(): MutableLiveData<String> { return _stringSend }

}