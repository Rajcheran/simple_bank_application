package sour;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;////password

import javax.swing.*;

public class experi2 implements MouseListener, ActionListener {
    JFrame f = new JFrame();

    // Webcam wc= Webcam.getDefault();
    ///////////////
    JPanel lp = new JPanel();
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

    JButton b = new JButton("Go Back");
    JButton lo = new JButton("Log out");

    String regex, re, mail;
    Pattern pattern, pa, mailPattern;
    Matcher matcher, ma, mailmat;

    experi2() {

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
        lp.setVisible(true);//////////////////////////////////////////////////// set this true later
        lp.setBounds(350, 20, 600, 700);
        lp.setLayout(null);

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

        p.setVisible(false);///////////////////////////////////////// make it false afterwards

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
    JPanel jp3 = new JPanel(null);
    JPanel jp4 = new JPanel(null);
    JPanel jp5 = new JPanel(null);
    JPanel jp6 = new JPanel(null);

    String namedisplay;

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel E = (JLabel) e.getSource();

        // p7.setBounds(0, 0, 1270, 720);
        // p7.setOpaque(true);
        // p7.setBackground(Color.GREEN);
        // p7.add(b);
        // p7.setVisible(false);

        makepanels(jp1);
        makepanels(jp2);
        makepanels(jp3);
        makepanels(jp4);
        makepanels(jp5);
        makepanels(jp6);
        // pr.add(p7);
        p.setVisible(true);
        

        JLabel detaiLabel[] = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            detaiLabel[i] = new JLabel();
            detaiLabel[i].setVisible(false);
        }

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
            System.out.println("p2");
        } else if ((E == p3)) {
            b.setActionCommand("p3");
            p.setVisible(false);
            jp3.setVisible(true);
            jp3.add(b);
            System.out.println("p3");
        } else if ((E == p4)) {
            b.setActionCommand("p4");
            p.setVisible(false);
            jp4.setVisible(true);
            jp4.add(b);
            System.out.println("p4");
        } else if ((E == p5)) {
            b.setActionCommand("p5");
            p.setVisible(false);
            jp5.setVisible(true);
            jp5.add(b);
            System.out.println("p5");
        } else if ((E == p6)) {
            b.setActionCommand("p6");
            p.setVisible(false);
            jp6.setVisible(true);
            jp6.add(b);
            JLabel detailpanel = new JLabel();

            detailpanel.setVisible(true);
            String detail[] = new String[6];
            detail[1] = "Name :" + namedisplay;

            detaiLabel[1] = new JLabel();
            makedisplaylabel(10, 40, 20, detaiLabel[1], detail[1]);
            detailpanel.add(detaiLabel[1]);

            detaiLabel[1].setVisible(true);

            System.out.println("p6");
        }

    }

    // detailpanel.setBounds(50, 60, 1200, 650);
    void makedisplaylabel(int x, int y, int height, JLabel disp, String text) {
        // disp = new JLabel();
        disp.setBounds(x, y, 295, height);
        disp.setText(text);
        disp.setOpaque(true);
        disp.setBackground(Color.BLACK);
        disp.setHorizontalTextPosition(JLabel.CENTER);
        disp.setVerticalTextPosition(JLabel.CENTER);
    }

    void makepanels(JPanel pan) {
        pan.setBounds(0, 0, 1270, 720);
        pan.setOpaque(true);
        pan.setBackground(Color.GREEN);
       
        pr.add(pan);
        pan.setVisible(false);
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
        } else if (b1 == "p3") {
            p.setVisible(true);
            jp3.setVisible(false);
        } else if (b1 == "p4") {
            p.setVisible(true);
            jp4.setVisible(false);
        } else if (b1 == "p5") {
            p.setVisible(true);
            jp5.setVisible(false);
        } else if (b1 == "p6") {
            p.setVisible(true);
            jp6.setVisible(false);
        } else if (b1 == "login") {

            try {
                lp.add(err);
                lp.add(er0);

                String ct = nt.getText();
                char[] cp = pt.getPassword();
                String pas = new String(cp);
                // System.out.println(pas);
                namedisplay = ct;

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
            f.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        // try {
        // File f = new File("E:/JAV/user files/" + names + ".txt");
        // Scanner sc = new Scanner(f);
        // String str;
        // while (sc.hasNextLine()) {
        // str = sc.nextLine();
        // System.out.println(str);
        // }
        // } catch (Exception e) {
        // System.out.println(e);
        // }
    }

    static int filescheck(String username, String password) {
        ArrayList<String> userdetails = new ArrayList<>();
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

}
