package com.fikri.resepmasakan.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TambahResepViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Halaman Tambah Resep"
    }
    val text: LiveData<String> = _text
}