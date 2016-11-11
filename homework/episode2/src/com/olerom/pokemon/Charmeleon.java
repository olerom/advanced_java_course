package com.olerom.pokemon;

/**
 * Created by oleg on 10.11.16.
 */
class Charmeleon extends Charmander implements FireType {
    Charmeleon() {
        super("Charmeleon", 58, 64, 58, 80, 65);
    }

    Charmeleon(String name, int stamina, int attack, int defense, int specialAttack, int specialDefense) {
        super(name, stamina, attack, defense, specialAttack, specialDefense);
    }

    @Override
    public int fireAttack() {
        return super.fireAttack();
    }
}
