package com.nathaniel.banana.plugin.defaultimpl

import com.nathaniel.banana.plugin.ConfigurableComponent

interface ServiceConfiger {
    fun configServie(configurableComponent: ConfigurableComponent, entityTableName: String): Unit
}