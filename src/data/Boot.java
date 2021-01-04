package data;

import helpers.Clock;
import helpers.Color_RGB;
import helpers.TextUtil;

import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import static org.lwjgl.opengl.GL11.*;
import static helpers.Artist.*;
import static helpers.Text.*;

public class Boot {

	/** time at last frame */
	long lastTimeFrame;
	/** frames per second */
	int fpsCounter;
	int fps = 0;
	/** last fps time */
	long lastFPSTime;


    public static void main(String[] arqs) {
        new Boot();
    }

    public Boot() {

        TextUtil textUtil = new TextUtil(); // textutil object
        Color_RGB setColor = new Color_RGB();
        boolean[] keys = new boolean[256];
        int i = 0;
        BeginSession();
        //Input_Key();
        int[][] map = {
                {2, 1, 1, 2, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 2, 2, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };


        TileGrid grid = new TileGrid(map);
        grid.setTile(7, 6, grid.getTile(3, 0).getType()); //duplicate tile
        Enemy e = new Enemy(QuickLoad("ultralisk-attack_3"), grid.getTile(3, 3), 64.1f, 63.9f, 5);
        Wave wave = new Wave(22, e);
        Player player = new Player(grid);

//        getDelta(); // call once before loop to initialise lastFrame
//		lastFPSTime = getTime(); // call before loop to initialise fps timer
        Clock.updateDeltaFrame();
        while (!Display.isCloseRequested()) {
        Clock.updateTotalTime();
        Clock.updateDeltaTick();
        Clock.updateFPS();
//            getDelta();
//            updateFPS();
            setColor.blacks();
            DrawSquad(0, 0, WIDTH, HEIGHT); //set BG

            playerClick(player);

            setColor.white();
            grid.draw();
            glLoadIdentity();
            wave.update();


            setColor.grey();
            DrawSquad(20, 600, 400, 80);

            int GrilleX = 583;
            int GrilleY = 692;
            int ISO_HEIGHT = 11 - 1;
            int ISO_WIDTH = 11 - 1;
            float ISO_HEIGHT_HALF = 5.5f;
            float ISO_WIDTH_HALF = 5.5f;
            float RealX = Mouse.getX() - GrilleX;
            float RealY = Mouse.getY() - GrilleY;
            float GrilleU = (float) (-1 - (Math.floor((RealX * ISO_HEIGHT_HALF + RealY * ISO_WIDTH_HALF) / (2 * ISO_HEIGHT_HALF * ISO_WIDTH_HALF) / 5.8)));
            float GrilleV = (float) (-1 - (Math.floor((-RealX * ISO_HEIGHT_HALF + RealY * ISO_WIDTH_HALF) / (2 * ISO_HEIGHT_HALF * ISO_WIDTH_HALF) / 5.8)));

            setColor.red();
            textUtil.drawText(String.valueOf(GrilleU), 60, 620);
            textUtil.drawText("X ", 40, 620);
            textUtil.drawText(String.valueOf(GrilleV), 60, 640);
            textUtil.drawText("Y", 40, 640);
            setColor.orange();
            textUtil.drawText(String.valueOf(Mouse.getX()), 200, 620);
            textUtil.drawText("mouse X ", 120, 620);
            textUtil.drawText(String.valueOf(Mouse.getY()), 200, 640);
            textUtil.drawText("mouse Y ", 120, 640);
            setColor.green();
            //need Fix
            textUtil.drawText(String.valueOf(GrilleX + ((GrilleU - GrilleV) * ISO_WIDTH_HALF)), 320, 620);
            textUtil.drawText("revert x ", 240, 620);
            textUtil.drawText(String.valueOf(GrilleY + ((GrilleU + GrilleV) * ISO_HEIGHT_HALF) + ISO_HEIGHT_HALF), 320, 640);
            textUtil.drawText("revert Y ", 240, 640);


            setColor.blue();
            DrawSquad(10, 50, 100, 100);
            setColor.cyan();
            DrawSquad(20, 70, 100, 100);
            setColor.magenta();
            DrawSquad(30, 90, 100, 100);

            DrawQuadDot(150, 50, 100, 100);

            drawString("h i j k l m n", 10, 10);
            i += 1;
            textUtil.drawText(String.valueOf(Clock.fps), 600, 600);


            Display.update();
            Display.sync(60);
        }
        Display.destroy();
        System.exit(0);
    }

    private void playerClick(Player player) {
        if (Mouse.isButtonDown(0) && !player.isMouseButton0())
        {

            player.setTile();
            // Mouse was clicked only in this frame
            int x = Mouse.getX();
            int y = Mouse.getY();
//            System.out.println("MOUSE DOWN @ X: " + x + " Y: " + y);

        }
        player.setMouseButton0(Mouse.isButtonDown(0));
    }

    public int updateFPS() {
		if (getTime() - lastFPSTime > 1000) {
            fps = fpsCounter;
			fpsCounter = 0;
			lastFPSTime += 1000;
		}
		fpsCounter++;
		return fps;
	}
	public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	public int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastTimeFrame);
		lastTimeFrame = time;

		return delta;
	}
}
