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
@Table(name = "Steps")
@NamedQueries({
    @NamedQuery(name = "Steps.findAll", query = "SELECT s FROM Steps s"),
    @NamedQuery(name = "Steps.findById", query = "SELECT s FROM Steps s WHERE s.id = :id"),
    @NamedQuery(name = "Steps.findByGameID", query = "SELECT s FROM Steps s WHERE s.gameID = :gameID"),
    @NamedQuery(name = "Steps.findByTime", query = "SELECT s FROM Steps s WHERE s.time = :time"),
    @NamedQuery(name = "Steps.findByY", query = "SELECT s FROM Steps s WHERE s.y = :y"),
    @NamedQuery(name = "Steps.findByX", query = "SELECT s FROM Steps s WHERE s.x = :x")})
public class Steps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "gameID")
    private int gameID;
    @Basic(optional = false)
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Basic(optional = false)
    @Column(name = "y")
    private int y;
    @Basic(optional = false)
    @Column(name = "x")
    private int x;

    public Steps() {
    }

    public Steps(Integer id) {
        this.id = id;
    }

    public Steps(Integer id, int gameID, Date time, int y, int x) {
        this.id = id;
        this.gameID = gameID;
        this.time = time;
        this.y = y;
        this.x = x;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
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
        if (!(object instanceof Steps)) {
            return false;
        }
        Steps other = (Steps) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SQL.Steps[ id=" + id + " ]";
    }
    
}
