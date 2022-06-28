package pro.fengjian;

import java.io.Serializable;

@MyAnnotation
public class Student extends Person implements Comparable<String>, Serializable {

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
