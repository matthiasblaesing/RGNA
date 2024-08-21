package io.github.lonesay.RGNA;

import com.sun.jna.Library;
import com.sun.jna.Structure;
import com.sun.jna.Structure.FieldOrder;

public interface Raylib extends Library {

    @FieldOrder({"x", "y"})
    public static class Vector2 extends Structure {

        public float x, y;

        public static class ByValue extends Vector2 implements Structure.ByValue {
        }
    }

    @FieldOrder({"x", "y", "z"})
    public static class Vector3 extends Structure {

        public float x, y, z;

        public static class ByValue extends Vector3 implements Structure.ByValue {
        }
    }

    @FieldOrder({"x", "y", "z", "w"})
    public static class Vector4 extends Structure {

        public float x, y, z, w;

        public static class ByValue extends Vector4 implements Structure.ByValue {
        }
    }

    @FieldOrder({
        "m0", "m4", "m8", "m12",
        "m1", "m5", "m9", "m13",
        "m2", "m6", "m10", "m14",
        "m3", "m7", "m11", "m15"
    })
    public static class Matrix extends Structure {

        public float m0, m4, m8, m12;
        public float m1, m5, m9, m13;
        public float m2, m6, m10, m14;
        public float m3, m7, m11, m15;

        public static class ByValue extends Matrix implements Structure.ByValue {
        }
    }

    @FieldOrder({"r", "g", "b", "a"})
    public static class Color extends Structure {

        public byte r, g, b;
        public byte a = (byte) 255;

        public static class ByValue extends Color implements Structure.ByValue {
        }
    }

    @FieldOrder({"x", "y", "width", "height"})
    public static class Rectangle extends Structure {

        public float x, y, width, height;

        public static class ByValue extends Rectangle implements Structure.ByValue {
        }
    }

    @FieldOrder({"offset", "target", "rotation", "zoom"})
    public static class Camera2D extends Structure {

        public Vector2 offset;
        public Vector2 target;
        public float rotation;
        public float zoom;

        public static class ByValue extends Camera2D implements Structure.ByValue {
        }
    }

    void InitWindow(int width, int height, String title);

    void CloseWindow();

    byte WindowShouldClose();

    byte IsWindowReady();

    void SetTargetFPS(int fps);

    float GetFrameTime();

    double GetTime();

    int GetFPS();

    void BeginDrawing();

    void ClearBackground(Color.ByValue color);

    void EndDrawing();

    Color.ByValue GetColor(int hexValue);

    void DrawFPS(int posX, int posY);

    void DrawText(String text, int posX, int posY, int fontSize, Color.ByValue color);

    void DrawPixel(int posX, int posY, Color.ByValue color);

    void DrawPixelV(Vector2.ByValue position, Color.ByValue color);

    void DrawLine(int startPosX, int startPosY, int endPosX, int endPosY, Color.ByValue color);

    void DrawLineV(Vector2.ByValue startPos, Vector2.ByValue endPos, Color.ByValue color);

    void DrawLineEx(Vector2.ByValue startPos, Vector2.ByValue endPos, float thick, Color.ByValue color);

    void DrawLineBezier(Vector2.ByValue startPos, Vector2.ByValue endPos, float thick, Color.ByValue color);
}
