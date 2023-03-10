/* Cinepop (A ticket management system with admin panel to edit the data )
 * languages used java and sql
 * programmed by Rushan khan
 * semester 2 project
 * 05/03/2023
 * it's my first program, so many things could be better
 * enjoy!*/

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;


import static java.awt.Font.BOLD;


public class Framework {

    //Home Screen components declaration

    JFrame mainFrame;
    JPanel jPanelContainer, landingScreenPanel;
    JLabel landPageTitle, landPageTitle2, logo;
    JButton landPageBtn, landPageBtn1;

    //Movie selection components declaration
    JLabel movieSPTitle, movieSPTitle2;
    JPanel movieSelectionPanel;
    JButton movieSPBtn, movieSPBackBtn;
  JComboBox<String> movieSPComboBox;



    String name;

    JMenuBar uMenu;
    JMenu userMenu, adminMenu;
    JMenuItem loginM, walletM, logOutM, settingsM, myTicketsM, searchTM, homeM, supportM, adminsSubMenu;
    //items for admin
    JMenuItem editMovM, editUserM, editTicketsM, editAdminsM,adminDashBoard;

    //  seating panel components declaration
    JLabel seatSPTitle, seatARowLabel, seatBRowLabel, seatCRowLabel, seatFirstColLabel, seatSecondColLabel, seatThirdColLabel, seatSPTitle2, seatSPTitle3, seatSPTitle4, seatSPTitle5, seatSPTitle6, seatSPTitle7, seatSPDateLabel, seatSPTimeLabel, seatSPSeatsLabel, seatSPShowSelectedSeatsLabel, seatSPTitle1, seatSPMovieNameLabel;
    JPanel seatSelectionPanel;
    JButton seat1A, seat2A, seat3A, seat1B, seat2B, seat3B, seat1C, seat2C, seat3C, seatSPBackBtn;

    JComboBox<String> seatSPGetDateBox;
    JComboBox<String> seatSPGetTimeBox;

    JTextField seatSPUserTotal;

    String total = "Total: ";

    JButton seatConfirmBtn;

    private String tickets;
    private String date;
    private String time;
    private String seat; // for confirm dialog
    int sum, price;

    // register and login components declaration

    JPanel AutFormPanel;
    JLabel autFPTitle, autFPEmailLabel, autFPPasswordLabel, autFPConfPasswordLabel, autFPFirstNameLabel, autFPPrompt;

    JTextField autFPEmailTF, autFPFirstNameTF;
    JPasswordField autFPPasswordPassF, autFPConfPasswordTF;

    JButton autFPSubmitBtn, autFPShowRegisterBtn, autFPBackBtn, autFPShowLoginBtn, autFPRegisterSubmitBtn;

    private boolean logChk;
    private String nameTemp;

    private int getUserId;
    private String getUserPass;


    // payments components declaration

    JPanel payPanel;
    JTextArea payPReceiptTA;

    JLabel payTitle, payPUserPrompt, payPTitle, payPCardTypeLabel, payPAccTitleLabel, payPCardNumLabel, payPCvcLabel, payPAvailableBalLabel, seatSPPrompt;

    JButton payPCreditCardMethodBtn, payPWalletMethodBtn, payPBackBtn, payPCardPayBtn, payPWalletPayBtn, payPDepositBtn;

    private int chkPibTransMethod = 0;


    // created this to check weather a user is going to payment screen or not

    private boolean payChk;
    // to make sure user doesn't get redirected to payment page if not selected any seat
    private boolean nullChk;

    // to we are at payment screen we will need to log in
    private boolean paySrcLogout;



    JTextField payPAccTitleTF, payPCvcTf, payPCardNumTf, payPGetAvailableBal;
    JComboBox<String> payPCardTypeComboBox;

    int bal;


    // admin Login Form

    JPanel adminsPanel;
    JLabel adminsPEmailLabel, adminsPPasswordLabel, adminsPPrompt, adminsPTitle;
    JTextField adminsPEmailTF;
    JPasswordField adminsPPasswordPassField;
    JButton adminsPSubmitBtn, adminsPBackBtn;
    private boolean isAdminOnDuty = false;
    //admin landing Page components
    JPanel adminHomePagePanel;
    JLabel adminHPTitle;
    JButton adminHPMoviesBtn, adminHPTicketsBtn, adminHPUsersBtn, adminHPAdminsBtn, adminHPBackBtn;


//receipt components

    JPanel PurchaseReceiptPanel;
    JLabel purReceiptTitle;
    JTextArea purReceiptTextArea;
    JButton purReceiptBackBtn;
    private String recEmailVar;

    private String getDate;
    private String getTime;

    //admin movie add/remove panel

    DefaultTableModel movieETabModel = new DefaultTableModel();

    JPanel movieEditorPanel;
    JTable movieEditorTable;

    JButton movieAddBtn, movieEditBtn, movieDeleteBtn, movieESelectBtn;

    AtomicReference<String> getName = new AtomicReference<>("");
    AtomicReference<String> movId = new AtomicReference<>("");
    java.sql.Date movDate;
    java.sql.Time movTime;

    int[] getSeats = new int[10];

    private String getEmail, getPass;
    private int getBal;


    /// search ticket components
    JPanel ticketSearchPanel;
    JLabel ticketSerTitle, ticketSerTitle1;
    JTextArea ticketSFetchTicketTArea;
    JButton ticketSBackBtn, ticketSGetTicketBtn;
    JTextField enterTicketIdToSearchTF;

//editor components

    String sendMovName;
    java.sql.Date sendMovDate;
    java.sql.Time sendMovTime;

    int getRowId;
    String getId;
    boolean isRowSelected;
    JFrame EditorFrame;

    JTextField movieEditNameTF, movieEditTimeTF, movieEditDateTF;
    JLabel movieEditNameLabel, movieEditDateLabel, movieEditTimeLabel;
    JComboBox movEditor1AComboBox, movEditor2AComboBox, movEditor3AComboBox, movEditor1BComboBox, movEditor2BComboBox, movEditor3BComboBox, movEditor1CComboBox, movEditor2CComboBox, movEditor3CComboBox;
    JPanel EditorFPanel;
    JLabel movEditor1ALabel, movEditor2ALabel, movEditor3ALabel, movEditor1BLabel, movEditor2BLabel, movEditor3BLabel, movEditor1CLabel, movEditor2CLabel, movEditor3CLabel;

    ///users edit panel
    DefaultTableModel adminsUEModel = new DefaultTableModel();
    JPanel adminsUserEditorPanel;
    JButton adminsUEUpdateBtn, adminsUEDeleteBtn;
    String[] editData = new String[9];
    //admin.tickets

    DefaultTableModel adminsTicketsTabModel = new DefaultTableModel();
    JPanel adminsTicketEditorPanel;
    //admins.admins
    DefaultTableModel adminsAETabModel = new DefaultTableModel();
    JPanel adminsAdminsEditorPanel;
    //pib transaction approval
    JPanel transWindowPanel;
    private final JPasswordField transWPasswordPassField;
    private final JLabel transWPasswordPFLabel;
    JButton transWPayBtn, transWCancelBtn;
    private int getPibBal;
    private String getCardTitle;
    private int getCardNum;
    private int getCardCvc;
    private String getCardType;

    //setting panel components
    JPanel userSettingsPanel;
    JLabel userSettingsTitle, userSYourNameLabel, userSYourEmailLabel, userSYourPasswordStatusLabel, userSPassStatus, userSUpdateWhatLabel, userSNewPassLabel, userSPrompt;
    JButton userSApplyChangeBtn, userSYourPasswordChangeBtn, userSYourEmailChangeBtn, userSYourNameChangeBtn, userSBackBtn;
    JTextField userSUpdateThisTF, userSNewPasswordTF;
    private int chkUpdateBtn = 0; // to check which update button is pressed , 1 for name, 2 for email 3 for pass , 0 for noting

    //User wallet components declaration

    JButton userWDepositFundsBtn;
    JLabel userWalletTitle, userWShowAvailableBal;

    //Transaction approval window components
    JFrame transWindowFrame;
    JButton transWLoginBtn;
    JTextField transWShowBalanceTF;
    JLabel transWShowBalanceLabel;

    //user wallet dashboard components
    JButton userWDepositApproveBtn, userWBackBtn;
    JTextField userWAmtToAddTF, userWAccountTitleTF;
    JLabel userWAmtToAddLabel, userWAccountTitleLabel;
    JPanel userWalletPanel;

    //user my ticket
    JPanel userTicketsListPanel;
    JButton userTLBackBtn;
    JTable userTLTable;
    DefaultTableModel userTlTableModel = new DefaultTableModel();



