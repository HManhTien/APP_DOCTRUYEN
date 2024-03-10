package vn.edu.btl.model;

public class taikhoan {
    private int mId;
    private String mTaiKhoan;
    private String mMatKhau;
    private String mEmaill;
    private int mPhanQuyen;

    public taikhoan(String mTaiKhoan, String mMatKhau, String mEmaill, int mPhanQuyen) {
        this.mTaiKhoan = mTaiKhoan;
        this.mMatKhau = mMatKhau;
        this.mEmaill = mEmaill;
        this.mPhanQuyen = mPhanQuyen;
    }

    public taikhoan(String mTaiKhoan, String mEmaill) {
        this.mTaiKhoan = mTaiKhoan;
        this.mEmaill = mEmaill;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmTaiKhoan() {
        return mTaiKhoan;
    }

    public void setmTaiKhoan(String mTaiKhoan) {
        this.mTaiKhoan = mTaiKhoan;
    }

    public String getmMatKhau() {
        return mMatKhau;
    }

    public void setmMatKhau(String mMatKhau) {
        this.mMatKhau = mMatKhau;
    }

    public String getmEmaill() {
        return mEmaill;
    }

    public void setmEmaill(String mEmaill) {
        this.mEmaill = mEmaill;
    }

    public int getmPhanQuyen() {
        return mPhanQuyen;
    }

    public void setmPhanQuyen(int mPhanQuyen) {
        this.mPhanQuyen = mPhanQuyen;
    }
}
