package com.example.sejaumguia.ui.main.retrofit.service

import com.example.sejaumguia.ui.main.model.Categories
import io.reactivex.Observable
import retrofit2.http.GET

interface CategoriesService {

    companion object {
        private const val pathCategories = "jokes/categories1"
    }

    @GET(pathCategories)
    fun getCategories(): Observable<List<Categories>>

}