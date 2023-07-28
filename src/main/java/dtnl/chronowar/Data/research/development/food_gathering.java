package dtnl.chronowar.Data.research.development;

public class food_gathering {

    public static int max = 2;
    //boost food gathering
    public static int power(int level) {
        switch (level) {
            case 1:
                return 20;
            case 2:
                return 55;
            default:
                return 0;
        }
    }
    public static int boost(int level) {
        switch (level) {
            case 1:
                return 10;
            case 2:
                return 20;
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
