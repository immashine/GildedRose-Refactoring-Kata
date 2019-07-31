package com.gildedrose;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class GildedRose {

    private final List<QualityUpdateStrategy> qualityUpdateStrategies = Arrays.asList(
            new AgedBrieQualityUpdateStrategy(), new BackstagePassesQualityUpdateStrategy());
    
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
                item.sellIn = item.sellIn - 1;
            } else {
                oldMethod(item);
            }
        }
    }

    private void oldMethod(Item item) {
        if (item.quality > 0) {
            if (!item.name.equals(SULFURAS)) {
                item.quality = item.quality - 1;
            }
            
        }
        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                if (!item.name.equals(SULFURAS)) {
                    item.quality = item.quality - 1;
                }
            }
        }
    }
}
