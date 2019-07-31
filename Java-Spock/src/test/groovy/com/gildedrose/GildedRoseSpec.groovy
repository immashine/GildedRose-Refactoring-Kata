package com.gildedrose

import spock.lang.Specification

class GildedRoseSpec extends Specification {

    def 'should decrease quality by 1 for common item'() {
        given: 'common item'
            Item[] items = [new Item('common item', 15, 33)]
        and: 'the application with this item'
            GildedRose app = new GildedRose(items)
        when: 'updating quality'
            app.updateQuality()
        then: 'quality decreased by 1'
            app.items[0].quality == 32
    }

    def 'should decrease quality by 2 when sellIn is negative for common item'() {
        given: 'common item with negative sellIn'
            Item[] items = [new Item('any item', -1, 28)]
        and: 'the application with this item'
            GildedRose app = new GildedRose(items)
        when: 'updating quality'
            app.updateQuality()
        then: 'quality decreased by 2'
            app.items[0].quality == 26
    }

    def 'should not decrease quality below zero'() {
        given: 'common item with zero quality'
            Item[] items = [new Item(name, 4, 0)]
        and: 'the application with this item'
            GildedRose app = new GildedRose(items)
        when: 'updating quality'
            app.updateQuality()
        then: 'quality did not change'
            app.items[0].quality == 0
        where:
            name << ['common item', 'Conjured']
    }

    def 'should decrease sellIn by 1'() {
        given: 'common item'
            Item[] items = [new Item('common item', 11, 23)]
        and: 'the application with this item'
            GildedRose app = new GildedRose(items)
        when: 'updating quality'
            app.updateQuality()
        then: 'sellIn was lowered by 1'
            app.items[0].sellIn == 10
    }

    def 'should increase quality by 1 for Aged Brie'() {
        given: 'Aged Brie'
            Item[] items = [new Item('Aged Brie', 78, 13)]
        and: 'the application with this item'
            GildedRose app = new GildedRose(items)
        when: 'updating quality'
            app.updateQuality()
        then: 'quality increased by 1'
            app.items[0].quality == 14
    }

    def 'should not increase quality above 50'() {
        given: 'Aged Brie with maximum allowed quality'
            Item[] items = [new Item(name, 25, 50)]
        and: 'the application with this item'
            GildedRose app = new GildedRose(items)
        when: 'updating quality'
            app.updateQuality()
        then: 'quality did not change'
            app.items[0].quality == 50
        where:
            name << ['Aged Brie', 'Backstage passes to a TAFKAL80ETC concert']
    }

    def 'should not change quality for Sulfuras'() {
        given: 'Sulfuras'
            Item[] items = [new Item('Sulfuras, Hand of Ragnaros', 20, 10)]
        and: 'the application with this item'
            GildedRose app = new GildedRose(items)
        when: 'updating quality'
            app.updateQuality()
        then: 'quality did not change'
            app.items[0].quality == 10
    }

    def 'should not change sellIn for Sulfuras'() {
        given: 'Sulfuras'
            Item[] items = [new Item('Sulfuras, Hand of Ragnaros', 59, 44)]
        and: 'the application with this item'
            GildedRose app = new GildedRose(items)
        when: 'updating quality'
            app.updateQuality()
        then: 'sellIn did not change'
            app.items[0].sellIn == 59
    }

    def 'should increase quality by 1 for Backstage passes'() {
        given: 'Backstage passes with more than 10 sellIn'
            Item[] items = [new Item('Backstage passes to a TAFKAL80ETC concert', 25, 7)]
        and: 'the application with this item'
            GildedRose app = new GildedRose(items)
        when: 'updating quality'
            app.updateQuality()
        then: 'quality increased by 1'
            app.items[0].quality == 8
    }

    def 'should increase quality by 2 if sellIn is lower than 11 for Backstage passes'() {
        given: 'Backstage passes with lower than 11 sellIn'
            Item[] items = [new Item('Backstage passes to a TAFKAL80ETC concert', 9, 29)]
        and: 'the application with this item'
            GildedRose app = new GildedRose(items)
        when: 'updating quality'
            app.updateQuality()
        then: 'quality decreased by 2'
            app.items[0].quality == 31
    }

    def 'should increase quality by 3 if sellIn is lower than 6 for Backstage passes'() {
        given: 'Backstage passes with lower than 6 sellIn'
            Item[] items = [new Item('Backstage passes to a TAFKAL80ETC concert', 5, 31)]
        and: 'the application with this item'
            GildedRose app = new GildedRose(items)
        when: 'updating quality'
            app.updateQuality()
        then: 'quality decreased by 3'
            app.items[0].quality == 34
    }

    def 'should drop quality to 0 if sellIn below 0 for  Backstage passes'() {
        given: 'Backstage passes with 0 sellIn'
            Item[] items = [new Item('Backstage passes to a TAFKAL80ETC concert', 0, 31)]
        and: 'the application with this item'
            GildedRose app = new GildedRose(items)
        when: 'updating quality'
            app.updateQuality()
        then: 'quality decreased to 0'
            app.items[0].quality == 0
    }

    def 'should decrease quality by 2 for conjured item'() {
        given: 'Conjured item'
            Item[] items = [new Item('Conjured', 32, 32)]
        and: 'the application with this item'
            GildedRose app = new GildedRose(items)
        when: 'updating quality'
            app.updateQuality()
        then: 'quality decreased by 2'
            app.items[0].quality == 30
    }

    def 'should decrease quality by 4 for conjured item if sellIn below 0'() {
        given: 'Conjured item'
            Item[] items = [new Item('Conjured', -5, 32)]
        and: 'the application with this item'
            GildedRose app = new GildedRose(items)
        when: 'updating quality'
            app.updateQuality()
        then: 'quality decreased by 4'
            app.items[0].quality == 28
    }
}
