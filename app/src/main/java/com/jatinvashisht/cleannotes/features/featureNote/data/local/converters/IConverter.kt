package com.jatinvashisht.cleannotes.features.featureNote.data.local.converters

interface IConverter<A, B> {
    fun convertFromAToB(typeOne: A): B
    fun convertFromBToA(typeTwo: B): A
}