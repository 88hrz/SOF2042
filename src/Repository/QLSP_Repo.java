/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.KhuyenMai;
import Model.SanPham;
import ViewModel.QLSP_ViewModel;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author X1
 */
public class QLSP_Repo {
    DbConnection dbConnection;
    
    //GETLIST
    public ArrayList<QLSP_ViewModel> getList(){
        String sql = "SELECT sp.MaSanPham, sp.TenSanPham, km.SoLuongApDung, sp.GiaBan, km.TenKhuyenMai \n" +
                        "FROM SanPham sp INNER JOIN KhuyenMai km ON sp.MaKhuyenMai = km.MaKhuyenMai";
        ArrayList<QLSP_ViewModel> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                String maSP = rs.getString("MaSanPham");
                String tenSP = rs.getString("TenSanPham");
                Integer soL = rs.getInt("SoLuongApDung");
                Float giaB = rs.getFloat("GiaBan");
                String tenKM = rs.getString("TenKhuyenMai");
                
                QLSP_ViewModel sp = new QLSP_ViewModel(maSP, tenSP, soL, giaB, tenKM);
                ls.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();    
        }
        return ls;
    }
    //GETLIST KM
    public ArrayList<KhuyenMai> getListKM(){
        String sql = "SELECT * FROM KhuyenMai";
        ArrayList<KhuyenMai> ls = new ArrayList<>();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                String maKM = rs.getString("MaKhuyenMai");
                String tenKM = rs.getString("TenKhuyenMai");
                Integer soL = rs.getInt("SoLuongApDung");
                String trangThai = rs.getString("TrangThai");
                
                KhuyenMai km = new KhuyenMai(maKM, tenKM, soL, trangThai);
                ls.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
    //GETID
    public KhuyenMai getIdByName(String name){
        String sql = "SELECT * FROM KhuyenMai WHERE TenKhuyenMai = ?";
        KhuyenMai km = new KhuyenMai();
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, name);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                String maKM = rs.getString("MaKhuyenMai");
                String tenKM = rs.getString("TenKhuyenMai");
                Integer soL = rs.getInt("SoLuongApDung");
                String trangThai = rs.getString("TrangThai");
                
                km = new KhuyenMai(maKM, tenKM, soL, trangThai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return km;
    }
    
    //ADD
    public Boolean addSP(SanPham sp){
        String sql = "INSERT INTO SanPham (MaSanPham, TenSanPham, GiaBan, SoLuongTon, MaKhuyenMai) \n" +
"							VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, sp.getMaSP());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, sp.getGiaB());
            ps.setObject(4, sp.getSoL());
            ps.setObject(5, sp.getMaKM());
            
            int check = ps.executeUpdate();
            if (check>0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //UPDATE
    public Boolean updateSP(SanPham sp){
        String sql = "UPDATE SanPham SET MaKhuyenMai = ?\n" +
                        ", TenSanPham = ?\n" +
                        ", GiaBan = ?\n" +
                        ", SoLuongTon = ?\n" +
                        "WHERE MaSanPham = ?";
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, sp.getMaKM());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, sp.getGiaB());
            ps.setObject(4, sp.getSoL());
            
            ps.setString(5, sp.getMaSP());
            
            int check = ps.executeUpdate();
            if (check>0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //DELETE
    public Boolean deleteSP(String maSP){
        String sql = "DELETE FROM SanPham\n" +
                "WHERE MaSanPham =?";
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, maSP);
            
            int check = ps.executeUpdate();
            if (check>0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //CHECK ID
    public Boolean checkId(String id){
        String sql = "SELECT COUNT(*) FROM SanPham WHERE MaSanPham =?";
        
        try (Connection conn = dbConnection.getConnection();
                PreparedStatement ps = conn.prepareCall(sql)){
            ps.setObject(1, id);
            
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