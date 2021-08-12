/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunnm.daos;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import hieunnm.dtos.CategoryDTO;
import hieunnm.dtos.ProductDTO;
import hieunnm.utils.DBAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author PC
 */
public class ProductDAO {

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

    public Vector<ProductDTO> loadProduct() throws Exception {
        Vector<ProductDTO> vector = new Vector<>();
        try {
            String sql = "SELECT * from tblProducts";
            con = DBAccess.getConnection();
            prSt = con.prepareStatement(sql);
            rs = prSt.executeQuery();
            while (rs.next()) {
                ProductDTO product = new ProductDTO(rs.getString("productID"),
                        rs.getString("productName"), rs.getString("unit"),
                        rs.getInt("price"), rs.getInt("quantity"),
                        rs.getString("categoryID"));
                vector.add(product);

            }
        } finally {
            disconnection();
        }
        return vector;
    }

    public void insertProduct(ProductDTO product) throws Exception {
        try {
            String sql = "insert into tblProducts values(?,?,?,?,?,?)";
            con = DBAccess.getConnection();
            prSt = con.prepareStatement(sql);
            prSt.setString(1, product.getId());
            prSt.setString(2, product.getName());
            prSt.setInt(3, (int) product.getPrice());
            prSt.setString(4, product.getUnit());
            prSt.setInt(5, product.getQuantity());
            prSt.setString(6, product.getCategoryId());
            prSt.executeUpdate();
        } finally {
            disconnection();
        }

    }

    public void updateProduct(ProductDTO product) throws Exception, SQLServerException {
        try {
            String sql = "update tblProducts set productName=?, price=?, unit=?, quantity=?, categoryID=? "
                    + "where productID=?";
            con = DBAccess.getConnection();
            prSt = con.prepareStatement(sql);
            prSt.setString(1, product.getName());
            prSt.setInt(2, (int) product.getPrice());
            prSt.setString(3, product.getUnit());
            prSt.setInt(4, product.getQuantity());
            prSt.setString(5, product.getCategoryId());
            prSt.setString(6, product.getId());
            prSt.executeUpdate();
        } finally {
            disconnection();
        }
    }

    public void deteleProduct(String productId) throws Exception {
        try {
            String sql = "delete from tblProducts where productID=?";
            con = DBAccess.getConnection();
            prSt = con.prepareCall(sql);
            prSt.setString(1, productId);
            prSt.executeUpdate();
        } finally {
            disconnection();
        }
    }
}
