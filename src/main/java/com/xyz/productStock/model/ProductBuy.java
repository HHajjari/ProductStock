package com.xyz.productStock.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

/**
 * The class is for representing a Product buy entity
 * @version 1.0
 * @author Hossein Hajjari
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "PRODUCT_BUY")
public class ProductBuy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CUSTOMER_EMAIL")
    private String customerEmail;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    @Column(name = "INSERT_DATE", columnDefinition = "datetime")
    private Date insertDate;

    @Column(name = "ITEM_COUNT")
    private Integer itemCount;

    @Column(name = "ITEM_PRICE")
    private Float itemPrice;
}
