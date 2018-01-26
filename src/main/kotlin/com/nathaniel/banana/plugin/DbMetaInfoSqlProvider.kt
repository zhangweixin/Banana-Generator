package com.nathaniel.banana.plugin

import com.nathaniel.banana.db.DbType

interface DbMetaInfoSqlProvider {

    fun supportDb(dbType: DbType): Boolean

    fun getQueryAllTableSql(): String

    fun getQueryTableFullFieldInfo(tableName: String): String
}