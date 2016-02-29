package helpers;

import org.lwjgl.Sys;

public class Clock {
	
	private static boolean paused = false;
	public static long LastFrame, totalTime;
	public static float d=0, multiplayer = 1;
	private static long lastFrame; // time at last frame
	public static float timeElapsed; // 10/fps
	private static int fps; // fps
	public static int FPS; // fps to show as text
	private static long lastFPS; // last fps
	private static double seconds; // how long game loads
	
	public static long getTime() {
		return Sys.getTime() *1000 / Sys.getTimerResolution();
	}
	
	public static void fps_count() {
		
		
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
	
	public static int getDelta2() {
		// method to get delta value
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;
		return delta;
	}	
	

	public static void updateFPS() {
		// fps counter
		if (getTime() - lastFPS > 1000) {
			FPS = fps;
			timeElapsed = (float) 10 / fps;

			fps = 0;
			lastFPS += 1000;
		}
		fps++;

	}
	
	public static float Multiplayer() {
		return multiplayer;
	}

	
	public static void update() {
		d = getDelta();
		totalTime += d;
		long start = System.nanoTime(); //start time
		getDelta2();
		lastFPS = getTime();
		long end = System.nanoTime();  //end time
		long elapsedTime = end - start; // tells how long game loads in nanoseconds
		seconds = (double)elapsedTime / 1000000000.0; //tells how long game loads in seconds
		
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
