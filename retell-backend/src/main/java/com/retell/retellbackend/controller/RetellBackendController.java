package com.retell.retellbackend.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.retell.retellbackend.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;

import com.retell.retellbackend.service.BookService;

import java.io.IOException;

@RestController
public class RetellBackendController {

    @Autowired
    public BookService service;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value="/", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String index(){
        JSONObject result = new JSONObject();
        result.put("book-name", "机器学习");
        result.put("author", "周志华");
        result.put("prev-cost", "45.00");
        result.put("cur-cost", "22.00");
        result.put("book-detail", "ACM数据挖掘中国分会点评周志华教授的专著《机器学习》\n2016-02-05 KDD China CKDD\n南京大学周志华教授撰写的《机器学习》（清华大学出版社）上架不到一周即成为亚马逊*\n畅销商品，各网站上现货被抢购一空，一时间“洛阳纸贵”。技术类书籍热卖到此程度，相\n\n当罕见。ACM数据挖掘中国分会部分专家仔细研读了这本专著，给出如下评价：\n\n\n全书16章，附带相关矩阵、优化、概率知识的附录，共425页，62.6万字。中国计算机学会\n终身成就奖得主陆汝钤院士作序，书后有作者自撰后记。该书有以下特点：\n1. 内容系统全面。全书16章，覆盖了机器学习几乎所有的主要分支领域，覆盖面超过了该\n领域国际著名书籍如ESL与PRML：** 部分（**-3 章）介绍机器学习的基础知识；第2 部");
        result.put("author-detail", "周志华，南京大学计算机系教授，ACM杰出科学家，IEEE Fellow, IAPR Fellow, IET/IEE Fellow, 中国计算机学会会士。国家杰出青年科学基金获得者、长江学者特聘教授。先后担任多种SCI(E)期刊执行主编、副主编、副编辑、编委等。中国计算机学会人工智能与模式识别专业委员会主任，中国人工智能学会机器学习专业委员会主任，IEEE计算智能学会数据挖掘技术委员会副主席。");
        result.put("img-url", "http://localhost:8080/ml.jpg");
        return result.toJSONString();
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value="/book", method= RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getBook(){
        Book curBook = service.getBookByID(1);
        JSONObject book = new JSONObject();
        book.put("book-name", curBook.getName());
        book.put("author", curBook.getAuthor());
        book.put("prev-cost", curBook.getPrevCost());
        book.put("cur-cost", curBook.getCurCost());
        book.put("book-detail", curBook.getBookDetail());
        book.put("author-detail", curBook.getAuthorDetail());
        book.put("img-url", curBook.getFrontpage());
        return book.toJSONString();
    }


}
