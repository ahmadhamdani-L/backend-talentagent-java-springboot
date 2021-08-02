package com.backend.talentagent.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="category")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
                 property = "cateId",scope = Long.class )
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cate_id")
    private Long cateId;
    
    @Column(name="cate_name", length = 25)
    @NotBlank(message = "category name harus diisi")
    private String cateName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIdentityReference(alwaysAsId =false)
    private List<Talent> talents = new ArrayList<>();

    public Category() {
    }

    public Category(Long cateId, String cateName) {
        this.cateId = cateId;
        this.cateName = cateName;
    }

    public Long getCateId() {
        return cateId;
    }

    public void setCateId(Long cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public List<Talent> getTalents() {
        return talents;
    }

    public void setTalents(List<Talent> talents) {
        this.talents = talents;
    }
    
    
    
}