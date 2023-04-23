package com.example.backendpos.service;

import com.example.backendpos.entity.BestSeller;
import com.example.backendpos.entity.SellItem;
import com.example.backendpos.entity.ShopItem;
import com.example.backendpos.repo.SellItemRepo;
import com.example.backendpos.repo.ShopItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ShopItemRepo shopItemRepo;
    @Autowired
    private SellItemRepo sellItemRepo;


    public List<ShopItem> findAllShopItem() {
        return shopItemRepo.findAll();
    }

    public ShopItem addShopItem(ShopItem shopItem) {
        return shopItemRepo.save(shopItem);
    }


    public List<SellItem> findAllSellItem() {
        return sellItemRepo.findAll();
    }

    public SellItem addSellItem(Integer id) {
        ShopItem shopItem = shopItemRepo.findById(id).get();
        if(shopItem != null){
            SellItem sellItem = new SellItem(shopItem);
            return sellItemRepo.save(sellItem);
        }
        return null;
    }

    public String totalSellPrice() {
        return sellItemRepo.totalSellPrice();
    }

    public List<BestSeller> sellItemByBestSeller() {
        return sellItemRepo.sellItemByBestSeller();
    }
}
