package com.nathaniel.banana.plugin

import com.nathaniel.banana.db.DbColumnInfo
import com.nathaniel.banana.db.DbTableInfo
import com.nathaniel.banana.db.DbType
import com.nathaniel.banana.db.ResultWrapper

interface DbMetaInfoExtracter {

    fun supportDb(dbType: DbType): Boolean

    fun extractTableInfo(tableResultWrapper: ResultWrapper): DbTableInfo

    fun extractColumnInfo(columnResultWrapper: ResultWrapper): DbColumnInfo
}