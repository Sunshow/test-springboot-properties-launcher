package org.thingsboard.server.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(("/thingsboard/plugin"))
class ThingsBoardPluginController {

    @GetMapping("/test")
    fun test(): String {
        return "Hello, this is a ThingsBoard plugin."
    }

}