package com.rb.surprise_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/birthday/wishes")
public class Controller {
    @Autowired
    private Service wishService;

    @PostMapping
    public Wish addWish(@RequestBody final WishDTO wishDTO) {
        return wishService.sendWish(wishDTO);
    }
    @GetMapping
    public List<Wish> getAllWishes(){
        return wishService.getAllWishesFromDB();
    }
    @DeleteMapping
    public void deleteAll(){
        wishService.deleteAllWishes();
    }
}