    public Framework() {

        price = 300;
        seat = "";
        logChk = false;

        User getUserFunctions = new User();
        Frameworkfunc getFWFunctions = new Frameworkfunc();

        //Declaring fonts

        //nexa bold size 40 for titles

        Font nexaB40 = new Font("Nexa Bold", BOLD, 40);
        // nexa bold size 20 for titles
        Font nexaB20 = new Font("Nexa Bold", BOLD, 20);
        // nexa light 20
        Font nexaL20 = new Font("Nexa Light", Font.PLAIN, 20);
        //nexa bold 15
        Font nexaB15 = new Font("Nexa Bold", BOLD, 15);
        //nexa bold 25
        Font nexaB25 = new Font("Nexa Bold", BOLD, 25);
        //nexa light 15
        Font nexaL15 = new Font("Nexa Light", Font.PLAIN, 15);
        // initializing dark red color

        Color dRed = new Color(204, 0, 0);

        //Landing page


        mainFrame = new JFrame("Cinepop");
        mainFrame.setSize(700, 500);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        landingScreenPanel = new JPanel(null);

        logo = new JLabel(new ImageIcon("C:\\Users\\acer\\Desktop\\logo-01.png"));
        logo.setBounds(240, 5, 200, 200);

        landPageTitle = new JLabel("Welcome To Cinepop");
        landPageTitle.setBounds(145, 165, 500, 40);
        landPageTitle.setFont(nexaB40);

        landPageTitle2 = new JLabel("Book Your Tickets Now!");
        landPageTitle2.setBounds(125, 220, 500, 35);
        landPageTitle2.setFont(nexaB40);

        landPageBtn = new JButton("Book Now");
        landPageBtn.setBounds(180, 265, 300, 100);
        landPageBtn.setFont(nexaB40);

        landPageBtn1 = new JButton("Login As Admin");
        landPageBtn1.setBounds(235, 370, 200, 30);


        userMenu = new JMenu("Guest");


        adminMenu = new JMenu("Admin");
        adminDashBoard = new JMenuItem("Dashboard");
        editMovM = new JMenuItem("Edit Movie");
        editUserM = new JMenuItem("Edit Users");
        editTicketsM = new JMenuItem("Edit Tickets");
        editAdminsM = new JMenuItem("Edit Admins");

        adminMenu.add(adminDashBoard);
        adminMenu.add(editMovM);
        adminMenu.add(editUserM);

        adminMenu.add(editTicketsM);
        adminMenu.add(editAdminsM);


        loginM = new JMenuItem("Login");

        myTicketsM = new JMenuItem("Tickets");
        searchTM = new JMenuItem("Search Tickets");
        settingsM = new JMenuItem("Settings");
        logOutM = new JMenuItem("Logout");
        walletM = new JMenuItem("Wallet");
        homeM = new JMenuItem("Home");
        supportM = new JMenuItem("Support");
        adminsSubMenu = new JMenuItem("Admin Panel");

        myTicketsM.setVisible(false);
        settingsM.setVisible(false);
        logOutM.setVisible(false);
        walletM.setVisible(false);
        supportM.setVisible(false);
        adminsSubMenu.setVisible(false);

        userMenu.add(homeM);

        userMenu.add(myTicketsM);
        userMenu.add(searchTM);
        userMenu.add(loginM);
        userMenu.add(walletM);
        userMenu.add(settingsM);
        userMenu.add(supportM);
        userMenu.add(logOutM);
        uMenu = new JMenuBar();
        uMenu.add(Box.createHorizontalGlue());


        uMenu.add(userMenu);
        userMenu.add(adminMenu);
        adminMenu.setVisible(false);


        landingScreenPanel.add(logo);
        landingScreenPanel.add(landPageTitle);

        landingScreenPanel.add(landPageTitle2);
        landingScreenPanel.add(landPageBtn1);
        landingScreenPanel.add(landPageBtn);

        mainFrame.setJMenuBar(uMenu);


        //Stylizing the components of home page
        uMenu.setBackground(dRed);
        userMenu.setForeground(Color.WHITE);
        userMenu.setFont(nexaB20);
        uMenu.setBorderPainted(false);

        adminMenu.setFont(nexaB20);
        adminMenu.setForeground(Color.BLUE);
        adminMenu.setBackground(Color.black);
        adminMenu.setBorderPainted(false);


        getFWFunctions.colourJMenu(loginM);
        getFWFunctions.colourJMenu(walletM);
        getFWFunctions.colourJMenu(logOutM);
        getFWFunctions.colourJMenu(settingsM);

        getFWFunctions.colourJMenu(myTicketsM);

        getFWFunctions.colourJMenu(searchTM);

        getFWFunctions.colourJMenu(supportM);

        getFWFunctions.colourJMenu(homeM);
        getFWFunctions.colourJMenu(editMovM);
        getFWFunctions.colourJMenu(editUserM);
        getFWFunctions.colourJMenu(adminDashBoard);
        getFWFunctions.colourJMenu(editTicketsM);
        getFWFunctions.colourJMenu(editAdminsM);


        landingScreenPanel.setBackground(dRed);
        getFWFunctions.colourBtn(landPageBtn);
        landPageBtn.setFont(nexaB40);
        getFWFunctions.colourBtn(landPageBtn1);
        landPageTitle.setForeground(Color.white);
        landPageTitle2.setForeground(Color.white);


        //Movie Selection Panel

        movieSelectionPanel = new JPanel(null);


        movieSPTitle = new JLabel("Choose Movie");
        movieSPTitle.setBounds(200, 0, 400, 50);
        movieSPTitle.setFont(nexaB40);

        movieSPTitle2 = new JLabel("Now Playing");
        movieSPTitle2.setBounds(280, 100, 250, 50);
        movieSPTitle2.setFont(nexaB20);

        movieSPBtn = new JButton("Continue");
        movieSPBtn.setBounds(180, 265, 300, 100);
        movieSPBtn.setFont(nexaB40);

        movieSPBackBtn = new JButton("<");
        movieSPBackBtn.setBounds(260, 370, 150, 40);
        movieSPBackBtn.setFont(nexaB40);


        movieSPComboBox = new JComboBox<>();
        movieSPComboBox.setBounds(155, 150, 400, 50);
        movieSPComboBox.setFont(nexaL20);

        movieSelectionPanel.add(movieSPComboBox);
        movieSelectionPanel.add(movieSPTitle);
        movieSelectionPanel.add(movieSPTitle2);
        movieSelectionPanel.add(movieSPBtn);
        movieSelectionPanel.add(movieSPBackBtn);

        //stylizing the components
        movieSelectionPanel.setBackground(dRed);

        getFWFunctions.colourBtn(movieSPBtn);

        movieSPTitle.setForeground(Color.white);
        movieSPTitle2.setForeground(Color.white);

        getFWFunctions.colourBtn(movieSPBackBtn);
        movieSPBtn.setFont(nexaB40);
        movieSPBackBtn.setFont(nexaB40);


        movieSPComboBox.setBackground(Color.WHITE);
        movieSPComboBox.setForeground(Color.black);

        //Seat Selection panel

        seatSelectionPanel = new JPanel(null);

        seatSPBackBtn = new JButton("<");
        seatSPBackBtn.setFont(nexaB40);
        seatSPBackBtn.setBounds(630, 380, 50, 50);


        seat1A = new JButton();
        seat2A = new JButton();
        seat3A = new JButton();
        seat1B = new JButton();
        seat2B = new JButton();
        seat3B = new JButton();
        seat1C = new JButton();
        seat2C = new JButton();
        seat3C = new JButton();


        seat1A.setBounds(60, 100, 50, 50);
        seat2A.setBounds(120, 100, 50, 50);
        seat3A.setBounds(180, 100, 50, 50);
        seat1B.setBounds(60, 180, 50, 50);
        seat2B.setBounds(120, 180, 50, 50);
        seat3B.setBounds(180, 180, 50, 50);
        seat1C.setBounds(60, 260, 50, 50);
        seat2C.setBounds(120, 260, 50, 50);
        seat3C.setBounds(180, 260, 50, 50);

        seatSPTitle = new JLabel("Select Seats");
        seatSPTitle.setBounds(200, 0, 400, 50);
        seatSPTitle.setFont(nexaB40);

        seatARowLabel = new JLabel("A");
        seatARowLabel.setBounds(30, 100, 50, 50);
        seatARowLabel.setFont(nexaB20);

        seatBRowLabel = new JLabel("B");
        seatBRowLabel.setBounds(30, 180, 50, 50);
        seatBRowLabel.setFont(nexaB20);

        seatCRowLabel = new JLabel("C");
        seatCRowLabel.setBounds(30, 260, 50, 50);
        seatCRowLabel.setFont(nexaB20);

        seatFirstColLabel = new JLabel("I");
        seatFirstColLabel.setBounds(80, 60, 50, 50);
        seatFirstColLabel.setFont(nexaB20);

        seatSecondColLabel = new JLabel("II");
        seatSecondColLabel.setBounds(140, 60, 50, 50);
        seatSecondColLabel.setFont(nexaB20);

        seatThirdColLabel = new JLabel("III");
        seatThirdColLabel.setBounds(200, 60, 50, 50);
        seatThirdColLabel.setFont(nexaB20);

        seatSPTitle1 = new JLabel("Screen");
        seatSPTitle1.setBounds(120, 300, 100, 50);
        seatSPTitle1.setFont(nexaB15);

        seatSPTitle2 = new JLabel("Red = Taken");
        seatSPTitle2.setBounds(60, 320, 100, 50);
        seatSPTitle2.setFont(nexaB15);


        seatSPTitle3 = new JLabel("Green = Available");
        seatSPTitle3.setBounds(60, 340, 200, 50);
        seatSPTitle3.setFont(nexaB15);

        seatSPTitle4 = new JLabel("*");
        seatSPTitle4.setBounds(40, 325, 100, 50);
        seatSPTitle4.setFont(nexaB25);
        seatSPTitle4.setForeground(Color.RED);

        seatSPTitle5 = new JLabel("*");
        seatSPTitle5.setBounds(40, 350, 100, 50);
        seatSPTitle5.setFont(nexaB25);
        seatSPTitle5.setForeground(Color.GREEN);

        seatSPTitle6 = new JLabel("Ticket Info");
        seatSPTitle6.setBounds(370, 60, 150, 50);
        seatSPTitle6.setFont(nexaB25);

        seatSPTitle7 = new JLabel("Movie");
        seatSPTitle7.setBounds(340, 110, 150, 50);
        seatSPTitle7.setFont(nexaB15);


        seatSPMovieNameLabel = new JLabel(); // movie name will appear here
        seatSPMovieNameLabel.setBounds(400, 110, 250, 50);
        seatSPMovieNameLabel.setFont(nexaB15);

        seatSPDateLabel = new JLabel("Date");
        seatSPDateLabel.setBounds(340, 150, 150, 50);
        seatSPDateLabel.setFont(nexaB15);

        seatSPGetDateBox = new JComboBox<>();
        seatSPGetDateBox.setBounds(430, 160, 150, 25);


        seatSPTimeLabel = new JLabel("Timing");
        seatSPTimeLabel.setBounds(340, 200, 150, 50);
        seatSPTimeLabel.setFont(nexaB15);

        seatSPGetTimeBox = new JComboBox<>();
        seatSPGetTimeBox.setBounds(430, 210, 150, 25);


        seatSPSeatsLabel = new JLabel("Seat");
        seatSPSeatsLabel.setBounds(340, 240, 150, 50);
        seatSPSeatsLabel.setFont(nexaB15);

        seatSPShowSelectedSeatsLabel = new JLabel("");
        seatSPShowSelectedSeatsLabel.setBounds(430, 240, 150, 50);
        seatSPShowSelectedSeatsLabel.setFont(nexaL15);


        seatSPUserTotal = new JTextField(total);
        seatSPUserTotal.setBounds(370, 350, 150, 30);
        seatSPUserTotal.setFont(nexaL15);

        seatConfirmBtn = new JButton("Confirm");
        seatConfirmBtn.setBounds(370, 390, 150, 20);

        seatSPPrompt = new JLabel("300/Rs per Ticket");
        seatSPPrompt.setFont(nexaL15);
        seatSPPrompt.setBounds(10, 390, 200, 50);


        // colouring
        seatSelectionPanel.setBackground(dRed);

        seatSPTitle4.setForeground(Color.RED);
        seatSPTitle5.setForeground(Color.GREEN);
        seat1A.setBackground(Color.green);
        seat2A.setBackground(Color.green);
        seat3A.setBackground(Color.green);
        seat1B.setBackground(Color.green);
        seat2B.setBackground(Color.green);
        seat3B.setBackground(Color.green);
        seat1C.setBackground(Color.green);
        seat2C.setBackground(Color.green);
        seat3C.setBackground(Color.green);

        seatSPPrompt.setForeground(Color.yellow);
        seatSPTitle.setForeground(Color.white);
        seatARowLabel.setForeground(Color.white);
        seatBRowLabel.setForeground(Color.white);
        seatCRowLabel.setForeground(Color.white);
        seatFirstColLabel.setForeground(Color.white);
        seatSecondColLabel.setForeground(Color.white);
        seatThirdColLabel.setForeground(Color.white);
        seatSPTitle2.setForeground(Color.white);
        seatSPTitle3.setForeground(Color.white);
        seatSPTitle6.setForeground(Color.white);
        seatSPTitle7.setForeground(Color.white);
        seatSPMovieNameLabel.setForeground(Color.yellow);
        seatSPDateLabel.setForeground(Color.white);
        seatSPTimeLabel.setForeground(Color.white);
        seatSPSeatsLabel.setForeground(Color.white);
        seatSPShowSelectedSeatsLabel.setForeground(Color.yellow);
        seatSPTitle1.setForeground(Color.white);
        seatSPGetDateBox.setBackground(Color.white);
        seatSPGetTimeBox.setBackground(Color.WHITE);
        getFWFunctions.colourBtn(seatConfirmBtn);
        getFWFunctions.colourBtn(seatSPBackBtn);
        seatSPBackBtn.setFont(nexaB40);


        seatSelectionPanel.add(seatSPTitle);
        seatSelectionPanel.add(seatSPBackBtn);
        seatSelectionPanel.add(seatSPPrompt);

        seatSelectionPanel.add(seat1A);
        seatSelectionPanel.add(seat2A);
        seatSelectionPanel.add(seat3A);
        seatSelectionPanel.add(seat1B);
        seatSelectionPanel.add(seat2B);
        seatSelectionPanel.add(seat3B);
        seatSelectionPanel.add(seat1C);
        seatSelectionPanel.add(seat2C);
        seatSelectionPanel.add(seat3C);
        seatSelectionPanel.add(seatARowLabel);
        seatSelectionPanel.add(seatBRowLabel);
        seatSelectionPanel.add(seatCRowLabel);
        seatSelectionPanel.add(seatFirstColLabel);
        seatSelectionPanel.add(seatSecondColLabel);
        seatSelectionPanel.add(seatThirdColLabel);
        seatSelectionPanel.add(seatSPTitle2);
        seatSelectionPanel.add(seatSPTitle3);
        seatSelectionPanel.add(seatSPTitle4);
        seatSelectionPanel.add(seatSPTitle5);
        seatSelectionPanel.add(seatSPTitle6);
        seatSelectionPanel.add(seatSPTitle7);
        seatSelectionPanel.add(seatSPDateLabel);
        seatSelectionPanel.add(seatSPTimeLabel);
        seatSelectionPanel.add(seatSPSeatsLabel);
        seatSelectionPanel.add(seatSPTitle1);
        seatSelectionPanel.add(seatSPMovieNameLabel);
        seatSelectionPanel.add(seatSPGetDateBox);
        seatSelectionPanel.add(seatSPGetTimeBox);

        seatSelectionPanel.add(seatSPUserTotal);
        seatSelectionPanel.add(seatSPShowSelectedSeatsLabel);
        seatSelectionPanel.add(seatConfirmBtn);


        // User Authorization Form

        AutFormPanel = new JPanel(null);

        autFPTitle = new JLabel("Please login to continue");
        autFPTitle.setBounds(210, 0, 400, 50);
        autFPTitle.setFont(nexaB20);

        autFPEmailTF = new JTextField();
        autFPEmailTF.setBounds(120, 150, 200, 30);

        autFPEmailLabel = new JLabel("Email:");
        autFPEmailLabel.setBounds(120, 120, 200, 30);

        autFPPasswordPassF = new JPasswordField();
        autFPPasswordPassF.setBounds(330, 150, 200, 30);

        autFPPasswordLabel = new JLabel("Password:");
        autFPPasswordLabel.setBounds(330, 120, 200, 30);

        autFPSubmitBtn = new JButton("Submit");
        autFPSubmitBtn.setBounds(120, 200, 200, 30);

        autFPRegisterSubmitBtn = new JButton("Submit");
        autFPRegisterSubmitBtn.setBounds(120, 200, 200, 30);
        autFPRegisterSubmitBtn.setVisible(false);

        autFPShowRegisterBtn = new JButton("Register");
        autFPShowRegisterBtn.setBounds(330, 200, 200, 30);

        autFPBackBtn = new JButton("Back");
        autFPBackBtn.setBounds(230, 250, 200, 30);

        autFPConfPasswordLabel = new JLabel("Confirm password:");
        autFPConfPasswordLabel.setBounds(120, 130, 200, 30);
        autFPConfPasswordLabel.setVisible(false);
        autFPConfPasswordTF = new JPasswordField();
        autFPConfPasswordTF.setBounds(120, 160, 200, 30);
        autFPConfPasswordTF.setVisible(false);

        autFPFirstNameLabel = new JLabel("First name:");
        autFPFirstNameLabel.setBounds(330, 130, 200, 30);
        autFPFirstNameLabel.setVisible(false);
        autFPFirstNameTF = new JTextField();
        autFPFirstNameTF.setBounds(330, 160, 200, 30);
        autFPFirstNameTF.setVisible(false);


        autFPShowLoginBtn = new JButton("login");
        autFPShowLoginBtn.setBounds(330, 200, 200, 30);
        autFPShowLoginBtn.setVisible(false);

        autFPPrompt = new JLabel();
        autFPPrompt.setBounds(50, 400, 300, 30);


        AutFormPanel.add(autFPTitle);
        AutFormPanel.add(autFPEmailTF);
        AutFormPanel.add(autFPPasswordPassF);
        AutFormPanel.add(autFPSubmitBtn);
        AutFormPanel.add(autFPShowRegisterBtn);
        AutFormPanel.add(autFPEmailLabel);
        AutFormPanel.add(autFPPasswordLabel);
        AutFormPanel.add(autFPBackBtn);
        AutFormPanel.add(autFPConfPasswordTF);
        AutFormPanel.add(autFPConfPasswordLabel);
        AutFormPanel.add(autFPFirstNameLabel);
        AutFormPanel.add(autFPFirstNameTF);
        AutFormPanel.add(autFPShowLoginBtn);
        AutFormPanel.add(autFPPrompt);
        AutFormPanel.add(autFPRegisterSubmitBtn);

        //styling the components
        autFPPrompt.setForeground(Color.yellow);

        autFPTitle.setForeground(Color.white);
        AutFormPanel.setBackground(dRed);
        autFPEmailTF.setBackground(Color.white);
        autFPEmailTF.setForeground(Color.red);
        autFPPasswordPassF.setBackground(Color.white);
        getFWFunctions.colourBtn(autFPSubmitBtn);
        getFWFunctions.colourBtn(autFPRegisterSubmitBtn);


        getFWFunctions.colourBtn(autFPShowLoginBtn);

        getFWFunctions.colourBtn(autFPShowRegisterBtn);

        getFWFunctions.colourBtn(autFPBackBtn);

        autFPFirstNameTF.setBackground(Color.white);
        autFPConfPasswordTF.setBackground(Color.white);
        autFPFirstNameLabel.setForeground(Color.white);
        autFPEmailLabel.setForeground(Color.white);
        autFPConfPasswordLabel.setForeground(Color.white);
        autFPPasswordLabel.setForeground(Color.white);

        //Payment Screen


        payPanel = new JPanel(null);

        payPReceiptTA = new JTextArea();
        payPReceiptTA.setBounds(50, 100, 200, 300);
        payPReceiptTA.setFont(new Font("Nexa Light", Font.PLAIN, 18));


        payTitle = new JLabel("Payment");
        payTitle.setBounds(240, 0, 200, 50);
        payTitle.setFont(nexaB40);

        payPUserPrompt = new JLabel();
        payPUserPrompt.setBounds(280, 100, 350, 50); // that's the prompt asking user how would he like to pay
        payPUserPrompt.setFont(nexaB20);

        payPTitle = new JLabel("Choose Payment Methods");
        payPTitle.setBounds(280, 130, 350, 50);
        payPTitle.setFont(new Font("Nexa Bold", BOLD, 17));

        payPCreditCardMethodBtn = new JButton("PIB"); //if user wants to pay with PIB(Bank system created by me also witch can be found in my GitHub also, you can only use ur that account) credit card.
        payPCreditCardMethodBtn.setBounds(300, 180, 130, 30);

        payPWalletMethodBtn = new JButton("Wallet");
        payPWalletMethodBtn.setBounds(460, 180, 130, 30);

        payPBackBtn = new JButton("Back");
        payPBackBtn.setBounds(370, 220, 160, 30);

        payPAccTitleTF = new JTextField();
        payPAccTitleTF.setBounds(300, 200, 130, 30);
        payPAccTitleTF.setVisible(false);

        payPAccTitleLabel = new JLabel("Title");
        payPAccTitleLabel.setBounds(300, 170, 130, 30);
        payPAccTitleLabel.setVisible(false);

        payPCardNumTf = new JTextField();
        payPCardNumTf.setBounds(460, 200, 130, 30);
        payPCardNumTf.setVisible(false);

        payPCardNumLabel = new JLabel("Card Number");
        payPCardNumLabel.setBounds(460, 170, 130, 30);
        payPCardNumLabel.setVisible(false);

        payPCvcTf = new JTextField();
        payPCvcTf.setBounds(300, 270, 130, 30);
        payPCvcTf.setVisible(false);

        payPCvcLabel = new JLabel("CVC");
        payPCvcLabel.setBounds(300, 240, 130, 30);
        payPCvcLabel.setVisible(false);

        String[] cType = {"Visa", "Master"};


        payPCardTypeComboBox= new JComboBox<>(cType);
        payPCardTypeComboBox.setBounds(460, 270, 130, 30);
        payPCardTypeComboBox.setVisible(false);

        payPCardTypeLabel = new JLabel("Card Type");
        payPCardTypeLabel.setBounds(460, 240, 130, 30);
        payPCardTypeLabel.setVisible(false);

        payPCardPayBtn = new JButton("Pay Now");
        payPCardPayBtn.setVisible(false);

        payPGetAvailableBal = new JTextField();
        payPGetAvailableBal.setBounds(460, 170, 130, 30);
        payPGetAvailableBal.setVisible(false);
        payPGetAvailableBal.setEditable(false);

        payPWalletPayBtn = new JButton("Pay Now");
        payPWalletPayBtn.setVisible(false);

        payPAvailableBalLabel = new JLabel("Available Balance");
        payPAvailableBalLabel.setBounds(300, 170, 130, 30);
        payPAvailableBalLabel.setVisible(false);

        payPDepositBtn = new JButton("Deposit");
        payPDepositBtn.setBounds(460, 270, 130, 30);
        payPDepositBtn.setVisible(false);

//adding components to the panel

        payPanel.add(payPReceiptTA);
        payPanel.add(payTitle);
        payPanel.add(payPUserPrompt);
        payPanel.add(payPTitle);
        payPanel.add(payPCreditCardMethodBtn);
        payPanel.add(payPWalletMethodBtn);
        payPanel.add(payPBackBtn);
        payPanel.add(payPAccTitleTF);
        payPanel.add(payPCvcTf);
        payPanel.add(payPCardNumTf);
        payPanel.add(payPCardTypeComboBox);
        payPanel.add(payPCardTypeLabel);
        payPanel.add(payPAccTitleLabel);
        payPanel.add(payPCardNumLabel);
        payPanel.add(payPCvcLabel);
        payPanel.add(payPCardPayBtn);
        payPanel.add(payPGetAvailableBal);
        payPanel.add(payPWalletPayBtn);
        payPanel.add(payPAvailableBalLabel);
        payPanel.add(payPDepositBtn);

//Styling the components
        payPanel.setBackground(dRed);
        payTitle.setForeground(Color.white);
        payPUserPrompt.setForeground(Color.yellow);
        payPTitle.setForeground(Color.yellow);
        payPAvailableBalLabel.setForeground(Color.WHITE);

        getFWFunctions.colourBtn(payPCreditCardMethodBtn);

        getFWFunctions.colourBtn(payPWalletMethodBtn);

        getFWFunctions.colourBtn(payPBackBtn);

        payPCardTypeLabel.setForeground(Color.white);
        payPAccTitleLabel.setForeground(Color.white);
        payPCardNumLabel.setForeground(Color.white);
        payPCvcLabel.setForeground(Color.white);
        getFWFunctions.colourBtn(payPCardPayBtn);

        getFWFunctions.colourBtn(payPWalletPayBtn);
        payPGetAvailableBal.setBackground(Color.WHITE);

        getFWFunctions.colourBtn(payPDepositBtn);

        //Ticket Search

        ticketSearchPanel = new JPanel(null);

        ticketSerTitle = new JLabel("Search Your Ticket");
        ticketSerTitle.setBounds(190, 0, 400, 50);
        ticketSerTitle.setFont(nexaB40);

        ticketSerTitle1 = new JLabel("Enter your ticket id here");
        ticketSerTitle1.setBounds(35, 100, 150, 50);

        enterTicketIdToSearchTF = new JTextField();
        enterTicketIdToSearchTF.setBounds(30, 140, 150, 40);


        ticketSFetchTicketTArea = new JTextArea();
        ticketSFetchTicketTArea.setBounds(200, 65, 310, 300);
        ticketSFetchTicketTArea.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        ticketSFetchTicketTArea.setEditable(false);


        ticketSBackBtn = new JButton("Back");
        ticketSBackBtn.setBounds(200, 380, 150, 40);

        ticketSGetTicketBtn = new JButton("Search");
        ticketSGetTicketBtn.setBounds(360, 380, 150, 40);


        ticketSearchPanel.add(ticketSerTitle);
        ticketSearchPanel.add(ticketSFetchTicketTArea);
        ticketSearchPanel.add(ticketSBackBtn);
        ticketSearchPanel.add(ticketSGetTicketBtn);
        ticketSearchPanel.add(enterTicketIdToSearchTF);
        ticketSearchPanel.add(ticketSerTitle1);

        ticketSearchPanel.setBackground(dRed);
        ticketSerTitle.setForeground(Color.white);
        ticketSerTitle1.setForeground(Color.white);
        getFWFunctions.colourBtn(ticketSGetTicketBtn);
        getFWFunctions.colourBtn(ticketSBackBtn);

        //Purchase Receipt


        PurchaseReceiptPanel = new JPanel(null);

        purReceiptTitle = new JLabel("Your Ticket");
        purReceiptTitle.setBounds(230, 0, 400, 50);
        purReceiptTitle.setFont(nexaB40);


        purReceiptTextArea = new JTextArea();
        purReceiptTextArea.setBounds(210, 65, 310, 300);
        purReceiptTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        purReceiptTextArea.setEditable(false);


        purReceiptBackBtn = new JButton("Continue");
        purReceiptBackBtn.setBounds(265, 380, 150, 40);


        PurchaseReceiptPanel.add(purReceiptTitle);
        PurchaseReceiptPanel.add(purReceiptTextArea);
        PurchaseReceiptPanel.add(purReceiptBackBtn);

        PurchaseReceiptPanel.setBackground(dRed);
        purReceiptTitle.setForeground(Color.white);

        getFWFunctions.colourBtn(purReceiptBackBtn);


        // ADMINS PANELS

        // login only for admins

        adminsPanel = new JPanel(null);


        adminsPTitle = new JLabel("Please login with with your Admin details");
        adminsPTitle.setBounds(160, 0, 400, 50);
        adminsPTitle.setFont(nexaB20);

        adminsPEmailTF = new JTextField();
        adminsPEmailTF.setBounds(120, 150, 200, 30);

        adminsPEmailLabel = new JLabel("Email:");
        adminsPEmailLabel.setBounds(120, 120, 200, 30);

        adminsPPasswordPassField = new JPasswordField();
        adminsPPasswordPassField.setBounds(330, 150, 200, 30);

        adminsPPasswordLabel = new JLabel("Password:");
        adminsPPasswordLabel.setBounds(330, 120, 200, 30);

        adminsPSubmitBtn = new JButton("Submit");
        adminsPSubmitBtn.setBounds(120, 200, 200, 30);
        adminsPBackBtn = new JButton("Back");
        adminsPBackBtn.setBounds(330, 200, 200, 30);


        adminsPPrompt = new JLabel();
        adminsPPrompt.setBounds(50, 400, 300, 30);

        //adding components to admin panel

        adminsPanel.add(adminsPTitle);
        adminsPanel.add(adminsPEmailLabel);
        adminsPanel.add(adminsPPasswordPassField);
        adminsPanel.add(adminsPPrompt);
        adminsPanel.add(adminsPPasswordLabel);
        adminsPanel.add(adminsPSubmitBtn);
        adminsPanel.add(adminsPEmailTF);
        adminsPanel.add(adminsPBackBtn);


        //styling the components
        adminsPPrompt.setForeground(Color.yellow);


        adminsPanel.setBackground(dRed);
        adminsPEmailTF.setBackground(Color.white);
        adminsPEmailTF.setForeground(Color.red);
        adminsPPasswordLabel.setBackground(Color.white);
        getFWFunctions.colourBtn(adminsPSubmitBtn);


        getFWFunctions.colourBtn(adminsPBackBtn);


        adminsPEmailLabel.setForeground(Color.white);
        adminsPPasswordLabel.setForeground(Color.white);
        adminsPTitle.setForeground(Color.white);


        //admin movie add/remove panel

        movieEditorPanel = new JPanel(new BorderLayout());

        movieESelectBtn = new JButton("SELECT");
        movieESelectBtn.setFont(nexaB20);


        String[] columnNames = {"Id", "Movie", "Date", "Time", "1A", "2A", "3A", "1B", "2B", "3B", "1C", "2C", "3C"};


        movieEditorTable = new JTable();


        movieETabModel.setColumnIdentifiers(columnNames);

        movieEditorTable.setModel(movieETabModel);
        movieEditorTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        movieEditorTable.setFillsViewportHeight(true);
        JScrollPane movieEScroll = new JScrollPane(movieEditorTable);
        movieEScroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        movieEScroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        movieEditorTable.setDefaultEditor(Object.class, null);

        //initializing columns in an object to change the size of that column

        TableColumn movNameCol = movieEditorTable.getColumnModel().getColumn(1);
        TableColumn movDateCol = movieEditorTable.getColumnModel().getColumn(2);
//row size changed here
        movieEditorTable.setRowHeight(40);

        // used those objects to change the size of the column
        movNameCol.setPreferredWidth(220);
        movDateCol.setPreferredWidth(100);

        //row font and alignment has been changed to center here
        movieEditorTable.setFont(new Font("New Times Roman", Font.PLAIN, 15));
        ((DefaultTableCellRenderer) movieEditorTable.getDefaultRenderer(String.class)).setHorizontalAlignment(SwingConstants.CENTER);
        //set font for table headers and then aligned it to the center

        movieEditorTable.getTableHeader().setFont(nexaB20);

        DefaultTableCellRenderer movieERenderer;


        movieERenderer = (DefaultTableCellRenderer)
                movieEditorTable.getTableHeader().getDefaultRenderer();
        movieERenderer.setHorizontalAlignment(JLabel.CENTER);
// disallowing users to edit or move columns
        movieEditorTable.getTableHeader().setReorderingAllowed(false);


        movieEScroll.setVisible(true);
        movieEditorPanel.add(movieEScroll, BorderLayout.CENTER);
        movieEditorPanel.add(movieESelectBtn, BorderLayout.SOUTH);
        getFWFunctions.colourBtn(movieESelectBtn);


        // Editor Frame
        EditorFrame = new JFrame("Editor");
        EditorFrame.getContentPane().setLayout(new BoxLayout(EditorFrame.getContentPane(), BoxLayout.Y_AXIS));

        EditorFPanel = new JPanel(null);


        EditorFrame.setSize(250, 800);

        movieAddBtn = new JButton("ADD");
        movieAddBtn.setBounds(40, 600, 150, 30);
        EditorFPanel.add(movieAddBtn);
        movieEditBtn = new JButton("UPDATE");
        movieEditBtn.setBounds(40, 640, 150, 30);
        EditorFPanel.add(movieEditBtn);
        movieDeleteBtn = new JButton("DELETE");
        movieDeleteBtn.setBounds(40, 680, 150, 30);
        EditorFPanel.add(movieDeleteBtn);


        movieEditNameTF = new JTextField();
        movieEditNameTF.setBounds(40, 30, 150, 30);
        movieEditNameLabel = new JLabel("Movie Name:");
        movieEditNameLabel.setBounds(40, 0, 200, 30);
        movieEditNameLabel.setFont(nexaB15);

        movieEditTimeTF = new JTextField("H:M:S");
        movieEditTimeTF.setBounds(40, 100, 150, 30);
        movieEditTimeLabel = new JLabel("Time:");
        movieEditTimeLabel.setBounds(40, 70, 200, 30);
        movieEditTimeLabel.setFont(nexaB15);

        movieEditDateTF = new JTextField("yyyy-mm-dd");
        movieEditDateTF.setBounds(40, 170, 150, 30);
        movieEditDateLabel = new JLabel("Date:");
        movieEditDateLabel.setBounds(40, 140, 200, 30);
        movieEditDateLabel.setFont(nexaB15);

        String[] seatConvertorNumToWord = new String[2];
        seatConvertorNumToWord[0] = "Available";
        seatConvertorNumToWord[1] = "Booked";

        movEditor1AComboBox = new JComboBox(seatConvertorNumToWord);
        movEditor1AComboBox.setBounds(40, 220, 100, 20);

        movEditor1ALabel = new JLabel("1A");
        movEditor1ALabel.setBounds(10, 220, 50, 30);
        movEditor1ALabel.setFont(nexaB15);

        EditorFPanel.add(movEditor1ALabel);
        EditorFPanel.add(movEditor1AComboBox);

        movEditor2AComboBox = new JComboBox(seatConvertorNumToWord);
        movEditor2AComboBox.setBounds(40, 260, 100, 20);

        movEditor2ALabel = new JLabel("2A");
        movEditor2ALabel.setBounds(10, 260, 50, 30);
        movEditor2ALabel.setFont(nexaB15);

        EditorFPanel.add(movEditor2ALabel);
        EditorFPanel.add(movEditor2AComboBox);

        movEditor3AComboBox = new JComboBox(seatConvertorNumToWord);
        movEditor3AComboBox.setBounds(40, 300, 100, 20);

        movEditor3ALabel = new JLabel("3A");
        movEditor3ALabel.setBounds(10, 300, 50, 30);
        movEditor3ALabel.setFont(nexaB15);

        EditorFPanel.add(movEditor3ALabel);
        EditorFPanel.add(movEditor3AComboBox);

        movEditor1BComboBox = new JComboBox(seatConvertorNumToWord);
        movEditor1BComboBox.setBounds(40, 340, 100, 20);

        movEditor1BLabel = new JLabel("1B");
        movEditor1BLabel.setBounds(10, 340, 50, 30);
        movEditor1BLabel.setFont(nexaB15);

        EditorFPanel.add(movEditor1BLabel);
        EditorFPanel.add(movEditor1BComboBox);

        movEditor2BComboBox = new JComboBox(seatConvertorNumToWord);
        movEditor2BComboBox.setBounds(40, 380, 100, 20);

        movEditor2BLabel = new JLabel("2B");
        movEditor2BLabel.setBounds(10, 380, 50, 30);
        movEditor2BLabel.setFont(nexaB15);

        EditorFPanel.add(movEditor2BLabel);
        EditorFPanel.add(movEditor2BComboBox);

        movEditor3BComboBox = new JComboBox(seatConvertorNumToWord);
        movEditor3BComboBox.setBounds(40, 420, 100, 20);

        movEditor3BLabel = new JLabel("3B");
        movEditor3BLabel.setBounds(10, 420, 50, 30);
        movEditor3BLabel.setFont(nexaB15);

        EditorFPanel.add(movEditor3BLabel);
        EditorFPanel.add(movEditor3BComboBox);

        movEditor1CComboBox = new JComboBox(seatConvertorNumToWord);
        movEditor1CComboBox.setBounds(40, 460, 100, 20);

        movEditor1CLabel = new JLabel("1C");
        movEditor1CLabel.setBounds(10, 460, 50, 30);
        movEditor1CLabel.setFont(nexaB15);

        EditorFPanel.add(movEditor1CLabel);
        EditorFPanel.add(movEditor1CComboBox);

        movEditor2CComboBox = new JComboBox(seatConvertorNumToWord);
        movEditor2CComboBox.setBounds(40, 500, 100, 20);

        movEditor2CLabel = new JLabel("2C");
        movEditor2CLabel.setBounds(10, 500, 50, 30);
        movEditor2CLabel.setFont(nexaB15);

        EditorFPanel.add(movEditor2CLabel);
        EditorFPanel.add(movEditor2CComboBox);

        movEditor3CComboBox = new JComboBox(seatConvertorNumToWord);
        movEditor3CComboBox.setBounds(40, 540, 100, 20);

        movEditor3CLabel = new JLabel("3C");
        movEditor3CLabel.setBounds(10, 540, 50, 30);
        movEditor3CLabel.setFont(nexaB15);

        EditorFPanel.add(movEditor3CLabel);
        EditorFPanel.add(movEditor3CComboBox);


        EditorFrame.add(EditorFPanel);

        EditorFPanel.add(movieEditNameTF);

        EditorFPanel.add(movieEditTimeTF);

        EditorFPanel.add(movieEditDateTF);
        EditorFPanel.add(movieEditNameLabel);
        EditorFPanel.add(movieEditTimeLabel);
        EditorFPanel.add(movieEditDateLabel);
        EditorFPanel.setBackground(dRed);
        movieEditNameLabel.setForeground(Color.white);
        movieEditTimeLabel.setForeground(Color.white);
        movieEditDateLabel.setForeground(Color.white);
        movEditor1ALabel.setForeground(Color.white);
        movEditor2ALabel.setForeground(Color.white);
        movEditor3ALabel.setForeground(Color.white);
        movEditor1BLabel.setForeground(Color.white);
        movEditor2BLabel.setForeground(Color.white);
        movEditor3BLabel.setForeground(Color.white);
        movEditor1CLabel.setForeground(Color.white);
        movEditor2CLabel.setForeground(Color.white);
        movEditor3CLabel.setForeground(Color.white);

        getFWFunctions.colourBtn(movieAddBtn);

        getFWFunctions.colourBtn(movieEditBtn);
        getFWFunctions.colourBtn(movieDeleteBtn);

        movEditor1AComboBox.setBackground(Color.white);
        movEditor2AComboBox.setBackground(Color.white);
        movEditor3AComboBox.setBackground(Color.white);
        movEditor1BComboBox.setBackground(Color.white);
        movEditor2BComboBox.setBackground(Color.white);
        movEditor3BComboBox.setBackground(Color.white);
        movEditor1CComboBox.setBackground(Color.white);
        movEditor2CComboBox.setBackground(Color.white);
        movEditor3CComboBox.setBackground(Color.white);


        //admin Panel Options Selector


        adminHomePagePanel = new JPanel();
        GridBagLayout gridBagAdminLayout = new GridBagLayout();
        adminHomePagePanel.setLayout(gridBagAdminLayout);
        GridBagConstraints gridBagAdminConstraints = new GridBagConstraints();
        gridBagAdminConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagAdminConstraints.fill = GridBagConstraints.HORIZONTAL;


        adminHPTitle = new JLabel("Admin Options:");
        adminHPTitle.setFont(nexaB20);
        adminHPTitle.setBounds(200, 0, 200, 50);


        adminHPMoviesBtn = new JButton("Movies");
        adminHPMoviesBtn.setPreferredSize(new Dimension(300, 50));

        adminHPTicketsBtn = new JButton("Tickets");
        adminHPTicketsBtn.setPreferredSize(new Dimension(300, 50));

        adminHPUsersBtn = new JButton("Users");
        adminHPUsersBtn.setPreferredSize(new Dimension(300, 50));

        adminHPAdminsBtn = new JButton("Admins");
        adminHPAdminsBtn.setPreferredSize(new Dimension(300, 50));
        adminHPBackBtn = new JButton("Back");

        adminHPBackBtn.setPreferredSize(new Dimension(300, 50));


        adminHomePagePanel.add(adminHPTitle, gridBagAdminConstraints);
        adminHomePagePanel.add(adminHPMoviesBtn, gridBagAdminConstraints);
        adminHomePagePanel.add(adminHPTicketsBtn, gridBagAdminConstraints);
        adminHomePagePanel.add(adminHPUsersBtn, gridBagAdminConstraints);
        adminHomePagePanel.add(adminHPAdminsBtn, gridBagAdminConstraints);

        adminHomePagePanel.add(adminHPBackBtn, gridBagAdminConstraints);

        getFWFunctions.colourBtn(adminHPMoviesBtn);
        getFWFunctions.colourBtn(adminHPTicketsBtn);
        getFWFunctions.colourBtn(adminHPUsersBtn);
        getFWFunctions.colourBtn(adminHPAdminsBtn);

        getFWFunctions.colourBtn(adminHPBackBtn);
        adminHomePagePanel.setBackground(dRed);
        adminHPTitle.setForeground(Color.white);


        // Admin Users panel


        adminsUserEditorPanel = new JPanel(new BorderLayout());
        JTable adminsUserEditTable;

        adminsUEDeleteBtn = new JButton("X");

        adminsUEUpdateBtn = new JButton("Update");
        adminsUEUpdateBtn.setFont(nexaB20);


        String[] userColumnNames = {"Id", "Email", "Name", "Password", "Balance"};


        adminsUserEditTable = new JTable();


        adminsUEModel.setColumnIdentifiers(userColumnNames);

        adminsUserEditTable.setModel(adminsUEModel);
        adminsUserEditTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        adminsUserEditTable.setFillsViewportHeight(true);
        JScrollPane adminsUEScroll = new JScrollPane(adminsUserEditTable);
        movieEScroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        movieEScroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


        //initializing columns in an object to change the size of that column

        TableColumn userEmailCol = adminsUserEditTable.getColumnModel().getColumn(1);
        TableColumn userPassCol = adminsUserEditTable.getColumnModel().getColumn(3);
        TableColumn userBalCol = adminsUserEditTable.getColumnModel().getColumn(4);
        TableColumn userNameCol = adminsUserEditTable.getColumnModel().getColumn(2);
//row size changed here
        adminsUserEditTable.setRowHeight(40);

        // used those objects to change the size of the column
        userEmailCol.setPreferredWidth(220);
        userPassCol.setPreferredWidth(150);
        userNameCol.setPreferredWidth(150);
        userBalCol.setPreferredWidth(150);

        //row font and alignment has been changed to center here
        adminsUserEditTable.setFont(new Font("New Times Roman", Font.PLAIN, 15));
        ((DefaultTableCellRenderer) adminsUserEditTable.getDefaultRenderer(String.class)).setHorizontalAlignment(SwingConstants.CENTER);
        //set font for table headers and then aligned it to the center

        adminsUserEditTable.getTableHeader().setFont(nexaB20);

        DefaultTableCellRenderer adminUETabRenderer;
        adminUETabRenderer = (DefaultTableCellRenderer)
                adminsUserEditTable.getTableHeader().getDefaultRenderer();
        adminUETabRenderer.setHorizontalAlignment(JLabel.CENTER);




        adminsUEDeleteBtn.setPreferredSize(new Dimension(50, 50));
        adminsUEScroll.setVisible(true);
        adminsUserEditorPanel.add(adminsUEScroll, BorderLayout.CENTER);
        adminsUserEditorPanel.add(adminsUEUpdateBtn, BorderLayout.SOUTH);
        adminsUserEditorPanel.add(adminsUEDeleteBtn, BorderLayout.EAST);

        getFWFunctions.colourBtn(adminsUEUpdateBtn);
        getFWFunctions.colourBtn(adminsUEDeleteBtn);
        adminsUEDeleteBtn.setFont(nexaB20);



        //Admins Tickets Editor


        adminsTicketEditorPanel = new JPanel(new BorderLayout());
        JTable adminsTicketsTable;


        String[] ticketsColumnNames = {"Id", "Movie", "Time", "Date", "Seats", "Total-Paid", "Pay-Method", "Email", "Purchasing-Date"};


        adminsTicketsTable = new JTable();


        adminsTicketsTabModel.setColumnIdentifiers(ticketsColumnNames);

        adminsTicketsTable.setModel(adminsTicketsTabModel);
        adminsTicketsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        adminsTicketsTable.setFillsViewportHeight(true);
        JScrollPane adminsTTScroll = new JScrollPane(adminsTicketsTable);
        adminsTTScroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        adminsTTScroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


        //initializing columns in an object to change the size of that column
        TableColumn ticketsIdCol = adminsTicketsTable.getColumnModel().getColumn(0);
        TableColumn ticketsMovCol = adminsTicketsTable.getColumnModel().getColumn(1);
        TableColumn ticketsTimeCol = adminsTicketsTable.getColumnModel().getColumn(2);
        TableColumn ticketsDateCol = adminsTicketsTable.getColumnModel().getColumn(3);
        TableColumn ticketsSeatsCol = adminsTicketsTable.getColumnModel().getColumn(4);
        TableColumn ticketsPaidCol = adminsTicketsTable.getColumnModel().getColumn(5);
        TableColumn ticketsMetCol = adminsTicketsTable.getColumnModel().getColumn(6);
        TableColumn ticketsEmailCol = adminsTicketsTable.getColumnModel().getColumn(7);
        TableColumn ticketsPurCol = adminsTicketsTable.getColumnModel().getColumn(8);

//row size changed here
        adminsTicketsTable.setRowHeight(40);

        // used those objects to change the size of the column
        ticketsEmailCol.setPreferredWidth(220);
        ticketsIdCol.setPreferredWidth(150);
        ticketsDateCol.setPreferredWidth(150);
        ticketsMetCol.setPreferredWidth(150);
        ticketsMovCol.setPreferredWidth(220);
        ticketsPurCol.setPreferredWidth(250);
        ticketsPaidCol.setPreferredWidth(150);
        ticketsTimeCol.setPreferredWidth(150);
        ticketsSeatsCol.setPreferredWidth(220);


        //row font and alignment has been changed to center here
        adminsTicketsTable.setFont(new Font("New Times Roman", Font.PLAIN, 15));
        ((DefaultTableCellRenderer) adminsTicketsTable.getDefaultRenderer(String.class)).setHorizontalAlignment(SwingConstants.CENTER);
        //set font for table headers and then aligned it to the center

        adminsTicketsTable.getTableHeader().setFont(nexaB20);

        DefaultTableCellRenderer adminsTicketsTabRenderer;
        adminsTicketsTabRenderer = (DefaultTableCellRenderer)
                adminsTicketsTable.getTableHeader().getDefaultRenderer();
        adminsTicketsTabRenderer.setHorizontalAlignment(JLabel.CENTER);


        adminsTTScroll.setVisible(true);
        adminsTicketEditorPanel.add(adminsTTScroll, BorderLayout.CENTER);

        //Admins admins Editor

        adminsAdminsEditorPanel = new JPanel(new BorderLayout());
        JTable adminsAETable;


        String[] adminsColumnNames = {"Id", "Name", "Email", "Password"};


        adminsAETable = new JTable();


        adminsAETabModel.setColumnIdentifiers(adminsColumnNames);

        adminsAETable.setModel(adminsAETabModel);
        adminsAETable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        adminsAETable.setFillsViewportHeight(true);
        JScrollPane scroll4 = new JScrollPane(adminsAETable);
        scroll4.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll4.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


        //initializing columns in an object to change the size of that column
        TableColumn adminsIdCol = adminsAETable.getColumnModel().getColumn(0);
        TableColumn adminsNameCol = adminsAETable.getColumnModel().getColumn(1);
        TableColumn adminsEmailCol = adminsAETable.getColumnModel().getColumn(2);
        TableColumn adminsPassCol = adminsAETable.getColumnModel().getColumn(3);

        //row size changed here
        adminsAETable.setRowHeight(40);

        // used those objects to change the size of the column
        adminsEmailCol.setPreferredWidth(220);
        adminsIdCol.setPreferredWidth(150);
        adminsNameCol.setPreferredWidth(150);
        adminsPassCol.setPreferredWidth(150);

        //row font and alignment has been changed to center here
        adminsAETable.setFont(new Font("New Times Roman", Font.PLAIN, 15));
        ((DefaultTableCellRenderer) adminsAETable.getDefaultRenderer(String.class)).setHorizontalAlignment(SwingConstants.CENTER);
        //set font for table headers and shen aligned it to the center

        adminsAETable.getTableHeader().setFont(nexaB20);

        DefaultTableCellRenderer adminsTabRenderer;


        adminsTabRenderer = (DefaultTableCellRenderer)
                adminsAETable.getTableHeader().getDefaultRenderer();
        adminsTabRenderer.setHorizontalAlignment(JLabel.CENTER);

        // disallowing users to edit or move columns
        adminsAETable.getTableHeader().setReorderingAllowed(false);


        scroll4.setVisible(true);
        adminsAdminsEditorPanel.add(scroll4, BorderLayout.CENTER);


        //Pib bank Transaction Window

        transWindowFrame = new JFrame("PIB");
        transWindowFrame.setSize(700, 500);

        transWindowPanel = new JPanel(null);
        JLabel transWindowTitle = new JLabel("Please confirm your transaction below");
        transWindowTitle.setFont(nexaB20);
        transWindowTitle.setBounds(200, 30, 400, 50);
        transWShowBalanceTF = new JTextField();
        transWShowBalanceTF.setBounds(300, 100, 150, 30);
        transWShowBalanceTF.setVisible(false);
        transWShowBalanceTF.setEditable(false);
        transWShowBalanceLabel = new JLabel("Balance :");
        transWShowBalanceLabel.setBounds(150, 100, 200, 30);
        transWShowBalanceLabel.setFont(nexaB15);
        transWShowBalanceLabel.setVisible(false);

        transWPasswordPassField = new JPasswordField();
        transWPasswordPassField.setBounds(300, 100, 150, 30);
        transWPasswordPFLabel = new JLabel("PIB Password:");
        transWPasswordPFLabel.setBounds(150, 100, 200, 30);
        transWPasswordPFLabel.setFont(nexaB15);

        transWLoginBtn = new JButton("Authorize");
        transWLoginBtn.setBounds(200, 200, 150, 30);
        transWPayBtn = new JButton("Pay now");
        transWPayBtn.setBounds(200, 200, 150, 30);
        transWPayBtn.setVisible(false);
        transWCancelBtn = new JButton("Cancel");
        transWCancelBtn.setBounds(420, 200, 150, 30);
        transWindowFrame.add(transWindowPanel);

        getFWFunctions.colourBtn(transWPayBtn);
        getFWFunctions.colourBtn(transWCancelBtn);
        getFWFunctions.colourBtn(transWLoginBtn);

        transWindowPanel.add(transWindowTitle);
        transWindowPanel.add(transWPasswordPassField);
        transWindowPanel.add(transWPasswordPFLabel);
        transWindowPanel.add(transWPayBtn);
        transWindowPanel.add(transWCancelBtn);
        transWindowPanel.add(transWLoginBtn);
        transWindowPanel.add(transWShowBalanceLabel);
        transWindowPanel.add(transWShowBalanceTF);
        transWindowPanel.setBackground(dRed);
        transWindowTitle.setForeground(Color.white);
        transWPasswordPFLabel.setForeground(Color.white);
        transWShowBalanceLabel.setForeground(Color.white);


        // User Settings


        userSettingsPanel = new JPanel(null);
        userSettingsTitle = new JLabel("Account Settings");
        userSettingsTitle.setBounds(100, 0, 500, 50);


        userSYourNameLabel = new JLabel("");
        userSYourNameLabel.setBounds(50, 60, 400, 50);
        userSYourNameChangeBtn = new JButton("Change");
        userSYourNameChangeBtn.setBounds(500, 70, 100, 30);


        userSYourEmailLabel = new JLabel("Your Email : rushanjk@gmail.com");
        userSYourEmailLabel.setBounds(50, 120, 400, 50);
        userSYourEmailChangeBtn = new JButton("Change");
        userSYourEmailChangeBtn.setBounds(500, 130, 100, 30);



        userSYourPasswordStatusLabel = new JLabel("Your Password status: ");
        userSYourPasswordStatusLabel.setBounds(50, 180, 400, 50);
        userSYourPasswordChangeBtn = new JButton("Change");
        userSYourPasswordChangeBtn.setBounds(500, 190, 100, 30);



        userSPassStatus = new JLabel("Strong");
        userSPassStatus.setBounds(250, 180, 200, 50);




        userSUpdateWhatLabel = new JLabel("New Name :");
        userSUpdateWhatLabel.setBounds(50, 230, 200, 50);
        userSUpdateWhatLabel.setVisible(false);


        userSUpdateThisTF = new JTextField();
        userSUpdateThisTF.setBounds(50, 270, 150, 30);
        userSUpdateThisTF.setVisible(false);

        userSNewPasswordTF = new JTextField();
        userSNewPasswordTF.setBounds(230, 270, 150, 30);
        userSNewPasswordTF.setVisible(false);

        userSNewPassLabel = new JLabel("New Password");
        userSNewPassLabel.setBounds(230, 230, 200, 50);
        userSNewPassLabel.setVisible(false);


        userSApplyChangeBtn = new JButton("Update");
        userSApplyChangeBtn.setBounds(50, 320, 150, 30);
        userSApplyChangeBtn.setVisible(false);

        userSBackBtn = new JButton("<");
        userSBackBtn.setBounds(630, 380, 50, 50);
        userSPrompt = new JLabel("");
        userSPrompt.setBounds(10, 390, 400, 50);


        //stylizing components

        userSettingsPanel.add(userSPrompt);
        getFWFunctions.colourBtn(userSBackBtn);
        getFWFunctions.colourBtn(userSYourNameChangeBtn);
        userSYourNameChangeBtn.setFont(nexaB15);
        userSPrompt.setForeground(Color.yellow);
        userSPrompt.setFont(nexaL15);
        userSBackBtn.setFont(nexaB40);
        getFWFunctions.colourBtn(userSApplyChangeBtn);
        userSApplyChangeBtn.setFont(nexaB15);
        userSNewPassLabel.setForeground(Color.white);
        userSNewPassLabel.setFont(nexaB15);
        userSUpdateWhatLabel.setForeground(Color.white);
        userSPassStatus.setFont(nexaB15);
        getFWFunctions.colourBtn(userSYourPasswordChangeBtn);
        userSYourPasswordChangeBtn.setFont(nexaB15);
        userSYourPasswordStatusLabel.setFont(nexaB15);
        getFWFunctions.colourBtn(userSYourEmailChangeBtn);
        userSYourEmailChangeBtn.setFont(nexaB15);
        userSettingsTitle.setFont(nexaB40);
        userSYourNameLabel.setFont(nexaB15);
        userSYourEmailLabel.setFont(nexaB15);
        userSUpdateWhatLabel.setFont(nexaB15);
        userSYourPasswordStatusLabel.setForeground(Color.white);
        userSettingsPanel.setBackground(dRed);
        userSettingsTitle.setForeground(Color.white);
        userSYourNameLabel.setForeground(Color.white);
        userSYourEmailLabel.setForeground(Color.white);

//adding components to panel

        userSettingsPanel.add(userSUpdateWhatLabel);
        userSettingsPanel.add(userSBackBtn);
        userSettingsPanel.add(userSNewPassLabel);
        userSettingsPanel.add(userSUpdateThisTF);
        userSettingsPanel.add(userSApplyChangeBtn);
        userSettingsPanel.add(userSNewPasswordTF);
        userSettingsPanel.add(userSYourPasswordStatusLabel);
        userSettingsPanel.add(userSYourPasswordChangeBtn);
        userSettingsPanel.add(userSPassStatus);
        userSettingsPanel.add(userSYourNameChangeBtn);
        userSettingsPanel.add(userSettingsTitle);
        userSettingsPanel.add(userSYourNameLabel);
        userSettingsPanel.add(userSYourEmailChangeBtn);
        userSettingsPanel.add(userSYourEmailLabel);
        //User Wallet screen

        userWalletPanel = new JPanel(null);



        userWalletTitle = new JLabel("User Wallet");
        userWalletTitle.setFont(nexaB40);
        userWalletTitle.setBounds(200, 0, 350, 50);

        userWShowAvailableBal = new JLabel("Available account balance = " + bal);
        userWShowAvailableBal.setBounds(50, 100, 500, 30);
        userWShowAvailableBal.setFont(nexaB25);

        userWDepositFundsBtn = new JButton("Deposit Funds");
        userWDepositFundsBtn.setBounds(100, 200, 150, 30);


        userWAccountTitleLabel = new JLabel("Account Title");
        userWAccountTitleLabel.setBounds(100, 300, 200, 30);
        userWAccountTitleLabel.setFont(nexaB15);
        userWAccountTitleLabel.setVisible(false);


        userWAccountTitleTF = new JTextField();
        userWAccountTitleTF.setBounds(100, 330, 130, 30);
        userWAccountTitleTF.setVisible(false);

        userWAmtToAddLabel = new JLabel("Amount");
        userWAmtToAddLabel.setBounds(300, 300, 130, 30);
        userWAmtToAddLabel.setFont(nexaB15);
        userWAmtToAddLabel.setVisible(false);

        userWAmtToAddTF = new JTextField();
        userWAmtToAddTF.setBounds(300, 330, 130, 30);
        userWAmtToAddTF.setVisible(false);

        userWDepositApproveBtn = new JButton("Go");
        userWDepositApproveBtn.setBounds(180, 380, 130, 30);
        userWDepositApproveBtn.setVisible(false);

        userWBackBtn = new JButton("<");
        getFWFunctions.colourBtn(userWBackBtn);
        userWBackBtn.setFont(nexaB40);
        userWBackBtn.setBounds(630, 380, 50, 50);

        userWalletTitle.setForeground(Color.white);
        userWAccountTitleLabel.setForeground(Color.white);
        getFWFunctions.colourBtn(userWDepositApproveBtn);
        userWDepositApproveBtn.setFont(nexaB15);
        userWAmtToAddLabel.setForeground(Color.white);
        getFWFunctions.colourBtn(userWDepositFundsBtn);
        userWDepositFundsBtn.setFont(nexaB15);
        userWShowAvailableBal.setForeground(Color.white);
        userWalletPanel.setBackground(dRed);


        userWalletPanel.add(userWDepositApproveBtn);
        userWalletPanel.add(userWBackBtn);
        userWalletPanel.add(userWAccountTitleTF);
        userWalletPanel.add(userWAccountTitleLabel);
        userWalletPanel.add(userWAmtToAddLabel);
        userWalletPanel.add(userWAmtToAddTF);
        userWalletPanel.add(userWDepositFundsBtn);
        userWalletPanel.add(userWalletTitle);
        userWalletPanel.add(userWShowAvailableBal);




        //users bought tickets


        userTicketsListPanel = new JPanel(new BorderLayout());

        userTLBackBtn = new JButton("Back");
        userTLBackBtn.setFont(nexaB20);


        String[] ticketColumnNames = {"Id", "Movie", "Time", "Date", "Seats", "Amount Paid", "Method", "Purchased on"};


        userTLTable = new JTable();



        userTlTableModel.setColumnIdentifiers(ticketColumnNames);

        userTLTable.setModel(userTlTableModel);
        userTLTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        userTLTable.setFillsViewportHeight(true);
        JScrollPane userTLScroll = new JScrollPane(userTLTable);
        userTLScroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        userTLScroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        userTLTable.setDefaultEditor(Object.class, null);

        //initializing columns in an object to change the size of that column
        TableColumn UserTIdCol = userTLTable.getColumnModel().getColumn(0);
        TableColumn UserTMovNameCol = userTLTable.getColumnModel().getColumn(1);
        TableColumn UserTMovTimeCol = userTLTable.getColumnModel().getColumn(2);
        TableColumn UserTMovDateCol = userTLTable.getColumnModel().getColumn(3);
        TableColumn UserTMovSeatsCol = userTLTable.getColumnModel().getColumn(4);
        TableColumn UserTAmtCol = userTLTable.getColumnModel().getColumn(5);
        TableColumn UserTMovMethodCol = userTLTable.getColumnModel().getColumn(6);
        TableColumn UserTPurDateCol = userTLTable.getColumnModel().getColumn(7);
//row size changed here
        userTLTable.setRowHeight(40);

        // used those objects to change the size of the column
        UserTMovNameCol.setPreferredWidth(220);
        UserTPurDateCol.setPreferredWidth(220);
        UserTMovSeatsCol.setPreferredWidth(220);
        UserTIdCol.setPreferredWidth(100);
        UserTMovTimeCol.setPreferredWidth(100);
        UserTMovDateCol.setPreferredWidth(100);
        UserTMovMethodCol.setPreferredWidth(100);
        UserTAmtCol.setPreferredWidth(100);

        //row font and alignment has been changed to center here
        userTLTable.setFont(new Font("New Times Roman", Font.PLAIN, 15));
        ((DefaultTableCellRenderer) userTLTable.getDefaultRenderer(String.class)).setHorizontalAlignment(SwingConstants.CENTER);
        //set font for table headers and then aligned it to the center

        userTLTable.getTableHeader().setFont(nexaB20);

        DefaultTableCellRenderer userTLRenderer;


        userTLRenderer = (DefaultTableCellRenderer)
                userTLTable.getTableHeader().getDefaultRenderer();
        userTLRenderer.setHorizontalAlignment(JLabel.CENTER);
// disallowing users to edit or move columns
        userTLTable.getTableHeader().setReorderingAllowed(false);


        userTLScroll.setVisible(true);
        userTicketsListPanel.add(userTLScroll, BorderLayout.CENTER);
        userTicketsListPanel.add(userTLBackBtn, BorderLayout.SOUTH);
        getFWFunctions.colourBtn(userTLBackBtn);





        //Card layout initializing
        jPanelContainer = new JPanel();
        CardLayout c1 = new CardLayout();
        jPanelContainer.setLayout(c1);
        mainFrame.add(jPanelContainer);

        // adding others panel to container
        jPanelContainer.add(landingScreenPanel, "0");//home
        jPanelContainer.add(movieSelectionPanel, "1");//movie selection
        jPanelContainer.add(seatSelectionPanel, "2");//seat selection
        jPanelContainer.add(AutFormPanel, "3");//authorization
        jPanelContainer.add(payPanel, "4");//payment
        jPanelContainer.add(adminsPanel, "admin");
        jPanelContainer.add(PurchaseReceiptPanel, "receipt");
        jPanelContainer.add(movieEditorPanel, "editMov");
        jPanelContainer.add(ticketSearchPanel, "serTic");
        jPanelContainer.add(adminHomePagePanel, "adminPan");
        jPanelContainer.add(adminsUserEditorPanel, "editUsers");
        jPanelContainer.add(adminsTicketEditorPanel, "ticketStatus");
        jPanelContainer.add(adminsAdminsEditorPanel, "adminsInfo");
        jPanelContainer.add(userSettingsPanel, "settings");
        jPanelContainer.add(userWalletPanel, "wallet");
        jPanelContainer.add(userTicketsListPanel, "myTickets");


        //show this panel on startup
        c1.show(jPanelContainer, "0");

        //BUTTONS ACTIONS IMPLEMENTATION
        //home screen buttons actions

        landPageBtn.addActionListener(e -> {
            movieSPComboBox.removeAllItems();  // removing all items added in it because it'll just stack up movies each time the button is clicked
            c1.show(jPanelContainer, "1");
            // connecting to database
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");
                Statement st = con.createStatement();
                String query = "select * from movies ";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    //Getting movies in the combo-box
                    movieSPComboBox.addItem(rs.getString("name"));

                }

                sum = 0;
                payPGetAvailableBal.setForeground(Color.black);
                seatSPShowSelectedSeatsLabel.setText("");


            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(jPanelContainer, "Couldn't connect to the Database");
//
            }


        });

        landPageBtn1.addActionListener(e -> {

            adminsPPasswordPassField.setText("");
            if (!isAdminOnDuty) // checking if admin is login in or not
                c1.show(jPanelContainer, "admin");
            else {
                int a = JOptionPane.showConfirmDialog(jPanelContainer, "You Are already logged in As a moderator ,Click yes to be redirected to Admin panel  ");
                if (a == JOptionPane.YES_OPTION) {
                    c1.show(jPanelContainer, "adminPan");
                }
            }
        });

        // movie selection buttons

        movieSPBtn.addActionListener(e -> {

            seat = " ";

            // getting the move name and showing it on ticket screen
            name = movieSPComboBox.getItemAt(movieSPComboBox.getSelectedIndex());
            // removing all items added in it because it'll just stack up data each time the button is clicked
            seatSPGetDateBox.removeAllItems();
            seatSPGetTimeBox.removeAllItems();


            // creating connection to catch shift,timings and seat data for the movie
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");
                Statement st = con.createStatement();
                String query = "select * from movies where name ='" + name + "'";
                ResultSet rs = st.executeQuery(query);


                while (rs.next()) {
                    getDate = rs.getString("date");
                    getTime = rs.getString("time");
                    getSeats[0] = rs.getInt("1A");
                    getSeats[1] = rs.getInt("2A");
                    getSeats[2] = rs.getInt("3A");
                    getSeats[3] = rs.getInt("1B");
                    getSeats[4] = rs.getInt("2B");
                    getSeats[5] = rs.getInt("3B");
                    getSeats[6] = rs.getInt("1C");
                    getSeats[7] = rs.getInt("2C");
                    getSeats[8] = rs.getInt("3C");


                }
                //adding movie's date and time to the components
                seatSPGetDateBox.addItem(getDate);
                seatSPGetTimeBox.addItem(getTime);

                seatSPMovieNameLabel.setText(name);
                c1.show(jPanelContainer, "2");

                //checking conditions if data coming from database is true (1) means its book and changing it colour to red if false(0) then green
                if (getSeats[0] == 1) {
                    seat1A.setBackground(Color.red);
                } else seat1A.setBackground(Color.green);
                if (getSeats[1] == 1) seat2A.setBackground(Color.red);
                else seat2A.setBackground(Color.green);
                if (getSeats[2] == 1) seat3A.setBackground(Color.red);
                else seat3A.setBackground(Color.green);
                if (getSeats[3] == 1) seat1B.setBackground(Color.red);
                else seat1B.setBackground(Color.green);
                if (getSeats[4] == 1) seat2B.setBackground(Color.red);
                else seat2B.setBackground(Color.green);
                if (getSeats[5] == 1) seat3B.setBackground(Color.red);
                else seat3B.setBackground(Color.green);
                if (getSeats[6] == 1) seat1C.setBackground(Color.red);
                else seat1C.setBackground(Color.green);
                if (getSeats[7] == 1) seat2C.setBackground(Color.red);
                else seat2C.setBackground(Color.green);
                if (getSeats[8] == 1) seat3C.setBackground(Color.red);
                else seat3C.setBackground(Color.green);


            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(jPanelContainer, "Encountered an error while getting data from database");
            }


        });

        movieSPBackBtn.addActionListener(e -> c1.previous(jPanelContainer));

        // seat selection buttons

        seatSPBackBtn.addActionListener(e -> {
            c1.previous(jPanelContainer);
            seatSPUserTotal.setText("Total: ");
            sum = 0;
        });
        seatConfirmBtn.addActionListener(e -> {


            nullChk = false;

            // setting the payment label here
            payPUserPrompt.setText("How would you like to pay " + sum + " Rs ?");

            // getting tickets in tickets variable
            tickets = seatSPShowSelectedSeatsLabel.getText();
            // getting date n time to a string variable
            date =  seatSPGetDateBox.getItemAt(seatSPGetDateBox.getSelectedIndex());
            time = seatSPGetTimeBox.getItemAt(seatSPGetTimeBox.getSelectedIndex());

// checking if user has selected at least one seat or not
            if (sum != 0) {
                int a = JOptionPane.showConfirmDialog(jPanelContainer, "Do you want to buy  " + name + " movie tickets \"" + tickets + "\" on " + date + " " + time + " for " + sum + "RS ?");
                if (a == JOptionPane.YES_OPTION) {

                    if (!logChk) {
                        // if we are not logged in we will be redirected to login page

                        c1.show(jPanelContainer, "3");
                        payChk = false;
                        //setting pay receipt text
                        payPReceiptTA.setText("\n" +
                                "          Receipt \n" + "\n" +
                                "Movie : " + name + "\n" +
                                "Time : " + time + "\n" +
                                "Date : " + date + "\n" +
                                "Seats : " + tickets + "\n" +
                                "Total : " + sum + " RS\n");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(jPanelContainer, "Please Select one seat at least", "Warning", JOptionPane.WARNING_MESSAGE);
                nullChk = true;
            }

            if (logChk && !nullChk) {
                //if user has logged in and any least one seat is selected then user will be redirected to payment screen
                c1.show(jPanelContainer, "4");
                paySrcLogout = true;
                payPReceiptTA.setText("\n" +
                        "          Receipt \n" + "\n" +
                        " Movie : " + name + "\n" +
                        " Time : " + time + "\n" +
                        " Date : " + date + "\n" +
                        " Seats : " + tickets + "\n" +
                        " Total : " + sum + " RS\n"
                );
            }


        });

        // values of colours
        // red = -65536
        // light gray = -4144960
        // green = -16711936


        seat1A.addActionListener(e -> {

             //checking if seat color is green then adding the price in a variable (sum) and setting it's colour to grey
            if (seat1A.getBackground().getRGB() == -16711936) {
                seat1A.setBackground(Color.LIGHT_GRAY);
                sum += price;
                //adding seat number to a string variable
                seat += " 1A";
                //setting seat's value to 1 if user selects a seat this will be needed to update the database
                getSeats[0] = 1;

            }

            //checking if seat color is gray then minus the price in a variable (sum) and setting it's colour to green
            else if (seat1A.getBackground().getRGB() == -4144960) {
                seat1A.setBackground(Color.green);
                sum -= price;
                //replacing the seat number to null if user deselect the seat
                seat = seat.replace(" 1A", "");
                //setting seat's value to 1 if user selects a seat this will be needed to update the database
                getSeats[0] = 0;


            } //if colour is red then its taken
                    else {

                JOptionPane.showMessageDialog(jPanelContainer, "Seat already taken", "Warning", JOptionPane.WARNING_MESSAGE);

            }
            seatSPUserTotal.setText(total + sum + " RS");
            seatSPShowSelectedSeatsLabel.setText(seat);


        });
        seat2A.addActionListener(e -> {

            if (seat2A.getBackground().getRGB() == -16711936) {
                seat2A.setBackground(Color.LIGHT_GRAY);
                sum += price;
                seat += " 2A";
                getSeats[1] = 1;


            } else if (seat2A.getBackground().getRGB() == -4144960) {
                seat2A.setBackground(Color.green);
                sum -= price;
                seat = seat.replace(" 2A", "");
                getSeats[1] = 0;

            } else {
                JOptionPane.showMessageDialog(jPanelContainer, "Seat already taken", "Warning", JOptionPane.WARNING_MESSAGE);

            }
            seatSPUserTotal.setText(total + sum + " RS");
            seatSPShowSelectedSeatsLabel.setText(seat);


        });
        seat3A.addActionListener(e -> {

            if (seat3A.getBackground().getRGB() == -16711936) {
                seat3A.setBackground(Color.LIGHT_GRAY);
                sum += price;
                seat += " 3A";
                getSeats[2] = 1;

            } else if (seat3A.getBackground().getRGB() == -4144960) {
                seat3A.setBackground(Color.green);
                sum -= price;
                seat = seat.replace(" 3A", "");
                getSeats[2] = 0;


            } else {
                JOptionPane.showMessageDialog(jPanelContainer, "Seat already taken", "Warning", JOptionPane.WARNING_MESSAGE);

            }
            seatSPUserTotal.setText(total + sum + " RS");
            seatSPShowSelectedSeatsLabel.setText(seat);


        });

        seat1B.addActionListener(e -> {

            if (seat1B.getBackground().getRGB() == -16711936) {
                seat1B.setBackground(Color.LIGHT_GRAY);
                sum += price;
                seat += " 1B";
                getSeats[3] = 1;


            } else if (seat1B.getBackground().getRGB() == -4144960) {
                seat1B.setBackground(Color.green);
                sum -= price;
                seat = seat.replace(" 1B", "");
                getSeats[3] = 0;

            } else {
                JOptionPane.showMessageDialog(jPanelContainer, "Seat already taken", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            seatSPUserTotal.setText(total + sum + " RS");
            seatSPShowSelectedSeatsLabel.setText(seat);


        });

        seat2B.addActionListener(e -> {

            if (seat2B.getBackground().getRGB() == -16711936) {
                seat2B.setBackground(Color.LIGHT_GRAY);
                sum += price;
                seat += " 2B";
                getSeats[4] = 1;

            } else if (seat2B.getBackground().getRGB() == -4144960) {
                seat2B.setBackground(Color.green);
                sum -= price;
                seat = seat.replace(" 2B", "");
                getSeats[4] = 0;

            } else {
                JOptionPane.showMessageDialog(jPanelContainer, "Seat already taken", "Warning", JOptionPane.WARNING_MESSAGE);

            }
            seatSPUserTotal.setText(total + sum + " RS");
            seatSPShowSelectedSeatsLabel.setText(seat);


        });

        seat3B.addActionListener(e -> {

            if (seat3B.getBackground().getRGB() == -16711936) {
                seat3B.setBackground(Color.LIGHT_GRAY);
                sum += price;
                seat += " 3B";
                getSeats[5] = 1;


            } else if (seat3B.getBackground().getRGB() == -4144960) {
                seat3B.setBackground(Color.green);
                sum -= price;
                seat = seat.replace(" 3B", "");
                getSeats[5] = 0;

            } else {
                JOptionPane.showMessageDialog(jPanelContainer, "Seat already taken", "Warning", JOptionPane.WARNING_MESSAGE);

            }
            seatSPUserTotal.setText(total + sum + " RS");
            seatSPShowSelectedSeatsLabel.setText(seat);


        });

        seat1C.addActionListener(e -> {

            if (seat1C.getBackground().getRGB() == -16711936) {
                seat1C.setBackground(Color.LIGHT_GRAY);
                sum += price;
                seat += " 1C";
                getSeats[6] = 1;


            } else if (seat1C.getBackground().getRGB() == -4144960) {
                seat1C.setBackground(Color.green);
                sum -= price;
                seat = seat.replace(" 1C", "");
                getSeats[6] = 0;

            } else {
                JOptionPane.showMessageDialog(jPanelContainer, "Seat already taken", "Warning", JOptionPane.WARNING_MESSAGE);

            }
            seatSPUserTotal.setText(total + sum + " RS");
            seatSPShowSelectedSeatsLabel.setText(seat);


        });

        seat2C.addActionListener(e -> {

            if (seat2C.getBackground().getRGB() == -16711936) {
                seat2C.setBackground(Color.LIGHT_GRAY);
                sum += price;
                seat += " 2C";
                getSeats[7] = 1;

            } else if (seat2C.getBackground().getRGB() == -4144960) {
                seat2C.setBackground(Color.green);
                sum -= price;
                seat = seat.replace(" 2C", "");
                getSeats[7] = 0;

            } else {
                JOptionPane.showMessageDialog(jPanelContainer, "Seat already taken", "Warning", JOptionPane.WARNING_MESSAGE);

            }
            seatSPUserTotal.setText(total + sum + " RS");
            seatSPShowSelectedSeatsLabel.setText(seat);


        });

        seat3C.addActionListener(e -> {

            if (seat3C.getBackground().getRGB() == -16711936) {
                seat3C.setBackground(Color.LIGHT_GRAY);
                sum += price;
                seat += " 3C";
                getSeats[8] = 1;

            } else if (seat3C.getBackground().getRGB() == -4144960) {
                seat3C.setBackground(Color.green);
                sum -= price;
                seat = seat.replace(" 3C", "");
                getSeats[8] = 0;

            } else {
                JOptionPane.showMessageDialog(jPanelContainer, "Seat already taken", "Warning", JOptionPane.WARNING_MESSAGE);

            }
            seatSPUserTotal.setText(total + sum + " RS");
            seatSPShowSelectedSeatsLabel.setText(seat);


        });



        // authorization buttons
        autFPBackBtn.addActionListener(e -> {
//checking if user on authorization screen has come from while buying tickets or from Menu button
            if (payChk) {
                c1.show(jPanelContainer, "0"); //if it comes from landing page then will return to landing page
            } else c1.show(jPanelContainer, "2"); //if it comes while buying tickets then will return to buying page


        });

        autFPShowRegisterBtn.addActionListener(e -> {
            // on this button click all elements for registration will get true and login elements will get hidden
            autFPEmailLabel.setBounds(120, 70, 200, 30);
            autFPEmailTF.setBounds(120, 100, 200, 30);
            autFPPasswordLabel.setBounds(330, 70, 200, 30);
            autFPPasswordPassF.setBounds(330, 100, 200, 30);
            autFPConfPasswordTF.setVisible(true);
            autFPConfPasswordLabel.setVisible(true);
            autFPFirstNameLabel.setVisible(true);
            autFPFirstNameTF.setVisible(true);
            autFPShowRegisterBtn.setVisible(false);
            autFPShowLoginBtn.setVisible(true);
            autFPSubmitBtn.setVisible(false);
            autFPRegisterSubmitBtn.setVisible(true);
            autFPPrompt.setText("");
            autFPEmailTF.setText("");
            autFPPasswordPassF.setText("");


        });

        autFPShowLoginBtn.addActionListener(e -> {
            // on this button click all elements for login will get true and registration elements will get hidden
            autFPEmailLabel.setBounds(120, 120, 200, 30);
            autFPEmailTF.setBounds(120, 150, 200, 30);

            autFPPasswordLabel.setBounds(330, 120, 200, 30);
            autFPPasswordPassF.setBounds(330, 150, 200, 30);
            autFPConfPasswordTF.setVisible(false);
            autFPConfPasswordLabel.setVisible(false);
            autFPFirstNameLabel.setVisible(false);
            autFPFirstNameTF.setVisible(false);
            autFPShowRegisterBtn.setVisible(true);
            autFPShowLoginBtn.setVisible(false);
            autFPSubmitBtn.setVisible(true);
            autFPRegisterSubmitBtn.setVisible(false);

            autFPEmailTF.setText("");
            autFPPasswordPassF.setText("");
            autFPConfPasswordTF.setText("");
            autFPFirstNameTF.setText("");


        });

        //login submit button
        autFPSubmitBtn.addActionListener(e -> {

            String tempEmail = autFPEmailTF.getText();
            String tempPass = Arrays.toString(autFPPasswordPassF.getPassword());
            // removing all brackets and spaces from password field
            tempPass = getUserFunctions.remover(tempPass);


            //checking weather email text area contains proper email addy or not


            if (!getUserFunctions.atChk(tempEmail)) {
                autFPPrompt.setText("Wrong \"Email\" type");
                autFPEmailTF.setForeground(Color.red);

            }


            //authorizing the login details from database

            else {
                autFPPrompt.setText("");
                autFPEmailTF.setForeground(Color.black);


                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");


                    Statement sta = connection.createStatement();
                    String query = "select * from users where email = '" + tempEmail + "' and password = '" + tempPass + "'";
                    ResultSet rs = sta.executeQuery(query);

                    if (rs.next()) {
                        nameTemp = rs.getString("name");
                        JOptionPane.showMessageDialog(jPanelContainer, "Welcome Back " + nameTemp, "Prompt", JOptionPane.WARNING_MESSAGE);

                        //setting login check to true on successful login
                        logChk = true;

                        //getting the user balance
                        bal = rs.getInt("balance");

                        //getting the user id
                        getUserId = rs.getInt("id");

                        //user email has been stored to a global variable for future use
                        recEmailVar = tempEmail;

                        //setting username to menu bar
                        userMenu.setText(nameTemp);

                        //setting all  user needed menus to visible on login

                        myTicketsM.setVisible(true);
                        settingsM.setVisible(true);
                        logOutM.setVisible(true);
                        walletM.setVisible(true);
                        adminsSubMenu.setVisible(false);
                        adminMenu.setVisible(false);
                        loginM.setVisible(false);
                        supportM.setVisible(false);
                        walletM.setText("Wallet (" + bal + "RS)");
                        payPGetAvailableBal.setText(bal + " Rs");

                        // setting admin duty checker to false on login from user credentials
                        isAdminOnDuty = false;

                        //relocating the payment screen buttons on login
                        payPCreditCardMethodBtn.setBounds(300, 180, 130, 30);
                        payPCreditCardMethodBtn.setVisible(true);
                        payPWalletMethodBtn.setVisible(true);
                        payPWalletMethodBtn.setBounds(460, 180, 130, 30);
                        payPBackBtn.setBounds(370, 220, 160, 30);
                        payPAccTitleTF.setVisible(false);
                        payPAccTitleLabel.setVisible(false);
                        payPCardNumTf.setVisible(false);
                        payPCardNumLabel.setVisible(false);
                        payPCvcTf.setVisible(false);
                        payPCvcLabel.setVisible(false);
                        payPCardTypeComboBox.setVisible(false);
                        payPCardTypeLabel.setVisible(false);
                        payPCardPayBtn.setVisible(false);
                        payPGetAvailableBal.setVisible(false);
                        payPWalletPayBtn.setVisible(false);
                        payPAvailableBalLabel.setVisible(false);
                        payPDepositBtn.setVisible(false);

                        // checking the password length to check if password is strong or not for user setting panel

                        //user password has been stored to another global variable for global usage
                        getUserPass = tempPass;
                        getFWFunctions.checkPassStatus(getUserPass, userSPassStatus);

                        // on successfully login redirecting user to desired screen
                        //if user came from movie selection screen then he'll be redirected to payment screen
                        if (!payChk) {
                            paySrcLogout = true; // pay screen logout = true that means if a person later logout from payment screen then this checking variable will be used accordingly
                            c1.show(jPanelContainer, "4");
                        } else c1.show(jPanelContainer, "0"); //else he'll be redirected to landing page

                    } else
                        JOptionPane.showMessageDialog(jPanelContainer, "Wrong email or password", "Prompt", JOptionPane.WARNING_MESSAGE);


                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(jPanelContainer, "Couldn't connect to the Database", "Error 302", JOptionPane.WARNING_MESSAGE);

                }
            }


        });


        //added a listener to change the color of email field to black on clicked @ button
        getFWFunctions.atTheRate(autFPEmailTF);
// register submit button
        autFPRegisterSubmitBtn.addActionListener(e -> {
            String tempEmail = autFPEmailTF.getText();
            String tempPass = Arrays.toString(autFPPasswordPassF.getPassword());
            String tempConfPass = Arrays.toString(autFPConfPasswordTF.getPassword());
            String tempName = autFPFirstNameTF.getText();
            // removing all brackets and spaces from password field
            tempPass = getUserFunctions.remover(tempPass);
            tempConfPass = getUserFunctions.remover(tempConfPass);


            //checking weather email text area contains proper email addy or not with password compare

            if (!getUserFunctions.atChk(tempEmail)) {
                autFPPrompt.setText("Wrong \"Email\" type");
                autFPEmailTF.setForeground(Color.red);
               if (!getUserFunctions.passCompare(tempPass, tempConfPass)) {
                    autFPPrompt.setText("Wrong \"Email\" type " + " and Passwords doesn't match");
                    autFPPasswordPassF.setForeground(Color.red);
                    autFPConfPasswordTF.setForeground(Color.red);
                    if (!getUserFunctions.passLenchk(tempPass)) {
                        autFPPrompt.setText("Passwords must be greater than 8 character");
                        autFPPasswordPassF.setForeground(Color.red);

                        if (!getUserFunctions.nameLenChk(tempName)) {
                            autFPPrompt.setText("name must be greater than 4 characters");
                            autFPFirstNameTF.setForeground(Color.red);

                        }
                    }
                }
            }

            // checking only password if email is correct
            else if (!getUserFunctions.passCompare(tempPass, tempConfPass)) {
                autFPPrompt.setText("Passwords doesn't match");
                autFPPasswordPassF.setForeground(Color.red);
                autFPConfPasswordTF.setForeground(Color.red);


            }
            // checking if the password length is more Than 8
            else if (!getUserFunctions.passLenchk(tempPass)) {
                autFPPrompt.setText("Passwords must be greater than 8 character");
                autFPPasswordPassF.setForeground(Color.red);

            }

            // checking if the name length is more than 4
            else if (!getUserFunctions.nameLenChk(tempName)) {
                autFPPrompt.setText("name must be greater than 4 characters");
                autFPFirstNameTF.setForeground(Color.red);

                // if all above condition does not satisfy that means we have no error and user will be registered
            } else {

                autFPPasswordPassF.setForeground(Color.black);
                autFPConfPasswordTF.setForeground(Color.black);
                autFPFirstNameTF.setForeground(Color.black);
                autFPPrompt.setText("");
                autFPEmailTF.setForeground(Color.black);

                // connecting database to store the registration values
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");

                    String query = "INSERT INTO users (name, email, password) VALUES ('" + tempName + "','" + tempEmail + "','" + tempPass + "')";

                    Statement sta = connection.createStatement();
                    sta.executeUpdate(query);
//
                    connection.close();

                    JOptionPane.showMessageDialog(jPanelContainer, "Successful Registered", "Prompt", JOptionPane.WARNING_MESSAGE);
                    logChk = true;
                    // paycheck will only be false if we are going from selection page to payment and if we are registered
                    // successfully while buy ticket we will redirect to payment page else to homepage
                    if (!payChk) {
                        paySrcLogout = true;
                        c1.show(jPanelContainer, "4");
                    } else c1.show(jPanelContainer, "0");


                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(jPanelContainer, "Email already registered or server problem", "Error 704", JOptionPane.WARNING_MESSAGE);
                    autFPEmailTF.setForeground(Color.red);
                }


            }
        });

        //payment buttons

        payPCreditCardMethodBtn.addActionListener(e -> {

            //showing all credit card method components on btn click
            payPCardPayBtn.setBounds(300, 330, 130, 30);
            payPWalletMethodBtn.setBounds(460, 330, 130, 30);
            payPBackBtn.setBounds(370, 370, 160, 30);
            payPAccTitleTF.setVisible(true);
            payPCvcTf.setVisible(true);
            payPCardNumTf.setVisible(true);
            payPCardTypeComboBox.setVisible(true);
            payPCardTypeLabel.setVisible(true);
            payPAccTitleLabel.setVisible(true);
            payPCardNumLabel.setVisible(true);
            payPCvcLabel.setVisible(true);
            payPCardPayBtn.setVisible(true);
            payPCreditCardMethodBtn.setVisible(false);
            payPWalletMethodBtn.setVisible(true);
            payPGetAvailableBal.setVisible(false);
            payPWalletPayBtn.setVisible(false);
            payPAvailableBalLabel.setVisible(false);
            payPDepositBtn.setVisible(false);


        });

        payPWalletMethodBtn.addActionListener(e -> {

            // checking if balance is enough or not then just colouring the labels and showing deposit btn if bal is low
            if (bal < sum) {
                payPBackBtn.setBounds(300, 270, 130, 30);
                payPDepositBtn.setVisible(true);
                payPGetAvailableBal.setForeground(Color.red);

            } else {
                payPGetAvailableBal.setForeground(Color.black);
                payPBackBtn.setBounds(300, 270, 130, 30);
            }

            //showing all wallet method components on btn click
            payPWalletPayBtn.setBounds(300, 230, 130, 30);
            payPCreditCardMethodBtn.setBounds(460, 230, 130, 30);

            payPAccTitleTF.setVisible(false);
            payPCvcTf.setVisible(false);
            payPCardNumTf.setVisible(false);
            payPCardTypeComboBox.setVisible(false);
            payPCardTypeLabel.setVisible(false);
            payPAccTitleLabel.setVisible(false);
            payPCardNumLabel.setVisible(false);
            payPCvcLabel.setVisible(false);
            payPCardPayBtn.setVisible(false);
            payPCreditCardMethodBtn.setVisible(true);
            payPGetAvailableBal.setVisible(true);
            payPAvailableBalLabel.setVisible(true);
            payPWalletPayBtn.setVisible(true);
            payPWalletMethodBtn.setVisible(false);


        });

        payPWalletPayBtn.addActionListener(e -> {

            //checking if balance is greater than the sum (user total)
            if (bal >= sum) {


                //getting a current date in a variable
                String purDate = String.valueOf(getUserFunctions.getDate());
                //creating a new unique ticket id
                String ticketId = getUserFunctions.generateUniqueId();
                String medium = "Wallet";

                purReceiptTextArea.setText("\n" +
                        " Receipt \n" + "\n" +
                        " Movie : " + name + "\n" +
                        " Time : " + time + "\n" +
                        " Date : " + date + "\n" +
                        " Seats : " + tickets + "\n" +
                        " Total Paid : " + sum + " RS\n" +
                        " Paid from : " + medium + "\n" +
                        " Email : " + recEmailVar + "\n" +
                        " Purchased on " + purDate + "\n" +
                        " Ticket id : #" + ticketId);
                int remBal = bal - sum;
                bal = remBal;


                seatSPUserTotal.setText("Total: ");

                 // connecting to database to update the balance , insert ticket data and update movie seats
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");

                    String query = "INSERT INTO tickets (id, movie, time, date, seats, amountPaid, medium, email, purDate) VALUES ('" + ticketId + "','" + name + "','" + time + "','" + date + "','" + tickets + "','" + sum + "','" + medium + "','" + recEmailVar + "','" + purDate + "')";
                    String query2 = "UPDATE movies SET 1A ='" + getSeats[0] + "'," + "2A = '" + getSeats[1] + "'," + "3A = '" + getSeats[2] + "'," + "1B = '" + getSeats[3] + "'," + "2B = '" + getSeats[4] + "'," + "3B = '" + getSeats[5] + "'," + "1C = '" + getSeats[6] + "'," + "2C = '" + getSeats[7] + "'," + "3C = '" + getSeats[8] + "'WHERE name ='" + name + "'";
                    String query3 = "UPDATE users SET balance = '" + remBal + "'WHERE email = '" + recEmailVar + "'";
                    Statement sta = connection.createStatement();
                    sta.executeUpdate(query);
                    sta.executeUpdate(query2);
                    sta.executeUpdate(query3);
//
                    connection.close();
                    walletM.setText("Wallet (" + bal + ")");
                    payPGetAvailableBal.setText(bal + " Rs");
                    JOptionPane.showMessageDialog(jPanelContainer, "Purchased");

                    c1.show(jPanelContainer, "receipt");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(jPanelContainer, "An error occurred while performing the task", "Error 509", JOptionPane.WARNING_MESSAGE);
                    seat = " ";


                }

                paySrcLogout = false;


            } else {
                int remChk = sum - bal; // to check the remaining balance we need
                payPGetAvailableBal.setForeground(Color.red);
                JOptionPane.showMessageDialog(jPanelContainer, "Low Balance! you need " + remChk + " RS more", "Prompt", JOptionPane.WARNING_MESSAGE);
                payPBackBtn.setBounds(300, 270, 130, 30);
                payPDepositBtn.setVisible(true);

            }


        });
        payPCardPayBtn.addActionListener(e -> {



            //getting card information to global variables
            getCardTitle = payPAccTitleTF.getText();
            getCardNum = Integer.parseInt(payPCardNumTf.getText());
            getCardCvc = Integer.parseInt(payPCvcTf.getText());
            getCardType = payPCardTypeComboBox.getItemAt(payPCardTypeComboBox.getSelectedIndex());
            //creating a connection to check the card info from pib bank database
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pib_db", "root", "");


                Statement sta = connection.createStatement();
                String query = "select * from card where cardNum = '" + getCardNum + "' and cardTitle = '" + getCardTitle + "' and cardCvc = '" + getCardCvc + "' and cardType = '" + getCardType + "'";
                ResultSet rs = sta.executeQuery(query);
                if (rs.next()) {

                    //if card exist then using a variable to assign a value to later check the condition

                    chkPibTransMethod = 1;

                    transWindowFrame.setVisible(true);
                    payPAccTitleTF.setForeground(Color.black);
                    payPCardNumTf.setForeground(Color.black);
                    payPCvcTf.setForeground(Color.black);
                    payPCardTypeComboBox.setForeground(Color.black);
                } else {
                    JOptionPane.showMessageDialog(jPanelContainer, "Wrong card information");
                    payPAccTitleTF.setForeground(Color.red);
                    payPCardNumTf.setForeground(Color.red);
                    payPCvcTf.setForeground(Color.red);
                    payPCardTypeComboBox.setForeground(Color.red);
                }


            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(jPanelContainer, "An error occurred in Authorization of the PIB Card", "Error 603", JOptionPane.WARNING_MESSAGE);
            }
        });

        // then transaction confirming popup will appear which will to confirm your Bank password
        transWLoginBtn.addActionListener(e -> {
            editData[0] = Arrays.toString(transWPasswordPassField.getPassword());

          // creating a connection to bank database to validate the password
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pib_db", "root", "");


                Statement sta = connection.createStatement();
                String query = "select balance from pib_data where password = '" + editData[0] + "'";
                ResultSet rs = sta.executeQuery(query);
                if (rs.next()) {
                    //getting the balance of the account
                    getPibBal = rs.getInt("balance");

                    transWPasswordPassField.setVisible(false);
                    transWPasswordPFLabel.setVisible(false);
                    transWShowBalanceTF.setVisible(true);
                    transWShowBalanceTF.setText(String.valueOf(getPibBal));
                    transWShowBalanceLabel.setVisible(true);
                    transWLoginBtn.setVisible(false);
                    transWPayBtn.setVisible(true);
                    JOptionPane.showMessageDialog(jPanelContainer, "Logged in to your pib account");


                } else {
                    JOptionPane.showMessageDialog(jPanelContainer, "password Wrong", "Error 405", JOptionPane.WARNING_MESSAGE);

                }


            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(jPanelContainer, "An error occurred while connecting to database", "Error 307", JOptionPane.WARNING_MESSAGE);
            }


        });

        transWPayBtn.addActionListener(e -> {
            // this button will perform and authorize the transactions happening with the pib bank

            if (chkPibTransMethod == 1) {

                // 1 means a user came here to approve a ticket payment

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pib_db", "root", "");


                    Statement sta = connection.createStatement();

                      // if pib bank balance is greater than the payment
                    if (getPibBal >= sum) {
                        int total = getPibBal - sum; // if true then subtracting the payment amount from the total balance and pushing it to database to update the balance

                        String updateBalQuery = "update pib_data set balance ='" + total + "'where u_Name='" + getCardTitle + "'";
                        sta.executeUpdate(updateBalQuery);

                        // if try works then the transaction has approved and user will receive a confirmation message
                        JOptionPane.showMessageDialog(jPanelContainer, "Transaction Approved");
                        transWindowFrame.dispose(); // and transaction window will be closed


                        // if payment approved then
                        // adding current date to a string variable
                        String purDate = String.valueOf(getUserFunctions.getDate());
                        // creating a unique ticket id then adding it to string variable
                        String ticketId = getUserFunctions.generateUniqueId();

                        //setting text of ticket data to user receipt
                        String medium = "PIB Debit";

                        purReceiptTextArea.setText("\n" +
                                " Receipt \n" + "\n" +
                                " Movie : " + name + "\n" +
                                " Time : " + time + "\n" +
                                " Date : " + date + "\n" +
                                " Seats : " + tickets + "\n" +
                                " Total Paid : " + sum + " RS\n" +
                                " Paid from : " + medium + "\n" +
                                " Email : " + recEmailVar + "\n" +
                                " Purchased on " + purDate + "\n" +
                                " Ticket id : #" + ticketId);


                        seatSPUserTotal.setText("Total = "); // setting total to null

                        c1.show(jPanelContainer, "receipt"); // showing receipt screen
                        connection.close();



                        // creating connection to cinepop database to add ticket data and updating the seats.
                        Connection connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");

                        String query = "INSERT INTO tickets (id, movie, time, date, seats, amountPaid, medium, email, purDate) VALUES ('" + ticketId + "','" + name + "','" + time + "','" + date + "','" + tickets + "','" + sum + "','" + medium + "','" + recEmailVar + "','" + purDate + "')";
                        String query2 = "UPDATE movies SET 1A ='" + getSeats[0] + "'," + "2A = '" + getSeats[1] + "'," + "3A = '" + getSeats[2] + "'," + "1B = '" + getSeats[3] + "'," + "2B = '" + getSeats[4] + "'," + "3B = '" + getSeats[5] + "'," + "1C = '" + getSeats[6] + "'," + "2C = '" + getSeats[7] + "'," + "3C = '" + getSeats[8] + "'WHERE name ='" + name + "'";
                        String query3 = "INSERT INTO card_payment_info (ticket_id,card_title,card_num,card_cvc,card_type) VALUES ('" + ticketId + "','" + getCardTitle + "','" + getCardNum + "','" + getCardCvc + "','" + getCardType + "')";
                        Statement sta2 = connection2.createStatement();
                        sta2.executeUpdate(query);
                        sta2.executeUpdate(query2);
                        sta2.executeUpdate(query3);

//
                        connection2.close();


                        JOptionPane.showMessageDialog(jPanelContainer, "Purchased");
                        //ticket purchased prompt
                        chkPibTransMethod = 0; //resetting it to default

                        paySrcLogout = false;

                    } else
                        JOptionPane.showMessageDialog(jPanelContainer, "Transaction denied (Low Balance)", "Error 404", JOptionPane.WARNING_MESSAGE);


                } catch (SQLException ex) {
        JOptionPane.showMessageDialog(jPanelContainer, "An error occurred while connecting to database", "Error 302", JOptionPane.WARNING_MESSAGE);
                }
            } else if (chkPibTransMethod == 2) {
                // if user used card to deposit money into his in-app wallet then this condition will be true
                int tempAmtAdd = Integer.parseInt(editData[4]); // getting the amount user wants to add in a variable
                if (tempAmtAdd >= 100) { //condition that minimum amount to add must be 100 or greater
                    if (getPibBal >= tempAmtAdd) { //if bank balance is greater than the amount to be added
                        //if yes then creating a connection to get balance from bank database
                        try {
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pib_db", "root", "");


                            Statement sta = connection.createStatement();


                            int total = getPibBal - tempAmtAdd; // got the balance after depositing in the wallet


                            String updateBalQuery = "update pib_data set balance ='" + total + "'where u_Name='" + editData[1] + "'";
                            sta.executeUpdate(updateBalQuery); // proceeding with the update here


                            JOptionPane.showMessageDialog(jPanelContainer, "Funds Added Successfully");
                            bal += tempAmtAdd; // adding the added amount to user global balance variable
                            walletM.setText("Wallet (" + bal + ")");
                            userWAccountTitleTF.setForeground(Color.BLACK);
                            userWDepositApproveBtn.setVisible(false);
                            userWAmtToAddTF.setVisible(false);
                            userWAmtToAddLabel.setVisible(false);
                            userWAccountTitleTF.setVisible(false);
                            userWAccountTitleLabel.setVisible(false);
                            chkPibTransMethod = 0;
                            userWShowAvailableBal.setText("Available account balance = " + bal);

                            payPGetAvailableBal.setText(String.valueOf(bal));
                            if(bal>=sum){
                                payPGetAvailableBal.setForeground(Color.black);
                            }

                            transWindowFrame.dispose(); // closing the frame here
//

                            connection.close();
                        } catch (SQLException ex) {

                            JOptionPane.showMessageDialog(jPanelContainer, "An error occurred while connecting to pib bank database", "Error 302", JOptionPane.WARNING_MESSAGE);

                        }
                        try {
                            //creating a connection to update user balance after the deposit to cinepop user table
                            Connection connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");
                            Statement sta = connection2.createStatement();

                            String updateUserBalQuery = "update users set balance ='" + bal + "'where id ='" + getUserId + "'";
                            sta.executeUpdate(updateUserBalQuery);

                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(jPanelContainer, "An error occurred while connecting to cinepop database", "Error 302", JOptionPane.WARNING_MESSAGE);


                        }


                    } else
                        JOptionPane.showMessageDialog(jPanelContainer, "Transaction denied (Low Balance)", "Error 404", JOptionPane.WARNING_MESSAGE);


                } else
                    JOptionPane.showMessageDialog(jPanelContainer, "Deposit Amount must be greater than 100rs", "Error 905", JOptionPane.WARNING_MESSAGE);
            }
        });


        transWCancelBtn.addActionListener(e -> {
            transWindowFrame.dispose(); // if user press cancel button then closing the frame
            JOptionPane.showMessageDialog(jPanelContainer, "Transaction canceled ", "Canceled", JOptionPane.WARNING_MESSAGE);


        });

        payPDepositBtn.addActionListener(e -> {
            c1.show(jPanelContainer, "wallet"); // showing wallet screen
            userWShowAvailableBal.setText("Available account balance = " + bal); //setting text
        });

        payPBackBtn.addActionListener(e -> {

            c1.show(jPanelContainer, "2"); // going from payment panel to seat selection screen
            seatSPShowSelectedSeatsLabel.setText(seat);
            payPGetAvailableBal.setForeground(Color.black);
            paySrcLogout = false; // setting pay screen logout to false means user is out of payment process and will be dealt accordingly

        });

        //menu actions

        homeM.addActionListener(e -> {
            seatSPUserTotal.setText("Total: ");
            sum = 0;
            autFPPasswordPassF.setText("");
            userWAccountTitleTF.setForeground(Color.BLACK);
            userWDepositApproveBtn.setVisible(false);
            userWAmtToAddTF.setVisible(false);
            userWAmtToAddLabel.setVisible(false);
            userWAccountTitleTF.setVisible(false);
            userWAccountTitleLabel.setVisible(false);


            c1.show(jPanelContainer, "0");

        });
        adminsSubMenu.addActionListener(e -> c1.show(jPanelContainer, "adminPan"));

        searchTM.addActionListener(e -> c1.show(jPanelContainer, "serTic"));

        loginM.addActionListener(e -> {
            payChk = true;
            autFPPasswordPassF.setText("");


            c1.show(jPanelContainer, "3");
        });
        logOutM.addActionListener(e -> {
            logChk = false;
            nameTemp = "Guest";
            userMenu.setText(nameTemp);


            myTicketsM.setVisible(false);
            settingsM.setVisible(false);
            logOutM.setVisible(false);
            walletM.setVisible(false);
            loginM.setVisible(true);
            supportM.setVisible(false);
            userMenu.setForeground(Color.WHITE);
            adminsSubMenu.setVisible(false);
            autFPPasswordPassF.setText("");


// checking if a user logged out from paying screen or not
            if (paySrcLogout) {
                autFPPasswordPassF.setText("");
                c1.show(jPanelContainer, "3");


            } else c1.show(jPanelContainer, "0");

            if (bal >= sum) {
                //if user balance is not low then not showing deposit btn
                payPDepositBtn.setVisible(false);

            }


        });

        walletM.addActionListener(e -> {
            c1.show(jPanelContainer, "wallet"); //goto wallet screen
            userWShowAvailableBal.setText("Available account balance = " + bal);
        });

        // menu admin submenu buttons action
