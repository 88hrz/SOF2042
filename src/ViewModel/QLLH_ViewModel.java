/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author X1
 */
public class QLLH_ViewModel {
    private Integer maLop;
    private String tenLop;
    private Integer siSo;
    private String tenGV;

    public QLLH_ViewModel() {
    }

    public QLLH_ViewModel(Integer maLop, String tenLop, Integer siSo, String tenGV) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.siSo = siSo;
        this.tenGV = tenGV;
    }

    public Integer getMaLop() {
        return maLop;
    }

    public void setMaLop(Integer maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public Integer getSiSo() {
        return siSo;
    }

    public void setSiSo(Integer siSo) {
        this.siSo = siSo;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }
    
    
}
