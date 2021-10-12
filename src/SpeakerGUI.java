//This class currently does not work

/**
 * Header
 */

import java.awt.*;
import javax.swing.*;

public class SpeakerGUI extends JFrame{

    private JLabel fnLabel, lnLabel, titleLabel, orgLabel;

    private JTextField fnTxt, lnTxt, titleTxt, orgTxt;

    private JButton saveBtn;

    private JPanel enterPersonPanel, buttonPanel;

    private Speaker x;

    public SpeakerGUI() {
        x = new Speaker();

        enterPersonPanel = createEnterPerson();
        //buttonPanel = createButtonPanel();

        add(enterPersonPanel);
        //add(buttonPanel);

        setSize(512,512);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public JPanel createEnterPerson() {
        fnLabel = new JLabel("First Name: ", SwingConstants.RIGHT);
        lnLabel = new JLabel("Last Name: ", SwingConstants.RIGHT);
        titleLabel = new JLabel("Title: ", SwingConstants.RIGHT);
        orgLabel = new JLabel("Organization: ", SwingConstants.RIGHT);

        fnTxt = new JTextField(25);
        lnTxt = new JTextField(25);
        titleTxt = new JTextField(25);
        orgTxt= new JTextField(25);

        enterPersonPanel.add(fnLabel);
        enterPersonPanel.add(lnLabel);
        enterPersonPanel.add(fnTxt);
        enterPersonPanel.add(lnTxt);
        enterPersonPanel.add(titleLabel);
        enterPersonPanel.add(titleTxt);
        enterPersonPanel.add(orgLabel);
        enterPersonPanel.add(orgTxt);

        return enterPersonPanel;
    }

    public static void main(String[] args) {
        SpeakerGUI x = new SpeakerGUI();
    }
}
