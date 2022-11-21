/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uniminuto.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "user_access")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAccess.findAll", query = "SELECT u FROM UserAccess u"),
    @NamedQuery(name = "UserAccess.findById", query = "SELECT u FROM UserAccess u WHERE u.id = :id"),
    @NamedQuery(name = "UserAccess.findByAccessPassword", query = "SELECT u FROM UserAccess u WHERE u.accessPassword = :accessPassword"),
    @NamedQuery(name = "UserAccess.findByRecoveryPassword", query = "SELECT u FROM UserAccess u WHERE u.recoveryPassword = :recoveryPassword"),
    @NamedQuery(name = "UserAccess.findByIsRecoveryPassword", query = "SELECT u FROM UserAccess u WHERE u.isRecoveryPassword = :isRecoveryPassword"),
    @NamedQuery(name = "UserAccess.findByDateCreate", query = "SELECT u FROM UserAccess u WHERE u.dateCreate = :dateCreate"),
    @NamedQuery(name = "UserAccess.findByDateModify", query = "SELECT u FROM UserAccess u WHERE u.dateModify = :dateModify"),
    @NamedQuery(name = "UserAccess.findByDateRecovery", query = "SELECT u FROM UserAccess u WHERE u.dateRecovery = :dateRecovery")})
public class UserAccess implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "access_password")
    private String accessPassword;
    @Size(max = 2147483647)
    @Column(name = "recovery_password")
    private String recoveryPassword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_recovery_password")
    private boolean isRecoveryPassword;
    @Column(name = "date_create")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @Column(name = "date_modify")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModify;
    @Column(name = "date_recovery")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRecovery;
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserRegister fkUser;

    public UserAccess() {
    }

    public UserAccess(Long id) {
        this.id = id;
    }

    public UserAccess(Long id, String accessPassword, boolean isRecoveryPassword) {
        this.id = id;
        this.accessPassword = accessPassword;
        this.isRecoveryPassword = isRecoveryPassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccessPassword() {
        return accessPassword;
    }

    public void setAccessPassword(String accessPassword) {
        this.accessPassword = accessPassword;
    }

    public String getRecoveryPassword() {
        return recoveryPassword;
    }

    public void setRecoveryPassword(String recoveryPassword) {
        this.recoveryPassword = recoveryPassword;
    }

    public boolean getIsRecoveryPassword() {
        return isRecoveryPassword;
    }

    public void setIsRecoveryPassword(boolean isRecoveryPassword) {
        this.isRecoveryPassword = isRecoveryPassword;
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

    public Date getDateRecovery() {
        return dateRecovery;
    }

    public void setDateRecovery(Date dateRecovery) {
        this.dateRecovery = dateRecovery;
    }

    public UserRegister getFkUser() {
        return fkUser;
    }

    public void setFkUser(UserRegister fkUser) {
        this.fkUser = fkUser;
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
        if (!(object instanceof UserAccess)) {
            return false;
        }
        UserAccess other = (UserAccess) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.Entities.UserAccess[ id=" + id + " ]";
    }
    
}
