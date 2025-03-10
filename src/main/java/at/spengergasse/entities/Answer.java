package at.spengergasse.entities;

import javax.persistence.*;

@Entity
@Table(name="a_answers")
public class Answer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="a_id")
    private int id;

    @Column(name="a_text")
    private String text;

    @Column(name = "a_correct")
    private boolean correct;

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", correct=" + correct +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
