package com.zjl.mylibrary.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseFragment : Fragment() {
    lateinit var mContext: Context
    lateinit var mActivity: AppCompatActivity
    private var fragmentProvider: ViewModelProvider? = null
    private var activityProvider: ViewModelProvider? = null
    private var dataBindingConfig: DataBindingConfig? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
        mActivity = context as AppCompatActivity
        initViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getLayoutId().let {
            val binding: ViewDataBinding =
                DataBindingUtil.inflate(inflater, it, container, false)
            binding.lifecycleOwner = viewLifecycleOwner
            dataBindingConfig = getDataBindingConfig()

        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(savedInstanceState)
    }

    open fun initViewModel() {

    }

    abstract fun getLayoutId(): Int

    abstract fun getDataBindingConfig(): DataBindingConfig

    open fun init(savedInstanceState: Bundle?) {


    }

    protected fun<T:ViewModel> getActivityViewModel(modelClass:Class<T>):T?{
        if(activityProvider==null){
            activityProvider = ViewModelProvider(mActivity)
        }
        return activityProvider?.get(modelClass)
    }

    protected fun<T:ViewModel> getFragmentViewModel(modelClass: Class<T>):T?{
        if(fragmentProvider==null){
            fragmentProvider = ViewModelProvider(this)
        }
        return fragmentProvider?.get(modelClass)
    }
}