package com.example.convidados.services.repository

import android.content.Context
import com.example.convidados.services.model.GuestModel

class GuestRepository(context: Context){

    private val dataBase = GuestDataBase.getDatabase(context).guestDAO()

    fun update(guest: GuestModel): Boolean {
        return dataBase.update(guest) > 0
    }

    fun delete(guest: GuestModel) {
        dataBase.delete(guest)
    }

    fun get(id: Int): GuestModel {
        return dataBase.load(id)
    }

    fun save(guest: GuestModel): Boolean {
        return dataBase.save(guest) > 0
    }

    fun getAll(): List<GuestModel> {
        return dataBase.getInvited()
    }

    fun getPresent(): List<GuestModel> {
        return dataBase.getPresent()
    }

    fun getAbsent(): List<GuestModel> {
        return dataBase.getAbsent()
    }

}