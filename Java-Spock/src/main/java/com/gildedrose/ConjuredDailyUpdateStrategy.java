package com.gildedrose;

class ConjuredDailyUpdateStrategy implements DailyItemUpdateStrategy {

    @Override
    public int getQualityDelta(Item item) {
        return -2;
    }

    @Override
    public boolean isApplicable(Item item) {
        return "Conjured".equals(item.name);
    }
}