adminDashBoard.addActionListener(e-> c1.show(jPanelContainer,"adminPan"));
        editUserM.addActionListener(e ->{
            int rowCount = adminsUEModel.getRowCount();
            for (int g = rowCount - 1; g >= 0; g--) {
                adminsUEModel.removeRow(g);}



            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");


                Statement sta = connection.createStatement();

                String query2 = "select * from users";
                ResultSet rs2 = sta.executeQuery(query2);
                while (rs2.next()) {


                    getName.set(rs2.getString("name"));
                    getId = rs2.getString("id");
                    getEmail = rs2.getString("email");
                    getPass = rs2.getString("password");
                    getBal = rs2.getInt("balance");


                    String[] tbData = {String.valueOf(getId), String.valueOf(getEmail), String.valueOf(getName), String.valueOf(getPass), String.valueOf(getBal)};

                    adminsUEModel.addRow(tbData);
                }
                c1.show(jPanelContainer, "editUsers");
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(jPanelContainer, "Couldn't connect to the Database", "Error 302", JOptionPane.WARNING_MESSAGE);
            }

        });

        editTicketsM.addActionListener(e ->{
            int rowCount = adminsTicketsTabModel.getRowCount();
            for (int g = rowCount - 1; g >= 0; g--) {
                adminsTicketsTabModel.removeRow(g);
            }


            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");


                Statement sta = connection.createStatement();
                String query2 = "select * from tickets";
                ResultSet rs2 = sta.executeQuery(query2);
                while (rs2.next()) {

                    editData[0] = rs2.getString("id");
                    editData[1] = rs2.getString("movie");
                    editData[2] = rs2.getString("time");
                    editData[3] = rs2.getString("date");
                    editData[4] = rs2.getString("seats");
                    editData[5] = rs2.getString("amountPaid");
                    editData[6] = rs2.getString("medium");
                    editData[7] = rs2.getString("email");
                    editData[8] = rs2.getString("purDate");

                    String[] tbData = {String.valueOf(editData[0]), String.valueOf(editData[1]), String.valueOf(editData[2]), String.valueOf(editData[3]), String.valueOf(editData[4]), String.valueOf(editData[5]), String.valueOf(editData[6]), String.valueOf(editData[7]), String.valueOf(editData[8])};

                    adminsTicketsTabModel.addRow(tbData);
                }
                c1.show(jPanelContainer, "ticketStatus");
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(jPanelContainer, "Couldn't connect to the Database", "Error 302", JOptionPane.WARNING_MESSAGE);
            }

        });
        editAdminsM.addActionListener(e -> {
            int rowCount = adminsAETabModel.getRowCount();
            for (int g = rowCount - 1; g >= 0; g--) {
                adminsAETabModel.removeRow(g);
            }


            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");


                Statement sta = connection.createStatement();

                String query2 = "select * from admins";
                ResultSet rs2 = sta.executeQuery(query2);
                while (rs2.next()) {

                    editData[0] = rs2.getString("id");
                    editData[1] = rs2.getString("adName");
                    editData[2] = rs2.getString("adEmail");
                    editData[3] = rs2.getString("adPassword");


                    String[] tbData = {String.valueOf(editData[0]), String.valueOf(editData[1]), String.valueOf(editData[2]), String.valueOf(editData[3])};

                    adminsAETabModel.addRow(tbData);
                }
                c1.show(jPanelContainer, "adminsInfo");
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(jPanelContainer, "Couldn't connect to the Database", "Error 302", JOptionPane.WARNING_MESSAGE);
            }
        });
        settingsM.addActionListener(e -> {

            userSPrompt.setText("");
            userSUpdateThisTF.setText("");
            userSNewPasswordTF.setText("");

            userSYourNameLabel.setText("Your Name : " + nameTemp);
            userSYourEmailLabel.setText("Your Email : " + recEmailVar);
            c1.show(jPanelContainer, "settings");
            chkUpdateBtn = 0;
            autFPConfPasswordTF.setVisible(false);
            userSNewPasswordTF.setVisible(false);
            userSUpdateWhatLabel.setVisible(false);
            userSUpdateThisTF.setVisible(false);
            userSNewPassLabel.setVisible(false);
            userSApplyChangeBtn.setVisible(false);
            userSApplyChangeBtn.setVisible(false);
        });


        // admin panel buttons
        getFWFunctions.atTheRate(adminsPEmailTF); //called function which will change the colour from red to black on clicking @ button
        adminsPBackBtn.addActionListener(e -> c1.show(jPanelContainer, "0")); // on admin login form back button redirect to landing screen
        adminsPSubmitBtn.addActionListener(e -> {

                     // checking if admin is trying to log in as admin while logged in as user if not then code will proceed
                    if (!logChk) {

                        String tempEmail = adminsPEmailTF.getText();
                        String tempPass = Arrays.toString(adminsPPasswordPassField.getPassword());
                        // removing all brackets and spaces from password field
                        tempPass = getUserFunctions.remover(tempPass);


                        //checking weather email text area contains proper email addy or not


                        if (!getUserFunctions.atChk(tempEmail)) {
                            adminsPPrompt.setText("Wrong \"Email\" type");
                            adminsPEmailTF.setForeground(Color.red);

                        }


                        //authorizing the login details from database

                        else {
                            adminsPPrompt.setText("");
                            adminsPEmailTF.setForeground(Color.black);


                            try {
                                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");


                                Statement sta = connection.createStatement();
                                String query = "select * from admins where adEmail = '" + tempEmail + "' and adPassword = '" + tempPass + "'";
                                ResultSet rs = sta.executeQuery(query);

                                if (rs.next()) {

                                    nameTemp = rs.getString("adName");


                                    JOptionPane.showMessageDialog(jPanelContainer, "Welcome Back " + nameTemp, "Prompt", JOptionPane.WARNING_MESSAGE);
                                    userMenu.setText(nameTemp);
                                    userMenu.setForeground(Color.blue);
                                    settingsM.setVisible(true);
                                    adminsSubMenu.setVisible(true);
                                    settingsM.setVisible(false);
                                    adminMenu.setVisible(true);
                                    isAdminOnDuty = true;
                                }

                                c1.show(jPanelContainer, "adminPan"); // redirected to admins control panel


                            } catch (SQLException ex) {

                                JOptionPane.showMessageDialog(jPanelContainer, "Couldn't connect to the Database", "Error 302", JOptionPane.WARNING_MESSAGE);
                            }
                        }

                    } else adminsPPrompt.setText("Please Logout first");
                }
        );

        //receipt buttons

        purReceiptBackBtn.addActionListener(e -> c1.show(jPanelContainer, "0"));
        //search ticket button actions implimentation
        ticketSGetTicketBtn.addActionListener(e -> {

                    String tempId = enterTicketIdToSearchTF.getText(); // getting the id of ticket to search it to the database

                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");


                        Statement sta = connection.createStatement();

                        String query = "select * from tickets where id = '" + tempId + "'";
                        ResultSet rs = sta.executeQuery(query);

                        if (rs.next()) {
                            // if ticket id matches then getting all data and showing it on a textarea


                            String movName = rs.getString("movie");
                            String movTime = rs.getString("time");
                            String movDate = rs.getString("date");
                            String movSeats = rs.getString("seats");
                            String movMedium = rs.getString("medium");
                            String movAmt = rs.getString("amountPaid");
                            String movEmail = rs.getString("email");
                            String movPurDate = rs.getString("purDate");
                            String movId = rs.getString("id");

                            ticketSFetchTicketTArea.setText("\n" +
                                    " TICKET INFO \n" + "\n" +
                                    " Movie : " + movName + "\n" +
                                    " Time : " + movTime + "\n" +
                                    " Date : " + movDate + "\n" +
                                    " Seats : " + movSeats + "\n" +
                                    " Total Paid : " + movAmt + " RS\n" +
                                    " Paid from : " + movMedium + "\n" +
                                    " Email : " + movEmail + "\n" +
                                    " Purchased on " + movPurDate + "\n" +
                                    " Ticket id : #" + movId);


                        } else ticketSFetchTicketTArea.setText("Ticket Not Found");


                    } catch (Exception ex) {

                        JOptionPane.showMessageDialog(jPanelContainer, "Couldn't Fetch Ticket Data form Database", "Error 708", JOptionPane.WARNING_MESSAGE);

                    }


                }

        );
        ticketSBackBtn.addActionListener(e -> c1.show(jPanelContainer, "0"));


        // editor buttons

       // movie editor table
        movieEditorTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // added a mouse listener to listen the selection of row
                isRowSelected = true; //making it true means user has selected a row
                getRowId = movieEditorTable.getSelectedRow(); //getting row id then to use it to get all data of selected row in variable
               if(getRowId>=0) {
                   getId = movieETabModel.getValueAt(getRowId, 0).toString();
                   movieEditNameTF.setText(movieETabModel.getValueAt(getRowId, 1).toString());
                   movieEditDateTF.setText(movieETabModel.getValueAt(getRowId, 2).toString());
                   movieEditTimeTF.setText(movieETabModel.getValueAt(getRowId, 3).toString());
                   movEditor1AComboBox.setSelectedItem(movieETabModel.getValueAt(getRowId, 4));
                   movEditor2AComboBox.setSelectedItem(movieETabModel.getValueAt(getRowId, 5));
                   movEditor3AComboBox.setSelectedItem(movieETabModel.getValueAt(getRowId, 6));
                   movEditor1BComboBox.setSelectedItem(movieETabModel.getValueAt(getRowId, 7));
                   movEditor2BComboBox.setSelectedItem(movieETabModel.getValueAt(getRowId, 8));
                   movEditor3BComboBox.setSelectedItem(movieETabModel.getValueAt(getRowId, 9));
                   movEditor1CComboBox.setSelectedItem(movieETabModel.getValueAt(getRowId, 10));
                   movEditor2CComboBox.setSelectedItem(movieETabModel.getValueAt(getRowId, 11));
                   movEditor3CComboBox.setSelectedItem(movieETabModel.getValueAt(getRowId, 12));
               }

            }
        });

       //movie editor frame edit button
        movieAddBtn.addActionListener(e -> {



            sendMovName = movieEditNameTF.getText();
            sendMovTime = Time.valueOf(movieEditTimeTF.getText());
            sendMovDate = Date.valueOf(movieEditDateTF.getText());
            getSeats[0] = movEditor1AComboBox.getSelectedIndex();
            getSeats[1] = movEditor2AComboBox.getSelectedIndex();
            getSeats[2] = movEditor3AComboBox.getSelectedIndex();
            getSeats[3] = movEditor1BComboBox.getSelectedIndex();
            getSeats[4] = movEditor2BComboBox.getSelectedIndex();
            getSeats[5] = movEditor3BComboBox.getSelectedIndex();
            getSeats[6] = movEditor1CComboBox.getSelectedIndex();
            getSeats[7] = movEditor2CComboBox.getSelectedIndex();
            getSeats[8] = movEditor3CComboBox.getSelectedIndex();
            //getting all data from text fields


            // connecting database to add new movie data init


            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");

                String query = "INSERT INTO movies (name,date,time,1A,1B,1C,2A,2B,2C,3A,3B,3C) VALUES ('" + sendMovName + "','" + sendMovDate + "','" + sendMovTime + "','" + getSeats[0] + "','" + getSeats[1] + "','" + getSeats[2] + "','" + getSeats[3] + "','" + getSeats[4] + "','" + getSeats[5] + "','" + getSeats[6] + "','" + getSeats[7] + "','" + getSeats[8] + "')";

                Statement sta = connection.createStatement();
                sta.executeUpdate(query);
//
                connection.close();

                JOptionPane.showMessageDialog(jPanelContainer, "Movie added Successfully", "Insert", JOptionPane.WARNING_MESSAGE);


            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(jPanelContainer, "Couldn't connect to the Database", "Error 302", JOptionPane.WARNING_MESSAGE);

            }

        });

        EditorFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //editor frame window listener to remove all movies rows from the table and then getting the data again and showing it on table
                int rowCount = movieETabModel.getRowCount();

                for (int i = rowCount - 1; i >= 0; i--) {
                    movieETabModel.removeRow(i); //this to clear the table
                }

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");


                    Statement sta = connection.createStatement();

                    String query2 = "select * from movies";
                    ResultSet rs2 = sta.executeQuery(query2);
                    while (rs2.next()) {


                        getName.set(rs2.getString("name"));
                        movId.set(rs2.getString("id"));
                        movDate = rs2.getDate("date");
                        movTime = rs2.getTime("time");

                        getSeats[0] = rs2.getInt("1A");
                        getSeats[1] = rs2.getInt("2A");
                        getSeats[2] = rs2.getInt("3A");
                        getSeats[3] = rs2.getInt("1B");
                        getSeats[4] = rs2.getInt("2B");
                        getSeats[5] = rs2.getInt("3B");
                        getSeats[6] = rs2.getInt("1C");
                        getSeats[7] = rs2.getInt("2C");
                        getSeats[8] = rs2.getInt("3C");

                        String[] seats = {String.valueOf(getSeats[0]), String.valueOf(getSeats[1]), String.valueOf(getSeats[2]), String.valueOf(getSeats[3]), String.valueOf(getSeats[4]), String.valueOf(getSeats[5]), String.valueOf(getSeats[6]), String.valueOf(getSeats[7]), String.valueOf(getSeats[8])};


                        for (int i = 0; i <= 8; i++) {

                            if (seats[i].equals("1")) {
                                seats[i] = "Booked"; //converting our 1 and 0 to booked and available
                            } else seats[i] = "Available";
                        }


                        String[] tbData = {String.valueOf(movId), String.valueOf(getName), String.valueOf(movDate), String.valueOf(movTime), seats[0], seats[1], seats[2], seats[3], seats[4], seats[5], seats[6], seats[7], seats[8]};

                        movieETabModel.addRow(tbData);
                    }


                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(jPanelContainer, "Couldn't connect to the Database", "Error 302", JOptionPane.WARNING_MESSAGE);
                }


                isRowSelected = false; // row selection to false
                movieEditNameTF.setText("");
                movieEditTimeTF.setText("");
                movieEditDateTF.setText("");


                e.getWindow().dispose();
            }

        });

      getFWFunctions.textToNullOnClick(movieEditTimeTF);
       getFWFunctions.textToNullOnClick( movieEditDateTF); //used functions to set text of text-field to null on user click

        movieDeleteBtn.addActionListener(e -> {

            if (isRowSelected) {
                int a = JOptionPane.showConfirmDialog(jPanelContainer, "Are you sure you want to delete it?");
                if (a == JOptionPane.YES_OPTION) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");


                    Statement sta = connection.createStatement();

                    String query2 = "DELETE FROM `movies` WHERE id = '" + getId + "'";
                    sta.executeUpdate(query2);
                    JOptionPane.showMessageDialog(EditorFrame, "Deleted Successfully", "Prompt", JOptionPane.WARNING_MESSAGE);


                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(jPanelContainer, "Couldn't connect to the Database", "Error 302", JOptionPane.WARNING_MESSAGE);
                }

            }} else
                JOptionPane.showMessageDialog(EditorFrame, "Select a row first", "Prompt", JOptionPane.WARNING_MESSAGE);


        });

        movieESelectBtn.addActionListener(e -> EditorFrame.setVisible(true));

        movieEditBtn.addActionListener(e -> {

            if (isRowSelected) {
                sendMovName = movieEditNameTF.getText();
                sendMovTime = Time.valueOf(movieEditTimeTF.getText());
                sendMovDate = Date.valueOf(movieEditDateTF.getText());
                getSeats[0] = movEditor1AComboBox.getSelectedIndex();
                getSeats[1] = movEditor2AComboBox.getSelectedIndex();
                getSeats[2] = movEditor3AComboBox.getSelectedIndex();
                getSeats[3] = movEditor1BComboBox.getSelectedIndex();
                getSeats[4] = movEditor2BComboBox.getSelectedIndex();
                getSeats[5] = movEditor3BComboBox.getSelectedIndex();
                getSeats[6] = movEditor1CComboBox.getSelectedIndex();
                getSeats[7] = movEditor2CComboBox.getSelectedIndex();
                getSeats[8] = movEditor3CComboBox.getSelectedIndex();


                // connecting database to add new movie
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");


                    PreparedStatement update = connection.prepareStatement
                            ("UPDATE movies SET name = ?, date = ?, time = ?, 1A = ?, 2A = ? , 3A = ? , 1B = ? , 2B = ? , 3B = ? , 1C = ? , 2C = ? , 3C = ?  WHERE id = ?");
                    update.setString(1, sendMovName);
                    update.setDate(2, sendMovDate);
                    update.setTime(3, sendMovTime);
                    update.setInt(4, getSeats[0]);
                    update.setInt(5, getSeats[1]);
                    update.setInt(6, getSeats[2]);
                    update.setInt(7, getSeats[3]);
                    update.setInt(8, getSeats[4]);
                    update.setInt(9, getSeats[5]);
                    update.setInt(10, getSeats[6]);
                    update.setInt(11, getSeats[7]);
                    update.setInt(12, getSeats[8]);
                    update.setString(13, getId);

                    update.executeUpdate();
//
                    connection.close();
                    JOptionPane.showMessageDialog(EditorFrame, "Done", "Prompt", JOptionPane.WARNING_MESSAGE);


                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(jPanelContainer, "Couldn't connect to the Database", "Error 302", JOptionPane.WARNING_MESSAGE);

                }
            } else
                JOptionPane.showMessageDialog(EditorFrame, "select a row first", "Prompt", JOptionPane.WARNING_MESSAGE);


        });

        //admin panel
        adminHPMoviesBtn.addActionListener(e -> {
            int rowCount = movieETabModel.getRowCount();
            for (int g = rowCount - 1; g >= 0; g--) {
                movieETabModel.removeRow(g);
            }

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");


                Statement sta = connection.createStatement();

                String query2 = "select * from movies";
                ResultSet rs2 = sta.executeQuery(query2);
                while (rs2.next()) {


                    getName.set(rs2.getString("name"));
                    movId.set(rs2.getString("id"));
                    movDate = rs2.getDate("date");
                    movTime = rs2.getTime("time");

                    getSeats[0] = rs2.getInt("1A");
                    getSeats[1] = rs2.getInt("2A");
                    getSeats[2] = rs2.getInt("3A");
                    getSeats[3] = rs2.getInt("1B");
                    getSeats[4] = rs2.getInt("2B");
                    getSeats[5] = rs2.getInt("3B");
                    getSeats[6] = rs2.getInt("1C");
                    getSeats[7] = rs2.getInt("2C");
                    getSeats[8] = rs2.getInt("3C");

                    String[] seats = {String.valueOf(getSeats[0]), String.valueOf(getSeats[1]), String.valueOf(getSeats[2]), String.valueOf(getSeats[3]), String.valueOf(getSeats[4]), String.valueOf(getSeats[5]), String.valueOf(getSeats[6]), String.valueOf(getSeats[7]), String.valueOf(getSeats[8])};


                    for (int i = 0; i <= 8; i++) {

                        if (seats[i].equals("1")) {
                            seats[i] = "Booked";
                        } else seats[i] = "Available";
                    }


                    String[] tbData = {String.valueOf(movId), String.valueOf(getName), String.valueOf(movDate), String.valueOf(movTime), seats[0], seats[1], seats[2], seats[3], seats[4], seats[5], seats[6], seats[7], seats[8]};

                    movieETabModel.addRow(tbData);
                }
                c1.show(jPanelContainer, "editMov");
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(jPanelContainer, "Couldn't connect to the Database", "Error 302", JOptionPane.WARNING_MESSAGE);
            }
        });
        editMovM.addActionListener(e -> {
            int rowCount = movieETabModel.getRowCount();
            for (int g = rowCount - 1; g >= 0; g--) {
                movieETabModel.removeRow(g);
            }

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");


                Statement sta = connection.createStatement();

                String query2 = "select * from movies";
                ResultSet rs2 = sta.executeQuery(query2);
                while (rs2.next()) {


                    getName.set(rs2.getString("name"));
                    movId.set(rs2.getString("id"));
                    movDate = rs2.getDate("date");
                    movTime = rs2.getTime("time");

                    getSeats[0] = rs2.getInt("1A");
                    getSeats[1] = rs2.getInt("2A");
                    getSeats[2] = rs2.getInt("3A");
                    getSeats[3] = rs2.getInt("1B");
                    getSeats[4] = rs2.getInt("2B");
                    getSeats[5] = rs2.getInt("3B");
                    getSeats[6] = rs2.getInt("1C");
                    getSeats[7] = rs2.getInt("2C");
                    getSeats[8] = rs2.getInt("3C");

                    String[] seats = {String.valueOf(getSeats[0]), String.valueOf(getSeats[1]), String.valueOf(getSeats[2]), String.valueOf(getSeats[3]), String.valueOf(getSeats[4]), String.valueOf(getSeats[5]), String.valueOf(getSeats[6]), String.valueOf(getSeats[7]), String.valueOf(getSeats[8])};


                    for (int i = 0; i <= 8; i++) {

                        if (seats[i].equals("1")) {
                            seats[i] = "Booked";
                        } else seats[i] = "Available";
                    }


//String tbData[]={String.valueOf(movId), String.valueOf(movName), String.valueOf(movDate), String.valueOf(movTime), String.valueOf(tab1a), String.valueOf(tab2a), String.valueOf(tab3a), String.valueOf(tab1b), String.valueOf(tab2b), String.valueOf(tab3b), String.valueOf(tab1c), String.valueOf(tab2c), String.valueOf(tab3c)};
                    String[] tbData = {String.valueOf(movId), String.valueOf(getName), String.valueOf(movDate), String.valueOf(movTime), seats[0], seats[1], seats[2], seats[3], seats[4], seats[5], seats[6], seats[7], seats[8]};

                    movieETabModel.addRow(tbData);
                }
                c1.show(jPanelContainer, "editMov");
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(jPanelContainer, "Couldn't connect to the Database", "Error 302", JOptionPane.WARNING_MESSAGE);
            }
        });

        myTicketsM.addActionListener(e-> {
            int rowCount = userTlTableModel.getRowCount();
            for (int g = rowCount - 1; g >= 0; g--) {
                userTlTableModel.removeRow(g);
            }

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");


                Statement sta = connection.createStatement();

                String query2 = "select * from tickets where email ='"+recEmailVar+"'";
                ResultSet rs2 = sta.executeQuery(query2);
                while (rs2.next()) {


                    getName.set(rs2.getString("movie"));
                    movId.set(rs2.getString("id"));
                    movDate = rs2.getDate("date");
                    movTime = rs2.getTime("time");
                    editData[0] = rs2.getString("seats");
                    editData[1] = rs2.getString("medium");
                    editData[2] = rs2.getString("amountPaid");
                    editData[3] = rs2.getString("purDate");
                    String[] getTicket = {String.valueOf(movId), String.valueOf(getName), String.valueOf(movDate), String.valueOf(movTime),editData[0],editData[2],editData[1],editData[3]};
                    userTlTableModel.addRow(getTicket);
                    c1.show(jPanelContainer,"myTickets");
                }
            }
            catch (SQLException ex){
                new RuntimeException(ex);
            }

                });
        userTLBackBtn.addActionListener(e-> c1.show(jPanelContainer,"0"));


        adminHPUsersBtn.addActionListener(e -> {

            int rowCount = adminsUEModel.getRowCount();
            for (int g = rowCount - 1; g >= 0; g--) {
                adminsUEModel.removeRow(g);}



            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");


                Statement sta = connection.createStatement();

                String query2 = "select * from users";
                ResultSet rs2 = sta.executeQuery(query2);
                while (rs2.next()) {


                    getName.set(rs2.getString("name"));
                    getId = rs2.getString("id");
                    getEmail = rs2.getString("email");
                    getPass = rs2.getString("password");
                    getBal = rs2.getInt("balance");


                    String[] tbData = {String.valueOf(getId), String.valueOf(getEmail), String.valueOf(getName), String.valueOf(getPass), String.valueOf(getBal)};

                    adminsUEModel.addRow(tbData);
                }
                c1.show(jPanelContainer, "editUsers");
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(jPanelContainer, "Couldn't connect to the Database", "Error 302", JOptionPane.WARNING_MESSAGE);
            }


        });

        adminsUserEditTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                isRowSelected = true;
                getRowId = adminsUserEditTable.getSelectedRow();
                editData[0] = adminsUEModel.getValueAt(getRowId, 0).toString();
                editData[1] = adminsUEModel.getValueAt(getRowId, 1).toString();
                editData[2] = adminsUEModel.getValueAt(getRowId, 2).toString();
                editData[3] = adminsUEModel.getValueAt(getRowId, 3).toString();
                editData[4] = adminsUEModel.getValueAt(getRowId, 4).toString();


            }
        });

        adminsUEUpdateBtn.addActionListener(e -> {

            if (isRowSelected) {

                // connecting database to add new movie
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");


                    PreparedStatement update = connection.prepareStatement
                            ("UPDATE users SET name = ?,email =?,password=?,balance=? WHERE id = ?");
                    update.setString(1, editData[2]);
                    update.setString(2, editData[1]);
                    update.setString(3, editData[3]);
                    update.setInt(4, Integer.parseInt(editData[4]));
                    update.setInt(5, Integer.parseInt(editData[0]));

                    update.executeUpdate();

                    JOptionPane.showMessageDialog(jPanelContainer, "Selected Row Updated");
                    isRowSelected = false;


//
                    connection.close();


                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(jPanelContainer, "Couldn't connect to the Database", "Error 302", JOptionPane.WARNING_MESSAGE);

                }


            } else JOptionPane.showMessageDialog(jPanelContainer, "Please select a row to update first");


        });


        adminsUEDeleteBtn.addActionListener(e -> {

            if (isRowSelected) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");


                    Statement sta = connection.createStatement();

                    String query2 = "DELETE FROM `users` WHERE id = '" + editData[0] + "'";
                    sta.executeUpdate(query2);
                    JOptionPane.showMessageDialog(jPanelContainer, "Deleted Successfully", "Prompt", JOptionPane.WARNING_MESSAGE);
                    isRowSelected = false;
                    int rowCount = adminsUEModel.getRowCount();
                    for (int g = rowCount - 1; g >= 0; g--) {
                        adminsUEModel.removeRow(g);
                    }


                    String query = "select * from users";
                    ResultSet rs2 = sta.executeQuery(query);
                    while (rs2.next()) {


                        getName.set(rs2.getString("name"));
                        getId = rs2.getString("id");
                        getEmail = rs2.getString("email");
                        getPass = rs2.getString("password");
                        getBal = rs2.getInt("balance");


                        String[] tbData = {String.valueOf(getId), String.valueOf(getEmail), String.valueOf(getName), String.valueOf(getPass), String.valueOf(getBal)};

                        adminsUEModel.addRow(tbData);
                    }


                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(jPanelContainer, "Couldn't connect to the Database", "Error 302", JOptionPane.WARNING_MESSAGE);
                }

            } else
                JOptionPane.showMessageDialog(EditorFrame, "Select a row first", "Prompt", JOptionPane.WARNING_MESSAGE);


        });
        adminHPBackBtn.addActionListener(e -> c1.show(jPanelContainer, "0"));
        adminHPTicketsBtn.addActionListener(e -> {

            int rowCount = adminsTicketsTabModel.getRowCount();
            for (int g = rowCount - 1; g >= 0; g--) {
                adminsTicketsTabModel.removeRow(g);
            }


            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");


                Statement sta = connection.createStatement();
                String query2 = "select * from tickets";
                ResultSet rs2 = sta.executeQuery(query2);
                while (rs2.next()) {

                    editData[0] = rs2.getString("id");
                    editData[1] = rs2.getString("movie");
                    editData[2] = rs2.getString("time");
                    editData[3] = rs2.getString("date");
                    editData[4] = rs2.getString("seats");
                    editData[5] = rs2.getString("amountPaid");
                    editData[6] = rs2.getString("medium");
                    editData[7] = rs2.getString("email");
                    editData[8] = rs2.getString("purDate");

                    String[] tbData = {String.valueOf(editData[0]), String.valueOf(editData[1]), String.valueOf(editData[2]), String.valueOf(editData[3]), String.valueOf(editData[4]), String.valueOf(editData[5]), String.valueOf(editData[6]), String.valueOf(editData[7]), String.valueOf(editData[8])};

                    adminsTicketsTabModel.addRow(tbData);
                }
                c1.show(jPanelContainer, "ticketStatus");
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(jPanelContainer, "Couldn't connect to the Database", "Error 302", JOptionPane.WARNING_MESSAGE);
            }


        });

        adminHPAdminsBtn.addActionListener(e -> {

            int rowCount = adminsAETabModel.getRowCount();
            for (int g = rowCount - 1; g >= 0; g--) {
                adminsAETabModel.removeRow(g);
            }


            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");


                Statement sta = connection.createStatement();

                String query2 = "select * from admins";
                ResultSet rs2 = sta.executeQuery(query2);
                while (rs2.next()) {

                    editData[0] = rs2.getString("id");
                    editData[1] = rs2.getString("adName");
                    editData[2] = rs2.getString("adEmail");
                    editData[3] = rs2.getString("adPassword");


                    String[] tbData = {String.valueOf(editData[0]), String.valueOf(editData[1]), String.valueOf(editData[2]), String.valueOf(editData[3])};

                    adminsAETabModel.addRow(tbData);
                }
                c1.show(jPanelContainer, "adminsInfo");
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(jPanelContainer, "Couldn't connect to the Database", "Error 302", JOptionPane.WARNING_MESSAGE);
            }


        });

