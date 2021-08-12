/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunnm.daos;

import hieunnm.dtos.CategoryDTO;
import hieunnm.utils.DBAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Vector;

/**
 *
 * @author PC
 */
public class CategoryDAO {

    Connection con = null;
    PreparedStatement prSt = null;
    ResultSet rs = null;

    public void disconnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (prSt != null) {
            prSt.close();
        }
        if (con != null) {
            con.close();
        }

    }

    public Vector<CategoryDTO> loadCate() throws Exception {
        Vector<CategoryDTO> vector = new Vector<>();
        try {
            String sql = "SELECT * from tblCategories";
            con = DBAccess.getConnection();
            prSt = con.prepareStatement(sql);
            rs = prSt.executeQuery();
            while (rs.next()) {
                CategoryDTO cate = new CategoryDTO(rs.getString("categoryID"), rs.getString("categoryName"), rs.getString("description"));
                vector.add(cate);

            }
        } finally {
            disconnection();
        }
        return vector;
    }
    
    public void insertCate(CategoryDTO cate) throws Exception {
        try {
            String sql = "insert into tblCategories values (?,?,?)";
            con = DBAccess.getConnection();
            prSt = con.prepareStatement(sql);
            prSt.setString(1, cate.getId());
            prSt.setString(2, cate.getName());
            prSt.setString(3, cate.getDescription());
            prSt.executeUpdate();
        } finally {
            disconnection();
        }
    }

    public void updateCate(CategoryDTO cate) throws Exception {
        try {
            String sql = "update tblCategories set categoryName=?,description=? where categoryID=?";
            con = DBAccess.getConnection();
            prSt = con.prepareStatement(sql);
            prSt.setString(1, cate.getName());
            prSt.setString(2, cate.getDescription());
            prSt.setString(3, cate.getId());
            prSt.executeUpdate();
        } finally {
            disconnection();
        }
    }

    public void deleteCate(String cateID) throws Exception {
        try {
            String sql = "delete from tblCategories where categoryID=?";
            con = DBAccess.getConnection();
            prSt = con.prepareStatement(sql);
            prSt.setString(1, cateID);
            prSt.executeUpdate();
        } finally {
            disconnection();
        }
    }
}
