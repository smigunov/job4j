package ru.job4j.level1.coffemachine;

import java.util.Arrays;
import java.util.Comparator;

public class CoffeMachine {
    class Coin {
        private int nominal;
        private int amount;

        public Coin(int nominal, int amount) {
            this.nominal = nominal;
            this.amount = amount;
        }

        public int getNominal() {
            return this.nominal;
        }

        public void give() {
            this.amount--;
        }

        public int getAmount() {
            return this.amount;
        }
    }

    class CoinCompare implements Comparator<Coin> {
        public int compare(Coin a, Coin b) {
            return b.nominal - a.nominal;
        }
    }

    private Coin[] coins;

    public CoffeMachine(int[][] coins) {
        this.coins = new Coin[coins.length];
        for (int i = 0; i < coins.length; i++) {
            this.coins[i] = new Coin(coins[i][0], coins[i][1]);
        }
        Arrays.sort(this.coins, new CoinCompare());
    }

    public int[] changes(int value, int price) {
        int change = price - value;
        int[] preResult = new int[100];
        int idx = 0;
        for (Coin coin : coins) {
            while (change >= coin.nominal && coin.getAmount() > 0) {
                change = change - coin.nominal;
                coin.give();
                preResult[idx] = coin.nominal;
                idx++;
            }
        }
        return Arrays.copyOf(preResult, idx);
        String s;
        s.equals()

    }

}
