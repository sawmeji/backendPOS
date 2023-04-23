package com.example.backendpos.repo;

import com.example.backendpos.entity.BestSeller;
import com.example.backendpos.entity.SellItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellItemRepo extends JpaRepository<SellItem, Integer> {


    @Query("select sum(shopItem.price) from SellItem ")
    String totalSellPrice();

    @Query("select new com.example.backendpos.entity.BestSeller(sell.id, sell.shopItem.name, sell.shopItem.price, count (sell.shopItem.id)) from SellItem sell group by sell.shopItem.name order by count (sell.shopItem.id) desc ")
    List<BestSeller> sellItemByBestSeller();
}
