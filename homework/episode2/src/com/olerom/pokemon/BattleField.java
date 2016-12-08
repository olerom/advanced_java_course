package com.olerom.pokemon;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by oleg on 06.11.16.
 */
class BattleField {
    void run() throws IOException {

        Battle logic = Battle.getInstance();

        ArrayList<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Charizard());
        pokemons.add(new Charmander());
        pokemons.add(new Squirtle());

        Trainer firstPlayer = new Trainer("First player", pokemons);
        pokemons = new ArrayList<>();

        pokemons.add(new Bulbasaur());
        pokemons.add(new Ivysaur());
        pokemons.add(new Venusaur());

        Trainer secondPlayer = new Trainer("Second player", pokemons);

        int firstChoice = logic.getChoice(firstPlayer);
        int secondChoice = logic.getChoice(secondPlayer);

        while (firstPlayer.getPokemon(firstChoice).getStamina() > 0
                && secondPlayer.getPokemon(secondChoice).getStamina() > 0) {

            System.out.println(firstPlayer.pokemonToString(firstChoice));
            System.out.println(secondPlayer.pokemonToString(secondChoice));

            logic.battleAction(firstPlayer, secondPlayer, firstChoice, secondChoice);

//            if (!(secondPlayer.getPokemonStamina(secondChoice) > 0)) {
//                break;
//            }

            logic.battleAction(secondPlayer, firstPlayer, secondChoice, firstChoice);
        }

        if (firstPlayer.getPokemon(firstChoice).getStamina() > 0) {
            System.out.print(firstPlayer.getName());
        } else {
            System.out.print(secondPlayer.getName());
        }
        System.out.println(" has won!");

        System.out.println("You have been playing for " + logic.getSessionTime() + " ms");
        System.out.println("Commands were thrown: " + logic.getTotalCommands() + " time(s)");
    }
}
