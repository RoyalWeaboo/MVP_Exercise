package com.malikazizali.designpattern.presenter

import com.malikazizali.designpattern.model.DataCarItem
import com.malikazizali.designpattern.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarPresenter (val carView: CarView){

    fun getCar(){
        ApiClient.instance.getAllCar()
            .enqueue(object : Callback<List<DataCarItem>>{
                override fun onResponse(
                    call: Call<List<DataCarItem>>,
                    response: Response<List<DataCarItem>>
                ) {
                    if(response.isSuccessful){
                        carView.onSuccess(response.message(), response.body()!!)
                    }
                    else{
                        carView.onFailure(response.message())
                    }

                }

                override fun onFailure(call: Call<List<DataCarItem>>, t: Throwable) {
                    carView.onFailure(t.message!!)
                }

            })
    }

}