package sour;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;////password
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;
import javax.swing.*;

public class finals implements MouseListener, ActionListener {
    JFrame f = new JFrame();
    static ArrayList<String> userdetails = new ArrayList<>();
    // Webcam wc= Webcam.getDefault();
    ///////////////
    JPanel lp = new JPanel();
    JLabel login_back_imgJLabel=new JLabel();
    JLabel np = new JLabel("User Name");
    JLabel pp = new JLabel("Password");
    JTextField nt = new JTextField(null);
    JPasswordField pt = new JPasswordField();

    JLabel err = new JLabel();
    JLabel er0 = new JLabel();
    JLabel err1 = new JLabel();
    JLabel err2 = new JLabel();
    JLabel err3 = new JLabel();
    JLabel err4 = new JLabel();
    JLabel err5 = new JLabel();
    JLabel err6 = new JLabel();

    JButton l = new JButton("Login");
    JButton sn = new JButton("Sign In");
    ///////////////// sign up
    ///////////////// components///////naml,nat,passl,spast,phonl,phot,accnl,acct,

    JPanel s = new JPanel();

    JLabel nam = new JLabel("Name");
    JTextField na = new JTextField(null);

    JLabel pass = new JLabel(" Set Password");
    JPasswordField spas = new JPasswordField();

    JLabel phon = new JLabel("Phone Number");
    JTextField pho = new JTextField();

    JLabel accn = new JLabel("Account Number");
    JTextField acc = new JTextField();

    JLabel mailid = new JLabel("Mail ID");
    JTextField mailTextField = new JTextField();

    JLabel credit = new JLabel("Credit Card Number");
    JTextField cerditTextField = new JTextField();

    JButton sig = new JButton("Sign Up");
    JButton bs = new JButton("Go Back");

    ////////////////////////////////////////
    JPanel pr = new JPanel();
    JPanel p = new JPanel();

    JLabel p1 = new JLabel();
    JLabel p2 = new JLabel();
    JLabel p3 = new JLabel();
    JLabel p4 = new JLabel();
    JLabel p5 = new JLabel();
    JLabel p6 = new JLabel();

    ImageIcon i1 = new ImageIcon("sour/qrb.png");
    ImageIcon i2 = new ImageIcon("sour/pacon.jpg");
    ImageIcon i3 = new ImageIcon("sour/rt.png");
    ImageIcon i4 = new ImageIcon("sour/bl.png");
    ImageIcon i5 = new ImageIcon("sour/cr2.png");
    ImageIcon i6 = new ImageIcon("sour/p.png");
    ImageIcon login_backgroundImageIcon= new ImageIcon("sour/gradient2.jpg");

    JButton b = new JButton("Go Back");
    JButton lo = new JButton("Log out");

    String regex, re, mail;
    Pattern pattern, pa, mailPattern;
    Matcher matcher, ma, mailmat;

