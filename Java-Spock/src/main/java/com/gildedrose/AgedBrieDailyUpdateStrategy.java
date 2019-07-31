package com.gildedrose;

public class AgedBrieDailyUpdateStrategy implements DailyItemUpdateStrategy {

    @Override
    public int getQualityDelta(Item item) {
        return item.quality < 50 
                ? 1
                : 0;
    }

    @Override
    public boolean isApplicable(Item item) {
        return "Aged Brie".equals(item.name);
    }
}
