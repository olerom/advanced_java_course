package com.olerom.pokemon;

/**
 * Created by oleg on 10.11.16.
 */
class Venusaur extends Ivysaur implements GrassType, PoisonType {
    @Override
    public int grassAttack() {
        return super.grassAttack();
    }

    @Override
    public int poisonAttack() {
        return super.poisonAttack();
    }

    Venusaur() {
        super("Venusaur", 80, 82, 83, 100, 100);
    }
}
