package at.spengergasse;

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
    Question q;

    public Quiz()
    {
        EntityManager em = Persistence.createEntityManagerFactory("demo")
                .createEntityManager();

        TypedQuery<Question> query =
                em.createQuery("SELECT q FROM Question q", Question.class);
    }

    public boolean showWuestionsAndAnswers()
    {
        if (nextQuestion >= questions.size())
        {
            finish();
            return false;
        }

        for (int i = 0; i < questions.size(); i++)
        {
            q = questions.get(i);
            System.out.println((i+1) + ". question: " + q.getText());

            System.out.println((i+1) + ") " + q.getAnswers());
            int userAnswer = s.nextInt();
            checkCorrect();
        }

        return true;
    }

    private void checkCorrect()
    {
        //check if answer is correct
    }

    private void finish()
    {
        //calculate percentage, show result
    }
}
