package com.olerom.pokemon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by oleg on 09.11.16.
 */
class Battle {

    private static Battle instance;

    private Battle() {
    }

    static Battle getInstance() {
        if (instance == null) {
            return new Battle();
        }
        return instance;
    }

    private static long sessionTime = System.currentTimeMillis();
    private static int commands;

    long getSessionTime() {
        return System.currentTimeMillis() - sessionTime;
    }

    int getTotalCommands() {
        return commands;
    }

    void action(Trainer trainerFirst, int firstChoice, Trainer trainerSecond, int secondChoice, String command) {
        this.commands++;
        switch (command) {
            case "attack":
                trainerSecond.setPokemonStamina(secondChoice,
                        trainerSecond.getPokemonStamina(secondChoice)
                                - trainerFirst.getPokemonAttack(firstChoice));
                break;
            case "protect":
                trainerFirst.setPokemonStamina(firstChoice,
                        trainerFirst.getPokemonStamina(firstChoice)
                                + trainerFirst.getPokemonDefense(firstChoice));
                break;
            case "special attack":
                trainerSecond.setPokemonStamina(secondChoice,
                        trainerSecond.getPokemonStamina(secondChoice)
                                - trainerFirst.getPokemonSpecialAttack(firstChoice));
                break;
            case "special protect":
                trainerFirst.setPokemonStamina(firstChoice,
                        trainerFirst.getPokemonStamina(firstChoice)
                                + trainerFirst.getPokemonDefense(firstChoice));
                break;
        }
    }

    int getChoice(Trainer player) {
        boolean flag = true;
        int result = 0;
        while (flag) {
            try {
                System.out.println(player.getName() + ": choose your pokemon.");
                int i;
                for (i = 0; i < player.getPokemonNumber(); i++) {
                    System.out.println(i + ". " + player.getPokemon(i));
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String line = bufferedReader.readLine();
                result = Integer.parseInt(line);
                if (result >= 0 && result < i) {
                    flag = false;
                } else {
                    throw new Exception();
                }

            } catch (Exception ex) {
                System.out.println("Wrong input. Try again, " + player.getName() + ".");
            }
        }
        return result;
    }

    void battleAction(Trainer firstPlayer, Trainer secondPlayer, int firstChoice, int secondChoice) {
        boolean flag = true;
        while (flag) {
            try {
                System.out.println(firstPlayer.getName() + " can command: attack, protect, special attack or special protect");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String commandFirst = bufferedReader.readLine();
                if (commandFirst.equals("attack") || commandFirst.equals("protect")
                        || commandFirst.equals("special attack") || commandFirst.equals("special protect")) {
                    Battle logic = Battle.getInstance();
                    logic.action(firstPlayer, firstChoice, secondPlayer, secondChoice, commandFirst);
                    flag = false;
                } else {
                    throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println("Wrong input. Try again, " + firstPlayer.getName() + ".");
            }
        }
    }
}
