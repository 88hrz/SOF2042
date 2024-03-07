/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author X1
 */
public class QLSP_ViewModel {
    private String maSP;
    private String tenSP;
    private Integer soL;
    private Float giaB;
    private String tenKM;

    public QLSP_ViewModel() {
    }

    public QLSP_ViewModel(String maSP, String tenSP, Integer soL, Float giaB, String tenKM) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soL = soL;
        this.giaB = giaB;
        this.tenKM = tenKM;
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

    public Integer getSoL() {
        return soL;
    }

    public void setSoL(Integer soL) {
        this.soL = soL;
    }

    public Float getGiaB() {
        return giaB;
    }

    public void setGiaB(Float giaB) {
        this.giaB = giaB;
    }

    
    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }
    
    
    
}
