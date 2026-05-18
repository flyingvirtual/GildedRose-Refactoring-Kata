package com.gildedrose.updaters;

import com.gildedrose.Item;

public class ConjuredItemUpdater extends AbstractItemUpdater {

        @Override
        public void update(Item item) {
            decreaseSellIn(item);

            int degradation = isExpired(item) ? 4 : 2;
            decreaseQuality(item, degradation);
        }
}
