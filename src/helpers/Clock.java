package helpers;

import org.lwjgl.Sys;

public class Clock {

    private static boolean paused = false;
    public static long lastTimeFrame, lastTimeTick, totalTime;
    public static float deltaTick = 0, deltaFrame = 0;
    public static float multiPlayers = 1; //delta time to draw one scene

    /** frames per second, to show as text */
    public static int fpsCounter = 0;
    public static int fps = 0;

    /**
     * Get the accurate system time
     *
     * @return The system time in milliseconds
     */
    public static long getTime() {
        return Sys.getTime() * 1000 / Sys.getTimerResolution();
    }

    /**
     * Calculate how many milliseconds have passed
     * since last frame.
     *
     * @return milliseconds passed since last frame
     */
    public static float getDeltaTickOrFrame(boolean isUpdateFrame) {
        // method to get delta value for one tick
        long currentTime = getTime();
        int delta;
         if (isUpdateFrame) {
             delta = (int) (currentTime - lastTimeFrame);
             lastTimeFrame = currentTime;
         } else {
             delta = (int) (currentTime - lastTimeTick);
             lastTimeTick = currentTime;
         }
        return delta * 0.01f;
    }



    /**
     * Calculate the FPS and set it in the title bar
     */
    public static void updateFPS() {
        if (getTime() - lastTimeFrame > 1000) {
            fps = fpsCounter;
            fpsCounter = 0;
            lastTimeFrame += 1000;
        }
        fpsCounter++;
    }

    public static float upDeltaTick() {
        if (paused)
            return 0;
        else
            return deltaTick * multiPlayers;
    }

    public static float TotalTime() {
        return totalTime;
    }

    public static float Multiplayer() {
        return multiPlayers;
    }

    public static void updateTotalTime() {
        totalTime += deltaTick;
    }

//	public static void update2() {
//		d = getDelta();
//		totalTime += d;
//		long start = System.nanoTime(); //start time
//		getDelta2();
//		lastFPS = getTime();
//		long end = System.nanoTime();  //end time
//		long elapsedTime = end - start; // tells how long game loads in nanoseconds
//		seconds = (double)elapsedTime / 1000000000.0; //tells how long game loads in seconds
//
//	}

//    public static void changeMultiplayer(int change) {
//        if (multiPlayers + change < -1 && multiPlayers + change > 7) {
//        } else {
//            multiPlayers += change;
//        }
//    }

    public static void Pause() {
        if (paused)
            paused = false;
        else paused = true;
    }

    public static void updateDeltaTick() {
        deltaTick = getDeltaTickOrFrame(false);
    }

    public static void updateDeltaFrame() {
        deltaFrame = getDeltaTickOrFrame(true);
    }
}
