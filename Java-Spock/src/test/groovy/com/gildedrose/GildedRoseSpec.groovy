package com.gildedrose

import spock.lang.Specification

class GildedRoseSpec extends Specification {

    def "should decrease quality by 1 for common item"() {
        given: "common item"
            Item[] items = [new Item("common item", 15, 33)];
        and: "the application with this item"
            GildedRose app = new GildedRose(items);
        when: "updating quality"
            app.updateQuality();
        then: "quality increased by 1"
            app.items[0].quality == 32
    }

    def "should decrease quality by 2 when sellIn is negative for common item"() {
        given: "common item with negative sellIn"
            Item[] items = [new Item("common item", -1, 28)];
        and: "the application with this item"
            GildedRose app = new GildedRose(items);
        when: "updating quality"
            app.updateQuality();
        then: "quality increased by 2"
            app.items[0].quality == 26
    }

    def "should not decrease quality below zero"() {
        given: "common item with zero quality"
            Item[] items = [new Item("common item", 4, 0)];
        and: "the application with this item"
            GildedRose app = new GildedRose(items);
        when: "updating quality"
            app.updateQuality();
        then: "quality did not change"
            app.items[0].quality == 0
    }

    def "should decrease sellIn by 1"() {
        given: "common item"
            Item[] items = [new Item("common item", 11, 23)];
        and: "the application with this item"
            GildedRose app = new GildedRose(items);
        when: "updating quality"
            app.updateQuality();
        then: "the quality is correct"
            app.items[0].sellIn == 10
    }
}
