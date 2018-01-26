package com.nathaniel.banana.model

data class ColumnInfo(
        var entityColumnName: String,
        var primitiveColumnName: String,
        var primaryKey: Boolean,
        var columnDbType: String,
        var columnComment: String?) {


    override fun toString(): String {
        return "ColumnInfo(entityColumnName='$entityColumnName', primitiveColumnName='$primitiveColumnName', primaryKey=$primaryKey, columnComment='$columnComment', columnDbType=$columnDbType)"
    }
}