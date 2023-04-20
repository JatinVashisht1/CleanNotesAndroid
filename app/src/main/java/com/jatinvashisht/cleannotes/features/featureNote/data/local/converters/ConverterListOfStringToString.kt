package com.jatinvashisht.cleannotes.features.featureNote.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.jatinvashisht.cleannotes.features.featureNote.domain.converters.IConverter

/**
 * Concrete implementation of *IConverter* interface.
 *
 * Class to convert **List of String ** to **String** and vice-versa.
 * @author Jatin Vashisht (https://www.github.com/jatinvashisht1)
 * */
class ConverterListOfStringToString: IConverter<List<String>, String> {

    /**
     * Method to convert object of *List of String* to object of *String*.
     * @param [typeOne] object of *List of String* data type.
     * */
    @TypeConverter
    override fun convertFromAToB(typeOne: List<String>): String = Gson().toJson(typeOne)

    /**
     * Method to convert object of *String* to object of *List of String*.
     * @param [typeTwo] object of *String* data type.
     * */
    @TypeConverter
    override fun convertFromBToA(typeTwo: String): List<String> = Gson().fromJson(typeTwo, Array<String>::class.java).toList()
}