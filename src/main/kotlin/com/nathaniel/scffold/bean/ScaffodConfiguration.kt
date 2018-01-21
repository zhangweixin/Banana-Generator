package com.nathaniel.scffold.bean

import com.nathaniel.scffold.component.DbConfig
import com.nathaniel.scffold.db.DbInfoParser
import com.nathaniel.scffold.db.DbMetaInfoExtracter
import com.nathaniel.scffold.db.DbMetaInfoSqlProvider
import com.nathaniel.scffold.util.build
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
@ComponentScan(basePackages = ["com.nathaniel.scffold.component","com.nathaniel.scffold.db"])
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