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
                 property = "taleId",scope = Long.class )
public class Talent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    @Column(name ="tale_id")
    private Long taleId;

    // many to one
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tale_cate_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Category category;
    
    @Column(name="tale_fullname",length=25)
    @NotBlank(message ="Title talent harus diisi")
    private String tale_fullname;

    @Column(name="tale_nationality",length=15)
    private String tale_nationality;

    @Column(name = "tale_age", length = 255)
    private int tale_age;

    @Column(name = "tale_height", length = 255)
    private int tale_height;

    @Column(name = "tale_weight", length = 255)
    private int tale_weight;

    @Column(name = "tale_birthday", length = 255)
    private String tale_birthday;

    @Column(name = "tale_account_sosial", length = 255)
    private String tale_account_sosial;

    @Column(name="tale_price",precision = 17,scale = 2)
    @DecimalMin(value="100.00", message = "price musth higher than '${validateValue}'")
    @DecimalMax(value="50000.00", message = "not greater than '${value}'")
    private Double tale_price;

  

    @Column(name="tale_image",length = 255)
    private String taleImage;

    public Talent() {
    }

    public Talent(Long taleId, Category category, @NotBlank(message = "Title talent harus diisi") String tale_fullname,String tale_nationality, int tale_age, int tale_height, int tale_weight, String tale_birthday,String tale_account_sosial,
            @DecimalMin(value = "100.00", message = "price musth higher than '${validateValue}'") @DecimalMax(value = "50000.00", message = "not greater than '${value}'") Double tale_price,
            String taleImage) {
        this.taleId = taleId;
        this.category = category;
        this.tale_fullname = tale_fullname;
        this.tale_nationality = tale_nationality;
        this.tale_age = tale_age;
        this.tale_height = tale_height;
        this.tale_weight = tale_weight;
        this.tale_birthday = tale_birthday;
        this.tale_account_sosial = tale_account_sosial;
        this.tale_price = tale_price;
        this.taleImage = taleImage;
    }

    public Long getTaleId() {
        return taleId;
    }

    public void setTaleId(Long taleId) {
        this.taleId = taleId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTale_fullname() {
        return tale_fullname;
    }

    public void setTale_fullname(String tale_fullname) {
        this.tale_fullname = tale_fullname;
    }

    public String getTale_nationality() {
        return tale_nationality;
    }

    public void setTale_nationality(String tale_nationality) {
        this.tale_nationality = tale_nationality;
    }

    public int getTale_age() {
        return tale_age;
    }

    public void setTale_age(int tale_age) {
        this.tale_age = tale_age;
    }

    public int getTale_height() {
        return tale_height;
    }

    public void setTale_height(int tale_height) {
        this.tale_height = tale_height;
    }

    public int getTale_weight() {
        return tale_weight;
    }

    public void setTale_weight(int tale_weight) {
        this.tale_weight = tale_weight;
    }

    public String getTale_birthday() {
        return tale_birthday;
    }

    public void setTale_birthday(String tale_birthday) {
        this.tale_birthday = tale_birthday;
    }

    public String getTale_account_sosial() {
        return tale_account_sosial;
    }

    public void setTale_account_sosial(String tale_account_sosial) {
        this.tale_account_sosial = tale_account_sosial;
    }

    public Double getTale_price() {
        return tale_price;
    }

    public void setTale_price(Double tale_price) {
        this.tale_price = tale_price;
    }

    public String getTaleImage() {
        return taleImage;
    }

    public void setTaleImage(String taleImage) {
        this.taleImage = taleImage;
    }

      
    
}