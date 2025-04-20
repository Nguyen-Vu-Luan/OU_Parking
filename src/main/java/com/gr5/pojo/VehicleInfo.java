/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gr5.pojo;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author luann
 */
@Entity
@Table(name = "vehicle_info")
@NamedQueries({
    @NamedQuery(name = "VehicleInfo.findAll", query = "SELECT v FROM VehicleInfo v"),
    @NamedQuery(name = "VehicleInfo.findById", query = "SELECT v FROM VehicleInfo v WHERE v.id = :id"),
    @NamedQuery(name = "VehicleInfo.findByLicensePlate", query = "SELECT v FROM VehicleInfo v WHERE v.licensePlate = :licensePlate"),
    @NamedQuery(name = "VehicleInfo.findByVehicleType", query = "SELECT v FROM VehicleInfo v WHERE v.vehicleType = :vehicleType"),
    @NamedQuery(name = "VehicleInfo.findByBrand", query = "SELECT v FROM VehicleInfo v WHERE v.brand = :brand"),
    @NamedQuery(name = "VehicleInfo.findByColor", query = "SELECT v FROM VehicleInfo v WHERE v.color = :color")})
public class VehicleInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "license_plate")
    private String licensePlate;
    @Size(max = 50)
    @Column(name = "vehicle_type")
    private String vehicleType;
    @Size(max = 50)
    @Column(name = "brand")
    private String brand;
    @Size(max = 30)
    @Column(name = "color")
    private String color;
    @OneToMany(mappedBy = "vehicleId")
    private Set<Reservations> reservationsSet;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private Users userId;

    public VehicleInfo() {
    }

    public VehicleInfo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<Reservations> getReservationsSet() {
        return reservationsSet;
    }

    public void setReservationsSet(Set<Reservations> reservationsSet) {
        this.reservationsSet = reservationsSet;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
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
        if (!(object instanceof VehicleInfo)) {
            return false;
        }
        VehicleInfo other = (VehicleInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gr5.pojo.VehicleInfo[ id=" + id + " ]";
    }
    
}
