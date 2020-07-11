package pageObjects;

import org.apache.logging.log4j.core.util.JsonUtils;

public class tester {
    public static void main(String[] args) {
        /*String a = "59,99 zł";
        String b = "90,00 zł";

        String[] partsA = a.split(" ");
        String part1a = partsA[0];
        part1a = part1a.replaceAll(",", ".");
        double oneItem = Double.parseDouble(part1a);

        String[] partsB = b.split(" ");
        String part1b = partsB[0];
        part1b = part1b.replaceAll(",", ".");
        double twoItem = Double.parseDouble(part1b);

        if (!(2*oneItem == twoItem)) System.out.println(true);

         */
        /*
        String abc = "Sztuk 29";
        String[] parts = abc.split(" ");
        String part2 = parts[1];
        int abcInt = Integer.parseInt(part2);
        System.out.println(abcInt);

         */
    }
    public boolean wordSearch(String sentence, String word) {
        if ( sentence.toLowerCase().indexOf(word.toLowerCase()) != -1 ) { return true; }
        else { return false; }
    }
}
