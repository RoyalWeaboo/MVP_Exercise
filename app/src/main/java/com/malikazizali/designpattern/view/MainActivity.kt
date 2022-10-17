package com.malikazizali.designpattern.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.malikazizali.designpattern.R
import com.malikazizali.designpattern.databinding.ActivityMainBinding
import com.malikazizali.designpattern.model.DataCarItem
import com.malikazizali.designpattern.presenter.CarPresenter
import com.malikazizali.designpattern.presenter.CarView

class MainActivity : AppCompatActivity(), CarView {
    lateinit var carPresenter: CarPresenter
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        carPresenter = CarPresenter(this)
        carPresenter.getCar()
    }

    override fun onSuccess(msg: String, car: List<DataCarItem>) {
        binding.rvMain.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvMain.adapter = CarAdapter(car)
    }

    override fun onFailure(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}