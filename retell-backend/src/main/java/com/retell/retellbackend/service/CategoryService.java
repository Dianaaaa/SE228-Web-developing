package com.retell.retellbackend.service;


import com.retell.retellbackend.entity.Category;

import java.util.List;

public interface CategoryService {
    List getCategory();

    Integer getCateByName(String name);

    Category getCateByID(Integer id);

}