    finals() {

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setSize(1290, 760);

        f.setLayout(null);

        p.setBounds(0, 0, 1270, 720);
        p.setOpaque(true);
        p.setBackground(Color.black);
        p.setLayout(null);

        pr.setBounds(0, 0, 1270, 720);
        pr.setLayout(null);
        f.add(pr);
        pr.add(p);

        /////////////////////////////// color///////
        Color co = new Color(22, 39, 70);
        // Color co= new Color(21, 37, 67);

        /// {pr root panel on which other panels are added like login, sing up, and
        /// other so that we can remove or dissappear a panel}
    
        ///////////////////////////// login ////////////////////////////////

        pr.add(lp);
        lp.setOpaque(true);
        // lp.setBackground(Color.BLACK);
        lp.setBackground(co);
        lp.setVisible(false);//////////////////////////////////////////////////// set this true later
        lp.setBounds(350, 20, 600, 700);
        lp.setLayout(null);

        pr.add(login_back_imgJLabel);

        lp.add(np);
        // np.setOpaque(true);
        // np.setBackground(Color.red);
        np.setForeground(Color.BLACK);
        np.setBounds(30, 150, 100, 40);
        np.setHorizontalAlignment(JLabel.CENTER);

        nt.setBounds(150, 150, 350, 40);
        lp.add(nt);
        //////////////////////////

        lp.add(pp);
        b.setBackground(co);
        // pp.setOpaque(true);
        // pp.setBackground(Color.red);
        pp.setForeground(Color.BLACK);
        pp.setBounds(30, 250, 100, 40);
        pp.setHorizontalAlignment(JLabel.CENTER);

        pt.setBounds(150, 250, 350, 40);
        lp.add(pt);
        ////////////////////////////

        l.setBounds(300, 400, 100, 50);
        l.setActionCommand("login");
        l.addActionListener(this);
        l.setFocusable(false);
        lp.add(l);

        sn.setBounds(100, 400, 100, 50);
        sn.setActionCommand("sign");
        sn.addActionListener(this);
        sn.setFocusable(false);
        lp.add(sn);

        p.setVisible(true);///////////////////////////////////////// make it false afterwards

        // ///////////////////
        err.setVisible(false);
        er0.setVisible(false);

        ///////////////////////////////////// sign in
        ///////////////////////////////////// ////////////////////////////////////////////

        pr.add(s);
        s.setOpaque(true);
        s.setBackground(Color.GRAY);
        s.setVisible(false);
        s.setBounds(350, 20, 600, 700);
        s.setLayout(null);

        // naml,nat,passl,spast,phonl,phot,accnl,acct,

        nam.setBounds(30, 50, 100, 40);
        s.add(nam);
        na.setBounds(150, 50, 350, 40);
        s.add(na);

        pass.setBounds(30, 150, 100, 40);
        s.add(pass);
        spas.setBounds(150, 150, 350, 40);
        s.add(spas);

        phon.setBounds(30, 250, 100, 40);
        s.add(phon);
        pho.setBounds(150, 250, 350, 40);
        s.add(pho);

        accn.setBounds(30, 350, 100, 40);
        s.add(accn);
        acc.setBounds(150, 350, 350, 40);
        s.add(acc);

        mailid.setBounds(30, 440, 100, 40);
        s.add(mailid);
        mailTextField.setBounds(150, 440, 350, 40);
        s.add(mailTextField);

        credit.setBounds(25, 530, 150, 40);
        s.add(credit);
        cerditTextField.setBounds(150, 530, 350, 40);
        s.add(cerditTextField);

        s.add(sig);
        sig.setBounds(300, 645, 100, 50);
        sig.setActionCommand("signup");
        sig.addActionListener(this);
        sig.setFocusable(false);

        bs.setBounds(150, 645, 100, 50);
        bs.setActionCommand("sign back");
        bs.addActionListener(this);
        bs.setFocusable(false);

        s.add(err1);
        s.add(err2);
        s.add(err3);
        s.add(err4);
        s.add(err5);
        s.add(err6);
        s.add(bs);
        err1.setVisible(false);
        err2.setVisible(false);
        err3.setVisible(false);
        err4.setVisible(false);
        err5.setVisible(false);
        err6.setVisible(false);

        /////////////////////////////////////////////////////////////////////////////////////////

        make(50, 20, 350, 330, i1, "Scan Qr", 0, p1);

        make(450, 20, 350, 330, i2, "Pay Contacts", 0, p2);

        make(850, 20, 350, 330, i3, "PRecent Transaction", 0, p3);

        make(50, 370, 350, 330, i4, "My Bank", 0, p4);

        make(450, 370, 350, 330, i5, "cards", 10, p5);

        make(850, 370, 350, 330, i6, "My profile", 0, p6);

        lo.setActionCommand("logout");
        lo.addActionListener(this);
        lo.setBounds(1200, 650, 80, 50);
        lo.setFocusable(false);
        p.add(lo);
        ////////////////////////////////////////////////////////////////////////

        b.setBounds(0, 0, 100, 50);
        b.addActionListener(this);
        b.setFocusable(false);// back bu

        ////////////////////////////// password
        regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        pattern = Pattern.compile(regex);
        re = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\.).{1,}$";
        pa = Pattern.compile(re);
        mail = "^[a-zA-Z0-9_! #$%&'*+/=?`{|}~^. -]+@[a-zA-Z0-9. -]+$";
        mailPattern = Pattern.compile(mail);

    }

    public void make(int x, int y, int w, int h, ImageIcon i19, String head, int g, JLabel funl) {

        funl.setBounds(x, y, w, h);

        funl.setOpaque(true);
        funl.setBackground(Color.BLACK);
        funl.setIcon(i19);
        funl.setText(head);
        funl.setHorizontalTextPosition(JLabel.CENTER);
        funl.setVerticalTextPosition(JLabel.BOTTOM);
        funl.setVerticalAlignment(JLabel.CENTER);
        funl.setHorizontalAlignment(JLabel.CENTER);
        funl.setIconTextGap(g);
        funl.addMouseListener(this);

        p.add(funl);
    }

    JLabel p7 = new JLabel();
    JPanel jp1 = new JPanel(null);
    JPanel jp2 = new JPanel(null);
    static JPanel jp3 = new JPanel(null);
    JPanel jp4 = new JPanel(null);
    JPanel jp5 = new JPanel(null);
    JPanel jp6 = new JPanel(null);

    JPanel pj1 = new JPanel();
    JPanel pj2 = new JPanel();
    JPanel pj3 = new JPanel();
    JPanel pj4 = new JPanel();
    JPanel pj5 = new JPanel();
    JPanel pj6 = new JPanel();

    JPanel pj41 = new JPanel();
    JLabel payment_success = new JLabel();

    String namedisplay;
    String passdisplay;
    static String accndisplay;
    static String carddisplay;
    static String phonedisplay;
    static String maildisplay;
    static String amountdisplay;
    // String accndisplay= userdetails.get(3);
    // String carddisplay= userdetails.get(5);
    // String phonedisplay= userdetails.get(2);
    // String maildisplay=userdetails.get(4);

    JLabel banktrans_name_Label = new JLabel("Name");
    JTextField banktrans_name_TextField = new JTextField();
    JLabel banktrans_acc_Label = new JLabel("Account number");
    JTextField banktrans_acc_TextField = new JTextField();
    JLabel banktrans_ammont_Label = new JLabel("Amount");
    JTextField banktrans_amont_TextField = new JTextField();
    JButton bankpayButton = new JButton("PAY");

    String bank_name_fetch;
    String bank_acc_fetch;
    String bank_amu_fetch;
    String bank_success;
    int payed = 0;

    JLabel err_bank_pay_name = new JLabel("Enter the correct name (Raja.R)");
    JLabel err_bank_pay_accn = new JLabel("Enter correct account number");
    JLabel err_bank_pay_amount = new JLabel("you don't have enough monry");

    JLabel phone_no_trans = new JLabel("Phone Number ");
    JTextField phone_no_transTextField = new JTextField();
    JLabel err_phone_trans = new JLabel("Enter correct Phone NUmber");
    JLabel phone_no_trans_amu = new JLabel("Amount");
    JTextField phone_no_amuJTextField = new JTextField();
    JLabel err_phone_trans_amu = new JLabel("Amount Underflow");
    JButton phone_transButton = new JButton("Pay");

    JLabel phone_no_success = new JLabel();

    static int z;
    static String phone_no_success_name;

    JTextArea recent_transaction_details_area = new JTextArea("\n\n");
    static JTextArea ta = new JTextArea();

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel E = (JLabel) e.getSource();

        makepanels(jp1);
        makepanels(jp2);
        makepanels(jp3);
        makepanels(jp4);
        makepanels(jp5);
        makepanels(jp6);
        // pr.add(p7);
        p.setVisible(true);

        makesubpanels(pj2);
        makesubpanels(pj3);
        makesubpanels(pj4);
        makesubpanels(pj5);
        makesubpanels(pj6);
        makesubpanels(pj41);
        pj41.setVisible(false);

        if ((E == p1)) {
            System.out.println("Click");
            p.setVisible(false);
            jp1.setVisible(true);
            jp1.add(b);
            System.out.println("p1");
            b.setActionCommand("p1");

        } else if ((E == p2)) {
            b.setActionCommand("p2");
            p.setVisible(false);
            jp2.setVisible(true);
            jp2.add(b);
            jp2.add(pj2);

            phone_no_trans.setBounds(50, 50, 100, 40);
            phone_no_trans.setOpaque(true);
            phone_no_trans.setBackground(Color.WHITE);
            phone_no_trans.setForeground(Color.BLACK);
            pj2.add(phone_no_trans);

            phone_no_transTextField.setBounds(150, 50, 350, 40);
            pj2.add(phone_no_transTextField);

            err_phone_trans.setBounds(150, 100, 350, 40);
            err_phone_trans.setOpaque(true);
            err_phone_trans.setBackground(Color.WHITE);
            err_phone_trans.setForeground(Color.RED);
            pj2.add(err_phone_trans);
            err_phone_trans.setVisible(false);

            phone_no_trans_amu.setBounds(50, 150, 100, 40);
            phone_no_trans_amu.setOpaque(true);
            phone_no_trans_amu.setBackground(Color.WHITE);
            phone_no_trans_amu.setForeground(Color.BLACK);
            pj2.add(phone_no_trans_amu);

            phone_no_amuJTextField.setBounds(150, 150, 350, 40);
            phone_no_amuJTextField.setText("0");
            pj2.add(phone_no_amuJTextField);

            err_phone_trans_amu.setBounds(150, 190, 350, 40);
            err_phone_trans_amu.setOpaque(true);
            err_phone_trans_amu.setBackground(Color.WHITE);
            err_phone_trans_amu.setForeground(Color.RED);
            pj2.add(err_phone_trans_amu);
            err_phone_trans_amu.setVisible(false);

            phone_no_success.setBounds(100, 400, 400, 40);
            phone_no_success.setOpaque(true);
            phone_no_success.setBackground(Color.WHITE);
            phone_no_success.setForeground(Color.BLACK);
            pj2.add(phone_no_success);
            phone_no_success.setVisible(false);

            phone_transButton.setBounds(200, 600, 100, 40);
            phone_transButton.setFocusable(false);
            phone_transButton.addActionListener(this);
            phone_transButton.setActionCommand("phone pay");
            pj2.add(phone_transButton);

            // contents(2);
            System.out.println("p2");
        } else if ((E == p3)) {
            b.setActionCommand("p3");
            p.setVisible(false);
            jp3.setVisible(true);
            jp3.add(b);
            jp3.add(pj3);
            ta.setLayout(null);
            ta.setBounds(350, 65, 800, 600);
            ta.setVisible(true);
            // ta.setBackground(Color.BLUE);
            ta.setFont(new Font("Times New Roman", Font.BOLD, 25));
            
            transctation();
            // contents(3);
            System.out.println("p3");
        } else if ((E == p4)) {
            b.setActionCommand("p4");
            p.setVisible(false);
            jp4.setVisible(true);
            jp4.add(b);
            jp4.add(pj4);
            jp4.add(pj41);
            // contents(4);
            System.out.println("p4");

            banktrans_name_Label.setBounds(10, 40, 100, 40);
            banktrans_name_Label.setOpaque(true);
            banktrans_name_Label.setBackground(Color.WHITE);
            banktrans_name_Label.setForeground(Color.BLACK);
            pj4.add(banktrans_name_Label);

            banktrans_name_TextField.setBounds(150, 40, 350, 40);
            pj4.add(banktrans_name_TextField);

            err_bank_pay_name.setBounds(150, 80, 350, 40);
            err_bank_pay_name.setForeground(Color.RED);
            pj4.add(err_bank_pay_name);
            err_bank_pay_name.setVisible(false);

            banktrans_acc_Label.setBounds(10, 120, 100, 40);
            banktrans_acc_Label.setOpaque(true);
            banktrans_acc_Label.setBackground(Color.WHITE);
            banktrans_acc_Label.setForeground(Color.BLACK);
            pj4.add(banktrans_acc_Label);

            banktrans_acc_TextField.setBounds(150, 120, 350, 40);
            pj4.add(banktrans_acc_TextField);

            err_bank_pay_accn.setBounds(150, 160, 350, 40);
            err_bank_pay_accn.setForeground(Color.RED);
            pj4.add(err_bank_pay_accn);
            err_bank_pay_accn.setVisible(false);

            banktrans_ammont_Label.setBounds(10, 200, 100, 40);
            banktrans_ammont_Label.setOpaque(true);
            banktrans_ammont_Label.setBackground(Color.WHITE);
            banktrans_ammont_Label.setForeground(Color.BLACK);
            pj4.add(banktrans_ammont_Label);

            banktrans_amont_TextField.setBounds(150, 200, 350, 40);
            pj4.add(banktrans_amont_TextField);
            banktrans_amont_TextField.setText("0");

            err_bank_pay_amount.setBounds(150, 240, 350, 40);
            err_bank_pay_amount.setForeground(Color.RED);
            pj4.add(err_bank_pay_amount);
            err_bank_pay_amount.setVisible(false);

            bankpayButton.setBounds(150, 350, 100, 40);
            bankpayButton.setFocusable(false);
            bankpayButton.setActionCommand("bank_pay");
            bankpayButton.setOpaque(true);
            bankpayButton.setForeground(Color.BLACK);
            bankpayButton.setBackground(Color.blue);
            bankpayButton.addActionListener(this);
            pj4.add(bankpayButton);

        } else if ((E == p5)) {
            b.setActionCommand("p5");
            p.setVisible(false);
            jp5.setVisible(true);
            jp5.add(b);
            jp5.add(pj5);
            // contents(5);
            System.out.println("p5");
        } else if ((E == p6)) {
            b.setActionCommand("p6");
            p.setVisible(false);
            jp6.setVisible(true);
            jp6.add(b);
            jp6.add(pj6);
            // contents(6);

            System.out.println(amountdisplay);
            String detail[] = new String[7];
            detail[0] = "Name :" + namedisplay;
            detail[1] = "Password : " + passdisplay;
            detail[2] = "Account Number : " + accndisplay;
            detail[3] = "Balance Amount : " + amountdisplay;
            detail[4] = "Phone Number : " + phonedisplay;
            detail[5] = "Cedit Card Number : " + carddisplay;
            detail[6] = "Mail Id : " + maildisplay;

            JLabel my_profile_heading = new JLabel();
            // makedisplaylabel(0, 0, my_profile_heading, pj6);
            my_profile_heading.setBounds(550, 10, 250, 40);
            pj6.add(my_profile_heading);
            my_profile_heading.setText("  MY PROFILE  ");

            recent_transaction_details_area.setLayout(null);
            recent_transaction_details_area.setBounds(40, 70, 1190, 640);
            recent_transaction_details_area.setFont(new Font("Times New Roman", Font.BOLD, 15));

            amountdisplay = userdetails.get(6);

            for (int i = 0; i < 7; i++) {
                recent_transaction_details_area.append(detail[i] + "\n\n");
            }
            pj6.add(recent_transaction_details_area);
            recent_transaction_details_area.setEditable(false);
            System.out.println("p6");
        }

    }

    // void makedisplaylabel(int x, int y, JLabel disp, JPanel father) {

    // disp.setBounds(x, y, 295, 40);
    // disp.setOpaque(true);
    // disp.setBackground(Color.WHITE);
    // disp.setForeground(Color.BLACK);
    // disp.setVerticalTextPosition(JLabel.NORTH_WEST);
    // father.add(disp);
    // }

    void makepanels(JPanel pan) {
        pan.setBounds(0, 0, 1270, 720);
        pan.setOpaque(true);
        pan.setBackground(Color.GREEN);

        pr.add(pan);
        pan.setVisible(false);
    }

    void makesubpanels(JPanel subpan) {
        subpan.setBounds(50, 60, 1200, 650);
        subpan.setOpaque(true);
        subpan.setBackground(Color.WHITE);
        subpan.setLayout(null);
        subpan.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JLabel E = (JLabel) e.getSource();

        if ((E == p1) || (E == p2) || (E == p3) || (E == p4) || (E == p5) || (E == p6)) {
            E.setBackground(Color.GRAY);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JLabel E = (JLabel) e.getSource();

        if ((E == p1) || (E == p2) || (E == p3) || (E == p4) || (E == p5) || (E == p6)) {
            E.setBackground(Color.BLACK);
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel E = (JLabel) e.getSource();

        if ((E == p1) || (E == p2) || (E == p3) || (E == p4) || (E == p5) || (E == p6)) {
            E.setSize(360, 340);
            // pr.remove(p);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel E = (JLabel) e.getSource();

        if ((E == p1) || (E == p2) || (E == p3) || (E == p4) || (E == p5) || (E == p6)) {
            E.setSize(350, 330);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String b1 = (String) e.getActionCommand();
        if (b1 == "p1") {
            System.out.println("but click");
            p.setVisible(true);
            jp1.setVisible(false);
        } else if (b1 == "p2") {
            p.setVisible(true);
            jp2.setVisible(false);
            amountdisplay = userdetails.get(6);
            phone_no_transTextField.setText(null);

        } else if (b1 == "p3") {
            p.setVisible(true);
            jp3.setVisible(false);
            transctation();
            amountdisplay = userdetails.get(6);
            ta.setText(null);
        } else if (b1 == "p4") {
            p.setVisible(true);
            jp4.setVisible(false);
            banktrans_name_TextField.setText(null);
            banktrans_acc_TextField.setText(null);
            banktrans_amont_TextField.setText(null);
            amountdisplay = userdetails.get(6);
        } else if (b1 == "p5") {
            p.setVisible(true);
            jp5.setVisible(false);
        } else if (b1 == "p6") {
            p.setVisible(true);
            jp6.setVisible(false);
            amountdisplay = userdetails.get(6);
            recent_transaction_details_area.setText(null);
        } else if (b1 == "login") {

            try {
                lp.add(err);
                lp.add(er0);

                String ct = nt.getText();
                char[] cp = pt.getPassword();
                String pas = new String(cp);
                // System.out.println(pas);
                namedisplay = ct;
                passdisplay = pas;
                matcher = pattern.matcher(pas);
                ma = pa.matcher(ct);

                if (ma.matches()) {
                    er0.setVisible(false);

                } else {
                    System.out.println(ma.matches());
                    er0.setBounds(150, 190, 350, 40);
                    er0.setForeground(Color.RED);
                    er0.setText("Enter the user name correctly(as per passbook(eg:-Raja.R))");
                    er0.setVisible(true);
                }

                // System.out.println(matcher.matches());

                if (matcher.matches()) {
                    err.setVisible(false);
                } else {
                    err.setBounds(150, 290, 400, 40);
                    err.setForeground(Color.RED);
                    err.setText("Incorrect (atleast 1 Upper,1 lower,case 1 number,minimum length 8)");
                    err.setVisible(true);
                }

                int i = filescheck(ct, pas);
                if (i == -1) {
                    err.setBounds(150, 290, 400, 40);
                    err.setForeground(Color.RED);
                    err.setText("Incorrect (atleast 1 Upper,1 lower,case 1 number,minimum length 8)");
                    err.setVisible(true);

                    er0.setBounds(150, 190, 350, 40);
                    er0.setForeground(Color.RED);
                    er0.setText("Enter the user name correctly(as per passbook(eg:-Raja.R))");
                    er0.setVisible(true);

                } else if (i == 1) {
                    err.setBounds(150, 290, 400, 40);
                    err.setForeground(Color.RED);
                    err.setText("Incorrect (atleast 1 Upper,1 lower,case 1 number,minimum length 8)");
                    err.setVisible(true);
                }

                if (matcher.matches() && ma.matches() && i == 2) {
                    p.setVisible(true);
                    lp.setVisible(false);
                    nt.setText("");
                    pt.setText("");
                }

            } catch (Exception x) {
                np = null;
            }

        } else if (b1 == "logout") {
            p.setVisible(false);
            lp.setVisible(true);
        } else if (b1 == "sign") {
            lp.setVisible(false);
            s.setVisible(true);
        } else if (b1 == "signup") {

            int p = 0, ac = 0;

            String names = na.getText();
            System.out.println(names);
            ma = pa.matcher(names);

            if (ma.matches()) {
                // System.out.println("name check");
                err1.setVisible(false);

            } else {

                err1.setBounds(150, 90, 350, 40);
                err1.setForeground(Color.RED);
                err1.setText("Enter your full name(as per passbook)(eg:-Raja.R)");
                err1.setVisible(true);
            }

            char[] password = spas.getPassword();
            String pass = new String(password);
            matcher = pattern.matcher(pass);

            if (matcher.matches()) {

                System.out.println("pass check");

                err2.setVisible(false);
            } else {
                err2.setBounds(150, 190, 350, 40);
                err2.setForeground(Color.RED);
                err2.setText("Incorrect (atleast 1 Upper, 1 lower,case 1 number,minimum length 8)");
                err2.setVisible(true);
            }

            String phone = pho.getText();

            if (phone.length() != 10) {

                err3.setBounds(150, 290, 350, 40);
                err3.setForeground(Color.RED);
                err3.setText("Enter valid Phone number");
                err3.setVisible(true);
            } else {
                System.out.println("phine check");
                err3.setVisible(false);
                p = 1;
            }

            String account = acc.getText();
            if (account.length() != 12) {
                err4.setBounds(150, 390, 350, 40);
                err4.setForeground(Color.RED);
                err4.setText("enter correct account number");
                err4.setVisible(true);
            } else {
                ac = 1;
                err4.setVisible(false);
            }
            String mailString = mailTextField.getText();
            mailmat = pattern.matcher(mailString);

            if (mailmat.matches()) {
                err5.setVisible(false);
            } else {
                err5.setBounds(150, 490, 350, 40);
                err5.setText("invaid");
                err5.setForeground(Color.RED);
                err5.setVisible(true);
            }

            String cardnum = cerditTextField.getText();
            int cn = 0;
            if (cardnum.length() >= 13 && cardnum.length() <= 16) {
                err6.setVisible(false);
                cn = 1;
            } else {
                err6.setBounds(150, 570, 350, 40);
                err6.setText("Invalid card");
                err6.setForeground(Color.RED);
                err6.setVisible(true);
            }

            if (ma.matches() && matcher.matches() && ac == 1 && p == 1 && mailmat.matches() && cn == 1) {
                lp.setVisible(true);
                s.setVisible(false);
                na.setText(null);
                spas.setText(null);
                pho.setText(null);
                acc.setText(null);
                mailTextField.setText(null);
                cerditTextField.setText(null);
                files(names, pass, phone, account, mailString, cardnum);
            }
        } else if (b1 == "sign back") {
            lp.setVisible(true);
            s.setVisible(false);
            err1.setVisible(false);
            err2.setVisible(false);
            err3.setVisible(false);
            err4.setVisible(false);
            err.setVisible(false);
            er0.setVisible(false);
        } else if (b1 == "bank_pay") {

            bank_name_fetch = banktrans_name_TextField.getText();
            System.out.println(bank_name_fetch);
            bank_acc_fetch = banktrans_acc_TextField.getText();
            System.out.println(bank_acc_fetch);

            bank_amu_fetch = banktrans_amont_TextField.getText();
            System.out.println(bank_amu_fetch);
            if (bank_amu_fetch != null) {

                int amu = Integer.valueOf(bank_amu_fetch);

                int i = transfer_amount(amu, bank_name_fetch, bank_acc_fetch);
                System.out.println(i);

                if (i == 3) {
                    pj4.setVisible(false);
                    pj41.setVisible(true);
                    bank_success = "Amount :" + bank_amu_fetch + " has been succesfully Transacted to : "
                            + bank_name_fetch
                            + " account Number : " + bank_acc_fetch;
                    payed = 1;

                    payment_success.setBounds(30, 30, 1000, 500);

                    payment_success.setText(bank_success);
                    payment_success.setFont(new Font("Times New Roman", Font.BOLD, 19));
                    pj41.add(payment_success);
                    err_bank_pay_accn.setVisible(false);
                    err_bank_pay_amount.setVisible(false);
                    err_bank_pay_name.setVisible(false);
                } else if (i == 2) {
                    err_bank_pay_amount.setVisible(true);
                    err_bank_pay_name.setVisible(false);
                    err_bank_pay_accn.setVisible(false);
                } else if (i == 1) {
                    err_bank_pay_amount.setVisible(true);
                    err_bank_pay_accn.setVisible(true);
                    err_bank_pay_name.setVisible(false);
                } else {

                    err_bank_pay_amount.setVisible(true);
                    err_bank_pay_accn.setVisible(true);
                    err_bank_pay_name.setVisible(true);
                }
            } else {

                err_bank_pay_amount.setVisible(true);
                err_bank_pay_accn.setVisible(true);
                err_bank_pay_name.setVisible(true);
            }

            System.out.println("payed through bank");
        } else if (b1 == "phone pay") {
            System.out.println("Phone pe button clicked");
            String phone_nu = phone_no_transTextField.getText();
            System.out.println(phone_nu);
            String phone_pe_amunt = phone_no_amuJTextField.getText();
            int phone_trans_amu = Integer.valueOf(phone_pe_amunt);
            System.out.println(z);
            payment_phone(phone_nu, phone_trans_amu);
            if (z == 1) {
                err_phone_trans.setVisible(true);
                err_phone_trans_amu.setVisible(true);
            } else if (z == 2) {
                err_phone_trans.setVisible(false);
                err_phone_trans_amu.setVisible(true);
            } else {
                err_phone_trans.setVisible(false);
                err_phone_trans_amu.setVisible(false);

                String succeString = "The Amount : " + phone_pe_amunt + " has been transfered to : "
                        + phone_no_success_name + "," + phone_nu;
                phone_no_success.setText(succeString);
                phone_no_success.setVisible(true);
                phone_no_amuJTextField.setText("0");
                phone_no_transTextField.setText(null);
            }

        }

    }

    public static void files(String names, String password, String phone, String account, String mailid,
            String credit) {
        try {
            FileWriter f = new FileWriter("E:/JAV/user files/" + names + ".txt", true);
            f.write(names + "\n");
            f.write(password + "\n");
            f.write(phone + "\n");
            f.write(account + "\n");
            f.write(mailid + "\n");
            f.write(credit + "\n");
            f.write(10000 + "\n");
            f.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    static int filescheck(String username, String password) {

        try {
            String filename = "E:/JAV/user files/" + username + ".txt";
            File f = new File(filename);
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                userdetails.add(sc.nextLine());
            }
            System.out.println(userdetails.get(0));
            String fileusername = userdetails.get(0);
            String filepassword = userdetails.get(1);
            String filephone = userdetails.get(2);
            String fileaccountnumber = userdetails.get(3);
            String filemailid = userdetails.get(4);
            String filecreditnum = userdetails.get(5);
            if (username.equals(fileusername)) {
                if (password.equals(filepassword)) {
                    System.out.println("Successfully registered");
                    System.out.println("phone number:" + filephone);
                    System.out.println("phone number:" + filemailid);
                    System.out.println("phone number:" + filecreditnum);
                    accndisplay = userdetails.get(3);
                    carddisplay = userdetails.get(5);
                    phonedisplay = userdetails.get(2);
                    maildisplay = userdetails.get(4);
                    amountdisplay = userdetails.get(6);
                    return 2;
                } else
                    return 1;
            } else {
                System.out.println("Error in the password");
                return -1;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return 0;
    }

    public static int transfer_amount(int amount, String name, String acno) {

        ArrayList<String> anotherdetails = new ArrayList<>();
        // System.out.println("enter the account number");
        // Scanner s=new Scanner(System.in);
        // String acno=s.nextLine();
        try {
            File f = new File("E:/JAV/user files/" + name + ".txt");
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                anotherdetails.add(sc.nextLine());
            }

            if (anotherdetails.get(3).equals(acno)) {

                int receiver_amount = Integer.valueOf(anotherdetails.get(6));
                int sender_amount = Integer.valueOf(userdetails.get(6));

                if (sender_amount - amount > 1000 && amount > 0) {
                    System.out.println("All correct");
                    sender_amount -= amount;
                    receiver_amount += amount;
                    String sendamount = String.valueOf(sender_amount);
                    String receiveamount = String.valueOf(receiver_amount);
                    userdetails.set(6, sendamount);
                    anotherdetails.set(6, receiveamount);
                    last(2, amount, userdetails.get(0), userdetails);
                    last(1, amount, anotherdetails.get(0), anotherdetails);

                    return 3;
                } else {
                    System.out.println("account correct");
                    return 2;

                }
            } else {
                System.out.println("name correct");
                return 1;
            }
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public static void last(int n, int amount, String username, ArrayList<String> list) {
        System.out.println(list.size());
        java.util.Date date = new java.util.Date();

        try {
            FileWriter f = new FileWriter("E:/JAV/user files/" + username + ".txt");
            for (int i = 0; i < list.size(); i++) {
                f.write(list.get(i) + "\n");
                System.out.println(list.get(i));
            }
            if (n == 1) {
                list.add("credited amount is : " + amount + ", " + date);
                f.write("credited amount is : " + amount + ", " + date + "\n");
            } else {
                list.add("Debited amount is : " + amount + ", " + date + "\n");
                f.write("Debited amount is : " + amount + ", " + date);
            }

            f.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void transctation() {

        ta.append("         ________TRACTION LIST_______       \n\n\n");
        for (int i = userdetails.size() - 1; i > 6; i--) {
            ta.append(userdetails.get(i) + "\n");
            ta.setFont(new Font("Times New Roman", Font.BOLD, 20));
            // ta.setForeground(Color.red);
        }
        jp3.add(ta);
        ta.setEditable(false);
        
    }

    public static void payment_phone(String phone, int amount) {
        String str;
        ArrayList<String> arr = new ArrayList<>();
        try {
            File file = new File("E:/JAV/user files/allfiles.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                str = sc.nextLine();
                arr.add(String.valueOf(str));
                // System.out.println(str);
            }
            sc.close();
            int i = 0;
            while (i < arr.size()) {
                String[] array = arr.get(i).split(",");
                // System.out.println(arr.size());
                if (array[1].equals(phone)) {
                    System.out.println("user name is :" + array[0]);
                    z = transfer_amount(amount, array[0], array[2]);
                    phone_no_success_name = array[0];
                    break;
                } else if (i == arr.size() - 1) {
                    System.out.println("not possible\n");
                    z = 1;
                }
                i++;

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
