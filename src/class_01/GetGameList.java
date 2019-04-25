package class_01;

import java.util.HashSet;

public class GetGameList {

    public char[] team1 = new char[]{'c','b','a'};
    public char[] team2 = new char[]{'x','y','z'};
    public HashSet<Character> set = new HashSet<>();

    public void getGameList(){
        for (int i=0; i<team1.length; i++){
            for (int j=0; j<team2.length; j++){
                if ('c' == team1[i]){
                    System.out.println(team1[i] + "vs" + 'z');
                }
            }
        }
    }
}
