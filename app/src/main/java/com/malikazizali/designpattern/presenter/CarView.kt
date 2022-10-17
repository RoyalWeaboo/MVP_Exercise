package com.malikazizali.designpattern.presenter

import com.malikazizali.designpattern.model.DataCarItem

interface CarView {
    fun onSuccess(msg : String, car : List<DataCarItem>)
    fun onFailure(msg : String)
}