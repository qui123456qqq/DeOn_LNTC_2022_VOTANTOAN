package Cau_3;

import java.util.Objects;

public class NhanVien {
    private int idNV;
    private String name;
    private Date birth;
    private String gender;
    private double basicSalary;

    public NhanVien(String name, Date birth, String gender, double basicSalary) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.basicSalary = basicSalary;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NhanVien nhanVien = (NhanVien) o;
        return Double.compare(nhanVien.basicSalary, basicSalary) == 0 && Objects.equals(name, nhanVien.name) && Objects.equals(birth, nhanVien.birth) && Objects.equals(gender, nhanVien.gender);
    }

    @Override
    public String toString() {

        return "  "+ name + "\t\t" + birth + "\t" + gender + "\t" + basicSalary + "\n";
    }
}
