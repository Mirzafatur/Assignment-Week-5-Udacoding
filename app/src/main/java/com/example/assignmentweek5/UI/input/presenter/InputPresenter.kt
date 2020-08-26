package com.example.assignmentweek5.UI.input.presenter

import com.example.assignmentweek5.network.NetworkModule
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class InputPresenter(val input : InputView) {

    fun inputData(nama : String, noHp : String, alamat : String){

        NetworkModule.service().insertData(nama, noHp, alamat)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                if (response.isSuccess == true){
                    input.onSuccessInput(response)
                } else{
                    input.onError(response?.message ?: "")
                }
            } , { error ->
                input.onError(error.localizedMessage)
            })
    }

    fun updateData(id : String, nama : String, noHp: String, alamat: String){

        NetworkModule.service().updateData(id, nama, noHp, alamat)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                if (response.isSuccess == true) {
                    input.onSuccessUpdate(response)
                } else {
                    input.onError(response?.message ?: "")
                }
            } , { error ->
                input.onError(error.localizedMessage)
            })
    }
}