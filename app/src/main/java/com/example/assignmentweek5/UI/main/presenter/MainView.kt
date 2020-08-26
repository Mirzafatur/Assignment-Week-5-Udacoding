package com.example.assignmentweek5.UI.main.presenter

import com.example.assignmentweek5.model.data.DataItem

interface MainView {

    fun onSuccess(msg : String, data : List<DataItem>?)
    fun onError(msg : String)
    fun onDelete(msg : String)


}