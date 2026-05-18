package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testQualityOfRegularItem() {
        Item[] items = new Item[] { new Item("vest", 10, 20) };
        GildedRose app = new GildedRose(items);

        // assert after 1 day
        progressDays(app, 1);
        verifyItem("vest", app.items[0], 19, 9);

        // assert halfway sell time
        progressDays(app, 4);
        verifyItem("vest", app.items[0], 15, 5);

        // assert sellIn reaching 0
        progressDays(app, 5);
        verifyItem("vest", app.items[0], 10, 0);

        // assert 10 days past sellIn
        progressDays(app, 10);
        verifyItem("vest", app.items[0], 0, -10);

        // assert 20 days past sellIn
        progressDays(app, 10);
        verifyItem("vest", app.items[0], 0, -20);

        // assert 30 days past sellIn
        progressDays(app, 10);
        verifyItem("vest", app.items[0], 0, -30);
    }

    @Test
    void testQualityOfAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 0) };
        GildedRose app = new GildedRose(items);

        // assert after 1 day
        progressDays(app, 1);
        verifyItem("Aged Brie", app.items[0], 1, 9);

        // assert halfway sell time
        progressDays(app, 4);
        verifyItem("Aged Brie", app.items[0], 5, 5);

        // assert sellIn reaching 0
        progressDays(app, 5);
        verifyItem("Aged Brie", app.items[0], 10, 0);

        // assert 10 days past sellIn
        progressDays(app, 10);
        verifyItem("Aged Brie", app.items[0], 30, -10);

        // assert 20 days past sellIn
        progressDays(app, 10);
        verifyItem("Aged Brie", app.items[0], 50, -20);

        // assert 30 days past sellIn
        progressDays(app, 10);
        verifyItem("Aged Brie", app.items[0], 50, -30);
    }

    @Test
    void testQualityOfSulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);

        // assert after 1 day
        progressDays(app, 1);
        verifyItem("Sulfuras, Hand of Ragnaros", app.items[0], 80, 0);

        // assert halfway sell time
        progressDays(app, 4);
        verifyItem("Sulfuras, Hand of Ragnaros", app.items[0], 80, 0);

        // assert sellIn reaching 0
        progressDays(app, 5);
        verifyItem("Sulfuras, Hand of Ragnaros", app.items[0], 80, 0);

        // assert 10 days past sellIn
        progressDays(app, 10);
        verifyItem("Sulfuras, Hand of Ragnaros", app.items[0], 80, 0);

        // assert 20 days past sellIn
        progressDays(app, 10);
        verifyItem("Sulfuras, Hand of Ragnaros", app.items[0], 80, 0);

        // assert 30 days past sellIn
        progressDays(app, 10);
        verifyItem("Sulfuras, Hand of Ragnaros", app.items[0], 80, 0);
    }

    @Test
    void testQualityOfBackStagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 30, 10) };
        GildedRose app = new GildedRose(items);

        // assert after 1 day
        progressDays(app, 1);
        verifyItem("Backstage passes to a TAFKAL80ETC concert", app.items[0], 11, 29);

        // assert halfway sell time
        progressDays(app, 14);
        verifyItem("Backstage passes to a TAFKAL80ETC concert", app.items[0], 25, 15);

        // assert sellIn reaching 10
        progressDays(app, 5);
        verifyItem("Backstage passes to a TAFKAL80ETC concert", app.items[0], 30, 10);

        // assert sellIn reaching 5
        progressDays(app, 5);
        verifyItem("Backstage passes to a TAFKAL80ETC concert", app.items[0], 40, 5);

        // assert sellIn reaching 0
        progressDays(app, 5);
        verifyItem("Backstage passes to a TAFKAL80ETC concert", app.items[0], 50, 0);

        // assert 10 days past sellIn
        progressDays(app, 10);
        verifyItem("Backstage passes to a TAFKAL80ETC concert", app.items[0], 0, -10);

        // assert 20 days past sellIn
        progressDays(app, 10);
        verifyItem("Backstage passes to a TAFKAL80ETC concert", app.items[0], 0, -20);

        // assert 30 days past sellIn
        progressDays(app, 10);
        verifyItem("Backstage passes to a TAFKAL80ETC concert", app.items[0], 0, -30);
    }

    @Test
    void testQualityOfConjuredItem() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 10, 10) };
        GildedRose app = new GildedRose(items);

        // assert after 1 day
        progressDays(app, 1);
        verifyItem("Conjured Mana Cake", app.items[0], 8, 9);

        // assert halfway sell time
        progressDays(app, 4);
        verifyItem("Conjured Mana Cake", app.items[0], 0, 5);

        // assert sellIn reaching 0
        progressDays(app, 5);
        verifyItem("Conjured Mana Cake", app.items[0], 0, 0);

        // assert 10 days past sellIn
        progressDays(app, 10);
        verifyItem("Conjured Mana Cake", app.items[0], 0, -10);

        // assert 20 days past sellIn
        progressDays(app, 10);
        verifyItem("Conjured Mana Cake", app.items[0], 0, -20);

        // assert 30 days past sellIn
        progressDays(app, 10);
        verifyItem("Conjured Mana Cake", app.items[0], 0, -30);
    }

    private void progressDays(GildedRose app, int numberOfDays) {
        for (int i = 0; i < numberOfDays; i++) {
            app.updateQuality();
        }
    }

    private void verifyItem(String foo, Item item, int quality, int sellIn) {
        assertEquals(foo, item.name);
        assertEquals(quality, item.quality);
        assertEquals(sellIn, item.sellIn);
    }

}
