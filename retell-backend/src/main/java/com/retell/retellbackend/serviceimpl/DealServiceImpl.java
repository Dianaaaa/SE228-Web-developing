package com.retell.retellbackend.serviceimpl;


import com.retell.retellbackend.repository.*;
import com.retell.retellbackend.entity.*;
import com.retell.retellbackend.service.DealService;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DealServiceImpl implements DealService {

    @Resource
    private CartRepository cartRepository;

    @Resource
    private DealRepository dealRepository;

    @Resource
    private BookRepository bookRepository;

    @Resource
    private UserRepository userRepository;

    @Resource
    private CartItemRepository cartItemRepository;

    public Boolean createDealByUserID(String phone, String address, String receiver,  BigDecimal total_price, Integer userID) {
        UserEntity user = userRepository.getUserByID(userID);
        Cart cart = cartRepository.getCartByUser(userID);
        List<CartItem> cartItems = cart.getItem();

        cart.setItem(new ArrayList<>());
        cartRepository.save(cart);

        List<CartItem> dealItems = new ArrayList<>();
        for (int i = 0; i < cartItems.size(); i++) {
            CartItem item = new CartItem();
            item.setAmount(cartItems.get(i).getAmount());
            item.setBook(cartItems.get(i).getBook());

            Book book = cartItems.get(i).getBook();
            Integer sales = book.getSales();
            sales = sales + cartItems.get(i).getAmount();
            book.setSales(sales);
            bookRepository.save(book);

            dealItems.add(item);
            cartItemRepository.deleteCartItem(cartItems.get(i).getID());
        }

        Deal deal = new Deal();
        deal.setAddress(address);
        deal.setItem(dealItems);
        deal.setPhone(phone);
        deal.setTotal_price(total_price);
        deal.setReceiver(receiver);
        deal.setUser(user);
        dealRepository.save(deal);

//        String sqlCart = "SELECT * FROM cart WHERE userID =  ?";
//        List<Map<String, Object>> cartItems = jdbc.queryForList(sqlCart, userID);
//        if (cartItems.size() == 0) {
//            System.out.print("no cart item \n");
//            return Boolean.FALSE;
//        }
//        String sqlDeal = "INSERT INTO deal(phone, address, receiver, total_price, userID) values (\"" + phone + "\",\"" + address + "\",\"" + receiver + "\", " + total_price.toString() + "," + userID + ")";
//        jdbc.execute(sqlDeal);
//        String sqlID = "SELECT LAST_INSERT_ID()";
//        Map<String, Object> ID = jdbc.queryForMap(sqlID);
//        Integer dealID = Integer.valueOf(ID.get("LAST_INSERT_ID()").toString());
//
        List<CartItem> iter = new ArrayList<>();
        iter = dealItems;
        for (int i = 0; i < iter.size(); i++) {
            Book book = iter.get(i).getBook();
            Integer amount = iter.get(i).getAmount();
            book.setStock(book.getStock() - amount);
            bookRepository.save(book);
//            String sqlDealBook = "INSERT INTO deal_book(bookID, ammount, dealID) values(" + cartItems.get(i).get("bookID") + "," + cartItems.get(i).get("ammount") + "," + dealID + ")";
//            jdbc.execute(sqlDealBook);
//            String sqlDeleteCart = "DELETE FROM cart WHERE ID = " + cartItems.get(i).get("ID");
//            jdbc.execute(sqlDeleteCart);
//            String sqlDeleteBook = "UPDATE book SET stock = stock - " + cartItems.get(i).get("ammount") + " WHERE ID = " + cartItems.get(i).get("bookID");
//            jdbc.execute(sqlDeleteBook);
        }

        return Boolean.TRUE;
    }

    public void createDealOneBook(String phone, String address, String receiver,BigDecimal total_price, Integer bookID, Integer amount, Integer userID) {
        UserEntity user = userRepository.getUserByID(userID);
        Deal deal = new Deal();
        CartItem item = new CartItem();
        List<CartItem> items = new ArrayList<>();
        items.add(item);
        Book book = bookRepository.getBook(bookID);
        item.setBook(book);
        item.setAmount(amount);
        deal.setReceiver(receiver);
        deal.setTotal_price(total_price);
        deal.setPhone(phone);
        deal.setAddress(address);
        deal.setUser(user);
        deal.setItem(items);
        dealRepository.save(deal);
        book.setStock(book.getStock() - amount);
        bookRepository.save(book);
        //        String sqlDeal = "INSERT INTO deal(phone, address, receiver, total_price, userID) values (\"" + phone + "\",\"" + address + "\",\"" + receiver + "\", " + total_price.toString() + "," + userID + ")";
//        jdbc.execute(sqlDeal);
//        String sqlID = "SELECT LAST_INSERT_ID()";
//        Map<String, Object> ID = jdbc.queryForMap(sqlID);
//        Integer dealID = Integer.valueOf(ID.get("LAST_INSERT_ID()").toString());
//        String sqlDealBook = "INSERT INTO deal_book(bookID, ammount, dealID) values(" + bookID.toString() + "," + ammount.toString() + "," + dealID + ")";
//        jdbc.execute(sqlDealBook);
//        String sqlDeleteBook = "UPDATE book SET stock = stock - " + ammount.toString() + " where ID = " + bookID.toString();
//        System.out.print("\""+sqlDeleteBook+"\"");
//        jdbc.execute(sqlDeleteBook);

        return;
    }

    public List  getDealByUser(Integer userID) {
        List<Deal> deals = dealRepository.getDeals(userID);
//        String sqlDeal = "SELECT * From deal WHERE userID = ?";
//        List<Map<String, Object>> deals = jdbc.queryForList(sqlDeal, userID);

        List objects = new ArrayList();
        for (int i = 0; i < deals.size(); i++) {
            JSONObject obj = new JSONObject();
            obj.put("ID", deals.get(i).getID());
            obj.put("phone", deals.get(i).getPhone());
            obj.put("address", deals.get(i).getAddress());
            obj.put("time", deals.get(i).getTime());
            obj.put("total_price", deals.get(i).getTotal_price());
            obj.put("receiver", deals.get(i).getReceiver());
//            Integer dealID = (Integer) deals.get(i).get("ID");
//            String sqlBooks = "select deal_book.ammount, deal_book.bookID, book.cur_cost, book.name, book.front_page, book.author From book JOIN deal_book ON book.ID = deal_book.bookID WHERE deal_book.dealID= ?";
//            List<Map<String, Object>> books = jdbc.queryForList(sqlBooks, dealID);
            List<CartItem> items = deals.get(i).getItem();

            List jsonbooks = new ArrayList();
            for (int j = 0; j < items.size(); j++) {
                JSONObject bok = new JSONObject();
                bok.put("ammount", items.get(j).getAmount());

                Book book = items.get(j).getBook();
                bok.put("bookID", book.getID());
                bok.put("name", book.getName());
                bok.put("author", book.getAuthor());
                bok.put("cur_cost", book.getCurCost());
                bok.put("front_page", book.getFrontpage());
                jsonbooks.add(bok);
            }
//            System.out.print(jsonbooks+"\n");
            obj.put("books", jsonbooks);

            objects.add(obj);
        }
        return objects;
    }

    public List  getAllDeals() {
        List<Deal> deals = dealRepository.getAllDeals();

        List objects = new ArrayList();
        for (int i = 0; i < deals.size(); i++) {
            JSONObject obj = new JSONObject();
            obj.put("ID", deals.get(i).getID());
            obj.put("phone", deals.get(i).getPhone());
            obj.put("address", deals.get(i).getAddress());
            obj.put("time", deals.get(i).getTime());
            obj.put("total_price", deals.get(i).getTotal_price());
            obj.put("receiver", deals.get(i).getReceiver());
            List<CartItem> items = deals.get(i).getItem();

            List jsonbooks = new ArrayList();
            for (int j = 0; j < items.size(); j++) {
                JSONObject bok = new JSONObject();
                bok.put("ammount", items.get(j).getAmount());
                Book book = items.get(j).getBook();
                bok.put("bookID", book.getID());
                bok.put("name", book.getName());
                bok.put("author", book.getAuthor());
                bok.put("cur_cost", book.getCurCost());
                bok.put("front_page", book.getFrontpage());
                jsonbooks.add(bok);
            }
            obj.put("books", jsonbooks);

            objects.add(obj);
        }
        return objects;
    }
}
