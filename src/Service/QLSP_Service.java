/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.KhuyenMai;
import Model.SanPham;
import Repository.QLSP_Repo;
import ViewModel.QLSP_ViewModel;
import java.util.ArrayList;

/**
 *
 * @author X1
 */
public class QLSP_Service {

    QLSP_Repo spRepo = new QLSP_Repo();
    
    //GETLIST
    public ArrayList<QLSP_ViewModel> getList(){
        return spRepo.getList();
    }
    public ArrayList<KhuyenMai> getListKM(){
        return spRepo.getListKM();
    }
    public KhuyenMai getIdByName(String name){
        return spRepo.getIdByName(name);
    }
    
    //CRUD
    public String addSP(SanPham sp){
        Boolean check = spRepo.addSP(sp);
        if (check) {
            return "Them thanh cong!!";
        }else{
            return "Them that bai :(";
        }
    }
    public String updateSP(SanPham sp){
        Boolean check = spRepo.updateSP(sp);
        if (check) {
            return "Update thanh cong!!";
        }else{
            return "Update that bai :(";
        }
    }
    public String deleteSP(String maSP){
        Boolean check = spRepo.deleteSP(maSP);
        if (check) {
            return "Xoa thanh cong!!";
        }else{
            return "Xoa that bai :(";
        }
    }
    
    //CHECK ID
    public Boolean checkId(String id){
        return spRepo.checkId(id);
    }
}
