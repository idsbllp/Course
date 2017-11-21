import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class MapDemo {
    static class dog {
        public String variety;

        public dog(String string) {
            this.variety = string;
        }
    }
    class collage{
        public String name;
        public HashMap classes;
    }

    public static void main(String[] args) {
        Map grade = new HashMap();

        grade.put("xiaoming",100);
        grade.put("xiaogang",99);
        grade.put("xiaohong",98);
        grade.put("xiaoming",60);
//        System.out.println(grade);

        Map manygrades=new HashMap();
        manygrades.put("math",grade);
        manygrades.put("english",grade);
        //System.out.println(manygrades);
        for (Iterator<Map.Entry> iterator=grade.entrySet().iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }

        //测试Map的特性
        grade.put("小明", "100");
        grade.put("小刚", "92");
        grade.put("小红", "100");
        grade.put("小明", "98");
        grade.put("a",new dog("s"));
        System.out.println(grade);
        Map manygrade = new HashMap();
        manygrade.put("数学", grade);
        manygrade.put("语文", grade);
        System.out.println(manygrade);

        //lambda表达式遍历容器
        manygrade.forEach((key, value) -> {
            System.out.println("姓名:" + key + ",分数:" + value);
        });

        //entrySet方法拿到键值对然后使用迭代器遍历
        for (Iterator<Map.Entry> iterator = grade.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry temp=iterator.next();
            System.out.println(temp.getKey() + ":" + temp.getValue());
        }
    }
}
