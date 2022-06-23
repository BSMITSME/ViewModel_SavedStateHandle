package com.example.viewmodel_savedstatehandle

import android.os.Bundle
import androidx.lifecycle.*
import androidx.savedstate.SavedStateRegistryOwner

class MyFactory(
    private val count : Int,
    owner: SavedStateRegistryOwner,
    defaultArgs : Bundle? = null) : AbstractSavedStateViewModelFactory(owner,defaultArgs)  {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        if(modelClass.isAssignableFrom(MyViewModel::class.java)){//특정 Class가 어떤 클래스/인터페이스를 상속/구현했는지 체크
            return MyViewModel(count,handle) as T
        }
        throw IllegalArgumentException("view model class not found")
    }

}