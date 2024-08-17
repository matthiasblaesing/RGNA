@Grab(group='net.java.dev.jna', module='jna', version='5.14.0')

import com.sun.jna.Native

Native.setProtected(true)
try {
    def raylib = (Raylib) Native.loadLibrary('./raylib.so', Raylib.class)
    raylib.InitWindow(600, 600, "Hello")
    def background = Color.Create([0,0,0])
    def red = Color.Create([255,0,0])
    def start = Vector2.Create([10f, 10f])
    def end = Vector2.Create([100f, 100f])
    raylib.SetTargetFPS(25)
    while (!raylib.IsWindowReady()) {}
    while (!raylib.WindowShouldClose()) {
        raylib.BeginDrawing()
        raylib.ClearBackground(background)
        raylib.DrawLine(10, 10, 500, 500, red)
        raylib.DrawLineEx(
                start,
                end,
                10.0f,
                red
        )
        raylib.DrawFPS(10, 10)
        raylib.EndDrawing()
    }
    raylib.CloseWindow()
} catch(UnsatisfiedLinkError e) {
    println 'Failed to load library'
    e.printStackTrace()
}

