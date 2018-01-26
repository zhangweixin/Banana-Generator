package com.nathaniel.scffold.plugin

import com.nathaniel.scffold.db.DbColumnInfo
import com.nathaniel.scffold.db.DbTableInfo
import com.nathaniel.scffold.db.DbType
import com.nathaniel.scffold.db.ResultWrapper

interface DbMetaInfoExtracter {

    fun supportDb(dbType: DbType): Boolean

    fun extractTableInfo(tableResultWrapper: ResultWrapper): DbTableInfo

    fun extractColumnInfo(columnResultWrapper: ResultWrapper): DbColumnInfo
}