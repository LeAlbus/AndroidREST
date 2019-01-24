package com.example.logonrmlocal.buscacep.ui.search

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.logonrmlocal.buscacep.model.Adress
import com.example.logonrmlocal.buscacep.repo.AdressRepo

class SearchViewModel: ViewModel(){

    val adressRepo = AdressRepo()
    val adress = MutableLiveData<Adress>()
    val errorMsg = MutableLiveData<String>()
    val searchRunning = MutableLiveData<Boolean>()

    fun search(cep: String){

        searchRunning.value = true

        adressRepo.search(
                cep,
                onComplete = {
                    this.adress.value = it
                    searchRunning.value = false

                }, onError = {

                    this.adress.value = null
                    this.errorMsg.value = it?.message
                    searchRunning.value = false
        }
        )
    }
}