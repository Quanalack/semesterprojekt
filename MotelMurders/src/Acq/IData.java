package Acq;

import java.util.Collection;

public interface IData {
    
    //Methods for data highscore - Make methods as abstract/generalized as possible f.eks. Collection instead of arraylist
	Collection<String> getUserNames();
	Collection<Double> getPricesOfAllSales();
	Collection<ISale> getSales();
}
