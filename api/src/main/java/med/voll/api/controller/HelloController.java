package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Para especificar que es un controlador de tipo rest, para retornar json, etc
@RequestMapping("/hello") //Para decirle la ruta http que va a seguir
public class HelloController {

    @GetMapping
    public String helloWorld() {
        return "HelloWorld from otros lad";
    }
}
