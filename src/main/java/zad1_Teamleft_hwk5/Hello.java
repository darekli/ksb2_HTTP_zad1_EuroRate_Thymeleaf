package zad1_Teamleft_hwk5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Hello {

    @GetMapping("/hello")
    public String get(){
        return "hello";
    }
}

