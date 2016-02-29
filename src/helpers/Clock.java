package helpers;

import org.lwjgl.Sys;

public class Clock {
	
	private static boolean paused = false;
	public static long LastFrame, totalTime;
	public static float d=0, multiplayer = 1;
	
	public static long getTime() {
		return Sys.getTime() *1000 / Sys.getTimerResolution();
	}
	
	public static float getDelta() {
		long currentTime = getTime();
		int delta = (int) (currentTime - LastFrame);
		LastFrame = getTime();
		return delta * 0.01f;
	}
	
	public static float Delta() {
		if (paused)
			return 0;
		else
			return d * multiplayer;
	}

	public static float TotalTime() {
		return totalTime;
	}
	
	public static float Multiplayer() {
		return multiplayer;
	}
	
	public static void update() {
		d = getDelta();
		totalTime += d;
	}
	
	public static void ChangeMultiplayer (int change) {
		if (multiplayer + change < -1 && multiplayer + change >7 ) {
		} else {
			multiplayer += change;}
		}
	
	public static void Pause() {
		if (paused)
			paused = false;
		else paused = true;
	}
}
