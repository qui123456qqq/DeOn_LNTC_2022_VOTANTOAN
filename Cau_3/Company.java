package Cau_3;

import java.util.ArrayList;

public class Company {
    private ArrayList<NhanVien> listNhanVien;

    public ArrayList<NhanVien> getListNhanVien() {
        return listNhanVien;
    }

    public void setListNhanVien(ArrayList<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
    }

    public Company() {
        listNhanVien = new ArrayList<NhanVien>();
    }

    public Company(ArrayList<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
    }

    public boolean checkNV(NhanVien nhanVien) {
        if (listNhanVien.contains(nhanVien))
            return false;
        listNhanVien.add(nhanVien);
        return true;
    }

    public void deleteNhanVien() {
        listNhanVien.removeAll(listNhanVien);
    }

    public String out() {
        String result = "     Ten NV" + "\t\t" + "Ngay sinh" + "\tGioi tinh" + "\tLuong co ban\n";
        int count = 0;
        for (NhanVien nhanVien : this.listNhanVien) {
            result += count++ + nhanVien.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        NhanVien nv1 = new NhanVien("Vo Tan Toan",
                new Date(1, 2, 2000), "Nam", 600000);
        NhanVien nv2 = new NhanVien("Nguyen Van A",
                new Date(5, 12, 2000), "Nam", 800000);
        NhanVien nv3 = new NhanVien("Dang Thi C",
                new Date(1, 3, 2000), "Nam", 1000000);
        Company company = new Company();
        ArrayList<NhanVien> list = company.getListNhanVien();
        list.add(nv1);
        list.add(nv2);
        list.add(nv3);
        for (NhanVien nhanVien : list) {
            System.out.println(nhanVien.toString());
        }
    }
}
