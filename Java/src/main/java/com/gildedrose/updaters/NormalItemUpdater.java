package com.gildedrose.updaters;

import com.gildedrose.Item;

public class NormalItemUpdater extends AbstractItemUpdater {

        @Override
        public void update(Item item) {
            decreaseSellIn(item);

            int degradation = isExpired(item) ? 2 : 1;
            decreaseQuality(item, degradation);
        }
}
