package com.gildedrose;

public class DefaultDailyUpdateStrategy implements DailyItemUpdateStrategy {

    @Override
    public int getQualityDelta(Item item) {
        if (item.quality <= 0) {
            return 0;
        }
        return item.sellIn <= 0
                ? -2
                : -1;
    }

    @Override
    public boolean isApplicable(Item item) {
        return true;
    }
}
