/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.GiangVien;
import Model.LopHoc;
import ViewModel.QLLH_ViewModel;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author X1
 */
public class QLLH_Repo {
    DbConnection dbConnection;
    
    //GETLIST
    public ArrayList<QLLH_ViewModel> getList(){
        String sql ="SELECT lh.ma_lop, lh.ten_lop, lh.si_so, gv.ten_giang_vien FROM LopHoc lh "
                + "INNER JOIN GiangVien gv ON lh.giang_vien_phu_trach = gv.ma_giang_vien";
        ArrayList<QLLH_ViewModel> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer maL = rs.getInt("ma_lop");
                String tenL = rs.getString("ten_lop");
                Integer siS = rs.getInt("si_so");
                String tenGV = rs.getString("ten_giang_vien");
                
                QLLH_ViewModel lh = new QLLH_ViewModel(maL, tenL, siS, tenGV);
                ls.add(lh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    public ArrayList<GiangVien> getGV(){
        String sql = "SELECT * FROM GiangVien";
        ArrayList<GiangVien> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {  
                Integer maGV = rs.getInt("ma_giang_vien");
                String tenGV = rs.getString("ten_giang_vien");
                String gioiT = rs.getString("gioi_tinh");
                String diaC = rs.getString("dia_chi");
                
                GiangVien gv = new GiangVien(maGV, tenGV, gioiT, diaC);
                ls.add(gv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls; 
    }
    public GiangVien getIdByName(String name){
        String sql = "SELECT ma_giang_vien FROM GiangVien WHERE ten_giang_vien =?";
        GiangVien gv = new GiangVien();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setString(1, name);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Integer maGv = rs.getInt("ma_giang_vien");
                
                gv = new GiangVien(maGv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gv;
    }
    
    //CRUD
    public Boolean addLH(LopHoc lh){
        String sql = "INSERT INTO LopHoc(ten_lop, si_so, giang_vien_phu_trach) VALUES\n" +
"									(?, ?, ?);";
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setString(1, lh.getTenLop());
            ps.setInt(2, lh.getSiSo());
            ps.setInt(3, lh.getMaGV());
            
            int check = ps.executeUpdate();
            if (check>0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean updateLH(LopHoc lh){
        String sql = "UPDATE LopHoc\n" +
                            "SET ten_lop =?\n" +
                            ", si_so =?\n" +
                            ", giang_vien_phu_trach =?\n" +
                            "WHERE ma_lop = ?";
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setString(1, lh.getTenLop());
            ps.setInt(2, lh.getSiSo());
            ps.setInt(3, lh.getMaGV());
            ps.setInt(4, lh.getMaLop());
            
            int check = ps.executeUpdate();
            if (check>0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Boolean deleteLH(Integer id){
        String sql = "DELETE FROM LopHoc WHERE ma_lop = ?";
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setInt(1, id);
            
            int check = ps.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //CHECK ID
    public Boolean checkId(Integer id){
        String sql = "SELECT COUNT(*) FROM LopHoc WHERE ma_lop = ?";
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
