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
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author luann
 */
@Entity
@Table(name = "parking_lots")
@NamedQueries({
    @NamedQuery(name = "ParkingLots.findAll", query = "SELECT p FROM ParkingLots p"),
    @NamedQuery(name = "ParkingLots.findById", query = "SELECT p FROM ParkingLots p WHERE p.id = :id"),
    @NamedQuery(name = "ParkingLots.findByName", query = "SELECT p FROM ParkingLots p WHERE p.name = :name"),
    @NamedQuery(name = "ParkingLots.findByTotalSlots", query = "SELECT p FROM ParkingLots p WHERE p.totalSlots = :totalSlots"),
    @NamedQuery(name = "ParkingLots.findByPricePerHour", query = "SELECT p FROM ParkingLots p WHERE p.pricePerHour = :pricePerHour")})
public class ParkingLots implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "address")
    private String address;
    @Column(name = "total_slots")
    private Integer totalSlots;
    @Column(name = "price_per_hour")
    private Long pricePerHour;
    @Lob
    @Size(max = 65535)
    @Column(name = "amenities")
    private String amenities;
    @Lob
    @Size(max = 65535)
    @Column(name = "image")
    private String image;
    @OneToMany(mappedBy = "lotId")
    private Set<Reviews> reviewsSet;
    @OneToMany(mappedBy = "lotId")
    private Set<ParkingSlots> parkingSlotsSet;
    @Transient
    private MultipartFile file;

    public ParkingLots() {
    }

    public ParkingLots(Integer id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(Integer totalSlots) {
        this.totalSlots = totalSlots;
    }

    public Long getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Long pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Reviews> getReviewsSet() {
        return reviewsSet;
    }

    public void setReviewsSet(Set<Reviews> reviewsSet) {
        this.reviewsSet = reviewsSet;
    }

    public Set<ParkingSlots> getParkingSlotsSet() {
        return parkingSlotsSet;
    }

    public void setParkingSlotsSet(Set<ParkingSlots> parkingSlotsSet) {
        this.parkingSlotsSet = parkingSlotsSet;
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
        if (!(object instanceof ParkingLots)) {
            return false;
        }
        ParkingLots other = (ParkingLots) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gr5.pojo.ParkingLots[ id=" + id + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
