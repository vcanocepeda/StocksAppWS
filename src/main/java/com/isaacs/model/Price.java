package com.isaacs.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="price")
public class Price 
{
  private Integer id;
  private Double value;
  private Stock stock = null;
//  private Integer idstock;
  
  public Price() {}
  
  public Price(Double value, Integer idstock)
  {
    setValue(value);
  }
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id", unique=true, nullable=false)
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  @Column(name="value", nullable=false, length=45)
  public Double getValue()
  {
    return this.value;
  }
  
  public void setValue(Double value)
  {
    this.value = value;
  }
  
  
  @ManyToOne
  @JoinColumn(name="idstock", nullable=false)
  public Stock getStock()
  {
    return this.stock;
  }
  
  public void setStock(Stock stock)
  {
    this.stock = stock;
  }
}
