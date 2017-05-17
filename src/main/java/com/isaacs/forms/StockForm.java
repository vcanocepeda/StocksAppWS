package com.isaacs.forms;

public class StockForm
{
  private Integer id;
  private String code = "";
  private String name = "";
  private Integer idmarket;
//  private List<Price> prices = null;
  
  public StockForm() {}
  
  public StockForm(String code, String name, Integer idmarket)
  {
    setCode(code);
    setName(name);
    setIdmarket(idmarket);
  }
  
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  public String getCode()
  {
    return this.code;
  }
  
  public void setCode(String code)
  {
    this.code = code;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }

public Integer getIdmarket() {
	return idmarket;
}

public void setIdmarket(Integer idmarket) {
	this.idmarket = idmarket;
}
  
}