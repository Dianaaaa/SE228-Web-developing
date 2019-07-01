package com.retell.retellbackend.serviceimpl;

import com.mongodb.util.JSON;
import com.retell.retellbackend.entity.CartItem;
import com.retell.retellbackend.entity.Deal;
import com.retell.retellbackend.repository.BookRepository;
import com.retell.retellbackend.repository.CategoryRepository;
import com.retell.retellbackend.entity.Book;

import com.retell.retellbackend.repository.DealRepository;
import com.retell.retellbackend.service.BookService;
import javafx.util.Pair;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookRepository bookRepository;

    @Resource
    private CategoryRepository cateRepository;

    @Resource
    private DealRepository dealRepository;

    public Book getBookByID(Integer ID) {
        Book book = bookRepository.getBook(ID);

//        Book cur_book = new Book();
//        cur_book.setID((Integer) result.get("ID"));
//        cur_book.setName((String)result.get("name"));
//        cur_book.setAuthor((String)result.get("author"));
//        cur_book.setISBN((String)result.get("ISBN"));
//        cur_book.setStock((Integer)result.get("stock"));
//        cur_book.setFrontpage((String)result.get("front_page"));
////        cur_book.setCategory((Integer)result.get("category"));
//        cur_book.setCurCost((BigDecimal)result.get("cur_cost"));
//        cur_book.setPrevCost((BigDecimal)result.get("prev_cost"));
//        cur_book.setBookDetail((String)result.get("book_detail"));
//        cur_book.setAuthorDetail((String)result.get("author_detail"));
//        cur_book.setStock((Integer) result.get("stock"));

        return book;
    }

    public void createBook(Book book) {
//        String sql = "insert into book (name, author, ISBN, stock, front_page, book_detail, author_detail, category, cur_cost, prev_cost) values(\"" + book.getName() + "\",\"" +  book.getAuthor() + "\",\"" + book.getISBN() + "\"," + book.getStock() + ",\"" + book.getFrontpage() + "\",\"" +  book.getBookDetail() + "\",\"" +  book.getAuthorDetail() + "\",\"" + book.getCategory() + "\"," +  book.getCurCost()  +  "," + book.getPrevCost() + ")";
//        jdbc.execute(sql);
        bookRepository.save(book);
    }

    public List getBookCarousel() {
        List<Book> books = bookRepository.getBookCarousel();
        return books;
    }

    public List getBookByCateIDLimited(Integer ID) {
        List<Book> books = bookRepository.getBookByCateLimit(ID);
//        System.out.print(results);
        return books;
    }

    public List getBookByCateID(Integer ID) {
        List<Book> books = bookRepository.getBookByCate(ID);
        return books;
    }

    public List getAllBook() {
        List<Book> books = bookRepository.getBookAll();
        return books;
    }

    //    public List getBookByCateName(String name) {
//        String sql = "SELECT ID from book_category where name = ?";
//        Map<String, Object> ID = jdbc.queryForMap(sql, name);
//        List<Map<String, Object>> results = getBookByCateIDLimited((Integer) ID.get("ID"));
//
//        return results;
//    }
    public List bookDump(List<Book> books) {
        List objects = new ArrayList();
        for (int i = 0; i < books.size(); i++) {
//            System.out.print(books.get(i));
            JSONObject result = new JSONObject();
            result.put("author", books.get(i).getAuthor());
            result.put("prev_cost", books.get(i).getPrevCost());
            result.put("cur_cost", books.get(i).getCurCost());
            result.put("front_page", books.get(i).getFrontpage());
            result.put("name", books.get(i).getName());
            result.put("id", books.get(i).getID());
            result.put("ISBN", books.get(i).getISBN());
            result.put("stock", books.get(i).getStock());
            result.put("sales", books.get(i).getSales());

            objects.add(result);
        }
        return objects;
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Integer ID) {
        Book book = bookRepository.getBook(ID);
        bookRepository.delete(book);
    }

    public void addSales(Integer ID, Integer amount) {
        Book book = bookRepository.getBook(ID);
        Integer sales = book.getSales();
        sales = sales + amount;
        book.setSales(sales);
        bookRepository.save(book);
    }

    public List<JSONObject> statBookByTime(String begin, String end) {
        begin = begin + " 00:00:00";
        end = end + " 23:59:59";
        System.out.println(begin);
        System.out.println(end);
        Timestamp betime = Timestamp.valueOf(begin);
        Timestamp entime = Timestamp.valueOf(end);
        List<Deal> deals =  dealRepository.getDealsByTime(end, begin);
        System.out.println(deals);
        Map<Integer, Integer> stat = new HashMap<>();

        for (int i = 0; i < deals.size(); i++) {
            List<CartItem> dealItems = deals.get(i).getItem();
            for (int j = 0; j < dealItems.size(); j++) {
                Integer key = dealItems.get(j).getID();
                if (stat.containsKey(key)) {
                    Integer sale = stat.get(key);
                    sale = sale + dealItems.get(j).getAmount();
                    stat.put(key, sale);
                }
                stat.put(key, dealItems.get(j).getAmount());
            }
        }

        List<JSONObject> result = new ArrayList<>();

        Iterator iter = stat.keySet().iterator();
        while (iter.hasNext()) {
            Object key = iter.next();
            Object val = stat.get(key);
            JSONObject obj = new JSONObject();
            Book book = bookRepository.getBook((Integer) key);
            obj.put("id", book.getID());
            obj.put("name", book.getName());
            obj.put("sale", (Integer) val);
            result.add(obj);
        }
        return result;
    }

    public List<JSONObject> statBookByTimeUser(String begin, String end, Integer ID) {
        begin = begin + " 00:00:00";
        end = end + " 23:59:59";
        System.out.println(begin);
        System.out.println(end);
        System.out.println(ID);
        Timestamp betime = Timestamp.valueOf(begin);
        Timestamp entime = Timestamp.valueOf(end);

        List<Deal> deals =  dealRepository.getDealsByTimeUser(end, begin, ID);
        System.out.println(deals);
        Map<Integer, Integer> stat = new HashMap<>();

        for (int i = 0; i < deals.size(); i++) {
            List<CartItem> dealItems = deals.get(i).getItem();
            for (int j = 0; j < dealItems.size(); j++) {
                Integer key = dealItems.get(j).getID();
                if (stat.containsKey(key)) {
                    Integer sale = stat.get(key);
                    sale = sale + dealItems.get(j).getAmount();
                    stat.put(key, sale);
                }
                stat.put(key, dealItems.get(j).getAmount());
            }
        }

        List<JSONObject> result = new ArrayList<>();

        Iterator iter = stat.keySet().iterator();
        while (iter.hasNext()) {
            Object key = iter.next();
            Object val = stat.get(key);
            JSONObject obj = new JSONObject();
            Book book = bookRepository.getBook((Integer) key);
            obj.put("id", book.getID());
            obj.put("name", book.getName());
            obj.put("sale", (Integer) val);
            result.add(obj);
        }
        return result;
    }
}
