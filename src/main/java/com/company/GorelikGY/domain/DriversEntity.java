package com.company.GorelikGY.domain;

import javax.persistence.*;

@Entity
@Table(name = "drivers", schema = "gorelik_g_y")
public class DriversEntity {
    private int iddriver;
    private String name;
    private String phone;
    private String experience;
    private String haveCar;

    @Id
    @Column(name = "iddriver")
    public int getIddriver() {
        return iddriver;
    }

    public void setIddriver(int iddriver) {
        this.iddriver = iddriver;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "experience")
    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Basic
    @Column(name = "have_car")
    public String getHaveCar() {
        return haveCar;
    }

    public void setHaveCar(String haveCar) {
        this.haveCar = haveCar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriversEntity that = (DriversEntity) o;

        if (iddriver != that.iddriver) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (experience != null ? !experience.equals(that.experience) : that.experience != null) return false;
        if (haveCar != null ? !haveCar.equals(that.haveCar) : that.haveCar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iddriver;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (experience != null ? experience.hashCode() : 0);
        result = 31 * result + (haveCar != null ? haveCar.hashCode() : 0);
        return result;
    }
}
