package com.example.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.convidados.services.model.GuestModel
import com.example.convidados.services.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    // Acesso a dados
    private val guestRepository: GuestRepository = GuestRepository(application.applicationContext)

    private val _guest = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = _guest

    private val _saveGuest = MutableLiveData<Boolean>()
    val saveGuest: LiveData<Boolean> = _saveGuest

    // Salva convidado
    fun save(id: Int, name: String, presence: Boolean) {
        val guest = GuestModel().apply {
            this.id = id
            this.name = name
            this.presence = presence
        }

        if (id == 0) {
            _saveGuest.value = guestRepository.save(guest)
        } else {
            _saveGuest.value = guestRepository.update(guest)
        }
    }

    // Carrega convidado
    fun load(id: Int) {
        _guest.value = guestRepository.get(id)
    }

}