package com.company.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@Table(name = "DEMO_PRODUCT")
@Entity(name = "demo$Product")
public class Product extends StandardEntity {
    private static final long serialVersionUID = -3743561133964548734L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Column(name = "MIN_DISCOUNT")
    protected Double minDiscount;

    @Column(name = "MAX_DISCOUNT")
    protected Double maxDiscount;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMinDiscount(Double minDiscount) {
        this.minDiscount = minDiscount;
    }

    public Double getMinDiscount() {
        return minDiscount;
    }

    public void setMaxDiscount(Double maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public Double getMaxDiscount() {
        return maxDiscount;
    }


}