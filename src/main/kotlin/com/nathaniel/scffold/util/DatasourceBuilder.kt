package com.nathaniel.scffold.util

import com.zaxxer.hikari.HikariDataSource

fun build(init: HikariDataSource.() -> Unit): HikariDataSource {
    var datasource: HikariDataSource = HikariDataSource()
    datasource.init()
    return datasource
}