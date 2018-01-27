package com.nathaniel.banana.plugin

interface MapperClassConfiger {
    fun configMapperClass(configurableComponent: ConfigurableComponent, entityTableName: String): Unit
}