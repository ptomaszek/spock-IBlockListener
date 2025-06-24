package org.example

import groovy.util.logging.Slf4j
import spock.lang.Specification

@Slf4j
class IBlockListenerSpec extends Specification {

    def "test"() {
        given: "given 1"
        log.info("given 1 custom log ")

        and: "given 2"
        log.info("given 2 custom log ")

        expect: "expect"
        log.info("expect custom log ")
    }
}
