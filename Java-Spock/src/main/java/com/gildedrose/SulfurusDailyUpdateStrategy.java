package com.gildedrose;

class SulfurusDailyUpdateStrategy implements DailyItemUpdateStrategy {

    @Override
    public int getQualityDelta(Item item) {
        return 0;
    }

    @Override
    public int getSellInDelta() {
        return 0;
    }
    
    @Override
    public boolean isApplicable(Item item) {
        return "Sulfuras, Hand of Ragnaros".equals(item.name);
    }
}
