/**
 * @author Mohamed Ali
 * @since 25-01-2021
 * @QUID 201912476
 * 
 */

import java.security.SecureRandom;
enum Gender {
	MALE, FEMALE;
}
public abstract class Animal {
	protected Gender gender;
	protected int age;
	public static final int BEAR_MAX_AGE = 9;
	public static final int FISH_MAX_AGE = 4;
	public Animal() {  //Random age and gender constructor.
		SecureRandom randObj = new SecureRandom();
		int genType = randObj.nextInt(2);
		if (genType==0) {
			gender = Gender.MALE;
		} else {
			gender = Gender.FEMALE;
		}
	} //end of constructor block.
	public Animal(int age, Gender gender) { //Given age and gender constructor. 
		this.age = age;
		this.gender = gender;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public abstract boolean maxAge();
	public abstract boolean incrementAge();	
}
