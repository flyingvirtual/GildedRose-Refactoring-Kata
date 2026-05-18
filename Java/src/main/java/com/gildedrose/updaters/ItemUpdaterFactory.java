package com.gildedrose.updaters;

import com.gildedrose.Item;

public class ItemUpdaterFactory {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED_ITEM = "Conjured Mana Cake";

    public ItemUpdater getUpdater(Item item) {
        return switch (item.name) {
            case AGED_BRIE -> new AgedBrieUpdater();
            case BACKSTAGE_PASS -> new BackstagePassUpdater();
            case SULFURAS -> new SulfurasUpdater();
            case CONJURED_ITEM -> new ConjuredItemUpdater();
            default -> new NormalItemUpdater();
        };
    }

}
