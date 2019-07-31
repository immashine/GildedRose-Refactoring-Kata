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
        then: 'quality increased by 1'
            app.items[0].quality == 32
    }

    def 'should decrease quality by 2 when sellIn is negative for common item'() {
        given: 'common item with negative sellIn'
            Item[] items = [new Item('common item', -1, 28)]
        and: 'the application with this item'
            GildedRose app = new GildedRose(items)
        when: 'updating quality'
            app.updateQuality()
        then: 'quality increased by 2'
            app.items[0].quality == 26
    }

    def 'should not decrease quality below zero'() {
        given: 'common item with zero quality'
            Item[] items = [new Item('common item', 4, 0)]
        and: 'the application with this item'
            GildedRose app = new GildedRose(items)
        when: 'updating quality'
            app.updateQuality()
        then: 'quality did not change'
            app.items[0].quality == 0
    }

    def 'should decrease sellIn by 1'() {
        given: 'common item'
            Item[] items = [new Item('common item', 11, 23)]
        and: 'the application with this item'
            GildedRose app = new GildedRose(items)
        when: 'updating quality'
            app.updateQuality()
        then: 'the quality is correct'
            app.items[0].sellIn == 10
    }

    def 'should increase quality by 1 for Aged Brie'() {
        given: 'common item'
            Item[] items = [new Item('Aged Brie', 78, 13)]
        and: 'the application with this item'
            GildedRose app = new GildedRose(items)
        when: 'updating quality'
            app.updateQuality()
        then: 'the quality is correct'
            app.items[0].quality == 24
    }

    def 'should not increase quality above 50'() {
        given: 'common item'
            Item[] items = [new Item('Aged Brie', 25, 50)]
        and: 'the application with this item'
            GildedRose app = new GildedRose(items)
        when: 'updating quality'
            app.updateQuality()
        then: 'the quality is correct'
            app.items[0].quality == 50
    }

    def 'should not change quality for Sulfuras'() {
        given: 'common item'
            Item[] items = [new Item('Sulfuras, Hand of Ragnaros', 20, 10)]
        and: 'the application with this item'
            GildedRose app = new GildedRose(items)
        when: 'updating quality'
            app.updateQuality()
        then: 'the quality is correct'
            app.items[0].quality == 10
    }

    def 'should not change sellIn for Sulfuras'() {
        given: 'common item'
            Item[] items = [new Item('Sulfuras, Hand of Ragnaros', 59, 44)]
        and: 'the application with this item'
            GildedRose app = new GildedRose(items)
        when: 'updating quality'
            app.updateQuality()
        then: 'the quality is correct'
            app.items[0].sellIn == 59
    }
}
