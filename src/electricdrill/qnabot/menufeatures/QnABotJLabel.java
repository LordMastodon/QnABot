package electricdrill.qnabot.menufeatures;

import electricdrill.qnabot.main.QnABotJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;

/**
 * Created by natemintos on 3/27/15.
 */
public class QnABotJLabel extends JLabel {

    public QnABotJLabel(ImageIcon icon, String text) {
        this.setText(text);
        this.setFont(QnABotJPanel.font);
        this.setIcon(icon);

        Dimension d = new Dimension(this.getPreferredSize());
        this.setSize(d);
    }

    public QnABotJLabel(String text) {
        this.setText(text);
        this.setFont(QnABotJPanel.font);
    }

    public void setTextOnLabel(String text) {
        this.setText(text);
    }
}
