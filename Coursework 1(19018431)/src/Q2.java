
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Q2 {

    public static void main(String[] args) {
        StringArray words = new StringArray();
        words = readingWordFile();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Reading from the text file.\n2. Reading from the keyboard. \nPress the number : ");
            int select = sc.nextInt();
            if (select == 1) {
                StringArray inputFile = readingInputFile();
                checkSpellingFromFile(words, inputFile);
                break;
            } else if (select == 2){
                checkSpellingFromKeyboard(words);
            }
        }
    }

    public static StringArray readingWordFile(){
        StringArray file = new StringArray();
        FileInput input = new FileInput("words");
        while (input.hasNextLine()) {
            String s = input.nextLine();
            file.add(s);
        }
        return file;
    }

    public static StringArray readingInputFile(){
        StringArray file = new StringArray();
        FileInput input = new FileInput("readingfile");
        while (input.hasNextLine()) {
            String s = input.nextLine();
            file.add(s);
        }
        return file;
    }


    public static void checkSpellingFromFile(StringArray words, StringArray input){
        for (int i = 0; i < input.size(); i++) {
            if (words.contains((input.get(i)))) {
                continue;
            } else {
                System.out.println("Incorrect word : " + input.get(i));
            }
        }
    }

    public static void checkSpellingFromKeyboard(StringArray words){
        while (true){
            StringArray inputArray = new StringArray();
            Scanner sc = new Scanner(System.in);
            System.out.println("Input sentence (Press \"@\" to quit) : ");
            String inputString = sc.nextLine();
            if (inputString.equalsIgnoreCase("@")){
                break;
            }
            Pattern pattern = Pattern.compile("\\w+");
            Matcher matcher = pattern.matcher(inputString);
            while (matcher.find()) {
                inputArray.add(matcher.group());
            }
            for (int i = 0; i < inputArray.size(); i++) {
                if (words.contains((inputArray.get(i)))) {
                    continue;
                } else {
                    System.out.println("Incorrect word : " + inputArray.get(i));
                }
            }
        }
    }
}
