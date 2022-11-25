import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int TestQuantity = 15000;

        test(TestQuantity, "average");

        test(TestQuantity, "best");

        test(TestQuantity, "worst");

    }

    private static void test(int numberOfTest, String TestType) {
        long elapsedTime = 0;
        String text = TextReader.getTextFromFile("src/main/resources/" + TestType + ".txt");
        String word = TextReader.getTextFromFile("src/main/resources/Word.txt");
        for (int i = 0; i < numberOfTest; i++) {
            elapsedTime += makeTest(elapsedTime, word, text);
        }

        FileWriter.writeToFile(new StringBuilder().append(elapsedTime / numberOfTest),
                "src/main/resources/results/" + TestType + "Result.txt");
    }

    private static long makeTest(long sum, String word, String text) {
        long start;
        long end;
        start = System.nanoTime();
        MorrisPratt.findWordInText(text, word);
        end = System.nanoTime();
        sum += (end - start);
        return sum / 1_000;
    }

}
