/**
 * @author Mohamed Ali
 * @since 25-01-2021
 * @QUID 201912476
 * 
 */

/*the data and methods in this class and fish class are never and no need for it.
 * But I just implemented it with a realistic data to avoid leaving them black. 
*/
import java.security.SecureRandom;

public class Bear extends Animal {
	protected int strength;
	private SecureRandom randomObj = new SecureRandom();

	public Bear() {
		super();
		age = randomObj.nextInt(10);
	} //end of constructor.
	
	public Bear(int age, Gender gender) {
		super(age,gender);
	} //end of block.
	
	@Override
	public boolean maxAge() {
		return age >= BEAR_MAX_AGE;
	} //end of block.
	
	@Override
	public boolean incrementAge() {
		if(age < BEAR_MAX_AGE) {
			age++;
			return true;
		}
		return false;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		int[] oldness = {0,1,2,3,4,5,6,7,8,9};
		int[] power = {1,2,3,4,5,4,3,2,1,0};
		
		for(int i = 0; i < oldness.length; i++) {
			if(oldness[i] == age) {
				strength = power[i];
			}
		}
		this.strength = strength;
	} //end of block.
	
	@Override
	public String toString() {
		String g;
		if(gender == Gender.FEMALE) {
			g = "F";
		} else {
			g = "M";
		} return "B" + g + age;
	}
	
	
	
}
