/**
 * @author Mohamed Ali
 * @since 25-01-2021
 * @QUID 201912476
 * 
 */

import java.security.SecureRandom;

public class Fish extends Animal {
	private SecureRandom randomObj = new SecureRandom();

	
	public Fish() {
		super();
		age = randomObj.nextInt(5);
	}
	
	public Fish(int age, Gender gender) {
		super(age,gender);
	}

	@Override
	public boolean maxAge() {
		// TODO Auto-generated method stub
		return age >= FISH_MAX_AGE;
	}
	@Override
	public boolean incrementAge() {
		if(age < FISH_MAX_AGE) {
			age++;
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		String g;
		if(gender == Gender.FEMALE) {
			g = "F";
		} else{
			g = "M";
		}
		return "F" + g + age;
	}
}
