package com.example.assignmentweek5.UI.main.presenter


import com.example.assignmentweek5.network.NetworkModule
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainPresenter(val main : MainView) {

    fun showData() {

        NetworkModule.service().getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                if (response.isSuccess == true){
                    main.onSuccess(response.message ?: "", response.data)
                }
                else {
                    main.onError("data tidak ada")
                }
            } , { error ->
                main.onError(error.localizedMessage ?: "")
            })
    }

    fun deleteData(idMahasiswa : String) {
        NetworkModule.service().deleteData(idMahasiswa)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                main.onDelete("Sukses menghapus data")
                showData()
            } , {
                main.onError(it.localizedMessage)
            })
    }
}