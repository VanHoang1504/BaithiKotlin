package com.example.thikotlin02

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class XeHoi_Viewmodel: ViewModel() {
    private val _apiService = SERVICE
    val _product: MutableState<List<XeHoi>> = mutableStateOf(emptyList())
    fun getProduct() {
        viewModelScope.launch {
            try {
                _product.value = _apiService.GET_PRODUCT()
            } catch (e: Exception) {
                println("Error: ${e.message}")
            }
        }
    }

    fun addProduct(item: XeHoi) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _apiService.ADD_PRODUCT(item)
            } catch (e: Exception) {
                println("Error: ${e.message}")
            }
        }
    }

    fun deleteProduct(item: XeHoi) {
        _product.value = _product.value.filter { it != item }
        viewModelScope.launch {
            try {
                _apiService.DELETE_PRODUCT(item.id)
            } catch (e: Exception) {
                println("Error: ${e.message}")
            }
        }
    }
    fun updateProduct(item: XeHoi) {
        viewModelScope.launch {
            try {
                _apiService.UPDATE_PRODUCT(item.id, item)
            } catch (e: Exception) {
                println("Error: ${e.message}")
            }
        }
    }
}