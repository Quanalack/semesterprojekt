package Business;

import Acq.IBusiness;
import Acq.IData;
import Acq.ISale;
import java.util.Collection;
import java.util.HashSet;


public class BusinessFacade implements IBusiness {
	private IData data;

	@Override
	public void injectData(IData dataLayer) {
		data = dataLayer;
	}
        
        //The actual methods 
        /* For example:
	@Override
	public Collection<String> getUserNames()
	{
		return data.getUserNames();
	}

	@Override
	public double getTotalValueOfSales()
	{
		// Responsibility of performing calculations etc. should be delegated to relevant object
		Collection<Double> sales = data.getPricesOfAllSales();
		double totalValue = 0;
		for (Double price : sales) {
			totalValue += price;
		}
		return totalValue;
	}

	@Override
	public double getAveragePriceOfItemsSold()
	{
		Collection<BusinessSale> sales = getBusinessSales();
		int totalItems = 0;
		double totalValue = 0;
		
		for (BusinessSale bSale : sales) {
			totalItems += bSale.getNumberOfItems();
			totalValue += bSale.getTotalValue();
		}
		
		if (totalItems != 0 && totalValue != 0)
			return totalValue / totalItems;
		return 0;
	}
	
	private Collection<BusinessSale> getBusinessSales() {
		Collection<ISale> dataSales = data.getSales();
		Collection<BusinessSale> sales = new HashSet<>();
		
		for (ISale sale : dataSales) {
			sales.add(new BusinessSale(sale.getNumberOfItems(), sale.getTotalValue()));
		}
		return sales;
	}
        */
}
