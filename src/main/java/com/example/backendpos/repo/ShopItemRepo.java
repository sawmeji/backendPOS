package com.example.backendpos.repo;

import com.example.backendpos.entity.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopItemRepo extends JpaRepository<ShopItem, Integer> {
}
