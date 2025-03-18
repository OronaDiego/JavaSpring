package coderHouse.JPA.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //Mediante esta anotacion defino que esta clase va a ser un controlador
@RequestMapping("/hello") // aca indico la direccion para acceder a este controlador
public class HelloWord {
    //Endpoint
    @GetMapping("/h")

    public String helloWord(){
        return "Hello Word!";
    }
}
