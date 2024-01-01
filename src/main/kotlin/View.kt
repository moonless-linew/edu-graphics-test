import java.awt.Canvas
import java.awt.Graphics
import java.awt.Point
import javax.swing.JPanel

class View : JPanel() {

    var circles: List<Circle>? = null

    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        g?.apply {
            circles?.forEach {
                drawOval(it.x, it.y, it.radius, it.radius)
            }
        }
    }

    fun onNewFrame(circles: List<Circle>) {
        this.circles = circles
        repaint()
    }

}