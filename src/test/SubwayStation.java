package test;

public class SubwayStation {

    String name;
    Integer number;//序号

    public SubwayStation(Integer number, String name ) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }
}
