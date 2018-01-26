package com.nathaniel.banana.bean

import com.nathaniel.banana.component.DbConfig
import com.nathaniel.banana.db.DbInfoParser
import com.nathaniel.banana.plugin.DbMetaInfoExtracter
import com.nathaniel.banana.plugin.DbMetaInfoSqlProvider
import com.nathaniel.banana.util.build
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
@ComponentScan(basePackages = ["com.nathaniel.banana.component","com.nathaniel.banana.db","com.nathaniel.banana.plugin"])
class ScaffodConfiguration {

    @Bean("datasource")
    fun datasource(dbConfig: DbConfig) = build {
        driverClassName = dbConfig.dbDriverClass
        jdbcUrl = dbConfig.dbUrl
        username = dbConfig.dbUser
        password = dbConfig.dbPassword
    }

    @Bean
    fun dbInfoParser(dataSource: DataSource, sqlProviders: List<DbMetaInfoSqlProvider>, infoExtracters: List<DbMetaInfoExtracter>): DbInfoParser {
        return DbInfoParser(sqlProviders, infoExtracters, dataSource)
    }
}