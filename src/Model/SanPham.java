/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author X1
 */
public class SanPham {
    private String maSP;
    private String tenSP;
    private Float giaB;
    private Integer soL;
    private String maKM; 

    public SanPham(String maSP, String tenSP, Float giaB, String maKM) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaB = giaB;
        this.maKM = maKM;
    }

    public SanPham() {
    }

    public SanPham(String maSP, String tenSP, Float giaB, Integer soL, String maKM) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaB = giaB;
        this.soL = soL;
        this.maKM = maKM;
    }
    
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Float getGiaB() {
        return giaB;
    }

    public void setGiaB(Float giaB) {
        this.giaB = giaB;
    }

    

    public Integer getSoL() {
        return soL;
    }

    public void setSoL(Integer soL) {
        this.soL = soL;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }
    
        
}
