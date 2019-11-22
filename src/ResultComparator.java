import java.util.Comparator;

public class ResultComparator implements Comparator<Sportsman> {

    @Override
    public int compare(Sportsman s1, Sportsman s2) {
       if (s1.getResult()>s2.getResult()){
           return 1;
       } else if (s2.getResult()>s1.getResult()){
           return -1;
       }
       return s1.getLastName().compareTo(s2.getLastName());
    }
}
