package com.nathaniel.banana.db

import cn.hutool.core.util.StrUtil
import cn.hutool.db.SqlRunner
import cn.hutool.db.handler.RsHandler
import com.nathaniel.banana.plugin.DbMetaInfoExtracter
import com.nathaniel.banana.plugin.DbMetaInfoSqlProvider
import java.sql.ResultSet
import javax.sql.DataSource

class DbInfoParser(
        val sqlProviders: List<DbMetaInfoSqlProvider>,
        val extracters: List<DbMetaInfoExtracter>,
        val dataSource: DataSource) {
    private var sqlProvider: DbMetaInfoSqlProvider? = null
    private var extracter: DbMetaInfoExtracter? = null
    fun execute() {

        val sqlRunner = SqlRunner.create(dataSource)
        val dialect = sqlRunner.runner.dialect
        val dbType = DbType.valueOf(dialect.dialectName().name)
        sqlProvider = sqlProviders.firstOrNull { it.supportDb(dbType) }
        extracter = extracters.firstOrNull { it.supportDb(dbType) }

        sqlProvider?.let { } ?: throw RuntimeException("")
        extracter?.let { } ?: throw RuntimeException("")
        val dbTableInfos = parseTableInfo(sqlRunner)
        val tableInfos = dbTableInfos.map {
            TableInfo(StrUtil.upperFirst(StrUtil.toCamelCase(it.tableName)), it.tableName, it.tableComment)
        }

        tableInfos.forEach { parseColumnInfo(it, sqlRunner) }
        tableInfos.forEach {
            println("${it.entityTableName},${it.primitiveTableName},${it.tableComment}")
            it.columns.forEach {
                println("   ${it.entityColumnName}, ${it.primitiveColumnName}, ${it.primaryKey}, ${it.columnDbType}, ${it.columnComment}")
            }
            println("\n\n")
        }
    }

    private fun parseTableInfo(sqlRunner: SqlRunner): List<DbTableInfo> {

        return sqlRunner.query(sqlProvider!!.getQueryAllTableSql(), RsHandler<List<DbTableInfo>> { rs: ResultSet ->
            val dbTableInfos = mutableListOf<DbTableInfo>()
            while (rs.next()) {
                val resultWrapper = ResultWrapper(rs)
                dbTableInfos.add(extracter!!.extractTableInfo(resultWrapper))
            }
            return@RsHandler dbTableInfos
        })
    }

    private fun parseColumnInfo(tableInfo: TableInfo, sqlRunner: SqlRunner) {
        sqlRunner.query(sqlProvider!!.getQueryTableFullFieldInfo(tableInfo.primitiveTableName), RsHandler<Unit> { rs: ResultSet ->
            val columnInfos = mutableListOf<ColumnInfo>()
            while (rs.next()) {
                val resultWrapper = ResultWrapper(rs)
                val dbColumnInfo = extracter!!.extractColumnInfo(resultWrapper)
                val entityName = StrUtil.upperFirst(StrUtil.toCamelCase(dbColumnInfo.columnName))
                columnInfos.add(ColumnInfo(entityName, dbColumnInfo.columnName, dbColumnInfo.primaryKey, dbColumnInfo.columnType, dbColumnInfo.columnComment))
            }
            tableInfo.columns = columnInfos
        })
    }
}