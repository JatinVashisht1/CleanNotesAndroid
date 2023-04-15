package com.jatinvashisht.cleannotes.features.featureNote.data.local.converters

import androidx.room.TypeConverter
import com.google.gson.Gson

class ConverterListOfStringToString: IConverter<List<String>, String> {
    @TypeConverter
    override fun convertFromAToB(typeOne: List<String>): String = Gson().toJson(typeOne)

    @TypeConverter
    override fun convertFromBToA(typeTwo: String): List<String> = Gson().fromJson(typeTwo, Array<String>::class.java).toList()
}