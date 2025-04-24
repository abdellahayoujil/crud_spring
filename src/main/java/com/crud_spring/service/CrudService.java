package com.crud_spring.service;

import com.crud_spring.Constant;
import com.crud_spring.Crud;
import com.crud_spring.repository.CrudRepository;

import java.util.List;

public class CrudService {

    CrudRepository crudRepository = new CrudRepository();

    public Crud getCrudByIdIndex(int index) {
        return crudRepository.allCrud.get(index);
    }

    public Crud getCrudById(String id) {
        int index = getcrudIndex(id);
        return index == Constant.NO_Find ?
                new Crud() :
                getCrudByIdIndex(index);
    }

    public void addData(Crud crud) {
        crudRepository.allCrud.add(crud);
    }

    public void updateData(Crud crud, int index) {
        crudRepository.allCrud.set(index, crud);
    }

    public List<Crud> getalldata() {
        return crudRepository.allCrud;
    }

    public int getcrudIndex(String id) {
        for (int i = 0; i < getalldata().size(); i++) {
            if (getCrudByIdIndex(i).getId().equals(id)) return i;
        }
        return Constant.NO_Find;
    }

    public void submitcrud(Crud crud) {
        int index = getcrudIndex(crud.getId());
        if (index == Constant.NO_Find) {
            addData(crud);
        } else {
            updateData(crud, index);
        }
    }
}
