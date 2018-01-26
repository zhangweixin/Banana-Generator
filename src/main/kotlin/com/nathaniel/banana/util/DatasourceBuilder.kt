package com.nathaniel.banana.util

import com.zaxxer.hikari.HikariDataSource

fun build(init: HikariDataSource.() -> Unit): HikariDataSource {
    var datasource: HikariDataSource = HikariDataSource()
    datasource.init()
    return datasource
}