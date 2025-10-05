package iuh.fit.se.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "NHACUNGCAP")
public class NhaCungCap {
    @Id
    private String maNCC;

    private String tenNhaCC;
    private String diaChi;
    private String soDienThoai;

    @OneToMany(mappedBy = "nhaCungCap", cascade = CascadeType.ALL)
    private List<DienThoai> danhSachDienThoai = new ArrayList<>();

    public NhaCungCap() {}

    public NhaCungCap(String maNCC, String tenNhaCC, String diaChi, String soDienThoai) {
        this.maNCC = maNCC;
        this.tenNhaCC = tenNhaCC;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    // Getters & Setters
    public String getMaNCC() { return maNCC; }
    public void setMaNCC(String maNCC) { this.maNCC = maNCC; }
    public String getTenNhaCC() { return tenNhaCC; }
    public void setTenNhaCC(String tenNhaCC) { this.tenNhaCC = tenNhaCC; }
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }
}
