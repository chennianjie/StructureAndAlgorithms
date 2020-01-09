package practice;

import java.util.*;

public class MyUtil {

    public HashMap<Integer, User> sortHash(HashMap<Integer, User> sortHashMap){
        LinkedHashMap<Integer, User> map = new LinkedHashMap<>();
        Set<Map.Entry<Integer, User>> entries = sortHashMap.entrySet();
        
        //把set转换list集合进行排序
        ArrayList<Map.Entry<Integer, User>> list = new ArrayList<>(entries);

        //调用Collections集合工具类进行按照年龄倒叙排序
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().getAge() - o1.getValue().getAge();
            }
        });

        //将排序好的集合遍历放进LinkedHashMap有序map集合里面
        for (Map.Entry<Integer, User> entry : list) {
            map.put(entry.getKey(), entry.getValue());
        }

        return map;
    }

    class User {

        private String name;
        private Integer age;

        public User() {
        }

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
