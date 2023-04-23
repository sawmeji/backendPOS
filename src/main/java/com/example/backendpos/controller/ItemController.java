package com.example.backendpos.controller;

import com.example.backendpos.entity.BestSeller;
import com.example.backendpos.entity.SellItem;
import com.example.backendpos.entity.ShopItem;
import com.example.backendpos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping({"/shopItem"})
    public List<ShopItem> shopItemList(){
        return itemService.findAllShopItem();
    }

    @PostMapping({"/shopItem"})
    public ShopItem addShopItem(@RequestBody ShopItem shopItem){
        return itemService.addShopItem(shopItem);
    }

    @GetMapping({"/sellItem"})
    public List<SellItem> sellItemList(){
        return itemService.findAllSellItem();
    }

    @GetMapping({"/sellItem/add/{id}"})
    public SellItem addSellItem(@PathVariable(name = "id") Integer id){
        return itemService.addSellItem(id);
    }

    @GetMapping({"/sellItem/totalSellPrice"})
    public String totalSellPrice(){
        return itemService.totalSellPrice();
    }

    @GetMapping({"/sellItem/sellItemByBestSeller"})
    public List<BestSeller> sellItemByBestSeller(){
        return itemService.sellItemByBestSeller();
    }



}
