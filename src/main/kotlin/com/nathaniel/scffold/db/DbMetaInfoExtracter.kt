package com.nathaniel.scffold.db

interface DbMetaInfoExtracter {

    fun supportDb(dbType: DbType): Boolean

    fun extractTableInfo(tableResultWrapper: ResultWrapper): DbTableInfo

    fun extractColumnInfo(columnResultWrapper: ResultWrapper): DbColumnInfo
}