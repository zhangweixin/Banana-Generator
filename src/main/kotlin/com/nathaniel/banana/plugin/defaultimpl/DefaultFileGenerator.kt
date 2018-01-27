package com.nathaniel.banana.plugin.defaultimpl

import com.nathaniel.banana.model.TableInfo
import com.nathaniel.banana.plugin.FileGenerator
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class DefaultFileGenerator: FileGenerator,ApplicationListener<ContextRefreshedEvent> {
    override fun onApplicationEvent(event: ContextRefreshedEvent?) {

    }

    override fun fileGenerate(tableInfos: List<TableInfo>) {

    }
}