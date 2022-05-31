/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ori
 */
@Entity
@Table(name = "FavoriteSize")
@NamedQueries({
    @NamedQuery(name = "FavoriteSize.findAll", query = "SELECT f FROM FavoriteSize f"),
    @NamedQuery(name = "FavoriteSize.findById", query = "SELECT f FROM FavoriteSize f WHERE f.id = :id"),
    @NamedQuery(name = "FavoriteSize.findByColumns", query = "SELECT f FROM FavoriteSize f WHERE f.columns = :columns"),
    @NamedQuery(name = "FavoriteSize.findByRows", query = "SELECT f FROM FavoriteSize f WHERE f.rows = :rows")})
public class FavoriteSize implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "columns")
    private int columns;
    @Basic(optional = false)
    @Column(name = "rows")
    private int rows;
    @JoinColumn(name = "userID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Users userID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "columns")
    private Collection<Games> gamesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rows")
    private Collection<Games> gamesCollection1;

    public FavoriteSize() {
    }

    public FavoriteSize(Integer id) {
        this.id = id;
    }

    public FavoriteSize(Integer id, int columns, int rows) {
        this.id = id;
        this.columns = columns;
        this.rows = rows;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    public Collection<Games> getGamesCollection() {
        return gamesCollection;
    }

    public void setGamesCollection(Collection<Games> gamesCollection) {
        this.gamesCollection = gamesCollection;
    }

    public Collection<Games> getGamesCollection1() {
        return gamesCollection1;
    }

    public void setGamesCollection1(Collection<Games> gamesCollection1) {
        this.gamesCollection1 = gamesCollection1;
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
        if (!(object instanceof FavoriteSize)) {
            return false;
        }
        FavoriteSize other = (FavoriteSize) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DataBase.FavoriteSize[ id=" + id + " ]";
    }
    
}
