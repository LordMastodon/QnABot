package electricdrill.qnabot.main;

import electricdrill.qnabot.logic.QnABotResponses;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class QnABotWindow {

    public static void main(String[] args) {
        new QnABotWindow();
    }

    public static int windowWidth = 800;
    public static int windowHeight = 600;

    public static void readFileByLine(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                QnABotResponses.responses.add(scanner.next().toString());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public QnABotWindow() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Q&A Bot");

                try {
                    UIManager.setLookAndFeel(new NimbusLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                frame.setJMenuBar(QnABotWindow.createMenuBar());

                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setResizable(false);

                frame.add(new QnABotJPanel());

                frame.pack();
                frame.setSize(windowWidth, windowHeight);
                frame.setVisible(true);
                frame.setResizable(false);
                QnABotResponses.initResponses();
            }
        });
    }

    public static JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu answersMenu;
        JMenuItem addNewAnswerItem;


        menuBar = new JMenuBar();

        answersMenu = new JMenu("Answers");
        menuBar.add(answersMenu);

        addNewAnswerItem = new JMenuItem("Add new possible answer");
    }

}
