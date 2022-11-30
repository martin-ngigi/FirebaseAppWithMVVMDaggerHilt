package com.example.firebaseappwithmvvmdaggerhilt.util

sealed class UIStates<out T> {
    object Loading: UIStates<Nothing>()
    data class Success<out T>(val data: T): UIStates<T>()
    data class Failure(val error: String): UIStates<Nothing>()
}