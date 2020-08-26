package com.example.assignmentweek5.UI.input.presenter

import com.example.assignmentweek5.model.action.ResponseAction

interface InputView {

    fun onSuccessInput(response : ResponseAction )
    fun onError(msg : String)
    fun onSuccessUpdate(response: ResponseAction)
}