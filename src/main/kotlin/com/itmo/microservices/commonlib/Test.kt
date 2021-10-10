package com.itmo.microservices.commonlib

import com.itmo.microservices.commonlib.annotations.InjectEventLogger
import com.itmo.microservices.commonlib.logging.EventLogger
import com.itmo.microservices.commonlib.logging.NotableEvent
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class Test {
    @InjectEventLogger
    lateinit var logger: EventLogger

    fun test(): Unit {
        logger.error(TestNotableEvent())
    }

    class TestNotableEvent : NotableEvent {
        override fun getTemplate(): String {
            return "Test1"
        }

        override fun getName(): String {
            return " Test2"
        }

    }

    @PostConstruct
    fun run(): Unit{
        test()
    }
}