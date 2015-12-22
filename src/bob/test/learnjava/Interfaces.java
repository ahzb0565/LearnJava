package bob.test.learnjava;

interface CanFight{
	void fight();
}

interface CanSwim{
	void swim();
}

interface CanFly{
	void fly();
}

abstract class ActionCharacter{
	public abstract void fight();
}

class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly{
	public void swim(){}
	public void fly(){}
	public void fight() {}
}

public class Interfaces{
	static void t(CanFight t){t.fight();}
	static void u(CanSwim u){u.swim();}
	static void v(CanFly v){v.fly();}
	static void w(ActionCharacter w){w.fight();}
	public static void main(String[] args){
		Hero i = new Hero();
		t(i);
		u(i);
		v(i);
		w(i);
	}
}