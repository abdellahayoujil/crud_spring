package com.crud_spring;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CrudController {

    List<Crud> allCrud = new ArrayList<>();


    @GetMapping("/")
    public String addnewdata(Model model, @RequestParam(required = false) String id){
        Crud crud = new Crud();
        int index = getcrudIndex(id);
        model.addAttribute("addnewdata", index == -1 ? crud : allCrud.get(index));
        return "addnewdata";
    }

    public int getcrudIndex(String id) {
        for (int i = 0; i < allCrud.size(); i++) {
            if (allCrud.get(i).getId().equals(id) ) return i;
        }
        return -1;
    }


    @PostMapping("/dataSubmitFrom")
    public String dataSubmitFrom(Crud crud){

        int index = getcrudIndex(crud.getId());
        if (index == -1) {
            allCrud.add(crud);
        } else {
            allCrud.set(index,crud);
        }
        return "redirect:/getalldata";
    }


    @GetMapping("/getalldata")
    public String getalldata(Model model){
        model.addAttribute("allCrud", allCrud);
        return "getalldata";
    }
        
}
