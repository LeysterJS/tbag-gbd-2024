package tbag.gbd.gameGUI;

import tbag.gbd.gameGUI.AdventureGameGUI;
import tbag.gbd.gbd_code.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStream;
import java.io.PrintStream;

public class GameGUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel messageLabel;
    private JTextField inputField;
    private JButton submitButton;
    private AdventureGameGUI game;
    private Game gameLogic;
    private JTextArea consoleOutput;

    public GameGUI(String projectName, String playerName) {
        createAndShowGUI(projectName, playerName);
    }

    private void createAndShowGUI(String projectName, String playerName) {
        frame = new JFrame("Game GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        panel = new JPanel();
        frame.add(panel);

        JLabel projectLabel = new JLabel("Project Name: " + projectName);
        panel.add(projectLabel);

        JLabel playerLabel = new JLabel("Player Name: " + playerName);
        panel.add(playerLabel);

        messageLabel = new JLabel();
        panel.add(messageLabel);

        inputField = new JTextField(20);
        panel.add(inputField);

        submitButton = new JButton("Submit");
        panel.add(submitButton);

        consoleOutput = new JTextArea(10, 30);
        consoleOutput.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(consoleOutput);
        panel.add(scrollPane);

        frame.setVisible(true);

        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                consoleOutput.append(String.valueOf((char) b));
            }
        }));

        game = new AdventureGameGUI(messageLabel, inputField);

        gameLogic = new Game(game);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gameLogic.start(playerName);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameGUI gui = new GameGUI("TBAG", "LeysterJS");
        });
    }
}