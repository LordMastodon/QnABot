package electricdrill.qnabot.menufeatures;

import electricdrill.qnabot.main.QnABotJPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by natemintos on 3/27/15.
 */
public class QnABotJButton extends JButton {

    public QnABotJButton(ImageIcon image, String text, String actionCommand) {
        super(text, image);

        this.setActionCommand(actionCommand);
        this.setFont(QnABotJPanel.font);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setHorizontalTextPosition(SwingConstants.CENTER);

        Dimension d = new Dimension(this.getPreferredSize());
        this.setSize(d);
    }

    public QnABotJButton(String text, String actionCommand) {
        super(text);

        this.setFont(QnABotJPanel.font);
        this.setActionCommand(actionCommand);
        this.setHorizontalTextPosition(SwingConstants.CENTER);

        Dimension d = new Dimension(this.getPreferredSize());
        this.setSize(d);
    }

}
