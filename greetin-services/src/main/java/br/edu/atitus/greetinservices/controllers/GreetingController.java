package br.edu.atitus.greetinservices.controllers;

import br.edu.atitus.greetinservices.configs.GreetingConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

//    @Value("${greeting-service.greeting}")
//    private String greeting;
//    @Value("${greeting-service.default-name}")
//    private String defaultName;
    private final GreetingConfig config;//pegar os dados da config
    //injeção de dependência -
    //p.s:Inversão de dependência são as interfaces
    public GreetingController(GreetingConfig config) {
        this.config = config;
    }

    @GetMapping({"","/"})
    public String getGreeting(
            @RequestParam(required = false) String name) {
        if (name == null || name.isEmpty()) {
            name = config.getDefaultName();
        }
        String greetingReturn = String.format("%s %s!!!",config.getGreeting(),name);
        return greetingReturn;
    }
}
