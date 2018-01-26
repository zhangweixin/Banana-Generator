package com.nathaniel.banana.plugin

import com.nathaniel.banana.db.DbColumnInfo
import com.nathaniel.banana.db.DbTableInfo
import com.nathaniel.banana.db.DbType
import com.nathaniel.banana.db.ResultWrapper
import org.springframework.stereotype.Component

@Component
class MysqlDbMetaInfoExtracter : DbMetaInfoExtracter {
    override fun supportDb(dbType: DbType): Boolean {
        return dbType.name == "MYSQL"
    }

    override fun extractTableInfo(tableResultWrapper: ResultWrapper): DbTableInfo {
        var tableName = tableResultWrapper.getString("Name")
        var tableComment = tableResultWrapper.getString("Comment")
        return DbTableInfo(tableName, tableComment)
    }

    override fun extractColumnInfo(columnResultWrapper: ResultWrapper): DbColumnInfo {
        var columnName = columnResultWrapper.getString("Field")
        var columnComment = columnResultWrapper.getString("Comment")
        var columnType = columnResultWrapper.getString("Type")
        var primaryKey = false
        if ("PRI" == columnResultWrapper.getString("Key")) {
            primaryKey = true
        }
        return DbColumnInfo(columnName, columnComment, primaryKey, columnType)
    }
}