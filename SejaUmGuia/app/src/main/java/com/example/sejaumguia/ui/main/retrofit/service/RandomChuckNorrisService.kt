package com.example.sejaumguia.ui.main.retrofit.service

import android.content.Intent
import com.example.sejaumguia.ui.main.model.RandomChuckNorris
import com.example.sejaumguia.ui.main.recyclerView.ValuesToPutData
import com.example.sejaumguia.ui.main.recyclerView.ValuesToPutData.descriptionData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface RandomChuckNorrisService {

    @GET
    fun repositoryRandomChuckNorris(@Url idCategories:String): Observable<RandomChuckNorris>


}