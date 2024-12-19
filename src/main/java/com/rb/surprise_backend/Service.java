package com.rb.surprise_backend;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired private Repo wishRepo;
    public Wish sendWish(WishDTO wishDTO) {
        Wish wish = Utility.toWish(wishDTO);
       return wishRepo.save(wish);
    }

    public List<Wish> getAllWishesFromDB() {
        return wishRepo.findAll();
    }

    public void deleteAllWishes() {
        wishRepo.deleteAll();
    }
}
