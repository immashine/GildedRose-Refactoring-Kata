package com.gildedrose;

class BackstagePassesDailyUpdateStrategy implements DailyItemUpdateStrategy {

    @Override
    public int getQualityDelta(Item item) {
        if (item.quality >= 50){
            return 0;
        }
        if (item.sellIn <= 0){
            return -item.quality;
        }
        if (item.sellIn < 6){
            return 3;
        }
        if (item.sellIn < 11){
            return 2;
        }
        return 1;
    }

    @Override
    public boolean isApplicable(Item item) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(item.name);
    }
}
