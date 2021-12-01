import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonGUI extends JFrame {

    private Database myDB = new Database();

    //Creates labels
    private JLabel firstName, lastName, titleLbl, orgLabel, addressLabel, emailLabel, cityLabel, speechDateLabel, inviteeLabel, inPersonLabel, parkingPassLabel;

    //Array that holds the string values for semester, gift, in person, and parking pass
    String radioOptions[] = new String[5];

    //submit button
    private JButton submitBtn;

    //text fields for speaker
    private JTextField firstNameTxt, lastnameTxt, titleTxt, orgTxt, addressTxt, emailTxt, cityTxt, speechDateTxt, inviteeTxt;

    //radio buttons for semester
    private ButtonGroup semOptionGroup = new ButtonGroup();
    private JRadioButton semOption[] = new JRadioButton[4];
    private String semesterOptionLabels[] = {"Spring", "Summer1", "Summer2", "Fall"};

    //radio buttons for gift
    private ButtonGroup giftTypeOptionGroup = new ButtonGroup();
    private JRadioButton giftType[] = new JRadioButton[4];
    private String giftTypeLabels[] = {"None", "Coffee Mug", "Compact Umbrella", "Portfolio Binder"};

    //radio buttons for in person
    private ButtonGroup inPersonGroup = new ButtonGroup();
    private JRadioButton inPersonOption[] = new JRadioButton[2];
    private String inPersonLabels[] = {"In Person", "Zoom"};

    //radio buttons for parking pass
    private ButtonGroup parkingPassGroup = new ButtonGroup();
    private JRadioButton parkingPassOption[] = new JRadioButton[2];
    private String parkingPassLabels[] = {"Yes", "No"};


    private JPanel enterPersonPanel, seasonRadioButtonPanel, giftRadioButtonPanel, inPersonRadioButtonPanel, buttonPanel;

    private Speaker x;

    //for person input
    public PersonGUI() {
        super("Speaker Manager");
        x = new Speaker();
        setLayout(new GridLayout(5, 1, 1, 1));

        enterPersonPanel = createEnterPersonPanel();
        seasonRadioButtonPanel = semCreateRadioButtonPanel();
        giftRadioButtonPanel = giftCreateRadioButtonPanel();
        inPersonRadioButtonPanel = inPersonCreateRadioButtonPanel();
        buttonPanel = createButtonPanel();

        add(enterPersonPanel);
        add(seasonRadioButtonPanel);
        add(giftRadioButtonPanel);
        add(inPersonRadioButtonPanel);
        add(buttonPanel);

        setSize(1300, 900);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //for entering the speaker
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

        enterPersonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        enterPersonPanel.setLayout(new GridLayout(5, 2, 1, 1));
        enterPersonPanel.setBorder(BorderFactory.createTitledBorder("Speaker Information"));

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

    //for entering semester
    public JPanel semCreateRadioButtonPanel() {

        SemRadioButtonHandle handler = new SemRadioButtonHandle();

        seasonRadioButtonPanel = new JPanel();
        seasonRadioButtonPanel.setBorder(BorderFactory.createTitledBorder("Semester"));
        seasonRadioButtonPanel.setLayout(new BoxLayout(seasonRadioButtonPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < semOption.length; i++) {
            semOption[i] = new JRadioButton(semesterOptionLabels[i]);
            seasonRadioButtonPanel.add(semOption[i]);
            semOptionGroup.add(semOption[i]);

            semOption[i].addActionListener(handler);
        }

        return seasonRadioButtonPanel;
    }

    //for entering the gift information
    public JPanel giftCreateRadioButtonPanel() {

        GiftRadioButtonHandle giftHandler = new GiftRadioButtonHandle();

        giftRadioButtonPanel = new JPanel();
        giftRadioButtonPanel.setBorder(BorderFactory.createTitledBorder("Previous Gift"));
        giftRadioButtonPanel.setLayout(new BoxLayout(giftRadioButtonPanel, BoxLayout.Y_AXIS));

        for (int i = 0; i < giftType.length; i++) {
            giftType[i] = new JRadioButton(giftTypeLabels[i]);
            giftRadioButtonPanel.add(giftType[i]);
            giftTypeOptionGroup.add(giftType[i]);

            giftType[i].addActionListener(giftHandler);
        }
        return giftRadioButtonPanel;
    }

    //for entering the in person / parking pass info
    public JPanel inPersonCreateRadioButtonPanel() {

        InPersonRadioButtonHandle inPersonHandler = new InPersonRadioButtonHandle();
        ParkingRadioButtonHandle parkingHandler = new ParkingRadioButtonHandle();


        inPersonLabel = new JLabel("In Person or Zoom?", SwingConstants.RIGHT);


        inPersonRadioButtonPanel = new JPanel();
        inPersonRadioButtonPanel.setBorder(BorderFactory.createTitledBorder("Parking Pass & Event Type"));
        inPersonRadioButtonPanel.setLayout(new BoxLayout(inPersonRadioButtonPanel, BoxLayout.Y_AXIS));

        parkingPassLabel = new JLabel("Parking Pass Issued: ", SwingConstants.RIGHT);

        inPersonRadioButtonPanel.add(inPersonLabel);

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

    //action listener for semester radio buttons
    class SemRadioButtonHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton jrb = (JRadioButton) e.getSource();
            radioOptions[0] = jrb.getText();
        }
    }

    //action listener for gift radio buttons
    class GiftRadioButtonHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton jrb = (JRadioButton) e.getSource();
            radioOptions[1] = jrb.getText();
        }
    }

    //action listener for parking permit radio buttons
    class ParkingRadioButtonHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton jrb = (JRadioButton) e.getSource();
            radioOptions[2] = jrb.getText();
        }
    }
    //action listener for in person radio buttons
    class InPersonRadioButtonHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton jrb = (JRadioButton) e.getSource();
            radioOptions[3] = jrb.getText();
        }
    }

    //Submit button panel
    public JPanel createButtonPanel() {

        ButtonHandle handler = new ButtonHandle();

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        submitBtn = new JButton("Submit");
        //submitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitBtn.addActionListener(handler);
        buttonPanel.add(submitBtn);

        return buttonPanel;
    }

    //action listener for submit button
    class ButtonHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            myDB = new Database();
            String fName, lName, title, addr, city, email, speechDate, invitee, organization;
            String semester, gift, parkingPass, inPerson;
            int result = 0;

            //Takes speaker info and enters it in the database if submit button is clicked
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