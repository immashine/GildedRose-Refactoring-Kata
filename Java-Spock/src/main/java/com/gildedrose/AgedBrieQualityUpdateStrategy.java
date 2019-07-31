package com.gildedrose;

public class AgedBrieQualityUpdateStrategy implements QualityUpdateStrategy {

    @Override
    public int getDelta(Item item) {
        return item.quality < 50 
                ? 1
                : 0;
    }

    @Override
    public boolean isApplicable(Item item) {
        return "Aged Brie".equals(item.name);
    }
}
