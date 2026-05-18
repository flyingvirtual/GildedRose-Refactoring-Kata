package com.gildedrose.updaters;

import com.gildedrose.Item;

public abstract class AbstractItemUpdater implements ItemUpdater {

    protected void increaseQuality(Item item, int amount) {
        item.quality = Math.min(50, item.quality + amount);
    }

    protected void decreaseQuality(Item item, int amount) {
        item.quality = Math.max(0, item.quality - amount);
    }

    protected void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    protected boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

}
