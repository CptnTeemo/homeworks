package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DefaultController {
    @RequestMapping("/index")
    public String index() {
        return (new Date()).toString() + " - дата-время и случайное число - " +
                Math.random();
//        return "index";
    }
}
