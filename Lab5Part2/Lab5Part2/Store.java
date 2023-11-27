
public abstract class Store {
	ConsumerItem consumerItem;
	ConsumerItem order() {
		consumerItem.customize();
		consumerItem.prepare();
		consumerItem.box();
		return consumerItem;
	}
}
