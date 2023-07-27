package dtnl.chronowar.Data;


import org.simpleyaml.configuration.serialization.SerializableAs;

@SerializableAs("Player")
public class Player {

    private final int level;
    private static int units_lvl1;
    private static int units_lvl2;
    private static int units_lvl3;
    private static int units_lvl4;
    private static int units_lvl5;
    private static int units_lvl6;

    private static int house_1;
    private static int house_2;
    private static int house_3;

    private static int foodfarm_1;
    private static int foodfarm_2;
    private static int foodfarm_3;

    private static int woodfarm_1;
    private static int woodfarm_2;
    private static int woodfarm_3;

    private static int metalmine_1;
    private static int metalmine_2;
    private static int metalmine_3;

    private static int goldmine_1;
    private static int goldmine_2;
    private static int goldmine_3;

    public Player(int lvl, int u1, int u2, int u3, int u4, int u5, int u6, int h1, int h2, int h3, int f1, int f2, int f3, int w1, int w2, int w3, int m1, int m2, int m3, int g1, int g2, int g3) {
        level = lvl;
        units_lvl1 = u1;
        units_lvl2 = u2;
        units_lvl3 = u3;
        units_lvl4 = u4;
        units_lvl5 = u5;
        units_lvl6 = u6;

        house_1 = h1;
        house_2 = h2;
        house_3 = h3;

        foodfarm_1 = f1;
        foodfarm_2 = f2;
        foodfarm_3 = f3;

        woodfarm_1 = w1;
        woodfarm_2 = w2;
        woodfarm_3 = w3;

        metalmine_1 = m1;
        metalmine_2 = m2;
        metalmine_3 = m3;

        goldmine_1 = g1;
        goldmine_2 = g2;
        goldmine_3 = g3;

    }

    public static void setunits(int lvl, int amount){
        switch (lvl) {
            case 1:
                units_lvl1 = amount;
            case 2:
                units_lvl2 = amount;
            case 3:
                units_lvl3 = amount;
            case 4:
                units_lvl4 = amount;
            case 5:
                units_lvl5 = amount;
            case 6:
                units_lvl6 = amount;
        }
    }

    public int getunits(int lvl) {
        switch (lvl) {
            case 1:
                return units_lvl1;
            case 2:
                return units_lvl2;
            case 3:
                return units_lvl3;
            case 4:
                return units_lvl4;
            case 5:
                return units_lvl5;
            case 6:
                return units_lvl6;
            default:
                return 0;
        }
    }

    public static int getHouse_1() {
        return house_1;
    }

    public static void setHouse_1(int house_1) {
        Player.house_1 = house_1;
    }

    public static int getHouse_2() {
        return house_2;
    }

    public static void setHouse_2(int house_2) {
        Player.house_2 = house_2;
    }

    public static int getHouse_3() {
        return house_3;
    }

    public static void setHouse_3(int house_3) {
        Player.house_3 = house_3;
    }

    public static int getFoodfarm_1() {
        return foodfarm_1;
    }

    public static void setFoodfarm_1(int foodfarm_1) {
        Player.foodfarm_1 = foodfarm_1;
    }

    public static int getFoodfarm_2() {
        return foodfarm_2;
    }

    public static void setFoodfarm_2(int foodfarm_2) {
        Player.foodfarm_2 = foodfarm_2;
    }

    public static int getFoodfarm_3() {
        return foodfarm_3;
    }

    public static void setFoodfarm_3(int foodfarm_3) {
        Player.foodfarm_3 = foodfarm_3;
    }

    public static int getWoodfarm_1() {
        return woodfarm_1;
    }

    public static void setWoodfarm_1(int woodfarm_1) {
        Player.woodfarm_1 = woodfarm_1;
    }

    public static int getWoodfarm_2() {
        return woodfarm_2;
    }

    public static void setWoodfarm_2(int woodfarm_2) {
        Player.woodfarm_2 = woodfarm_2;
    }

    public static int getWoodfarm_3() {
        return woodfarm_3;
    }

    public static void setWoodfarm_3(int woodfarm_3) {
        Player.woodfarm_3 = woodfarm_3;
    }

    public static int getMetalmine_1() {
        return metalmine_1;
    }

    public static void setMetalmine_1(int metalmine_1) {
        Player.metalmine_1 = metalmine_1;
    }

    public static int getMetalmine_2() {
        return metalmine_2;
    }

    public static void setMetalmine_2(int metalmine_2) {
        Player.metalmine_2 = metalmine_2;
    }

    public static int getMetalmine_3() {
        return metalmine_3;
    }

    public static void setMetalmine_3(int metalmine_3) {
        Player.metalmine_3 = metalmine_3;
    }

    public static int getGoldmine_1() {
        return goldmine_1;
    }

    public static void setGoldmine_1(int goldmine_1) {
        Player.goldmine_1 = goldmine_1;
    }

    public static int getGoldmine_2() {
        return goldmine_2;
    }

    public static void setGoldmine_2(int goldmine_2) {
        Player.goldmine_2 = goldmine_2;
    }

    public static int getGoldmine_3() {
        return goldmine_3;
    }

    public static void setGoldmine_3(int goldmine_3) {
        Player.goldmine_3 = goldmine_3;
    }

    public int getLevel() {
        return level;
    }
}
