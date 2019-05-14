package com.retell.retellbackend.service;


import com.retell.retellbackend.dao.CategoryRepository;
import com.retell.retellbackend.domain.Category;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    @Resource
    private CategoryRepository cateRepository;

    public List getCategory() {
        List<Category> categories = cateRepository.getCate();
//        String sql = "SELECT ID, name FROM book_category";
//
//        List<Map<String, Object>> categories = jdbc.queryForList(sql);
        List objects = new ArrayList();
        for (int i = 0; i < categories.size(); i++) {
//            System.out.print(categories.get(i));
            JSONObject result = new JSONObject();
            result.put("name", categories.get(i).getName());
            result.put("id", categories.get(i).getID());

            objects.add(result);
        }
        return objects;
    }

    public Integer getCateByName(String name) {
        Integer id = cateRepository.getCateByName(name);
//        String sql = "SELECT ID FROM book_category where name = ?";
//        Map<String, Object> cate = jdbc.queryForMap(sql, name);

        return id;
    }

}
