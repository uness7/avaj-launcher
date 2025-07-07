/*************************************/
/*     @author Youness Zioual       */
/*************************************/

/**
 * My own notes :)
 * We cannot instantiate Flyable class since it is an abstract class, but it can be subclasses.
 * We can have both abstract and concrete methods in an abstract class.
 * The subclasses of Flyable respect the is-a relationship. For instance, Aircraft is-a Flyable.
 **/

public abstract class Flyable {
	public abstract void updateConditions();
}
