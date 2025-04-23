package com.crud_spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CrudController {


    @GetMapping("/crudname")    
    public String getCrudName(){
            return "crudname";
        }
        
}
