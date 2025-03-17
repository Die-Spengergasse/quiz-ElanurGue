package at.spengergasse;

import at.spengergasse.entities.Answer;
import at.spengergasse.entities.Question;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz
{
    private List<Question> questions = new ArrayList<>();
    Scanner s = new Scanner(System.in);
    int nextQuestion = 0;
    int correctanswers = 0;

    public Quiz()
    {
        EntityManager em = Persistence.createEntityManagerFactory("demo")
                .createEntityManager();

        TypedQuery<Question> query =
                em.createQuery("SELECT q FROM Question q", Question.class);

        questions = query.getResultList();

        em.close();
    }

    public boolean showQuestionsAndAnswers()
    {
        Question q = questions.get(nextQuestion);

        for (int i = 0; i < questions.size(); i++)
        {
            System.out.println((i+1) + ". question: " + q.getText());
            nextQuestion++;
            System.out.println("Answers: ");
            System.out.println(q.getAnswers());
            int userAnswer = Integer.parseInt(s.nextLine());
            checkCorrect(q, userAnswer);
        }

        if (nextQuestion >= questions.size())
        {
            finish();
            return false;
        }

        return true;
    }

    private void checkCorrect(Question q, int userAnswer)
    {
        if (q.getAnswers().get(userAnswer).isCorrect())
        {
            System.out.println("Correct Answer!");
            correctanswers++;
        }

        else
        {
            System.out.println("Wrong Answer! The correct answer was: " + q.getAnswers().get(userAnswer));
        }
    }

    private void finish()
    {
        System.out.println("Quiz finished!");
        for (int i = 0; i < questions.size(); i++)
        {
            System.out.println("Percentage of correct answers: " + (correctanswers / questions.size()) * 100 + "%");
        }
    }
}
