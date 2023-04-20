package com.jatinvashisht.cleannotes.features.featureNote.domain.converters

/**
 * Interface containing method definitions to convert a data of **type A** to **type B**
 * @param [A] type one data type
 * @param [B] type two data type
 * @author Jatin Vashisht (https://www.github.com/jatinvashisht1)
 * */
interface IConverter<A, B> {

    /**
     * Method to convert object of *type A* to object of *type B*.
     * @param [typeOne] object of *typeOne* data type.
     * */
    fun convertFromAToB(typeOne: A): B

    /**
     * Method to convert object of *type B* to object of *type A*.
     * @param [typeTwo] object of *typeTwo* data type.
     * */
    fun convertFromBToA(typeTwo: B): A
}