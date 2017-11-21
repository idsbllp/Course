import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        Random random=new Random(System.currentTimeMillis());
        HashSet hashSet=new HashSet();
//        for (int i = 0; i <500 ; i++) {
//            hashSet.add(random.nextInt(10));
//        }
//        System.out.println(hashSet);
        /*for(Iterator iterator=hashSet.iterator();iterator.hasNext();)
            System.out.println(iterator.next());*/
        //lambda表达式输出
        hashSet.forEach((key)->{
            System.out.println(key);
        });


        //三种不同的Set实现,输出的不同
        LinkedHashSet linkedHashSet=new LinkedHashSet<>();
        TreeSet treeSet=new TreeSet();
        for (Integer i=1000;i>0;i--) {
//            int temp=random.nextInt(30);
            hashSet.add(i);
            linkedHashSet.add(i);
            treeSet.add(i);
        }
        System.out.println(hashSet);
        System.out.println(linkedHashSet);
        System.out.println(treeSet);
    }
}
