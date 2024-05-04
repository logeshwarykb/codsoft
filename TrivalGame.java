import java.util.*;

public class TrivialGame {
    private static final int QUESTION_TIME_LIMIT_SECONDS = 10;
    private static int totalScore = 0;

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        List<Question> triviaQuestions = initializeQuestions();

        System.out.println("Welcome to the Trivia Game!");

        for (Question q : triviaQuestions) {
            displayQuestion(q);
            System.out.println("Time Left: " + QUESTION_TIME_LIMIT_SECONDS + " seconds");

            TimerTask task = new TimerTask() {
                public void run() {
                    System.out.println("Time's up!");
                    displayCorrectAnswer(q);
                    System.out.println();
                }
            };

            Timer timer = new Timer();
            timer.schedule(task, QUESTION_TIME_LIMIT_SECONDS * 1000L);

            System.out.print("Your answer: ");
            String userAnswer = inputScanner.nextLine();
            timer.cancel();

            if (userAnswer.equalsIgnoreCase(q.getCorrectAnswer())) {
                System.out.println("Correct!");
                totalScore++;
            } else {
                System.out.println("Incorrect!");
                displayCorrectAnswer(q);
            }

            System.out.println();
        }

        System.out.println("Trivia Complete!");
        System.out.println("Your Final Score: " + totalScore + "/" + triviaQuestions.size());
        System.out.println("Summary of Correct/Incorrect Answers:");
        displaySummary(triviaQuestions);

        inputScanner.close();
    }

    private static void displayQuestion(Question q) {
        System.out.println(q.getQuestion());
        List<String> options = q.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((char) ('A' + i) + ". " + options.get(i));
        }
    }

    private static void displayCorrectAnswer(Question q) {
        System.out.println("Correct Answer: " + q.getCorrectAnswer());
    }

    private static void displaySummary(List<Question> triviaQuestions) {
        for (int i = 0; i < triviaQuestions.size(); i++) {
            Question q = triviaQuestions.get(i);
            System.out.print("Question " + (i + 1) + ": ");
            if (q.isAnsweredCorrectly()) {
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect");
            }
        }
    }

    private static List<Question> initializeQuestions() {
        List<Question> triviaQuestions = new ArrayList<>();

        
        Question question1 = new Question("What is the capital of France?", Arrays.asList("London", "Paris", "Berlin", "Rome"), "Paris");
        Question question2 = new Question("What is the largest planet in our solar system?", Arrays.asList("Venus", "Saturn", "Jupiter", "Mars"), "Jupiter");
        Question question3 = new Question("Who wrote 'Romeo and Juliet'?", Arrays.asList("William Shakespeare", "Jane Austen", "Charles Dickens", "Mark Twain"), "William Shakespeare");

        triviaQuestions.add(question1);
        triviaQuestions.add(question2);
        triviaQuestions.add(question3);

        return triviaQuestions;
    }
}

class Question {
    private String question;
    private List<String> options;
    private String correctAnswer;
    private boolean answeredCorrectly;

    public Question(String question, List<String> options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isAnsweredCorrectly() {
        return answeredCorrectly;
    }

    public void setAnsweredCorrectly(boolean answeredCorrectly) {
        this.answeredCorrectly = answeredCorrectly;
    }
}
