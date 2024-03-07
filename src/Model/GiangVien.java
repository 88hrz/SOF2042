/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author X1
 */
public class GiangVien {
    private Integer maGV;
    private String tenGV;
    private String gioiTinh;
    private String diaChi;

    public GiangVien() {
    }

    public GiangVien(Integer maGV) {
        this.maGV = maGV;
    }

    public GiangVien(Integer maGV, String tenGV, String gioiTinh, String diaChi) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    public Integer getMaGV() {
        return maGV;
    }

    public void setMaGV(Integer maGV) {
        this.maGV = maGV;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
}
