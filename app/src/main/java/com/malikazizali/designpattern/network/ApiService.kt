package com.malikazizali.designpattern.network

import com.malikazizali.designpattern.model.DataCarItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("admin/car")
    fun getAllCar() : Call<List<DataCarItem>>
}