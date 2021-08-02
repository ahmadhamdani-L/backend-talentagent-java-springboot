package com.backend.talentagent.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="talent")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
                 property = "prodId",scope = Long.class )
public class Talent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    @Column(name ="prod_id")
    private Long prodId;

    // many to one
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="prod_cate_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Category category;
    
    @Column(name="title",length=25)
    @NotBlank(message ="Title talent harus diisi")
    private String title;

    @Column(name="condition",length=15)
    private String condition;

    @Column(name = "manufacture", length = 255)
    private String manufacture;

    @Column(name="price",precision = 17,scale = 2)
    @DecimalMin(value="100.00", message = "price musth higher than '${validateValue}'")
    @DecimalMax(value="50000.00", message = "not greater than '${value}'")
    private Double price;

    @Column(name="stock")
    private int stock;

    @Column(name="prod_image",length = 255)
    private String prodImage;

    public Talent() {
    }

    public Talent(Long prodId, @NotBlank(message = "Title talent harus diisi") String title, String condition,
            String manufacture,
            @DecimalMin(value = "100.00", message = "price musth higher than '${validateValue}'") @DecimalMax(value = "50000.00", message = "not greater than '${value}'") Double price,
            int stock, String prodImage) {
        this.prodId = prodId;
        this.title = title;
        this.condition = condition;
        this.manufacture = manufacture;
        this.price = price;
        this.stock = stock;
        this.prodImage = prodImage;
    }

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getProdImage() {
        return prodImage;
    }

    public void setProdImage(String prodImage) {
        this.prodImage = prodImage;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    

    
    
}