package Data;

import Acq.IData;
import Acq.ISale;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;


public class DataFacade implements IData
{
	@Override
	public Collection<String> getUserNames()
	{
		// Should fetch some data from a database or files on harddrive - a method in another class has the purpose of performing this action
		// In this example the data are hardcoded in this method
		Collection<String> names = new ArrayList<>();
		names.add("Peter123");
		names.add("Loni_a");
		names.add("johnjohn");
		return names;
	}

	@Override
	public Collection<Double> getPricesOfAllSales()
	{
		// Should fetch some data from a database or files on harddrive - a method in another class has the purpose of performing this action
		// In this example the data are hardcoded in this method
		Collection<Double> salePrices = new HashSet<>();
		salePrices.add(213.5);
		salePrices.add(12.0);
		salePrices.add(99.75);
		return salePrices;
	}

	@Override
	public Collection<ISale> getSales()
	{
		// Should fetch some data from a database or files on harddrive - a method in another class has the purpose of performing this action
		// In this example the data are hardcoded in this method
            /*
		Collection<ISale> sales = new LinkedList<>();
		sales.add(new DataSale(10, 213.5));
		sales.add(new DataSale(2, 12));
		sales.add(new DataSale(20, 99.75));
		
		return sales; */
            return null;
	}
}
