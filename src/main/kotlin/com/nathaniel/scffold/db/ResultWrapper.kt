package com.nathaniel.scffold.db

import java.sql.ResultSet
import java.sql.SQLException

class ResultWrapper(var resultSet: ResultSet) {

    @Throws(SQLException::class)
    fun getString(columnIndex: Int): String = resultSet.getString(columnIndex)

    @Throws(SQLException::class)
    fun getString(columnLabel: String): String = resultSet.getString(columnLabel)

}