package com.nathaniel.banana.plugin

import com.nathaniel.banana.db.TableInfo

interface FileGenerator {
    fun fileGenerate(tableInfos: List<TableInfo>): Unit
}