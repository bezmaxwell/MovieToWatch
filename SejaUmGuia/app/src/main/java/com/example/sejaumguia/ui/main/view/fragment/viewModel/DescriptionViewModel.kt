package com.example.sejaumguia.ui.main.view.fragment.viewModel

import androidx.lifecycle.ViewModel
import com.example.sejaumguia.ui.main.model.RandomChuckNorris
import com.example.sejaumguia.ui.main.model.Repository
import javax.inject.Inject

class DescriptionViewModel @Inject constructor(private val repository:Repository): ViewModel() {

    var teste = repository


}