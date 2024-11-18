package sample.app

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(("/app"))
class SampleController {

    @GetMapping("/test")
    fun test(): String {
        return "Hello, this is a app."
    }

    @GetMapping("/restart")
    fun restart(): String {
        SampleApplication.restart()
        return "Restarting app..."
    }


}