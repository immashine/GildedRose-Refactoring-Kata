package com.gildedrose;

import java.util.Arrays;
import java.util.List;

class GildedRose {

    private final List<DailyItemUpdateStrategy> updateStrategies = Arrays.asList(
            new AgedBrieDailyUpdateStrategy(),
            new BackstagePassesDailyUpdateStrategy(),
            new SulfurusDailyUpdateStrategy(),
            new DefaultDailyUpdateStrategy()
    );

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateStrategies.stream()
                    .filter(strategy -> strategy.isApplicable(item))
                    .findFirst()
                    .ifPresent(strategy -> update(item, strategy));
        }
    }

    private void update(Item item, DailyItemUpdateStrategy strategy) {
        item.quality = item.quality + strategy.getQualityDelta(item);
        item.sellIn = item.sellIn + strategy.getSellInDelta();
    }

}
