package com.example.logonrmlocal.buscacep.repo

import com.example.logonrmlocal.buscacep.api.getAdressService
import com.example.logonrmlocal.buscacep.model.Adress
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdressRepo{

    fun search(cep: String,
               onComplete: (Adress?) -> Unit,
               onError: (Throwable?) -> Unit){
        getAdressService()
                .runSearch(cep)
                .enqueue(object: Callback<Adress>{
                    override fun onFailure(call: Call<Adress>?, t: Throwable?) {
                        onError(t)
                    }

                    override fun onResponse(call: Call<Adress>?, response: Response<Adress>?) {

                        if (response?.isSuccessful == true){
                            onComplete(response?.body())

                        } else {
                            onError(Throwable(response?.errorBody().toString()))
                        }

                    }
                })

    }
}