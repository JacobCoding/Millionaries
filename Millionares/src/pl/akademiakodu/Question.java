package pl.akademiakodu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Question {
    private String content;
    private boolean isYesCorrect;

    public Question(String content, boolean isYesCorrect) {
        this.content = content;
        this.isYesCorrect = isYesCorrect;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isYesCorrect() {
        return isYesCorrect;
    }

    public void setYesCorrect(boolean yesCorrect) {
        isYesCorrect = yesCorrect;
    }

    public static List<Question> getExampleQuestions(){
        String fileName = "hello.txt";
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            //1. filter line 3
            //2. convert all content to upper case
            //3. convert it into a List
            list = stream
                    .filter(line -> !line.startsWith("line3"))
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(list);


        for ( String line:list){
            String correctness = line.substring(line.length()-3,line.length());
            System.out.println(correctness);
            String question = line.substring(0,line.length()-4);
            System.out.println(question);
        }


        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Czy Kanada leży w Europie?",false));
        questions.add(new Question("Czy Java to język programowania?",true));
        questions.add(new Question("Czy String to Klasa?",true));
        questions.add(new Question("Czy int to Klasa?",false));
        questions.add(new Question("Czy Mokotów to dzielnica?",true));
        return questions;
    }
}
