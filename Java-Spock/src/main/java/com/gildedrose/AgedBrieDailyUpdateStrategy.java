package com.gildedrose;

class AgedBrieDailyUpdateStrategy implements DailyItemUpdateStrategy {

    @Override
    public int getQualityDelta(Item item) {
        return 1;
    }

    @Override
    public boolean isApplicable(Item item) {
        return "Aged Brie".equals(item.name);
    }
}
