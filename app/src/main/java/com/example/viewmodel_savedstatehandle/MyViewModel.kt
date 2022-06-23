package com.example.viewmodel_savedstatehandle

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MyViewModel(_counter : Int, private val savedStateHandle : SavedStateHandle) : ViewModel(){
    companion object{ //SavedStateHandle은 key-value로 값을 저장하기 때문에 Key값을 지정해줌
        private const val SAVE_STATE_KEY = "counter"
    }
    var counter = savedStateHandle.get<Int>(SAVE_STATE_KEY) ?: _counter //만약 null이면 전달받은 초기값을 입력받기

    fun saveState(){ //count값을 저장하는 함수
        savedStateHandle.set(SAVE_STATE_KEY,counter)
    }

}