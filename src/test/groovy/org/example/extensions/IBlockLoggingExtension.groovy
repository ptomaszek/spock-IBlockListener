package org.example.extensions

import org.spockframework.runtime.extension.IGlobalExtension
import org.spockframework.runtime.model.SpecInfo

class IBlockLoggingExtension implements IGlobalExtension {

    @Override
    void visitSpec(SpecInfo spec) {
        spec.addListener(new BlockLoggingRunListener())
    }
}
