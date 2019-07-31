package com.gildedrose;

public class DefaultQualityUpdateStrategy implements QualityUpdateStrategy {

    @Override
    public int getDelta(Item item) {
        if (item.quality <= 0) {
            return 0;
        }
        return item.sellIn <= 0
                ? -2
                : -1;
    }

    @Override
    public boolean isApplicable(Item item) {
        return !"Sulfuras, Hand of Ragnaros".equals(item.name);
    }
}
