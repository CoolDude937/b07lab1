public class DeliveryService{
	//this is to indicate the type of item being delivered, for example, a Book Express or a Grocery Express.
	String serviceName;

	public DeliveryService(String serviceName) {
		this.serviceName = serviceName;
	}
	
	void deliver(Store store, DeliverableItem item, Customer customer) {
		if(store.itemExists(item)){
			System.out.println("Delivering " + item);
			System.out.println("Delivery service: " + this.serviceName);
			System.out.println("Box size: " + item.determineBoxSize());
			System.out.println("Address: " + customer.getPostalCode());
			store.removeItem(item);
		}
	}
}
