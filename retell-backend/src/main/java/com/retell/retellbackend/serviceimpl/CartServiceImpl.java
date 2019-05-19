package com.retell.retellbackend.serviceimpl;

import com.retell.retellbackend.repository.BookRepository;
import com.retell.retellbackend.repository.CartItemRepository;
import com.retell.retellbackend.repository.CartRepository;
import com.retell.retellbackend.entity.Book;
import com.retell.retellbackend.entity.Cart;
import com.retell.retellbackend.entity.CartItem;
import com.retell.retellbackend.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Resource
    private CartRepository cartRepository;

    @Resource
    private CartItemRepository cartItemRepository;

    @Resource
    private BookRepository bookRepository;

    public List  getCartByUser(Integer userID) {
        Cart cart = cartRepository.getCartByUser(userID);
        List<CartItem> results = cart.getItem();
//        List objects = new ArrayList();
//        for (int i = 0; i < results.size(); i++) {
//            JSONObject obj = new JSONObject();
//            obj.put("ammount", results.get(i).getAmount());
//            obj.put("cartID", results.get(i).getID());
//            Book book = results.get(i).getBook();
//            obj.put("bookID", book.getID());
//            obj.put("cur_cost", book.getCurCost());
//            obj.put("name", book.getName());
//            obj.put("front_page", book.getFrontpage());
//            obj.put("author", book.getAuthor());
//            obj.put("stock", book.getStock());
//
//            objects.add(obj);
//        }
        return results;
    }

    public void addToCart(Integer userID, Integer bookID, Integer amount) {
        Cart cart = cartRepository.getCartByUser(userID);
        List<CartItem> items = cart.getItem();
        for (int i = 0; i < items.size(); i++) {
            Book book = items.get(i).getBook();
            if (book.getID() == bookID) {
                Integer tot = items.get(i).getAmount() + amount;
                cartItemRepository.updateCartItem(tot, items.get(i).getID());
//                items.get(i).setAmount(items.get(i).getAmount() + amount);
//                cartItemRepository.save(items.get(i));
                return;
            }
        }
        CartItem newItem = new CartItem();
        Book newBook = bookRepository.getBook(bookID);
        newItem.setAmount(amount);
        newItem.setBook(newBook);
        cartItemRepository.save(newItem);
        items.add(newItem);
        cart.setItem(items);
        cartRepository.save(cart);

        return;
    }

    @Transactional
    public void deleteCart(Integer ID) {
        cartItemRepository.deleteCartItem(ID);
        return;
    }

    public Boolean updateAmmount(Integer userID, Integer bookID, Integer amount) {
        Cart cart = cartRepository.getCartByUser(userID);
        List<CartItem> items = cart.getItem();
        for (int i = 0; i < items.size(); i++) {
            Book book = items.get(i).getBook();
            if (book.getID() == bookID) {
                items.get(i).setAmount(amount);
                cartItemRepository.updateCartItem(amount, items.get(i).getID());
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
