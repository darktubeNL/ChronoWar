package dtnl.chronowar;

public class Toolbox {
    public static int GetResource(String list, String type){
        String[] values = list.split("\\.");
        switch (type){
            case "food":
                return Integer.parseInt(values[0]);
            case "wood":
                return Integer.parseInt(values[1]);
            case "metal":
                return Integer.parseInt(values[2]);
            case "gold":
                return Integer.parseInt(values[3]);
        }
        return 0;
    }
}
