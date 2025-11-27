package com.example.linearandconstrainlayouts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TenantViewModel : ViewModel() {
    // First Name
    private val _firstName = MutableLiveData<String>()
    val firstName: LiveData<String> get() = _firstName

    // Second Name
    private val _secondName = MutableLiveData<String>()
    val secondName: LiveData<String> get() = _secondName

    // Apartment Number
    private val _apartmentNumber = MutableLiveData<String>()
    val apartmentNumber: LiveData<String> get() = _apartmentNumber

    fun setFirstName(name: String?) {
        _firstName.value = name ?: "N/A"
    }

    fun setSecondName(name: String?) {
        _secondName.value = name ?: "N/A"
    }

    fun setApartmentNumber(number: String?) {
        _apartmentNumber.value = number ?: "N/A"
    }
}
