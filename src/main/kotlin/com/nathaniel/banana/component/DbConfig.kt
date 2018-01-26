package com.nathaniel.banana.component

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Component

@Component
@ComponentScan
data class DbConfig(
        @Value("\${db.url}")
        var dbUrl: String,
        @Value("\${db.driverClass}")
        var dbDriverClass: String,
        @Value("\${db.user}")
        var dbUser: String,
        @Value("\${db.password}")
        var dbPassword: String
)