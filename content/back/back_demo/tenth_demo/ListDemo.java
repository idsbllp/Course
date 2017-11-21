import java.util.*;

public class ListDemo {

    public static void main(String[] args) {
        List<classes> list=new ArrayList();
        list.add(new classes("01011601"));
        list.add(new classes("01011603"));
        System.out.println(list.get(0).variety);
        System.out.println(list.get(1).variety);
    }
}

class classes {
    public String variety;

    public classes(String variety) {
        this.variety = variety;
    }
}
