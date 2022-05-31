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
@Table(name = "BombsLocation")
@NamedQueries({
    @NamedQuery(name = "BombsLocation.findAll", query = "SELECT b FROM BombsLocation b"),
    @NamedQuery(name = "BombsLocation.findById", query = "SELECT b FROM BombsLocation b WHERE b.id = :id"),
    @NamedQuery(name = "BombsLocation.findByGameID", query = "SELECT b FROM BombsLocation b WHERE b.gameID = :gameID"),
    @NamedQuery(name = "BombsLocation.findByY", query = "SELECT b FROM BombsLocation b WHERE b.y = :y"),
    @NamedQuery(name = "BombsLocation.findByX", query = "SELECT b FROM BombsLocation b WHERE b.x = :x")})
public class BombsLocation implements Serializable {

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
    @Column(name = "y")
    private int y;
    @Basic(optional = false)
    @Column(name = "x")
    private int x;

    public BombsLocation() {
    }

    public BombsLocation(Integer id) {
        this.id = id;
    }

    public BombsLocation(Integer id, int gameID, int y, int x) {
        this.id = id;
        this.gameID = gameID;
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
        if (!(object instanceof BombsLocation)) {
            return false;
        }
        BombsLocation other = (BombsLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataBase.BombsLocation[ id=" + id + " ]";
    }
    
}
