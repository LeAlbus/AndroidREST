package com.example.logonrmlocal.buscacep.model

import com.google.gson.annotations.SerializedName

data class Adress(

        val cep: String,
        @SerializedName("logradouro") val log: String,
        @SerializedName("complemento") val comp: String,
        val bairro: String,
        val local: String,
        val uf: String
)