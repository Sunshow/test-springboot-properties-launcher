package sample.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class PluginApplication {
}

fun main(args: Array<String>) {
    runApplication<PluginApplication>(*args)
}
