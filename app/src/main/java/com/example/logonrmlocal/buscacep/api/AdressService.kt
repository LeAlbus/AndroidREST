package com.example.logonrmlocal.buscacep.api

import com.example.logonrmlocal.buscacep.model.Adress
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AdressService{

    @GET("ws/{cep}/json/")

    fun runSearch(@Path("cep")cepValue: String): Call<Adress>
}