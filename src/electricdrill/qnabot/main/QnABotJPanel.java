package electricdrill.qnabot.main;

import electricdrill.qnabot.logic.QnABotResponses;
import electricdrill.qnabot.menufeatures.QnABotJButton;
import electricdrill.qnabot.menufeatures.QnABotJLabel;
import electricdrill.qnabot.menufeatures.QnABotJTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by natemintos on 3/27/15.
 */
public class QnABotJPanel extends JPanel {

    public Random random = new Random();

    static QnABotJButton submitButton;
    static QnABotJLabel askMeAQuestionLabel;
    static QnABotJTextField questionInputTextField;
    public static QnABotJLabel answerField;
    static QnABotJButton askNewQuestionButton;
    static QnABotJLabel titleLabel;
    static QnABotJLabel subtitleLabel;

    public static Font font = new Font("Avenir Next", Font.PLAIN, 20);

    String askMeAQuestion = "Ask me a question!";

    public int responseToUse;
    public String response;

    public String usersInput;

    public QnABotJPanel() {
        setLayout(new GroupLayout(this));

        submitButton = new QnABotJButton("Submit", "/submit");
        submitButton.setLocation(QnABotWindow.windowWidth / 4 - (int) submitButton.getPreferredSize().getWidth() / 2,  (QnABotWindow.windowHeight / 4) * 3 - (int) submitButton.getPreferredSize().getHeight() / 2);

        askMeAQuestionLabel = new QnABotJLabel(askMeAQuestion);
        Dimension askMeAQuestionLabelD = new Dimension(askMeAQuestionLabel.getPreferredSize());
        askMeAQuestionLabel.setLocation(QnABotWindow.windowWidth / 4 - (int) askMeAQuestionLabelD.getWidth() / 2, QnABotWindow.windowHeight / 3 - (int) askMeAQuestionLabelD.getHeight() / 2);
        askMeAQuestionLabel.setSize(askMeAQuestionLabelD);

        questionInputTextField = new QnABotJTextField("Question Input");

        Dimension questionInputTextFieldD = new Dimension(questionInputTextField.getPreferredSize());
        questionInputTextField.setSize((int) questionInputTextFieldD.getWidth() + 300, (int) questionInputTextFieldD.getHeight());
        questionInputTextField.setLocation((QnABotWindow.windowWidth / 4) * 3 - ((int) questionInputTextFieldD.getWidth() / 2 + 225), QnABotWindow.windowHeight / 3 - (int) questionInputTextFieldD.getHeight() / 2);

        responseToUse = random.nextInt(QnABotResponses.responses.size());
        response = QnABotResponses.responses.get(responseToUse);

        answerField = new QnABotJLabel(response);
        answerField.setVisible(false);
        Dimension answerFieldD = new Dimension(answerField.getPreferredSize());
        answerField.setLocation(QnABotWindow.windowWidth / 2 - (int) answerFieldD.getWidth() / 2, (QnABotWindow.windowHeight / 4) * 2 - (int) answerFieldD.getHeight() / 2);
        answerField.setSize(answerFieldD);

        askNewQuestionButton = new QnABotJButton("Ask a new question!", "/askNewQuestion");
        askNewQuestionButton.setLocation((QnABotWindow.windowWidth / 4) * 3 - (int) askNewQuestionButton.getPreferredSize().getWidth() / 2, (QnABotWindow.windowHeight / 4) * 3 - (int) askNewQuestionButton.getPreferredSize().getHeight() / 2);

        titleLabel = new QnABotJLabel("The Amazing Kreskin!");
        titleLabel.setFont(font.deriveFont(Font.PLAIN, 30));

        Dimension titleLabelD = new Dimension(titleLabel.getPreferredSize());
        titleLabel.setSize(titleLabelD);
        titleLabel.setLocation(QnABotWindow.windowWidth / 2 - (int) titleLabelD.getWidth() / 2, QnABotWindow.windowHeight / 6 - (int) titleLabelD.getHeight() / 2);

        subtitleLabel = new QnABotJLabel("Ask any question...");
        subtitleLabel.setFont(font.deriveFont(Font.PLAIN, 15));

        Dimension subtitleLabelD = new Dimension(subtitleLabel.getPreferredSize());
        subtitleLabel.setSize(subtitleLabelD);
        subtitleLabel.setLocation(QnABotWindow.windowWidth / 2 - (int) subtitleLabelD.getWidth() / 2, (QnABotWindow.windowHeight / 6 - (int) subtitleLabelD.getHeight() / 2) + (int) titleLabelD.getHeight() - 10);

        this.add(submitButton);
        this.add(askMeAQuestionLabel);
        this.add(questionInputTextField);
        this.add(answerField);
        this.add(askNewQuestionButton);
        this.add(titleLabel);
        this.add(subtitleLabel);

        this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals(submitButton.getActionCommand())) {
                    usersInput = questionInputTextField.returnText();

                    if (usersInput.endsWith("?")) {
                        answerField.setVisible(true);
                    } else {
                        answerField.setTextOnLabel("Please either specify a question or add a \"?\" to the end of your question.");

                        Dimension answerFieldD = new Dimension(answerField.getPreferredSize());
                        answerField.setSize((int) answerFieldD.getWidth(), (int) answerFieldD.getHeight());
                        answerField.setLocation(QnABotWindow.windowWidth / 2 - (int) answerFieldD.getWidth() / 2, (QnABotWindow.windowHeight / 4) * 2 - (int) answerFieldD.getHeight() / 2);

                        answerField.setVisible(true);
                    }
                } else if (e.getActionCommand().equals(askNewQuestionButton.getActionCommand())) {
                    answerField.setVisible(false);

                    responseToUse = random.nextInt(QnABotResponses.responses.size());
                    response = QnABotResponses.responses.get(responseToUse);

                    answerField.setTextOnLabel(response);

                    Dimension answerFieldD = new Dimension(answerField.getPreferredSize());
                    answerField.setSize(answerFieldD);

                    answerField.setLocation(QnABotWindow.windowWidth / 2 - (int) answerFieldD.getWidth() / 2, (QnABotWindow.windowHeight / 4) * 2 - (int) answerFieldD.getHeight() / 2);
                }
            }

        });
    }

    public void addActionListener(ActionListener listener) {
        submitButton.addActionListener(listener);
        askNewQuestionButton.addActionListener(listener);
    }

}
