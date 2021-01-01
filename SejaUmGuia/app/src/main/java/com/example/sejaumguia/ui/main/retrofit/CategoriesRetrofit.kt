package com.example.sejaumguia.ui.main.retrofit

import com.example.sejaumguia.ui.main.model.Categories
import com.example.sejaumguia.ui.main.retrofit.service.CategoriesService
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class CategoriesRetrofit  {

    private var service: CategoriesService

     init{

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val timeConnection = OkHttpClient.Builder().connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)

        val httpClient = timeConnection
        httpClient.addInterceptor(logging).build()

        val path = "https://demo5768403.mockable.io/"
        val gson = GsonBuilder().setLenient().create()


        val retrofit = Retrofit.Builder()
            .baseUrl(path)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build())
            .build()

        service = retrofit.create(CategoriesService::class.java)

    }



    fun getCategories(): Observable<Categories> {

        return service.getCategories().flatMap { categoriesObserver ->
            Observable.just(categoriesObserver)

        }
            .flatMapIterable { it}
          .map { Categories(it.idCategories) }


            .onErrorReturn { Categories(it.message.toString()) }
    }
}




