package com.nathaniel.banana.plugin

interface ControllerConfiger {
    fun configController(configurableComponent: ConfigurableComponent, entityTableName: String): Unit
}