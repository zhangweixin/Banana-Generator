package com.nathaniel.banana.plugin.defaultimpl

import com.nathaniel.banana.plugin.ConfigurableComponent

interface ControllerConfiger {
    fun configController(configurableComponent: ConfigurableComponent, entityTableName: String): Unit
}