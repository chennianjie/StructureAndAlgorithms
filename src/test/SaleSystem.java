package test;

import java.util.ArrayList;

public class SaleSystem {


    private SubwayLine subwayLine1;

    public SaleSystem(){

        ArrayList<SubwayStation> stations = new ArrayList<>();
        stations.add(new SubwayStation(1 , "四惠东"));
        stations.add(new SubwayStation(2 , "四惠"));
        stations.add(new SubwayStation(3 , "大望路"));
        stations.add(new SubwayStation(4 , "国贸"));
        stations.add(new SubwayStation(5 , "永安里"));
        stations.add(new SubwayStation(6 , "建国门"));
        stations.add(new SubwayStation(7 , "东单"));
        stations.add(new SubwayStation(8 , "王府井"));
        stations.add(new SubwayStation(9 , "天安门东"));
        stations.add(new SubwayStation(10 , "天安门西"));
        stations.add(new SubwayStation(11 , "西单"));
        stations.add(new SubwayStation(12 , "复兴门"));
        stations.add(new SubwayStation(13 , "南礼士路"));
        stations.add(new SubwayStation(14 , "木樨地"));
        stations.add(new SubwayStation(15 , "军事博物馆"));
        stations.add(new SubwayStation(16 , "公主坟"));

        this.subwayLine1 = new SubwayLine(stations, "一号线");
    }

    public int sale(String start, String end) {
        int s = subwayLine1.getNumByName(start);
        int e = subwayLine1.getNumByName(end);
        int length = (e-s)>0 ? (e-s) : -(e-s);
        int money;
        if (length <= 5) {
            money = 3;
        } else if (length > 5 && length <= 8) {
            money = 4;
        } else if (length > 8 && length <= 12) {
            money = 5;
        } else {
            money = 6;
        }
        System.out.println("您需要支付" + money + "元，请投入1，5，10面值纸币");
        return money;
    }

    /**
     * 找零
     * @return
     */
    public void change(int need, int pay){
        if (pay != 1 || pay != 5 || pay != 10) {
            System.out.println("请投规定面值纸币");
            return;
        }

        int change = pay - need;
        if (change < 0) {
            return;
        }

        int valueOfFive = change/5;
        if (valueOfFive == 0) {
            System.out.println("找零:1元 张数:" + change);
        } else {
            System.out.println("找零:5元 张数:" + valueOfFive + "，1元 张数: " + change%5);
        }
    }

    public static void main(String[] args) {
        String name = "c\\h\\e\\\\n";
        System.out.println(name);
        String[] split = name.split("\\\\\\\\");
        for (String s : split) {
            System.out.print(s);
        }

        int a = 15;
        a += (++a);
        System.out.println(a);
        int b = 15;
        b += b++;
        System.out.println(b);

        int c[][] = {{1,2,3,4,5,6}};
    }
}
