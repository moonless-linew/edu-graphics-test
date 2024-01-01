import javax.swing.JFrame

fun main() {
    val graphic = View()
    val engine = Engine{
        graphic.onNewFrame(it)
    }
    JFrame().apply {
        add(graphic)
        setSize(1000, 1200)
        isVisible = true
        title = "Graphics test"
    }
    engine.start()
}