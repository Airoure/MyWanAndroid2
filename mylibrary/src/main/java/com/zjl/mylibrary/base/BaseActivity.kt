package com.zjl.mylibrary.base

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zackratos.ultimatebarx.library.UltimateBarX

abstract class BaseActivity : AppCompatActivity() {
    private var mActivityProvider:ViewModelProvider? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        setStatusColor()
        initViewModel()
        observe()
        init(savedInstanceState)
    }

    open fun setStatusColor() {
        UltimateBarX.with(this)
            .color(Color.parseColor("#00ffffff"))
            .light(true)
            .fitWindow(true)
            .applyStatusBar()
    }

    abstract fun getLayout(): Int

    open fun initViewModel() {

    }

    open fun observe() {

    }

    open fun init(savedInstanceState: Bundle?) {

    }

    protected fun <T: ViewModel?> getActivityViewModel(modelClass: Class<T>):T?{
        if(mActivityProvider==null){
            mActivityProvider = ViewModelProvider(this)
        }
        return mActivityProvider?.get(modelClass)
    }
}