package com.crud_spring.controller;


import com.crud_spring.Constant;
import com.crud_spring.Crud;
import com.crud_spring.service.CrudService;
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

    //CrudRepository crudRepository = new CrudRepository();

    CrudService crudService = new CrudService();

    @GetMapping("/")
    public String addnewdata(Model model, @RequestParam(required = false) String id) {
        Crud crud = new Crud();

        model.addAttribute("addnewdata", crudService.getCrudById(id));

        return "addnewdata";
    }


    @PostMapping("/dataSubmitFrom")
    public String dataSubmitFrom(@Valid @ModelAttribute("addnewdata") Crud crud, BindingResult result) {
        if (result.hasFieldErrors()) {
            return "addnewdata";
        }

        crudService.submitcrud(crud);
        //int index = crudService.getcrudIndex(crud.getId());
        //if (index == Constant.NO_Find) {
        //  crudService.addData(crud);
        //} else {
        //  crudService.updateData(crud, index);
        //}
        return "redirect:/getalldata";
    }


    @GetMapping("/getalldata")
    public String getalldata(Model model) {
        model.addAttribute("allCrud", crudService.getalldata());
        return "getalldata";
    }

}
