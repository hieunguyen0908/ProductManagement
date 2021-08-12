/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunnm.dtos;

/**
 *
 * @author PC
 */
public class AccountDTO {
    String id;
    String fullName;
    String password;
    boolean status;

    public AccountDTO(String id, String fullName, String password, boolean status) {
        this.id = id;
        this.fullName = fullName;
        this.password = password;
        this.status = status;
    }

    public String getUserID() {
        return id;
    }

    public void setUserID(String userID) {
        this.id = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
