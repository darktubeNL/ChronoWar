package dtnl.chronowar.Data.research;

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
}
