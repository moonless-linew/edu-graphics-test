import java.awt.Point

data class Circle(var x: Int, var y: Int, var radius: Int) {
    var velocity = 0.0
    var center: Point
        get() = Point(x + radius, y + radius)
        set(value) {
            x = value.x - radius
            y = value.y - radius
        }

}