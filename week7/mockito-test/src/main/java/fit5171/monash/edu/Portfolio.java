package fit5171.monash.edu;

import java.util.ArrayList;

import java.util.List;

public class Portfolio {
	
	private List<Stock> stocks;
	
	private StockService stockService;
	   
	public Portfolio() {
		stocks = new ArrayList<Stock>();
	}


	public void setStocks(List<Stock> stocks) {
		// TODO Auto-generated method stub
		this.stocks = stocks;
		
	}
	
	public List<Stock> getStocks() {
	      return stocks;
	}
	
	public void setStockService(StockService stockServiceMock) {
		// TODO Auto-generated method stub
		this.stockService = stockService;
	}
	
	public StockService getStockService() {
	      return stockService;
	}
	public double getMarketValue() {
		// TODO Auto-generated method stub
		double marketValue = 0.0;
	      
	      for(Stock stock:stocks){
	         marketValue += stockService.getPrice(stock) * stock.getQuantity();
	      }
	      return marketValue;
		//return 0;
	}


}
