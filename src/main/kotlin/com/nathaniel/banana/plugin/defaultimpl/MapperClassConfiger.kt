package com.nathaniel.banana.plugin.defaultimpl

import com.nathaniel.banana.plugin.ConfigurableComponent

interface MapperClassConfiger {
    fun configMapperClass(configurableComponent: ConfigurableComponent, entityTableName: String): Unit
}