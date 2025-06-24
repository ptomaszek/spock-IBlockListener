package org.example.extensions

import org.slf4j.LoggerFactory
import org.spockframework.runtime.AbstractRunListener
import org.spockframework.runtime.extension.IBlockListener
import org.spockframework.runtime.extension.IGlobalExtension
import org.spockframework.runtime.model.BlockInfo
import org.spockframework.runtime.model.FeatureInfo
import org.spockframework.runtime.model.SpecInfo
import spock.lang.Specification

class IBlockLoggingExtension implements IGlobalExtension {

    @Override
    void visitSpec(SpecInfo spec) {
        spec.addListener(new BlockLoggingRunListener())
    }

    class BlockLoggingRunListener extends AbstractRunListener {

        @Override
        void beforeFeature(FeatureInfo feature) {
            feature.addBlockListener(new BlockLoggingListener())
        }
    }

    class BlockLoggingListener implements IBlockListener {

        @Override
        <S extends Specification> void blockEntered(S specificationInstance, BlockInfo blockInfo) {
            def logger = LoggerFactory.getLogger(specificationInstance.class)
            logger.info("{}", blockInfo.getTexts().join("; "))
        }
    }
}
