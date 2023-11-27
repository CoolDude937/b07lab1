import java.util.ArrayList;
import java.util.List;

public class BubbleSortAdapter implements SortingService{
	
	public BubbleSortAdapter() {}
	
	@Override
	public List<Double> sort(List<Double> L){
		double [] doubleArray = new double[L.size()];
		for (int i = 0; i < L.size(); i++) {
			doubleArray[i] = L.get(i);
		}
		BubbleSort.sortArray(doubleArray);
		List<Double> sortedDoubles = new ArrayList<>();
		for (int i = 0; i < L.size(); i++) {
			sortedDoubles.add(doubleArray[i]);
		}
		return sortedDoubles;
	}
}
