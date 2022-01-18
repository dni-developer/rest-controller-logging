package net.dni.restcontrollerlogging.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.dni.restcontrollerlogging.service.HelloService;

@RestController
@RequestMapping("/hello")
public class HelloRestController {

    private final HelloService helloService;

    public HelloRestController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String sayHello() {
        return helloService.sayHello("world");
    }

}
