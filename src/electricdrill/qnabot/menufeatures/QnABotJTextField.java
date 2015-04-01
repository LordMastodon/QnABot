package electricdrill.qnabot.menufeatures;

import electricdrill.qnabot.main.QnABotJPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by natemintos on 3/31/15.
 */
public class QnABotJTextField extends JTextField {

    public QnABotJTextField(String text) {
        this.setText(text);
        this.setFont(QnABotJPanel.font);
    }

    public String returnText() {
        return this.getText();
    }

}
