package com.nathaniel.scffold.component

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
data class GlobalConfig(
        @Value("\${global.author}")
        val author: String,
        @Value("\${global.basePackage}")
        val basePackage: String,
        @Value("\${global.servicePackage}")
        val servicePackage: String,
        @Value("\${global.mapperClassPackage}")
        val mapperClassPackage: String,
        @Value("\${global.mapperXmlPackage}")
        val mapperXmlPackage: String,
        @Value("\${global.serviceNameSuffix}")
        val serviceNameSuffix: String,
        @Value("\${global.mapperClassNameSuffix}")
        val mapperClassNameSuffix: String,
        @Value("\${global.mapperXmlNameSuffix}")
        val mapperXmlNameSuffix: String
)
