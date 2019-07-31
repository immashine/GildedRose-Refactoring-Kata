package com.gildedrose;

public interface QualityUpdateStrategy {

    int getDelta(Item item);
    
    boolean isApplicable(Item item);
}
