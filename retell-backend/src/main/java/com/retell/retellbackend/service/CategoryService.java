package com.retell.retellbackend.service;


import java.util.List;

public interface CategoryService {
    List getCategory();

    Integer getCateByName(String name);

}
