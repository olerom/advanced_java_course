package com.olerom.pokemon;

/**
 * Created by oleg on 10.11.16.
 */
class Ivysaur extends Bulbasaur implements GrassType, PoisonType {
    Ivysaur() {
        super("Ivysaur", 60, 62, 63, 80, 80);
    }

    Ivysaur(String name, int stamina, int attack, int defense, int specialAttack, int specialDefense) {
        super(name, stamina, attack, defense, specialAttack, specialDefense);
    }

    @Override
    public int grassAttack() {
        return super.grassAttack();
    }

    @Override
    public int poisonAttack() {
        return super.poisonAttack();
    }
}
