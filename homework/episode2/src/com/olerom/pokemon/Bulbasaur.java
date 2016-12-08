package com.olerom.pokemon;

/**
 * Created by oleg on 10.11.16.
 */
class Bulbasaur extends Pokemon implements GrassType, PoisonType {

    Bulbasaur() {
        super("Bulbasaur", 60, 62, 63, 65, 65);
    }

    Bulbasaur(String name, int stamina, int attack, int defense, int specialAttack, int specialDefense) {
        super(name, stamina, attack, defense, specialAttack, specialDefense);
    }


    @Override
    public int grassAttack() {
        return this.getAttack() + 10;
    }

    @Override
    public int poisonAttack() {
        return this.getAttack() + 6;
    }
}
