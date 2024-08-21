package io.github.lonesay.RGNA;

import com.sun.jna.Native;
import io.github.lonesay.RGNA.Raylib.Color;
import io.github.lonesay.RGNA.Raylib.Vector2;
import java.util.Date;

public class App {

    public static void main(String[] args) {
        Raylib raylib = Native.load("raylib", Raylib.class);
        raylib.InitWindow(600, 600, "Hello");
        Color.ByValue background = new Color.ByValue();
        Color.ByValue red = new Color.ByValue();
        red.r = (byte) 255;
        Vector2.ByValue start = new Vector2.ByValue();
        start.x = 10f;
        start.y = 10f;
        Vector2.ByValue end = new Vector2.ByValue();
        end.x = 100f;
        end.y = 100f;
        raylib.SetTargetFPS(25);
        while (raylib.IsWindowReady() == 0) {
        }
        while (raylib.WindowShouldClose() == 0) {
            raylib.BeginDrawing();
            raylib.ClearBackground(background);
            raylib.DrawLine(10, 10, 500, 500, red);
            raylib.DrawLineEx(
                    start,
                    end,
                    10.0f,
                    red
            );
            raylib.DrawFPS(10, 10);
            raylib.DrawText(new Date().toString(), 80, 40, 20, red);
            raylib.EndDrawing();
        }
        raylib.CloseWindow();
    }
}
