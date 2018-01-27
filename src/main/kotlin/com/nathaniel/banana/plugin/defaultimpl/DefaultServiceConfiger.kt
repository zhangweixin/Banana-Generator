package com.nathaniel.banana.plugin.defaultimpl

import com.nathaniel.banana.plugin.ConfigurableComponent
import org.springframework.stereotype.Component

@Component
class DefaultServiceConfiger : DefaultConfigerAdaptor() {
    override fun configServie(configurableComponent: ConfigurableComponent, entityTableName: String) {
        super.configServie(configurableComponent, entityTableName);
    }
}