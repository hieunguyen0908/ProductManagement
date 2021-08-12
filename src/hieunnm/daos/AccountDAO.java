/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunnm.daos;

import hieunnm.utils.DBAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author PC
 */
public class AccountDAO {

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

    public boolean checkAccount(String username, String password) throws Exception {
        PreparedStatement st = DBAccess.getConnection().prepareStatement(
                "SELECT * FROM tblUsers WHERE userID=? AND password=? AND status='True'");
        st.setString(1, username);
        st.setString(2, password);
        try (Connection con = DBAccess.getConnection();
                Statement statement = con.createStatement()) {
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        }
        return false;
    }

}
