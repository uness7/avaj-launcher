/*************************************/
/*     @author Youness Zioual       */
/*************************************/

import java.util.List;

public class Tower {
	private List<Flyable> observers;

	Tower() {
	}

	public void register(Flyable p_flyable) {
		this.observers.add(p_flyable);
	}

	public void unregister(Flyable p_flyable) {
		this.observers.remove(p_flyable);
	}

	protected void conditionChanged() {
	}
}
