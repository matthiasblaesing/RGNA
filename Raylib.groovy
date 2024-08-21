import com.sun.jna.*
import static com.sun.jna.Structure.*

class Vector2 extends Structure {
    public float x, y
    static class Value extends Vector2 implements ByValue {
        /*Value(x, y) {
            super()
            ensureAllocated()
            byte[] buffer = Utils.FloatArray2ByteArray([x, y] as float[])
            getPointer().write(0, buffer, 0, buffer.length)
            read()
        }*/
    }
    static def Create(List vector) {
        def result = new Value()
        result.ensureAllocated()
        result.x = vector[0] as float
        result.y = vector[1] as float
        result.write()
        return result
    }
    @Override
    protected List getFieldOrder() {
        return ['x', 'y']
    }
}

class Vector3 extends Structure {
    public float x, y, z
    static class ByValue extends Vector3 implements Structure.ByValue {}
    static def Create(List vector) {
        def result = new ByValue()
        result.x = vector[0] as float
        result.y = vector[1] as float
        result.z = vector[2] as float
        return result
    }
    @Override
    protected List getFieldOrder() {
        return ['x', 'y', 'z']
    }
}

class Vector4 extends Structure {
    public float x, y, z, w
    static class ByValue extends Vector4 implements Structure.ByValue {}
    static def Create(List vector) {
        def result = new ByValue()
        result.x = vector[0] as float
        result.y = vector[1] as float
        result.z = vector[2] as float
        result.w = vector[3] as float
        return result
    }
    @Override
    protected List getFieldOrder() {
        return ['x', 'y', 'z', 'w']
    }
}

class Matrix extends Structure {
    float m0, m4, m8, m12
    float m1, m5, m9, m13
    float m2, m6, m10, m14
    float m3, m7, m11, m15
    static class ByValue extends Matrix implements Structure.ByValue {}
    static def Create(List vector) {
        def result = new ByValue()
        result.m0 = vector[0] as float
        result.m4 = vector[1] as float
        result.m8 = vector[2] as float
        result.m12 = vector[3] as float
        result.m1 = vector[0] as float
        result.m5 = vector[1] as float
        result.m9 = vector[2] as float
        result.m13 = vector[3] as float
        result.m2 = vector[0] as float
        result.m6 = vector[1] as float
        result.m10 = vector[2] as float
        result.m14 = vector[3] as float
        result.m3 = vector[0] as float
        result.m7 = vector[1] as float
        result.m11 = vector[2] as float
        result.m15 = vector[3] as float
        return result
    }
    @Override
    protected List getFieldOrder() {
        return ['m0', 'm4', 'm8', 'm12',
                'm1', 'm5', 'm9', 'm13',
                'm2', 'm6', 'm10', 'm14',
                'm3', 'm7', 'm11', 'm15']
    }
}

class Color extends Structure {
    public byte r, g, b, a
    static class Value extends Color implements ByValue {
        /*Value(r, g, b, a=255) {
            super()
            ensureAllocated()
            byte[] buffer = [r, g, b, a] as byte[]
            getPointer().write(0, buffer, 0, buffer.length)
            read()
        }*/
    }
    static def Create(List color) {
        def result = new Value()
        result.ensureAllocated()
        result.r = (byte)color[0]
        result.g = (byte)color[1]
        result.b = (byte)color[2]
        result.a = color.size() > 3 ? (byte)color[3]: (byte)255
        result.write()
        return result
    }
    @Override
    protected List getFieldOrder() {
        return ['r', 'g', 'b', 'a']
    }
}

class Rectangle extends Structure {
    public float x, y, width, height
    static class ByValue extends Rectangle implements Structure.ByValue {}
    static def Create(List rect) {
        def result = new ByValue()
        result.x = rect[0] as float
        result.y = rect[1] as float
        result.width = rect[2] as float
        result.height = rect[3] as float
        return result
    }
    @Override
    protected List getFieldOrder() {
        return ['x', 'y', 'width', 'height']
    }
}

class Camera2D extends Structure {
    Vector2 offset
    Vector2 target
    float rotation
    float zoom
    static class ByValue extends Camera2D implements Structure.ByValue {}
    static def Create(Vector2 offset, Vector2 target, float rotation, float zoom) {
        def result = new ByValue()
        result.offset = offset
        result.target = target
        result.rotation = rotation
        result.zoom = zoom
        return result
    }
    @Override
    protected List getFieldOrder() {
        return ['offset', 'target', 'rotation', 'zoom']
    }
}

interface Raylib extends Library {
    void InitWindow(int width, int height, String title)
    void CloseWindow()
    byte WindowShouldClose() // potentiell kaput
    byte IsWindowReady() // potentiell kaput

    void SetTargetFPS(int fps)
    float GetFrameTime()
    double GetTime()
    int GetFPS()

    void BeginDrawing()
    void ClearBackground(Color.Value color)
    void EndDrawing()

    Color.Value GetColor(int hexValue) // kaputt

    void DrawFPS(int posX, int posY)
    void DrawText(String text, int posX, int posY, int fontSize, Color.Value color)

    void DrawPixel(int posX, int posY, Color.Value color)
    void DrawPixelV(Vector2.Value position, Color.Value color)
    void DrawLine(int startPosX, int startPosY, int endPosX, int endPosY, Color.Value color)
    void DrawLineV(Vector2.Value startPos, Vector2.Value endPos, Color.Value color)
    void DrawLineEx(Vector2.Value startPos, Vector2.Value endPos, float thick, Color.Value color)
    // void DrawLineStrip(Buffer points, int pointCount, Color color)
    void DrawLineBezier(Vector2.Value startPos, Vector2.Value endPos, float thick, Color.Value color)
}

/*class UnsignedInt extends IntegerType {
    UnsignedInt() {
        super(4, true);
    }
}
*/
