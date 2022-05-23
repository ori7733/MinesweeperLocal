/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ori
 */
@Entity
@Table(name = "Games")
@NamedQueries({
    @NamedQuery(name = "Games.findAll", query = "SELECT g FROM Games g"),
    @NamedQuery(name = "Games.findById", query = "SELECT g FROM Games g WHERE g.id = :id"),
    @NamedQuery(name = "Games.findByUserID", query = "SELECT g FROM Games g WHERE g.userID = :userID"),
    @NamedQuery(name = "Games.findByColumns", query = "SELECT g FROM Games g WHERE g.columns = :columns"),
    @NamedQuery(name = "Games.findByRows", query = "SELECT g FROM Games g WHERE g.rows = :rows"),
    @NamedQuery(name = "Games.findByDstart", query = "SELECT g FROM Games g WHERE g.dstart = :dstart"),
    @NamedQuery(name = "Games.findByDend", query = "SELECT g FROM Games g WHERE g.dend = :dend"),
    @NamedQuery(name = "Games.findByIsFinish", query = "SELECT g FROM Games g WHERE g.isFinish = :isFinish")})
public class Games implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "userID")
    private Integer userID;
    @Basic(optional = false)
    @Column(name = "columns")
    private int columns;
    @Basic(optional = false)
    @Column(name = "rows")
    private int rows;
    @Column(name = "D_start")
    @Temporal(TemporalType.DATE)
    private Date dstart;
    @Column(name = "D_end")
    @Temporal(TemporalType.DATE)
    private Date dend;
    @Lob
    @Column(name = "timer")
    private byte[] timer;
    @Basic(optional = false)
    @Column(name = "isFinish")
    private boolean isFinish;

    public Games() {
    }

    public Games(Integer id) {
        this.id = id;
    }

    public Games(Integer id, int columns, int rows, boolean isFinish) {
        this.id = id;
        this.columns = columns;
        this.rows = rows;
        this.isFinish = isFinish;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public Date getDstart() {
        return dstart;
    }

    public void setDstart(Date dstart) {
        this.dstart = dstart;
    }

    public Date getDend() {
        return dend;
    }

    public void setDend(Date dend) {
        this.dend = dend;
    }

    public byte[] getTimer() {
        return timer;
    }

    public void setTimer(byte[] timer) {
        this.timer = timer;
    }

    public boolean getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(boolean isFinish) {
        this.isFinish = isFinish;
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
        if (!(object instanceof Games)) {
            return false;
        }
        Games other = (Games) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SQL.Games[ id=" + id + " ]";
    }
    
}
