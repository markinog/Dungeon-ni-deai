package arena.entity;

import java.util.Random;

public class D20 {
    public static int rolar() {
        Random ran = new Random();

        return 1 + ran.nextInt((20 - 1) + 1);
    }
}
