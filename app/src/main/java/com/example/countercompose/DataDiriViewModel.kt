package com.example.countercompose

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class DataDiriViewModel : ViewModel() {

    private val _nama = mutableStateOf("")
    val nama: State<String> = _nama

    private val _umur = mutableStateOf("")
    val umur: State<String> = _umur

    fun onNamaChange(value: String) {
        _nama.value = value
    }

    fun onUmurChange(value: String) {
        if (value.all { it.isDigit() }) {
            _umur.value = value
        }
    }
}