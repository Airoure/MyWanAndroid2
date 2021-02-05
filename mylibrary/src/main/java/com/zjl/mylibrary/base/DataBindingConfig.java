package com.zjl.mylibrary.base;

import android.util.SparseArray;

import androidx.lifecycle.ViewModel;

public class DataBindingConfig {

    private int layoutId;

    private ViewModel stateViewModel;

    private SparseArray bindingParams = new SparseArray();

    public DataBindingConfig(int layoutId,ViewModel stateViewModel){
        this.layoutId = layoutId;
        this.stateViewModel = stateViewModel;
    }

    public DataBindingConfig(int layout) {
        this.layoutId = layout;
    }

    public ViewModel getStateViewModel() {
        return stateViewModel;
    }

    public SparseArray getBindingParams() {
        return bindingParams;
    }

    public DataBindingConfig addBindingParam(int variableId, Object object) {
        if (bindingParams.get(variableId) == null) {
            bindingParams.put(variableId, object);
        }
        return this;
    }
}
