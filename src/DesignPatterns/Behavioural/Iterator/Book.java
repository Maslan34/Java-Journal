package DesignPatterns.Behavioural.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Book {
    private String bookName;
    private List<Question> questionList;

    public Book(String bookName) {
        this.bookName = bookName;
        this.questionList = new ArrayList<Question>();

        questionList.add(new Question(1));
        questionList.add(new Question(2));
        questionList.add(new Question(3));
        questionList.add(new Question(4));
        questionList.add(new Question(5));
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /* Before Iterarator
    public List<Question> getQuestionList() {
        return questionList;
    }

     */

    public Iterator<Question> getQuestionList() {
        return questionList.iterator();
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
