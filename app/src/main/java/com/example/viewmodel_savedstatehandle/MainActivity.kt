package com.example.viewmodel_savedstatehandle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.viewmodel_savedstatehandle.databinding.ActivityMainBinding

//SavedStateHandle 이란?
//(휘발성)메모리에 많은 양의 데이터가 들어가면 앱은 자동으로 종료되며 앱의 데이터가 사라지는데
//이때 변경된 데이터 값을 잃지 않게 보호해 주는 것이다.

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val factory = MyFactory(300, this) // 초기값 설정
        val myViewModel = ViewModelProvider(this, factory).get(MyViewModel::class.java)
        // ::class와 ::class.java의 차이점
        //By using ::class, you get an instance of KClass. It is Kotlin Reflection API,
            // that can handle Kotlin features like properties, data classes, etc.
        //By using ::class.java, you get an instance of Class.
            // It is Java Reflection API, that interops with any Java reflection code, but can't work with some Kotlin features.

        binding.textView.text = myViewModel.counter.toString()
        binding.button.setOnClickListener{
            myViewModel.counter += 1
            binding.textView.text = myViewModel.counter.toString()
            myViewModel.saveState()
        }



    }
}