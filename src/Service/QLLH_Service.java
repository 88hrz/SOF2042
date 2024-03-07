/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.GiangVien;
import Model.LopHoc;
import Repository.QLLH_Repo;
import ViewModel.QLLH_ViewModel;
import java.util.ArrayList;

/**
 *
 * @author X1
 */
public class QLLH_Service {
    QLLH_Repo lhRepo = new QLLH_Repo();
    
    //GET
    public ArrayList<QLLH_ViewModel> getList(){
        return lhRepo.getList();
    }
    public ArrayList<GiangVien> getListGV(){
        return lhRepo.getGV();
    }
    public GiangVien getIdByName(String name){
        return lhRepo.getIdByName(name);
    }
    
    //CRUD
    public String addLH(LopHoc lh){
        Boolean check = lhRepo.addLH(lh);
        if (check) {
            return "Them thanh congg~";
        }else{
            return "Them that bai :(";
        }
    }
    public String updateLH(LopHoc lh){
        Boolean check = lhRepo.updateLH(lh);
        if (check) {
            return "Update thanh congg~";
        }else{
            return "Update that bai :(";
        }
    }
    public String deleteLH(Integer id){
        Boolean check = lhRepo.deleteLH(id);
        if (check) {
            return "Xoa thanh congg~";
        }else{
            return "Xoa that bai :(";
        }
    }
    
    //CHECK ID
    public Boolean checkId(Integer id){
        return lhRepo.checkId(id);
    }
}
