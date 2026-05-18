package com.gildedrose.updaters;

import com.gildedrose.Item;

public class BackstagePassUpdater extends AbstractItemUpdater {

    @Override
    public void update(Item item) {
        int qualityIncrease = 1;

        if (item.sellIn <= 10) {
            qualityIncrease++;
        }

        if (item.sellIn <= 5) {
            qualityIncrease++;
        }

        increaseQuality(item, qualityIncrease);

        decreaseSellIn(item);

        if (isExpired(item)) {
            item.quality = 0;
        }
    }
}

