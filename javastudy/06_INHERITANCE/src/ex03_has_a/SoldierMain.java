package ex03_has_a;

public class SoldierMain {

	public static void main(String[] args) {
		
		Gun gun =new Gun();
		gun.setModel("K2");
		gun.setBullet(9);
		
		Soldier soldier = new Soldier();
		soldier.setGun(gun);
		
		//soldier가 총을 꺼내서 쏜다.
		//soldier.getGun().shoot();
		
		//soldier가 총을 쏜다.
		soldier.shoot();
		//soldier가 총을 꺼내서 장전한다
		//soldier.getGun().reload(1);
		//soldier가 장전한다.
		soldier.reload(1);
		
		//soldier가 가지고 있는 gun의 model //캡슐화 관점에서 좋은 코드는 아님?
		System.out.println(soldier.getGun().getModel());
		
		//soldier가 가지고 있는 gun의 bullet 수
		System.out.println(soldier.getGun().getBullet());

	}

}
