package net.dni.restcontrollerlogging.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String sayHello(String name) {
        return String.format("hello, %s", name);
    }

}
