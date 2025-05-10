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
@Table(name = "parking_slots")
@NamedQueries({
    @NamedQuery(name = "ParkingSlots.findAll", query = "SELECT p FROM ParkingSlots p"),
    @NamedQuery(name = "ParkingSlots.findById", query = "SELECT p FROM ParkingSlots p WHERE p.id = :id"),
    @NamedQuery(name = "ParkingSlots.findBySlotNumber", query = "SELECT p FROM ParkingSlots p WHERE p.slotNumber = :slotNumber"),
    @NamedQuery(name = "ParkingSlots.findByStatus", query = "SELECT p FROM ParkingSlots p WHERE p.status = :status"),
    @NamedQuery(name = "ParkingSlots.findByImage", query = "SELECT p FROM ParkingSlots p WHERE p.image = :image")})
public class ParkingSlots implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "slot_number")
    private String slotNumber;
    @Size(max = 11)
    @Column(name = "status")
    private String status;
    @Size(max = 255)
    @Column(name = "image")
    private String image;
    @OneToMany(mappedBy = "slotId")
    private Set<Reservations> reservationsSet;
    @JoinColumn(name = "lot_id", referencedColumnName = "id")
    @ManyToOne
    private ParkingLots lotId;

    public ParkingSlots() {
    }

    public ParkingSlots(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Reservations> getReservationsSet() {
        return reservationsSet;
    }

    public void setReservationsSet(Set<Reservations> reservationsSet) {
        this.reservationsSet = reservationsSet;
    }

    public ParkingLots getLotId() {
        return lotId;
    }

    public void setLotId(ParkingLots lotId) {
        this.lotId = lotId;
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
        if (!(object instanceof ParkingSlots)) {
            return false;
        }
        ParkingSlots other = (ParkingSlots) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gr5.pojo.ParkingSlots[ id=" + id + " ]";
    }
    
}
