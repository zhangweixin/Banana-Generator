package com.nathaniel.banana.db

data class DbColumnInfo(val columnName: String,
                        val columnComment: String?,
                        val primaryKey: Boolean,
                        val columnType: String)

