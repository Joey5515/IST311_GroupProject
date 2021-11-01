import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonGUI extends JFrame {


    private JLabel firstName, lastName, titleLbl, orgLabel, addressLabel, emailLabel, cityLabel, speechDateLabel, inviteeLabel;


    private JButton submittBtn;

    private JTextField firstNameTxt, lastnameTxt, titleTxt, orgTxt, addressTxt, emailTxt, cityTxt, speechDateTxt, inviteeTxt;
    private JTextArea displaySpeaker;

    private ButtonGroup seasonOptionGroup = new ButtonGroup();
    private JRadioButton seasonOption[] = new JRadioButton[4];
    private String seasonOptionLabels[] = {"Spring", "Summer1", "Summer2", "Fall"};

    private ButtonGroup giftOptionGroup = new ButtonGroup();
    private JRadioButton giftOption[] = new JRadioButton[2];
    private String giftOptionLabels[] = {"Yes", "No"};

    private ButtonGroup inPersonGroup = new ButtonGroup();
    private JRadioButton inPersonOption[] = new JRadioButton[2];
    private String inPersonLabels[] = {"In Person", "Zoom"};


    private JPanel enterPersonPanel, seasonRadioButtonPanel, giftRadioButtonPanel, inPersonRadioButtonPanel, displayPanel, buttonPanel;

    private Speaker x;

    public PersonGUI() {
        super("Speaker Manager");
        x = new Speaker();
        setLayout(new GridLayout(4, 1,1, 1));

        enterPersonPanel = createEnterPersonPanel();
        seasonRadioButtonPanel = seasonCreateRadioButtonPanel();
        giftRadioButtonPanel = giftCreateRadioButtonPanel();
        inPersonRadioButtonPanel = inPersonCreateRadioButtonPanel();
        displayPanel = createDisplayPanel();
        buttonPanel = createButtonPanel();

        add(enterPersonPanel);
        add(seasonRadioButtonPanel);
        add(giftRadioButtonPanel);
        add(inPersonRadioButtonPanel);
        add(displayPanel);
        add(buttonPanel);

        setSize(512,512);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JPanel createEnterPersonPanel() {
        firstName = new JLabel("First Name: ", SwingConstants.RIGHT);
        lastName = new JLabel("Last Name: ", SwingConstants.RIGHT);
        titleLbl = new JLabel("Title", SwingConstants.RIGHT);
        orgLabel = new JLabel("Organization: ", SwingConstants.RIGHT);
        addressLabel = new JLabel("Address: ", SwingConstants.RIGHT);
        emailLabel = new JLabel("Email Address: ", SwingConstants.RIGHT);
        cityLabel = new JLabel("City: ", SwingConstants.RIGHT);
        speechDateLabel = new JLabel("Speech Date", SwingConstants.RIGHT);
        inviteeLabel = new JLabel("Invitee: ", SwingConstants.RIGHT);

        firstNameTxt = new JTextField(25);
        lastnameTxt = new JTextField(25);
        titleTxt = new JTextField(25);
        orgTxt = new JTextField(25);
        addressTxt = new JTextField(25);
        emailTxt = new JTextField(25);
        cityTxt = new JTextField(25);
        speechDateTxt = new JTextField(25);
        inviteeTxt = new JTextField(25);

        enterPersonPanel = new JPanel();
        enterPersonPanel.setLayout(new GridLayout(5, 2, 1, 1));
        enterPersonPanel.setBorder(BorderFactory.createTitledBorder("Enter Speaker Data"));
        enterPersonPanel.setBackground(Color.LIGHT_GRAY);

        enterPersonPanel.add(firstName);
        enterPersonPanel.add(firstNameTxt);
        enterPersonPanel.add(lastName);
        enterPersonPanel.add(lastnameTxt);
        enterPersonPanel.add(titleLbl);
        enterPersonPanel.add(titleTxt);
        enterPersonPanel.add(orgLabel);
        enterPersonPanel.add(orgTxt);
        enterPersonPanel.add(addressLabel);
        enterPersonPanel.add(addressTxt);
        enterPersonPanel.add(emailLabel);
        enterPersonPanel.add(emailTxt);
        enterPersonPanel.add(cityLabel);
        enterPersonPanel.add(cityTxt);
        enterPersonPanel.add(speechDateLabel);
        enterPersonPanel.add(speechDateTxt);
        enterPersonPanel.add(inviteeLabel);
        enterPersonPanel.add(inviteeTxt);

        return enterPersonPanel;
    }

    public JPanel seasonCreateRadioButtonPanel() {

        RadioButtonHandle handler = new RadioButtonHandle();

        seasonRadioButtonPanel = new JPanel();
        seasonRadioButtonPanel.setBorder(BorderFactory.createTitledBorder("Semester: "));
        seasonRadioButtonPanel.setLayout(new BoxLayout(seasonRadioButtonPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < seasonOption.length; i++) {
            seasonOption[i] = new JRadioButton(seasonOptionLabels[i]);
            seasonRadioButtonPanel.add(seasonOption[i]);
            seasonOptionGroup.add(seasonOption[i]);

            seasonOption[i].addActionListener(handler);
        }
        return seasonRadioButtonPanel;
    }

    public JPanel giftCreateRadioButtonPanel() {

        RadioButtonHandle handler = new RadioButtonHandle();

        giftRadioButtonPanel = new JPanel();
        giftRadioButtonPanel.setBorder(BorderFactory.createTitledBorder("Previous Gift? "));
        giftRadioButtonPanel.setLayout(new BoxLayout(giftRadioButtonPanel, BoxLayout.Y_AXIS));

        for(int i = 0; i < giftOption.length; i++) {
            giftOption[i] = new JRadioButton(giftOptionLabels[i]);
            giftRadioButtonPanel.add(giftOption[i]);
            giftOptionGroup.add(giftOption[i]);

            giftOption[i].addActionListener(handler);
        }
        return giftRadioButtonPanel;
    }

    public JPanel inPersonCreateRadioButtonPanel() {

        RadioButtonHandle handler = new RadioButtonHandle();

        inPersonRadioButtonPanel = new JPanel();
        inPersonRadioButtonPanel.setBorder(BorderFactory.createTitledBorder("In Person or Zoom? "));
        inPersonRadioButtonPanel.setLayout(new BoxLayout(inPersonRadioButtonPanel, BoxLayout.Y_AXIS));

        for(int i = 0; i < inPersonOption.length; i++) {
            inPersonOption[i] = new JRadioButton(inPersonLabels[i]);
            inPersonRadioButtonPanel.add(inPersonOption[i]);
            inPersonGroup.add(inPersonOption[i]);

            inPersonOption[i].addActionListener(handler);
        }
        return inPersonRadioButtonPanel;
    }

    class RadioButtonHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public JPanel createDisplayPanel() {
        displayPanel = new JPanel();
        displayPanel.setBorder(BorderFactory.createTitledBorder("Display"));
        displayPanel.setBackground(Color.LIGHT_GRAY);
        displaySpeaker = new JTextArea(5, 25);
        displaySpeaker.setEditable(false);
        displayPanel.add(displaySpeaker);

        return displayPanel;
    }

    public JPanel createButtonPanel() {

        ButtonHandle handler = new ButtonHandle();

        buttonPanel = new JPanel();
        submittBtn = new JButton("Submit");
        submittBtn.addActionListener(handler);
        buttonPanel.add(submittBtn);

        return buttonPanel;
    }

    class ButtonHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            x.setFirstName(firstNameTxt.getText());
            x.setLastName(lastName.getText());
            //add the rest here
            }
        }


    public static void main(String[] args) {
        PersonGUI x = new PersonGUI();
    }

}