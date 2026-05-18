package com.gildedrose;

import com.gildedrose.updaters.ItemUpdater;
import com.gildedrose.updaters.ItemUpdaterFactory;

class GildedRose {

    Item[] items; //FIXME discuss with goblin to allow us to make this private and provide a getter
    private final ItemUpdaterFactory itemUpdaterFactory = new ItemUpdaterFactory();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater updater = itemUpdaterFactory.getUpdater(item);
            updater.update(item);
        }
    }
}
