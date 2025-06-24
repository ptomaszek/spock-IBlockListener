package org.example.extensions

import org.slf4j.LoggerFactory
import org.spockframework.runtime.extension.IBlockListener
import org.spockframework.runtime.model.BlockInfo
import spock.lang.Specification

class BlockLoggingListener implements IBlockListener {

    @Override
    <S extends Specification> void blockEntered(S specificationInstance, BlockInfo blockInfo) {
        def logger = LoggerFactory.getLogger(specificationInstance.class)
        logger.info("{}", blockInfo.getTexts().join("; "))
    }
}
