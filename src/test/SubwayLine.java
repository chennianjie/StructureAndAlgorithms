package test;

import java.util.ArrayList;

public class SubwayLine {


    private String name;
    private ArrayList<SubwayStation> stations;

    public SubwayLine(ArrayList<SubwayStation> stations, String name) {
        this.stations = stations;
        this.name = name;
    }

    public int getNumByName(String name) {
        if (name == null || name.equals("")) {
            return -1;
        }

        for (SubwayStation subwayStation : stations) {
            if (name.equals(subwayStation.getName())) {
                return subwayStation.getNumber();
            }
        }
        return -1;
    }
}
