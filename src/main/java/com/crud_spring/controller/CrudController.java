package com.crud_spring.controller;


import com.crud_spring.Constant;
import com.crud_spring.Crud;
import com.crud_spring.repository.CrudRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CrudController {

    CrudRepository crudRepository = new CrudRepository();

    @GetMapping("/")
    public String addnewdata(Model model, @RequestParam(required = false) String id){
        Crud crud = new Crud();
        int index = getcrudIndex(id);
        model.addAttribute("addnewdata", index == Constant.NO_Find ?
                crud : crudRepository.getCrudByIdIndex(index));
        return "addnewdata";
    }

    public int getcrudIndex(String id) {
        for (int i = 0; i < crudRepository.getalldata().size(); i++) {
            if(crudRepository.getCrudByIdIndex(i).getId().equals(id) ) return i;
        }
        return Constant.NO_Find;
    }


    @PostMapping("/dataSubmitFrom")
    public String dataSubmitFrom(@Valid @ModelAttribute("addnewdata") Crud crud, BindingResult result){
        if(result.hasFieldErrors()) {return "addnewdata";}

        int index = getcrudIndex(crud.getId());
        if (index == Constant.NO_Find) {
            crudRepository.addData(crud);
        } else {
            crudRepository.updateData(crud,index);
        }
        return "redirect:/getalldata";
    }


    @GetMapping("/getalldata")
    public String getalldata(Model model){
        model.addAttribute("allCrud", crudRepository.getalldata());
        return "getalldata";
    }
        
}
