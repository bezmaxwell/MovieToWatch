package com.example.sejaumguia.ui.main.retrofit

import com.example.sejaumguia.ui.main.model.Categories
import com.example.sejaumguia.ui.main.model.RandomChuckNorris
import com.example.sejaumguia.ui.main.recyclerView.ValuesToPutData.descriptionData
import com.example.sejaumguia.ui.main.retrofit.service.RandomChuckNorrisService
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RandomChuckNorrisRetrofit {

        private val service:RandomChuckNorrisService

    init {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val path = "https://api.chucknorris.io/"

        val gson = GsonBuilder().setLenient().create()


        val retrofit = Retrofit.Builder()
                .baseUrl(path)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build()

        service = retrofit.create(RandomChuckNorrisService::class.java)

    }


    fun getRandomChuckNorrisDescription():Observable<RandomChuckNorris> {
            return service.repositoryRandomChuckNorris("jokes/random?category="+descriptionData).flatMap { random ->
                Observable.fromArray(random)
            }.map { random ->
                RandomChuckNorris(random.categories,random.created_at,random.icon_url,
                        random.id,random.updated_at,random.value, random.url)
            }
                .onErrorReturn { RandomChuckNorris(null,null,null,null,null,null,null) }



    }

}

