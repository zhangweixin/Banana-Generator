package com.nathaniel.scffold.plugin

import com.nathaniel.scffold.db.DbType

interface DbMetaInfoSqlProvider {

    fun supportDb(dbType: DbType): Boolean

    fun getQueryAllTableSql(): String

    fun getQueryTableFullFieldInfo(tableName: String): String
}