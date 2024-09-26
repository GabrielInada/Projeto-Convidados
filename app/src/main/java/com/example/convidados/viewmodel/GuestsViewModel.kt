package com.example.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.convidados.services.constants.GuestConstants
import com.example.convidados.services.model.GuestModel
import com.example.convidados.services.repository.GuestRepository

class GuestsViewModel(application: Application) : AndroidViewModel(application) {

    private var mGuestRepository: GuestRepository = GuestRepository(application.applicationContext)

    private val mGuestList = MutableLiveData<List<GuestModel>>()
    val guestsList: LiveData<List<GuestModel>> = mGuestList

    fun load(filter: Int) {

        if (filter == GuestConstants.FILTER.EMPTY) {
            mGuestList.value = mGuestRepository.getAll()
        } else if (filter == GuestConstants.FILTER.PRESENT) {
            mGuestList.value = mGuestRepository.getPresent()
        } else {
            mGuestList.value = mGuestRepository.getAbsent()
        }
    }

    fun delete(id: Int) {
        mGuestRepository.delete(mGuestRepository.get(id))
    }
}