// user settings panel buttons action

        userSYourNameChangeBtn.addActionListener(e -> {
            chkUpdateBtn = 1;
            userSUpdateWhatLabel.setText("New Name: ");
            userSUpdateWhatLabel.setVisible(true);
            userSUpdateThisTF.setVisible(true);
            userSNewPassLabel.setVisible(false);
            userSApplyChangeBtn.setVisible(true);
            userSApplyChangeBtn.setVisible(true);


        });
        userSYourEmailChangeBtn.addActionListener(e -> {
            userSPrompt.setText("");
            userSUpdateThisTF.setText("");
            chkUpdateBtn = 2;
            userSUpdateWhatLabel.setText("New Email: ");
            userSUpdateWhatLabel.setVisible(true);
            userSUpdateThisTF.setVisible(true);
            userSNewPassLabel.setVisible(false);
            userSApplyChangeBtn.setVisible(true);
            userSApplyChangeBtn.setVisible(true);


        });
        userSYourPasswordChangeBtn.addActionListener(e -> {
            userSPrompt.setText("");
            userSUpdateThisTF.setText("");
            userSNewPasswordTF.setText("");
            chkUpdateBtn = 3;
            userSUpdateWhatLabel.setText("Old Password: ");
            autFPConfPasswordTF.setVisible(true);
            userSNewPasswordTF.setVisible(true);
            userSUpdateWhatLabel.setVisible(true);
            userSUpdateThisTF.setVisible(true);
            userSNewPassLabel.setVisible(true);
            userSApplyChangeBtn.setVisible(true);
            userSApplyChangeBtn.setVisible(true);


        });

        userSBackBtn.addActionListener(e -> {
            userSPrompt.setText("");
            userSUpdateThisTF.setText("");
            userSNewPasswordTF.setText("");


            chkUpdateBtn = 0;
            autFPConfPasswordTF.setVisible(false);
            userSNewPasswordTF.setVisible(false);
            userSUpdateWhatLabel.setVisible(false);
            userSUpdateThisTF.setVisible(false);
            userSNewPassLabel.setVisible(false);
            userSApplyChangeBtn.setVisible(false);
            userSApplyChangeBtn.setVisible(false);
            c1.show(jPanelContainer, "0");


        });

        userSApplyChangeBtn.addActionListener(e -> {


            if (chkUpdateBtn == 1) {

                editData[0] = userSUpdateThisTF.getText();
                if (getUserFunctions.nameLenChk(editData[0])) {
                    if (!nameTemp.equalsIgnoreCase(editData[0])) {

                        try {
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");


                            Statement sta = connection.createStatement();
                            String query = "update users set name='" + editData[0] + "'where id = '" + getUserId + "'";
                            userSPrompt.setText("Name Changed Successfully");
                            nameTemp = editData[0];
                            userSYourNameLabel.setText("Your Name : " + nameTemp);
                            userMenu.setText(nameTemp);


                            sta.executeUpdate(query);
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(jPanelContainer, "Couldn't connect to the Database", "Error 302", JOptionPane.WARNING_MESSAGE);
                        }
                    } else userSPrompt.setText("Old name cannot be your New Name");
                } else {
                    userSPrompt.setText("Your New Name should be Grater than 4 ch");
                }
            } else if (chkUpdateBtn == 2) {

                editData[0] = userSUpdateThisTF.getText();
                if (getUserFunctions.atChk(editData[0])) {

                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");


                        Statement sta = connection.createStatement();
                        String query = "update users set email='" + editData[0] + "'where id = '" + getUserId + "'";
                        userSPrompt.setText("Email Changed Successfully");

                        recEmailVar = editData[0];
                        userSYourEmailLabel.setText("Your Email : " + recEmailVar);


                        sta.executeUpdate(query);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(jPanelContainer, "Couldn't connect to the Database", "Error 302", JOptionPane.WARNING_MESSAGE);
                    }

                } else userSPrompt.setText("Please use correct email");
            } else if (chkUpdateBtn == 3) {
                editData[0] = userSUpdateThisTF.getText();
                editData[1] = userSNewPasswordTF.getText();
                // checking the length

                //let's get the old pass here
                if (getUserFunctions.passLenchk(editData[1])) {
                    if (!editData[1].equalsIgnoreCase(editData[0])) {
                        try {
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinepop", "root", "");


                            Statement sta = connection.createStatement();
                            String query = "select * from users where id = '" + getUserId + "' and password = '" + editData[0] + "'";
                            String updatePassQuery = "update users set password='" + editData[1] + "'where id = '" + getUserId + "'";
                            ResultSet rs = sta.executeQuery(query);
                            if (rs.next()) {
                                getFWFunctions.checkPassStatus(editData[1], userSPassStatus);

                                sta.executeUpdate(updatePassQuery);
                                userSPrompt.setText("Password Changed Successfully");


                            } else userSPrompt.setText("Old Password Doesn't match");
                        } catch (SQLException ex) {

        JOptionPane.showMessageDialog(jPanelContainer, "Couldn't connect to the Database", "Error 302", JOptionPane.WARNING_MESSAGE);
                        }
                    } else userSPrompt.setText("New Password  cannot be the old password");


                } else userSPrompt.setText("New Password Length must be greater than 7");
            }


        });

        //user wallet buttons

        userWDepositFundsBtn.addActionListener(e -> {
            userWDepositApproveBtn.setVisible(true);
            userWAmtToAddTF.setVisible(true);
            userWAmtToAddLabel.setVisible(true);
            userWAccountTitleTF.setVisible(true);
            userWAccountTitleLabel.setVisible(true);

        });

        userWBackBtn.addActionListener(e -> {
            userWAccountTitleTF.setForeground(Color.BLACK);
            userWDepositApproveBtn.setVisible(false);
            userWAmtToAddTF.setVisible(false);
            userWAmtToAddLabel.setVisible(false);
            userWAccountTitleTF.setVisible(false);
            userWAccountTitleLabel.setVisible(false);
            if (paySrcLogout) {
                c1.show(jPanelContainer, "4");


            } else c1.show(jPanelContainer, "0");

        });


        userWDepositApproveBtn.addActionListener(e -> {

            editData[4] = userWAmtToAddTF.getText();
            editData[1] = userWAccountTitleTF.getText();
            //checking if account title is valid or not
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pib_db", "root", "");


                Statement sta = connection.createStatement();
                String query = "select * from pib_data where u_Name = '" + editData[1] + "'";
                ResultSet rs = sta.executeQuery(query);
                if (rs.next()) {
                    chkPibTransMethod = 2;
                    transWindowFrame.setVisible(true);
                    userWAmtToAddTF.setVisible(false);
                    userWAmtToAddTF.setText("");

                    userWAccountTitleTF.setVisible(false);
                    userWAccountTitleTF.setText("");
                    userWAccountTitleTF.setForeground(Color.BLACK);
                } else {
                    JOptionPane.showMessageDialog(jPanelContainer, "No such Account Found");
                    userWAccountTitleTF.setForeground(Color.red);

                }


            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(jPanelContainer, "An error occurred while Authorizing  PIB Account", "Error 669", JOptionPane.WARNING_MESSAGE);
            }
        });


    }


    public static void main(String[] args) {
        new Framework();
    }


}
