package at.spengergasse.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="q_questions")

public class Question
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //vergibt automatisch eine ID
    @Column(name = "q_id")
    private int id;

    @Column(name = "q_text")
    private String text;

    @OneToMany //Beziehung: 1 zu n
    @JoinColumn(name = "fk_q_id") // foreign key
    private List<Answer> answers = new ArrayList<>();

    public List<Answer> getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", answers=" + answers +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
