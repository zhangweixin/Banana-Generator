package com.nathaniel.banana.plugin.defaultimpl

import com.nathaniel.banana.plugin.ConfigurableComponent

interface MapperXmlConfiger {
    fun configMapperXml(configurableComponent: ConfigurableComponent, entityTableName: String): Unit
}