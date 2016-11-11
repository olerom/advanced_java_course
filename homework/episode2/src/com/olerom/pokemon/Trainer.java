package com.olerom.pokemon;

import java.util.ArrayList;

/**
 * Created by oleg on 08.11.16.
 */
class Trainer {
    private String name;
    private ArrayList<Pokemon> pokemonHand;
    private double score;

    Trainer(String name, ArrayList<Pokemon> pokemonHand) {
        this.name = name;
        this.pokemonHand = pokemonHand;
        this.score = 0;
    }

    String pokemonToString(int index) {
        return this.getName() + " - " + this.getPokemon(index);
    }


    int getPokemonNumber() {
        return getPokemonHand().size();
    }

    String getPokemonName(int index) {
        return this.getPokemon(index).getName();
    }

    int getPokemonStamina(int index) {
        return this.getPokemon(index).getStamina();
    }

    int getPokemonAttack(int index) {
        return this.getPokemon(index).getAttack();
    }

    int getPokemonSpecialAttack(int index) {
        return this.getPokemon(index).getSpecialAttack();
    }

    int getPokemonDefense(int index) {
        return this.getPokemon(index).getDefense();
    }

    int getPokemonSpecialDefense(int index) {
        return this.getPokemon(index).getSpecialDefense();
    }

    Pokemon getPokemon(int index) {
        return this.getPokemonHand().get(index);
    }

    void setPokemonStamina(int index, int stamina) {
        this.getPokemon(index).setStamina(stamina);
    }

    void setName(String name) {
        this.name = name;
    }

    void setPokemonHand(ArrayList<Pokemon> pokemonHand) {
        this.pokemonHand = pokemonHand;
    }

    void setScore(double score) {
        this.score = score;
    }

    String getName() {
        return name;
    }

    ArrayList<Pokemon> getPokemonHand() {
        return pokemonHand;
    }

    double getScore() {
        return score;
    }
}
