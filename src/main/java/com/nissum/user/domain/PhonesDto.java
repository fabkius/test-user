package com.nissum.user.domain;

import javax.persistence.*;

@Entity
public class PhonesDto {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idphone;
    @Column
    private String number;
    @Column
    private String citycode;
    @Column
    private String contrycode;


    public Long getIdphone() {
        return idphone;
    }

    public void setIdphone(Long idphone) {
        this.idphone = idphone;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getContrycode() {
        return contrycode;
    }

    public void setContrycode(String contrycode) {
        this.contrycode = contrycode;
    }

    @Override
    public String toString() {
        return "PhonesDto{" +
                "number='" + number + '\'' +
                ", citycode='" + citycode + '\'' +
                ", contrycode='" + contrycode + '\'' +
                '}';
    }
}
