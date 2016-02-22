package helpers;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Input {
	public static void Input_Key() {
	boolean up = Keyboard.isKeyDown(Keyboard.KEY_W);
	boolean down = Keyboard.isKeyDown(Keyboard.KEY_S);
	boolean left = Keyboard.isKeyDown(Keyboard.KEY_A);
	boolean right = Keyboard.isKeyDown(Keyboard.KEY_D);
	boolean flyUp = Keyboard.isKeyDown(Keyboard.KEY_E);
	boolean flyDown = Keyboard.isKeyDown(Keyboard.KEY_Q);
	boolean speedUp = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);
	boolean slowDown = Keyboard.isKeyDown(Keyboard.KEY_LCONTROL);
	boolean f4 = Keyboard.isKeyDown(Keyboard.KEY_F4);
	
	if(f4) {
		System.out.println("f4");
	}

	float walkspeed = 0.15f;

	float mx = Mouse.getDX();
	float my = Mouse.getDY();
	if(Mouse.isButtonDown(0)){
		mx *=0.25f;
		my *=0.25f;

		
		System.out.print(Mouse.getDX());
		System.out.print(Mouse.getDY());
	}
	if (!Mouse.isButtonDown(0)) {	   }
	if (speedUp && !slowDown){
		walkspeed = 0.25f;
	}
	if (slowDown && !speedUp){
		walkspeed = 0.10f;
	}
	if (up && !down) {
		
	}
	if (down && !up) {

	}
	if (right && !left) {

	}
	if (left && !right) {

	}
	if(flyUp && !flyDown){

	}
	if(flyDown && !flyUp){

	}
	}
}
