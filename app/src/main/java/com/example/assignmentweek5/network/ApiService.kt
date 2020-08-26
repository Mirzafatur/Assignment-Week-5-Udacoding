package com.example.assignmentweek5.network

import com.example.assignmentweek5.model.action.ResponseAction
import com.example.assignmentweek5.model.data.ResponseMahasiswa
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    //getData
    @GET("getData.php")
    fun getData(): Observable<ResponseMahasiswa>

    //getDataById
    @GET("getData.php")
    fun getDataById(@Query("id") id: String) : Call<ResponseMahasiswa>

    //insert
    @FormUrlEncoded
    @POST("insertData.php")
    fun insertData(@Field("nama") nama: String,
                   @Field("nohp") nohp: String,
                   @Field("alamat") alamat: String) : Observable<ResponseAction>

    //update
    @FormUrlEncoded
    @POST("updateData.php")
    fun updateData(@Field("id") id: String,
                   @Field("nama") nama: String,
                   @Field("nohp") nohp: String,
                   @Field("alamat") alamat: String) : Observable<ResponseAction>

    @FormUrlEncoded
    @POST("deleteData.php")
    fun deleteData(@Field("id") id: String) : Single<ResponseAction>
}