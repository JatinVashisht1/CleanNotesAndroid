package com.jatinvashisht.cleannotes.core

/**
 * Sealed class to represent state of screen, i.e, [Error], [Loading], [Success].
 * */
sealed class Resource<T> {
    data class Error<T>(val error: String) : Resource<T>()
    class Loading<T>: Resource<T>()
    data class Success<T>(val data: T): Resource<T>()
}
