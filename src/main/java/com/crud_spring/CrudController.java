package com.crud_spring;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CrudController {

    List<Crud> allCrud = new ArrayList<>();

    @GetMapping("/crudname")    
    public String getCrudName(Model model){


        model.addAttribute("allCrud",allCrud);

        return "crudname";
        }



    @GetMapping("/")
    public String addnewdata(Model model){

        model.addAttribute("addnewdata",new Crud());

        return "addnewdata";
    }

    @PostMapping("/dataSubmitFrom")
    public String dataSubmitFrom(Crud crud){
        allCrud.add(crud);
        return "redirect:/getalldata";
    }


    @GetMapping("/getalldata")
    public String getalldata(Model model){
        model.addAttribute("allCrud", allCrud);
        return "getalldata";
    }
        
}
