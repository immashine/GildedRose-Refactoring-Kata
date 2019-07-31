package com.gildedrose;

class ConjuredDailyUpdateStrategy extends DefaultDailyUpdateStrategy implements DailyItemUpdateStrategy {

    @Override
    public int getQualityDelta(Item item) {
        return super.getQualityDelta(item) * 2;
    }

    @Override
    public boolean isApplicable(Item item) {
        return "Conjured".equals(item.name);
    }
}
