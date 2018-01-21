package com.nathaniel.scffold.util

import com.nathaniel.scffold.bean.ScaffodConfiguration
import com.nathaniel.scffold.db.DbInfoParser
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.core.env.PropertiesPropertySource
import org.springframework.core.io.ClassPathResource


fun main(args: Array<String>) {
    val applicationContext = AnnotationConfigApplicationContext {
        register(ScaffodConfiguration::class.java)
        val factoryBean = YamlPropertiesFactoryBean()
        factoryBean.setResources(ClassPathResource("generator/config/default.config.yml"))
        environment.propertySources.addFirst(PropertiesPropertySource("scaffodconfig", factoryBean.`object`))
        refresh()
    }
    val dbInfoParser = applicationContext.getBean(DbInfoParser::class.java)
    dbInfoParser.execute()
}