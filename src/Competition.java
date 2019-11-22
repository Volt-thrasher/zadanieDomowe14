import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Competition {
    public static void main(String[] args) {
        try {
            checkInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkInput() throws IOException {
        System.out.println("Podaj wynik kolejnego gracza (lub stop)");
        try (BufferedWriter bfw = new BufferedWriter(new FileWriter(new File("competition.csv")))) {
            Scanner input = new Scanner(System.in);
            ResultComparator comparator = new ResultComparator();
            inputAndRecord(bfw, input,comparator);
        }
    }

    private static void inputAndRecord(BufferedWriter bfw, Scanner input, ResultComparator comparator) throws IOException {
        String line = input.nextLine();
        Set<Sportsman> sportsmen = new TreeSet<>(comparator);
        while (!line.equals("")) {
            if (line.equals("stop")) {
                input.close();
                for (Sportsman s : sportsmen) {
                    bfw.write(s.toString());
                    bfw.newLine();
                }
                break;
            } else {
                String[] results = line.split(" ");
                sportsmen.add(new Sportsman(results[0],results[1],Integer.parseInt(results[2])));
                System.out.println("Podaj wynik kolejnego gracza (lub stop)");
                line = input.nextLine();
            }
        }
    }
}

