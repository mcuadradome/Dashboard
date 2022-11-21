/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uniminuto.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "user_register")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRegister.findAll", query = "SELECT u FROM UserRegister u"),
    @NamedQuery(name = "UserRegister.findById", query = "SELECT u FROM UserRegister u WHERE u.id = :id"),
    @NamedQuery(name = "UserRegister.findByName", query = "SELECT u FROM UserRegister u WHERE u.name = :name"),
    @NamedQuery(name = "UserRegister.findBySecondName", query = "SELECT u FROM UserRegister u WHERE u.secondName = :secondName"),
    @NamedQuery(name = "UserRegister.findByFirstLastName", query = "SELECT u FROM UserRegister u WHERE u.firstLastName = :firstLastName"),
    @NamedQuery(name = "UserRegister.findBySecondLastName", query = "SELECT u FROM UserRegister u WHERE u.secondLastName = :secondLastName"),
    @NamedQuery(name = "UserRegister.findByEmail", query = "SELECT u FROM UserRegister u WHERE u.email = :email"),
    @NamedQuery(name = "UserRegister.findByDateCreate", query = "SELECT u FROM UserRegister u WHERE u.dateCreate = :dateCreate"),
    @NamedQuery(name = "UserRegister.findByDateModify", query = "SELECT u FROM UserRegister u WHERE u.dateModify = :dateModify")})
public class UserRegister implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "name")
    private String name;
    @Size(max = 250)
    @Column(name = "second_name")
    private String secondName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "first_last_name")
    private String firstLastName;
    @Size(max = 250)
    @Column(name = "second_last_name")
    private String secondLastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "email")
    private String email;
    @Column(name = "date_create")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @Column(name = "date_modify")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModify;
    @OneToMany(mappedBy = "fkUser")
    private Collection<HechoVentas> hechoVentasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkUser")
    private Collection<UserAccess> userAccessCollection;

    public UserRegister() {
    }

    public UserRegister(Long id) {
        this.id = id;
    }

    public UserRegister(Long id, String name, String firstLastName, String email) {
        this.id = id;
        this.name = name;
        this.firstLastName = firstLastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateModify() {
        return dateModify;
    }

    public void setDateModify(Date dateModify) {
        this.dateModify = dateModify;
    }

    @XmlTransient
    public Collection<HechoVentas> getHechoVentasCollection() {
        return hechoVentasCollection;
    }

    public void setHechoVentasCollection(Collection<HechoVentas> hechoVentasCollection) {
        this.hechoVentasCollection = hechoVentasCollection;
    }

    @XmlTransient
    public Collection<UserAccess> getUserAccessCollection() {
        return userAccessCollection;
    }

    public void setUserAccessCollection(Collection<UserAccess> userAccessCollection) {
        this.userAccessCollection = userAccessCollection;
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
        if (!(object instanceof UserRegister)) {
            return false;
        }
        UserRegister other = (UserRegister) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.Entities.UserRegister[ id=" + id + " ]";
    }
    
}
