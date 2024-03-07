/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author X1
 */
public class KhuyenMai {
    private String maKM;
    private String tenKM;
    private Integer soLApDung;
    private String trangThai;

    public KhuyenMai() {
    }

    public KhuyenMai(String maKM, String tenKM, Integer soLApDung, String trangThai) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.soLApDung = soLApDung;
        this.trangThai = trangThai;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public Integer getSoLApDung() {
        return soLApDung;
    }

    public void setSoLApDung(Integer soLApDung) {
        this.soLApDung = soLApDung;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
}
