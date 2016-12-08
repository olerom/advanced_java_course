package com.olerom.pokemon;

/**
 * Created by oleg on 10.11.16.
 */
class Charmander extends Pokemon implements FireType {
    Charmander() {
        super("Charmander", 39, 60, 50, 60, 50);
    }

    Charmander(String name, int stamina, int attack, int defense, int specialAttack, int specialDefense) {
        super(name, stamina, attack, defense, specialAttack, specialDefense);
    }

    @Override
    public int fireAttack() {
        return this.getAttack() + 6;
    }
}
