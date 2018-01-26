package com.nathaniel.banana.plugin

import com.nathaniel.banana.model.TableInfo

/**
 * 根据解析出来的数据库信息自定义相关文件生成
 */
interface FileGenerator {

    fun fileGenerate(tableInfos: List<TableInfo>): Unit
}