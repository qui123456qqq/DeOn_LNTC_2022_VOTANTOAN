package Cau_4;

import Cau_3.Company;
import Cau_3.Date;
import Cau_3.NhanVien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View extends JFrame implements ActionListener {
    JPanel jPanel_Main;
    JLabel nameStaff_lb, birth_lb, gender_lb, basicSalary_lb;
    JTextField tf_NameStaff, tf_Birth, tf_gender, tf_BasicSalary;
    JButton btn_Add, btn_DeleteAll, btn_Exit;
    JTextArea jTextArea;
    static Company company ;

    public View() {
        company = new Company();
        setSize(600, 350);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        init();
        data();
        action();
        setVisible(true);
    }



    private void action() {
        this.btn_Add.addActionListener(this);
        this.btn_Exit.addActionListener(this);
        this.btn_DeleteAll.addActionListener(this);
    }



    private void init() {
        JPanel panel_In = new JPanel();
        panel_In.setLayout(new GridLayout(4, 2));
        nameStaff_lb = new JLabel("Ten nhan vien", SwingConstants.RIGHT);
        birth_lb = new JLabel("Ngay sinh", SwingConstants.RIGHT);
        gender_lb = new JLabel("Gioi tinh", SwingConstants.RIGHT);
        basicSalary_lb = new JLabel("Luong co ban", SwingConstants.RIGHT);
        tf_BasicSalary = new JTextField(20);
        tf_Birth = new JTextField(20);
        tf_gender = new JTextField(20);
        tf_NameStaff = new JTextField(20);
        panel_In.add(nameStaff_lb);
        panel_In.add(tf_NameStaff);
        panel_In.add(birth_lb);
        panel_In.add(tf_Birth);
        panel_In.add(gender_lb);
        panel_In.add(tf_gender);
        panel_In.add(basicSalary_lb);
        panel_In.add(tf_BasicSalary);

        /*

         */
        JPanel jPanel_Function = new JPanel();
        JPanel jPanel_Text = new JPanel();
        btn_Add = new JButton("Them");
        btn_DeleteAll = new JButton("Xoa tat ca");
        btn_DeleteAll.setEnabled(false);
        btn_Exit = new JButton("Thoat");
        jTextArea = new JTextArea(10, 50);
        jTextArea.setText("     Ten NV" + "\t\t" + "Ngay sinh" + "\tGioi tinh" + "\tLuong co ban\n");
        jPanel_Function.add(btn_Add);
        jPanel_Function.add(btn_DeleteAll);
        jPanel_Function.add(btn_Exit);
        jPanel_Text.add(jTextArea);


        this.add(panel_In, BorderLayout.NORTH);
        this.add(jPanel_Function, BorderLayout.CENTER);
        this.add(jPanel_Text, BorderLayout.SOUTH);

    }
    private void data() {
        NhanVien nv1 = new NhanVien("Vo Tan Toan",
                new Date(1, 2, 2000), "Nam", 600000);
        NhanVien nv3 = new NhanVien("Dang Thi C",
                new Date(1, 3, 2000), "Nam", 1000000);
        ArrayList<NhanVien> list = company.getListNhanVien();
        list.add(nv1);
        list.add(nv3);
//        company = new Company(list);
    }
    private String printOut() {
        String titleBar = company.out();
        jTextArea.setText(titleBar);
        return titleBar;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btn_Exit) {
            System.exit(0);
        }
        if (e.getSource() == this.btn_Add) {

            String name = tf_NameStaff.getText();
            int day = Integer.parseInt(tf_Birth.getText().split("/")[0]);
            int month = Integer.parseInt(tf_Birth.getText().split("/")[1]);
            int year = Integer.parseInt(tf_Birth.getText().split("/")[2]);
            Date date = new Date(day, month, year);
            String gender = tf_gender.getText();
            double basicSalary = Double.parseDouble(tf_BasicSalary.getText());
            boolean check = company.checkNV(new NhanVien(name, date, gender, basicSalary));
            if (check == false) {
                JOptionPane.showMessageDialog(null, "Da ton tai");
                return;
            } else {
//                this.jTextArea.setText("Ten NV" + "\t\t" + "Ngay sinh" + "\tGioi tinh" + "\tLuong co ban\n");
                printOut();
            }
            tf_Birth.setText("");
            tf_gender.setText("");
            tf_NameStaff.setText("");
            tf_BasicSalary.setText("");
            btn_DeleteAll.setEnabled(true);
        }
        if (e.getSource() == this.btn_DeleteAll) {
            company.deleteNhanVien();
            jTextArea.setText("     Ten NV" + "\t\t" + "Ngay sinh" + "\tGioi tinh" + "\tLuong co ban\n");
        }
    }
}
