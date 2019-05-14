package com.retell.retellbackend.domain;

import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="deals")
public class Deal {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer ID;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
    @Column(name = "phone", nullable = false, length = 50)
    private String phone;
    @Column(name = "address", nullable = false, length = 128)
    private String address;
    @CreatedDate
    @Column(name = "time", nullable = false)
    private Timestamp time;
    @Column(name = "receiver", nullable = false, length = 50)
    private String receiver;
    @Column(name = "total_price", nullable = false)
    private BigDecimal total_price;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private List<CartItem> item;

    public Deal () {}

//    public Deal (Integer ID, UserEntity user, Book book, String phone, String address, Timestamp time, BigDecimal total_price) {
//        this.ID = ID;
//        this.userID = userID;
//        this.phone = phone;
//        this.address = address;
//        this.time = time;
//        this.total_price = total_price;
//    }


    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public List<CartItem> getItem() {
        return item;
    }

    public void setItem(List<CartItem> item) {
        this.item = item;
    }
}
