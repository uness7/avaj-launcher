/*
**	@author Youness Zioual
*/

import java.util.ArrayList;
import java.util.List;

public class Tower {
	private static List<Flyable> observers = new ArrayList<>();

	Tower() {
	}

	public void register(Flyable p_flyable) {
		observers.add(p_flyable);
	}

	public void unregister(Flyable p_flyable) {
		observers.remove(p_flyable);
	}

	protected void conditionChanged() {
		for (Flyable p_flyable : observers) {
			p_flyable.updateConditions();
		}
	}
}
