package Collections.Sets;

import java.util.TreeSet;

public class TreeSets {

    public static void main(String[] args) {
        TreeSet<Student> set = new TreeSet<>();


        set.add(new Student("Mehmet Aslan",21));
        set.add(new Student("Aslı Aslan",24));
        set.add(new Student("Kerem Aslan",22));
        set.add(new Student("Burak Aslan",23));
        set.add(new Student("Ali Aslan",20));


        System.out.println(set);
    }

}
