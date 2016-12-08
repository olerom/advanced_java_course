package com.olerom.pokemon;

/**
 * Created by oleg on 06.11.16.
 */
class Pokemon {
    private String name;
    private int stamina;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;

    Pokemon(String name, int stamina, int attack, int defense, int specialAttack, int specialDefense) {
        this.name = name;
        this.stamina = stamina;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
    }

    @Override
    public String toString() {
        return this.getName() + ": " + this.getStamina() + " stamina, "
                + this.getAttack() + " attack, " + this.getDefense() + " defense, "
                + this.getSpecialAttack() + " special attack, "
                + this.getSpecialDefense() + " special defence";
    }

    String getName() {
        return name;
    }

    int getStamina() {
        return stamina;
    }

    void setStamina(int stamina) {
        this.stamina = stamina;
    }

    int getAttack() {
        return attack;
    }

    int getDefense() {
        return defense;
    }

    int getSpecialAttack() {
        return this.specialAttack;
    }

    int getSpecialDefense() {
        return this.specialDefense;
    }
}
