package com.gildedrose;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

class GildedRose {

    private final List<QualityUpdateStrategy> qualityUpdateStrategies = Collections.singletonList(
            new AgedBrieQualityUpdateStrategy());

    final static String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    final static String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            Optional<QualityUpdateStrategy> strat = qualityUpdateStrategies.stream()
                    .filter(strategy -> strategy.isApplicable(item))
                    .findFirst();
            if (strat.isPresent()) {
                int delta = strat.get().getDelta(item);
                item.quality = item.quality + delta;
            } else {
                oldMethod(item);
            }
        }
    }

    private void oldMethod(Item item) {
        if (!item.name.equals(BACKSTAGE_PASSES)) {
            if (item.quality > 0) {
                if (!item.name.equals(SULFURAS)) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.sellIn < 11) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }

                if (item.sellIn < 6) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }

        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals(BACKSTAGE_PASSES)) {
                if (item.quality > 0) {
                    if (!item.name.equals(SULFURAS)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                item.quality = item.quality - item.quality;
            }
        }
    }
}
