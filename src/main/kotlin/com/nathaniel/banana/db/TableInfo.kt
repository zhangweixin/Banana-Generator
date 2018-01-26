package com.nathaniel.banana.db

class TableInfo(val entityTableName: String,
                val primitiveTableName: String,
                val tableComment: String) {
    var columns: MutableList<ColumnInfo> = mutableListOf()

    override fun toString(): String {
        return "TableInfo(entityTableName='$entityTableName', primitiveTableName='$primitiveTableName', tableComment='$tableComment', columns=$columns)"
    }
}