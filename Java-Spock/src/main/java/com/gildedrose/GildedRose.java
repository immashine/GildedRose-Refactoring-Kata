package com.gildedrose;

import java.util.Arrays;
import java.util.List;

class GildedRose {

    private final List<QualityUpdateStrategy> qualityUpdateStrategies = Arrays.asList(
            new AgedBrieQualityUpdateStrategy(),
            new BackstagePassesQualityUpdateStrategy(),
            new DefaultQualityUpdateStrategy()
    );

    final static String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            qualityUpdateStrategies.stream()
                    .filter(strategy -> strategy.isApplicable(item))
                    .findFirst()
                    .ifPresent(strategy -> update(item, strategy));
        }
    }

    private void update(Item item, QualityUpdateStrategy strategy) {
        int delta = strategy.getDelta(item);
        item.quality = item.quality + delta;
        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }
    }

}
