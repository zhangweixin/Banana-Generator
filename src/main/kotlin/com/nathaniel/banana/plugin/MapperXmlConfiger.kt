package com.nathaniel.banana.plugin

interface MapperXmlConfiger {
    fun configMapperXml(configurableComponent: ConfigurableComponent, entityTableName: String): Unit
}