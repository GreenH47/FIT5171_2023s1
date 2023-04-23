package fit5171.monash.edu;


public class Stock {

	private String id;
	private String name;
	private int quantity;
	
	public Stock(String id, String name, int number) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		quantity = number;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(StockValidation.validateName(name)) {
			this.name = name;
			//do something
		}
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
