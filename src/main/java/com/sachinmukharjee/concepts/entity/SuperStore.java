package com.sachinmukharjee.concepts.entity;

import com.sachinmukharjee.concepts.dto.ProductSearchResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "superstore")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SqlResultSetMapping(
    name = "ProductSearchResponseMapping",
    classes = {
        @ConstructorResult(
            targetClass = ProductSearchResponse.class,
            columns = {
                @ColumnResult(name = "product_id", type = String.class),
                @ColumnResult(name = "product_name", type = String.class)
            })
    })
@NamedNativeQuery(
    name = "SuperStore.searchProducts",
    query = "SELECT product_id,product_name FROM superstore where product_name like %:productName%",
    resultSetMapping = "ProductSearchResponseMapping")
public class SuperStore {

  @Id
  @Column(name = "row_id")
  private Integer rowId;

  @Column(name = "profit")
  private Double profit;

  @Column(name = "discount")
  private Double discount;

  @Column(name = "quantity")
  private Integer quantity;

  @Column(name = "sales")
  private Double sales;

  @Column(name = "product_name")
  private String productName;

  @Column(name = "sub_category")
  private String subCategory;

  @Column(name = "product_id")
  private String productId;

  @Column(name = "category")
  private String category;

  @Column(name = "region")
  private String region;

  @Column(name = "postal_code")
  private Integer postalCode;

  @Column(name = "state")
  private String state;

  @Column(name = "city")
  private String city;

  @Column(name = "country")
  private String country;

  @Column(name = "segment")
  private String segment;

  @Column(name = "customer_name")
  private String customerName;

  @Column(name = "customer_id")
  private String customerId;

  @Column(name = "ship_mode")
  private String shipMode;

  @Temporal(TemporalType.DATE)
  @Column(name = "ship_date")
  private Date shipDate;

  @Temporal(TemporalType.DATE)
  @Column(name = "order_date")
  private Date orderDate;
}
