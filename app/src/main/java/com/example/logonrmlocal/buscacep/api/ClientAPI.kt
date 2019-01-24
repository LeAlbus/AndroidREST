package com.example.logonrmlocal.buscacep.api

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientAPI<T>{

    fun getClient(c: Class<T>): T{

        val okHTTP = OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("https://viacep.com.br/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHTTP)
                .build()

        return retrofit.create(c)
    }

}

fun getAdressService():AdressService{

    val apiClient = ClientAPI<AdressService>()
    return apiClient.getClient(AdressService::class.java)
}