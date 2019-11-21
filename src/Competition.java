import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Competition {
    public static void main(String[] args) {
        ResultComparator comparator = new ResultComparator();
        TreeSet<Sportsman> sportsmen = new TreeSet<>(comparator);
        sortAndRecord(sportsmen);
    }

    private static void sortAndRecord(TreeSet<Sportsman> sportsmen) {
        try (BufferedWriter bfw = new BufferedWriter(new FileWriter(new File("competition.csv")))) {
            System.out.println("Podaj wynik kolejnego gracza (lub stop)");
            checkInput(sportsmen, bfw);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void checkInput(TreeSet<Sportsman> sportsmen, BufferedWriter bfw) throws IOException {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        while (!line.equals("")) {
            if (line.equals("stop")) {
                input.close();
                for (Sportsman s : sportsmen) {
                    bfw.write(s.toString());
                }
                break;
            } else {
                sportsmen.add(new Sportsman(line, input.nextLine(), input.nextDouble()));
                input.nextLine();
                System.out.println("Podaj wynik kolejnego gracza (lub stop)");
                line = input.nextLine();
            }
        }
    }
}

