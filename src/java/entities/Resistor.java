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
@Table(name = "resistors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resistor.findAll", query = "SELECT r FROM Resistor r"),
    @NamedQuery(name = "Resistor.findById", query = "SELECT r FROM Resistor r WHERE r.id = :id"),
    @NamedQuery(name = "Resistor.findByName", query = "SELECT r FROM Resistor r WHERE r.name = :name"),
    @NamedQuery(name = "Resistor.findByResistance", query = "SELECT r FROM Resistor r WHERE r.resistance = :resistance"),
    @NamedQuery(name = "Resistor.findByPower", query = "SELECT r FROM Resistor r WHERE r.power = :power"),
    @NamedQuery(name = "Resistor.findByPrice", query = "SELECT r FROM Resistor r WHERE r.price = :price"),
    @NamedQuery(name = "Resistor.findByCount", query = "SELECT r FROM Resistor r WHERE r.count = :count")})
public class Resistor implements Serializable {

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
    @Column(name = "resistance")
    private int resistance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "power")
    private double power;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private double price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "count")
    private int count;

    public Resistor() {
    }

    public Resistor(Integer id) {
        this.id = id;
    }

    public Resistor(Integer id, String name, int resistance, double power, double price, int count) {
        this.id = id;
        this.name = name;
        this.resistance = resistance;
        this.power = power;
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

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
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
        if (!(object instanceof Resistor)) {
            return false;
        }
        Resistor other = (Resistor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Resistor[ id=" + id + " ]";
    }
    
}
