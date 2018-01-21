package com.nathaniel.scffold.db

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