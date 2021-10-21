package com.xyz.productStock.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * The class is for representing a Product stock entity
 * @version 1.0
 * @author Hossein Hajjari
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_STOCK")
public class ProductStock {

    @Id
    @Column(name = "ID")
    private Long id;


    @Column(name = "AVAILABLE_COUNT", nullable = false)
    private Integer AvailaleCount;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;
}
