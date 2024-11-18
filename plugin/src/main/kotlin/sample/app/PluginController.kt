package sample.app

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(("/plugin"))
class PluginController {

    @GetMapping("/test")
    fun test(): String {
        return "Hello, this is a plugin."
    }

}