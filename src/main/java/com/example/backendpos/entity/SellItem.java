package com.example.backendpos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SellItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private ShopItem shopItem;

    public SellItem() {
    }

    public SellItem(ShopItem shopItem) {
        this.shopItem = shopItem;
    }
}
