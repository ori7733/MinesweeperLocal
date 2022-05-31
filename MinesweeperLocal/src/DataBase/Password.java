/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Ori
 */
@Entity
@Table(name = "Password")
@NamedQueries({
    @NamedQuery(name = "Password.findAll", query = "SELECT p FROM Password p"),
    @NamedQuery(name = "Password.findById", query = "SELECT p FROM Password p WHERE p.id = :id"),
    @NamedQuery(name = "Password.findByUserID", query = "SELECT p FROM Password p WHERE p.userID = :userID"),
    @NamedQuery(name = "Password.findByPassword", query = "SELECT p FROM Password p WHERE p.password = :password"),
    @NamedQuery(name = "Password.findByActivisionDate", query = "SELECT p FROM Password p WHERE p.activisionDate = :activisionDate"),
    @NamedQuery(name = "Password.findByDisableDate", query = "SELECT p FROM Password p WHERE p.disableDate = :disableDate")})
public class Password implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "userID")
    private int userID;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "activisionDate")
    private String activisionDate;
    @Column(name = "disableDate")
    private String disableDate;

    public Password() {
    }

    public Password(Integer id) {
        this.id = id;
    }

    public Password(Integer id, int userID, String password, String activisionDate) {
        this.id = id;
        this.userID = userID;
        this.password = password;
        this.activisionDate = activisionDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActivisionDate() {
        return activisionDate;
    }

    public void setActivisionDate(String activisionDate) {
        this.activisionDate = activisionDate;
    }

    public String getDisableDate() {
        return disableDate;
    }

    public void setDisableDate(String disableDate) {
        this.disableDate = disableDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Password)) {
            return false;
        }
        Password other = (Password) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataBase.Password[ id=" + id + " ]";
    }
    
}
