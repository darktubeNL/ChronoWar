package dtnl.chronowar.Data.buildings;

public class house_1 {

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
    public static int housing(int level) {
        switch (level) {
            case 1:
                return 5;
            case 2:
                return 10;
            default:
                return 0;
        }
    }
}
