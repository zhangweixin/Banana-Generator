package com.nathaniel.banana.plugin

interface ServiceConfiger {
    fun configServie(configurableComponent: ConfigurableComponent, entityTableName: String): Unit
}