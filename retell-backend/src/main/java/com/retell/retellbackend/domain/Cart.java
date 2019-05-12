package com.retell.retellbackend.domain;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer ID;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Set<CartItem> item;


    public Cart() {}

//    public Cart(Integer ID, UserEntity user, Book book, Integer amount) {
//        this.ID = ID;
//        this.user = user;
//        this.book = book;
//        this.amount = amount;
//    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Set<CartItem> getItem() {
        return item;
    }

    public void setItem(Set<CartItem> item) {
        this.item = item;
    }
}
