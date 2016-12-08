package com.olerom.pokemon;

/**
 * Created by oleg on 10.11.16.
 */
class Squirtle extends Pokemon implements WaterType {
    Squirtle() {
        super("Squirtle", 44, 48, 65, 50, 64);
    }

    @Override
    public int waterAttack() {
        return this.getAttack() + 4;
    }
}
