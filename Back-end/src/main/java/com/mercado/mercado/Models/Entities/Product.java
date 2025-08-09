package com.mercado.mercado.Models.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
  @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
  private long id;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  private String nameProduct;

  private double price;

  public Product() {
  }

  public Product(Category category, String nameProduct, double price) {
    this.category = category;
    this.nameProduct = nameProduct;
    this.price = price;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public String getNameProduct() {
    return nameProduct;
  }

  public void setNameProduct(String nameProduct) {
    this.nameProduct = nameProduct;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}

