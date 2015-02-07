package com.isaacs.dao;

import com.isaacs.model.Market;

import java.util.List;

public interface MarketDao extends GenericDao<Market, Integer>
{
	 /* It is just for new method implementation
	  * Tries to remove employee from the system.
      * @param employee Employee to remove
      * @return {@code true} if employee is not assigned to any task
      * or timesheet. Else {@code false}.
     */
 //   boolean removeMarket(Market market);
	  Market findByCode(String code);
  
}