package iuh.fit.se.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "DIENTHOAI")
public class DienThoai {
    @Id
    private String maDT;

    private String tenDT;
    private int namSanXuat;
    private String cauHinh;
    private String hinhAnh;

    @ManyToOne
    @JoinColumn(name = "MANCC")
    private NhaCungCap nhaCungCap;

    public DienThoai() {}

    public DienThoai(String maDT, String tenDT, int namSanXuat, String cauHinh, String hinhAnh, NhaCungCap ncc) {
        this.maDT = maDT;
        this.tenDT = tenDT;
        this.namSanXuat = namSanXuat;
        this.cauHinh = cauHinh;
        this.hinhAnh = hinhAnh;
        this.nhaCungCap = ncc;
    }

    // Getters & Setters
    public String getMaDT() { return maDT; }
    public void setMaDT(String maDT) { this.maDT = maDT; }
    public String getTenDT() { return tenDT; }
    public void setTenDT(String tenDT) { this.tenDT = tenDT; }
    public int getNamSanXuat() { return namSanXuat; }
    public void setNamSanXuat(int namSanXuat) { this.namSanXuat = namSanXuat; }
    public String getCauHinh() { return cauHinh; }
    public void setCauHinh(String cauHinh) { this.cauHinh = cauHinh; }
    public String getHinhAnh() { return hinhAnh; }
    public void setHinhAnh(String hinhAnh) { this.hinhAnh = hinhAnh; }
    public NhaCungCap getNhaCungCap() { return nhaCungCap; }
    public void setNhaCungCap(NhaCungCap nhaCungCap) { this.nhaCungCap = nhaCungCap; }
}
