package com.xyz.productStock.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.Set;

/**
 * The class is for representing a Product entity
 * @version 1.0
 * @author Hossein Hajjari
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class Product {

    public Product(String title, Float price)
    {
        this.title = title;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE", nullable = false)
    @Nationalized
    private String title;

    @Column(name = "PRICE", nullable = false, columnDefinition="Decimal(18,2) default '100.00'")
    private Float price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ProductStock stock;

    @OneToMany(mappedBy="product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ProductBuy> productBuyList;

}
