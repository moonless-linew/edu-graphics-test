import java.awt.Graphics
import java.awt.Point

interface Entity {

    val center: Point

    fun draw(g: Graphics)

}