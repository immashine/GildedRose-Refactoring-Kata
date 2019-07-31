package com.gildedrose;

class DefaultDailyUpdateStrategy implements DailyItemUpdateStrategy {

    @Override
    public int getQualityDelta(Item item) {
        return item.sellIn <= 0
                ? -2
                : -1;
    }

    @Override
    public boolean isApplicable(Item item) {
        return true;
    }
}
