package tbag.gbd.gameGUI;

import tbag.gbd.AdventureGame;

import javax.swing.*;

public class AdventureGameGUI extends AdventureGame {
    private JLabel messageLabel;
    private JTextField inputField;

    public AdventureGameGUI(JLabel messageLabel, JTextField inputField) {
        super();
        this.messageLabel = messageLabel;
        this.inputField = inputField;
    }

    @Override
    public void show(String message) {
        messageLabel.setText(message);
    }

    @Override
    public String ask(String question) {
        inputField.setText("");
        inputField.requestFocus();
        while (inputField.getText().trim().isEmpty()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return inputField.getText();
    }
}