package org.example.extensions


import org.spockframework.runtime.AbstractRunListener
import org.spockframework.runtime.model.FeatureInfo

class BlockLoggingRunListener extends AbstractRunListener {

    @Override
    void beforeFeature(FeatureInfo feature) {
        feature.addBlockListener(new BlockLoggingListener())
    }
}
