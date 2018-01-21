package com.nathaniel.scffold.db

interface DbMetaInfoSqlProvider {

    fun supportDb(dbType: DbType): Boolean

    fun getQueryAllTableSql(): String

    fun getQueryTableFullFieldInfo(tableName: String): String
}