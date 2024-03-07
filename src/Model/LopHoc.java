/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author X1
 */
public class LopHoc {
    private Integer maLop;
    private String tenLop;
    private Integer siSo;
    private Integer maGV;

    public LopHoc() {
    }

    public LopHoc(Integer maLop, String tenLop, Integer siSo, Integer maGV) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.siSo = siSo;
        this.maGV = maGV;
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

    public Integer getMaGV() {
        return maGV;
    }

    public void setMaGV(Integer maGV) {
        this.maGV = maGV;
    }
    
    
}
