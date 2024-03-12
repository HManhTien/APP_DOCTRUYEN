package vn.edu.btl.model;

public class Truyen {

    private int ID;
    private String Tentruyen , Noidung , Anh ;
    private int ID_TK;

    public Truyen(String tentruyen, String noidung, String anh, int ID_TK) {
        Tentruyen = tentruyen;
        Noidung = noidung;
        Anh = anh;
        this.ID_TK = ID_TK;
    }

    public Truyen(int ID, String tentruyen, String noidung, String anh, int ID_TK) {
        this.ID = ID;
        Tentruyen = tentruyen;
        Noidung = noidung;
        Anh = anh;
        this.ID_TK = ID_TK;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTentruyen() {
        return Tentruyen;
    }

    public void setTentruyen(String tentruyen) {
        Tentruyen = tentruyen;
    }

    public String getNoidung() {
        return Noidung;
    }

    public void setNoidung(String noidung) {
        Noidung = noidung;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String anh) {
        Anh = anh;
    }

    public int getID_TK() {
        return ID_TK;
    }

    public void setID_TK(int ID_TK) {
        this.ID_TK = ID_TK;
    }
}

