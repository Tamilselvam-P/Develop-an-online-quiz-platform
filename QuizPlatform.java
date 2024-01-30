import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    String text;
    int type; // 1: Multiple Choice, 2: True/False
    List<String> options;
    String correctAnswer;

    public Question(String text, int type, List<String> options, String correctAnswer) {
        this.text = text;
        this.type = type;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

class Quiz {
    List<Question> questions;

    public Quiz() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void conductQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (Question question : questions) {
            System.out.println(question.text);

            if (question.type == 1) { // Multiple Choice
                for (int i = 0; i < question.options.size(); i++) {
                    System.out.println((i + 1) + ". " + question.options.get(i));
                }

                int userAnswer = scanner.nextInt();
                if (question.options.get(userAnswer - 1).equals(question.correctAnswer)) {
                    score++;
                }
            } else if (question.type == 2) { // True/False
                System.out.println("1. True");
                System.out.println("2. False");

                int userAnswer = scanner.nextInt();
                if ((userAnswer == 1 && question.correctAnswer.equalsIgnoreCase("True"))
                        || (userAnswer == 2 && question.correctAnswer.equalsIgnoreCase("False"))) {
                    score++;
                }
            }

            System.out.println();
        }

        System.out.println("Quiz completed! Your score: " + score + "/" + questions.size());
    }
}

public class QuizPlatform {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Sample questions
        Question question1 = new Question("What is the capital of France?", 1,
                List.of("Berlin", "Paris", "London", "Madrid"), "Paris");

        Question question2 = new Question("Is the Earth round?", 2, List.of(), "True");

        Question question3 = new Question("Which programming language is known for its 'write once, run anywhere' philosophy?", 1,
                List.of("Java", "C++", "Python", "JavaScript"), "Java");

        Question question4 = new Question("What is the largest planet in our solar system?", 1,
                List.of("Mars", "Jupiter", "Venus", "Saturn"), "Jupiter");

        Question question5 = new Question("Who is the author of 'To Kill a Mockingbird'?", 1,
                List.of("J.K. Rowling", "Harper Lee", "George Orwell", "Jane Austen"), "Harper Lee");

        Question question6 = new Question("The Great Wall of China is the longest wall in the world. True or False?", 2, List.of(), "True");

        // Add questions to the quiz
        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
        quiz.addQuestion(question3);
        quiz.addQuestion(question4);
        quiz.addQuestion(question5);
        quiz.addQuestion(question6);

        // Conduct the quiz
        quiz.conductQuiz();
    }
}