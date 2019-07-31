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
            if (isNotUpdatable(item)) {
                continue;
            }
            qualityUpdateStrategies.stream()
                    .filter(strategy -> strategy.isApplicable(item))
                    .findFirst()
                    .ifPresent(strategy -> update(item, strategy.getDelta(item)));
        }
    }

    private boolean isNotUpdatable(Item item) {
        return item.name.equals(SULFURAS);
    }

    private void update(Item item, int delta) {
        item.quality = item.quality + delta;
        item.sellIn = item.sellIn - 1;
    }

}
