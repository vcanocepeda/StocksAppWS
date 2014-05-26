package com.isaacs.dao;

import com.isaacs.model.Stock;
import java.util.List;

public abstract interface StockDao
{
  public abstract void save(Stock stock);
  
  public abstract void update(Stock stock, String code);
  
  public abstract void delete(Stock stock);
  
  public abstract Stock findByStockCode(String code);
  
  public abstract List<Stock> getStockList();
}
