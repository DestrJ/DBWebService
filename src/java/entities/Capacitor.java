/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Destr
 */
@Entity
@Table(name = "capacitors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Capacitor.findAll", query = "SELECT c FROM Capacitor c"),
    @NamedQuery(name = "Capacitor.findById", query = "SELECT c FROM Capacitor c WHERE c.id = :id"),
    @NamedQuery(name = "Capacitor.findByName", query = "SELECT c FROM Capacitor c WHERE c.name = :name"),
    @NamedQuery(name = "Capacitor.findByCapacity", query = "SELECT c FROM Capacitor c WHERE c.capacity = :capacity"),
    @NamedQuery(name = "Capacitor.findByPrice", query = "SELECT c FROM Capacitor c WHERE c.price = :price"),
    @NamedQuery(name = "Capacitor.findByCount", query = "SELECT c FROM Capacitor c WHERE c.count = :count")})
public class Capacitor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacity")
    private int capacity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "count")
    private int count;

    public Capacitor() {
    }

    public Capacitor(Integer id) {
        this.id = id;
    }

    public Capacitor(Integer id, String name, int capacity, double price, int count) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
        if (!(object instanceof Capacitor)) {
            return false;
        }
        Capacitor other = (Capacitor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Capacitor[ id=" + id + " ]";
    }
    
}
