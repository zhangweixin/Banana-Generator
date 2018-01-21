package com.nathaniel.scffold.db

import org.springframework.stereotype.Component

@Component
class MysqlDbMetaInfoSqlProvider : DbMetaInfoSqlProvider {

    override fun supportDb(dbType: DbType) = "MYSQL" == dbType.name

    override fun getQueryAllTableSql() = "show table status"

    override fun getQueryTableFullFieldInfo(tableName: String) = "show full fields from `${tableName}`"
}