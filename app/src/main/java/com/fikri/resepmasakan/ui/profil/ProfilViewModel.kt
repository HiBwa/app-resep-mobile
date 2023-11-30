package com.fikri.resepmasakan.ui.profil

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfilViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Ini Adalah Halaman Profil"
    }
    val text: LiveData<String> = _text
}