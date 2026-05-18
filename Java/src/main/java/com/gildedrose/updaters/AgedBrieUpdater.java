package com.gildedrose.updaters;

import com.gildedrose.Item;

public class AgedBrieUpdater extends AbstractItemUpdater {

    @Override
    public void update(Item item) {
        decreaseSellIn(item);

        int qualityIncrease = isExpired(item) ? 2 : 1;
        increaseQuality(item, qualityIncrease);
    }
}

