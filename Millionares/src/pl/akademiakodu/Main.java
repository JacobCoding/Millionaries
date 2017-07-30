package pl.akademiakodu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Main extends JFrame implements ActionListener {

    private List<Question> questionList;
    private JLabel label;
    private int currentNumberOfQuestion;
    private int numberOfPoints;
    private JButton buttonYes;
    private JButton buttonNO;
    private static final String YES = "TAK";
    private static final String NO = "NIE";


    public Main() {
        currentNumberOfQuestion = 0;
        numberOfPoints = 0;
        setFrameDefualtProperties();
        questionList = Question.getExampleQuestions();
        addButtonsAndLabelToLayout();
    }

    private void setFrameDefualtProperties() {
        setTitle("Millionaires");
        setVisible(true);
        setSize(500, 500);
        setLayout(new GridLayout(3, 1));
    }

    private void addButtonsAndLabelToLayout() {
        label = new JLabel(questionList.get(currentNumberOfQuestion).getContent());
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);
        buttonYes = new JButton(YES);
        buttonYes.addActionListener(this);
        buttonNO = new JButton(NO);
        buttonNO.addActionListener(this);
        add(buttonYes);
        add(buttonNO);
    }


    public static void main(String[] args) {
        // write your code here

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        Question currentQuestion = questionList.get(currentNumberOfQuestion);
        if (jButton.getText().equals(YES) && currentQuestion.isYesCorrect())
            numberOfPoints++;
        if (jButton.getText().equals(NO) && !currentQuestion.isYesCorrect())
            numberOfPoints++;

        // kliknięto nie

        //currentNumberOfQuestion++
        if (currentNumberOfQuestion < questionList.size() - 1)

        {
            currentNumberOfQuestion = currentNumberOfQuestion + 1;
            label.setText(questionList.get(currentNumberOfQuestion).getContent());
        } else

        {
            buttonYes.setEnabled(false);
            buttonNO.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Liczba punktów to" + numberOfPoints);
        }
    }
}
