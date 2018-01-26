package com.nathaniel.banana.plugin

import java.net.URL

interface ConfigurableComponent {

    fun setFileLocation(location: URL): Unit

    fun setName(name: String): Unit

    fun setIsExecute(execute: Boolean): Unit

    fun setTemplateLocation(location: URL): Unit
}