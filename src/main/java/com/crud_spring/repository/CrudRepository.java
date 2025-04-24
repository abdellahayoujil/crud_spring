package com.crud_spring.repository;

import com.crud_spring.Crud;

import java.util.ArrayList;
import java.util.List;

public class CrudRepository {

    public List<Crud> allCrud = new ArrayList<>();

    public Crud getCrudByIdIndex(int index) {
        return allCrud.get(index);
    }

    public void addData(Crud crud) {
        allCrud.add(crud);
    }

    public void updateData(Crud crud, int index) {
        allCrud.set(index, crud);
    }

    public List<Crud> getalldata() {
        return allCrud;
    }
}
