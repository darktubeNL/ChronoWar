package dtnl.chronowar.Data.buildings;

public class Barracks {

    public static int max = 2;

    public static int power(int level) {
        switch (level) {
            case 1:
                return 20;
            case 2:
                return 40;
            default:
                return 0;
        }
    }
    public static int boost(int level) {
        switch (level) {
            case 1:
                return 5;
            case 2:
                return 10;
            default:
                return 0;
        }
    }

    public static String cost(int level) {
        //return food.wood.metal.gold
        switch (level) {
            case 1:
                return "130.0.0.0";
            case 2:
                return "340.230.60.120";
            default:
                return "0.0.0.0";
        }
    }
}
