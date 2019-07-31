package com.gildedrose;

interface DailyItemUpdateStrategy {

    boolean isApplicable(Item item);

    int getQualityDelta(Item item);

    default int getSellInDelta() {
        return -1;
    }

}
