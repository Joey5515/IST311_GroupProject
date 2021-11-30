import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonGUI extends JFrame {

    private Database myDB = new Database();

    private JLabel firstName, lastName, titleLbl, orgLabel, addressLabel, emailLabel, cityLabel, speechDateLabel, inviteeLabel, giftTypeLabel, parkingPassLabel;

    String radioOptions[] = new String[5];

    private JButton submitBtn;

    private JTextField firstNameTxt, lastnameTxt, titleTxt, orgTxt, addressTxt, emailTxt, cityTxt, speechDateTxt, inviteeTxt;
    private JTextArea displaySpeaker;

    private ButtonGroup seasonOptionGroup = new ButtonGroup();
    private JRadioButton seasonOption[] = new JRadioButton[4];
    private String semesterOptionLabels[] = {"Spring", "Summer1", "Summer2", "Fall"};
    private JLabel semesterYear;
    private JTextField semesterYearTxt;


    private ButtonGroup giftTypeOptionGroup = new ButtonGroup();
    private JRadioButton giftType[] = new JRadioButton[4];
    private String giftTypeLabels[] = {"None", "Coffee Mug", "Compact Umbrella", "Portfolio Binder"};

    private ButtonGroup inPersonGroup = new ButtonGroup();
    private JRadioButton inPersonOption[] = new JRadioButton[2];
    private String inPersonLabels[] = {"In Person", "Zoom"};

    private ButtonGroup parkingPassGroup = new ButtonGroup();
    private JRadioButton parkingPassOption[] = new JRadioButton[2];
    private String parkingPassLabels[] = {"Yes", "No"};


    private JPanel enterPersonPanel, seasonRadioButtonPanel, giftRadioButtonPanel, inPersonRadioButtonPanel, displayPanel, buttonPanel, parkingPassRadioButtonPanel;

    private Speaker x;

    public PersonGUI() {
        super("Speaker Manager");
        x = new Speaker();
        setLayout(new GridLayout(4, 1, 1, 1));

        enterPersonPanel = createEnterPersonPanel();
        seasonRadioButtonPanel = seasonCreateRadioButtonPanel();
        giftRadioButtonPanel = giftCreateRadioButtonPanel();
        inPersonRadioButtonPanel = inPersonCreateRadioButtonPanel();
        buttonPanel = createButtonPanel();

        add(enterPersonPanel);
        add(seasonRadioButtonPanel);
        add(giftRadioButtonPanel);
        add(inPersonRadioButtonPanel);
        add(buttonPanel);

        setSize(1024, 768);
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
        speechDateLabel = new JLabel("Speech Date(DD/MM/YY)", SwingConstants.RIGHT);
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

        SeasonRadioButtonHandle handler = new SeasonRadioButtonHandle();

        semesterYear = new JLabel("Year: ", SwingConstants.RIGHT);
        semesterYearTxt = new JTextField(25);

        seasonRadioButtonPanel = new JPanel();
        seasonRadioButtonPanel.setBorder(BorderFactory.createTitledBorder("Semester: "));
        seasonRadioButtonPanel.setLayout(new BoxLayout(seasonRadioButtonPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < seasonOption.length; i++) {
            seasonOption[i] = new JRadioButton(semesterOptionLabels[i]);
            seasonRadioButtonPanel.add(seasonOption[i]);
            seasonOptionGroup.add(seasonOption[i]);

            seasonOption[i].addActionListener(handler);
        }

        seasonRadioButtonPanel.add(semesterYear);
        seasonRadioButtonPanel.add(semesterYearTxt);
        return seasonRadioButtonPanel;
    }

    public JPanel giftCreateRadioButtonPanel() {

        GiftRadioButtonHandle giftHandler = new GiftRadioButtonHandle();

        giftTypeLabel = new JLabel("Gift Type: ", SwingConstants.RIGHT);


        giftRadioButtonPanel = new JPanel();
        giftRadioButtonPanel.setBorder(BorderFactory.createTitledBorder("Previous Gift? "));
        giftRadioButtonPanel.setLayout(new BoxLayout(giftRadioButtonPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < giftType.length; i++) {
            giftType[i] = new JRadioButton(giftTypeLabels[i]);
            giftRadioButtonPanel.add(giftType[i]);
            giftTypeOptionGroup.add(giftType[i]);

            giftType[i].addActionListener(giftHandler);
        }
        return giftRadioButtonPanel;
    }

    public JPanel inPersonCreateRadioButtonPanel() {

        InPersonRadioButtonHandle inPersonHandler = new InPersonRadioButtonHandle();
        ParkingRadioButtonHandle parkingHandler = new ParkingRadioButtonHandle();

        inPersonRadioButtonPanel = new JPanel();
        inPersonRadioButtonPanel.setBorder(BorderFactory.createTitledBorder("In Person or Zoom? "));
        inPersonRadioButtonPanel.setLayout(new BoxLayout(inPersonRadioButtonPanel, BoxLayout.Y_AXIS));

        parkingPassLabel = new JLabel("Parking Pass Issued: ", SwingConstants.RIGHT);

        for (int i = 0; i < inPersonOption.length; i++) {
            inPersonOption[i] = new JRadioButton(inPersonLabels[i]);
            inPersonRadioButtonPanel.add(inPersonOption[i]);
            inPersonGroup.add(inPersonOption[i]);

            inPersonOption[i].addActionListener(inPersonHandler);
        }

        inPersonRadioButtonPanel.add(parkingPassLabel);

        for (int i = 0; i < parkingPassOption.length; i++) {
            parkingPassOption[i] = new JRadioButton(parkingPassLabels[i]);
            inPersonRadioButtonPanel.add(parkingPassOption[i]);
            parkingPassGroup.add(parkingPassOption[i]);

            parkingPassOption[i].addActionListener(parkingHandler);
        }

        return inPersonRadioButtonPanel;
    }

    class SeasonRadioButtonHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton jrb = (JRadioButton) e.getSource();
            radioOptions[0] = jrb.getText();
        }
    }

    class GiftRadioButtonHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton jrb = (JRadioButton) e.getSource();
            radioOptions[1] = jrb.getText();
        }
    }

    class ParkingRadioButtonHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton jrb = (JRadioButton) e.getSource();
            radioOptions[2] = jrb.getText();
        }
    }

    class InPersonRadioButtonHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton jrb = (JRadioButton) e.getSource();
            radioOptions[3] = jrb.getText();
        }
    }

    public JPanel createButtonPanel() {

        ButtonHandle handler = new ButtonHandle();

        buttonPanel = new JPanel();
        submitBtn = new JButton("Submit");
        submitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitBtn.addActionListener(handler);
        buttonPanel.add(submitBtn);

        return buttonPanel;
    }

    class ButtonHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            myDB = new Database();
            String fName, lName, title, addr, city, email, speechDate, invitee, organization;
            String semester, gift, parkingPass, inPerson;
            int result = 0;

            if (e.getSource() == submitBtn) {
                fName = firstNameTxt.getText();
                lName = lastnameTxt.getText();
                title = titleTxt.getText();
                addr = addressTxt.getText();
                city = cityTxt.getText();
                email = emailTxt.getText();
                speechDate = speechDateTxt.getText();
                invitee = inviteeTxt.getText();
                organization = orgTxt.getText();
                semester = radioOptions[0];
                gift = radioOptions[1];
                parkingPass = radioOptions[2];
                inPerson = radioOptions[3];

                result = myDB.addSpeaker(fName, lName, title, addr, city, email, speechDate, invitee, organization, semester, gift, parkingPass, inPerson);
            }
        }
    }


    public static void main(String[] args) {
        PersonGUI x = new PersonGUI();
    }

}