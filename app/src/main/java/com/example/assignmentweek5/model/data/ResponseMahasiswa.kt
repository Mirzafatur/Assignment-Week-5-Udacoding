package com.example.assignmentweek5.model.data

import com.google.gson.annotations.SerializedName

data class ResponseMahasiswa(
    @field:SerializedName("isSuccess")
    val isSuccess: Boolean? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("data")
    val data: List<DataItem>? = null
)