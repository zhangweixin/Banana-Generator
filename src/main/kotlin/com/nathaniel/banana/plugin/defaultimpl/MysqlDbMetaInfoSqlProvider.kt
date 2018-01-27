package com.nathaniel.banana.plugin.defaultimpl

import com.nathaniel.banana.db.DbType
import com.nathaniel.banana.plugin.DbMetaInfoSqlProvider
import org.springframework.stereotype.Component

@Component
class MysqlDbMetaInfoSqlProvider : DbMetaInfoSqlProvider {

    override fun supportDb(dbType: DbType) = "MYSQL" == dbType.name

    override fun getQueryAllTableSql() = "show table status"

    override fun getQueryTableFullFieldInfo(tableName: String) = "show full fields from `${tableName}`"
}