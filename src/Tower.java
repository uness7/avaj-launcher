/*
**	@author Youness Zioual
*/

import java.util.ArrayList;
import java.util.List;

public class Tower {
	private List<Flyable> observers = new ArrayList<>();

	Tower() {
	}

	public void register(Flyable p_flyable) {
		observers.add(p_flyable);
	}

	public void unregister(Flyable p_flyable) {
		observers.remove(p_flyable);
	}

	protected void conditionChanged() {
		for (Flyable p_flyable : new ArrayList<>(observers)) {
			p_flyable.updateConditions();
		}
	}

	//for (Flyable p_flyable : observers) { -> wrong and throws java.util.ConcurrentModificationException
	// because we are modifying observers while iterating over it
}
