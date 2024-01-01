import java.awt.Point

class Engine(private val onUpdate: (List<Circle>) -> Unit) {

    private var acceleration = 0.5
    private var velocity = 0.0
    private var jumpingK = 0.9
    private val circles: MutableList<Circle> = mutableListOf()
    private var counter = 0


    init {
        repeat(40) {
            circles.add(
                Circle(it * 40 + 50, 100, 40)
            )
        }
    }


    private val ticker = Ticker {
        onNextTick()
    }

    fun start() {
        ticker.startTicker()
    }

    fun stop() {
        ticker.stopTicker()
    }


    private fun onNextTick() {
        circles.forEachIndexed { index, it ->
            if (index <= counter) {
                it.velocity += acceleration
                if (it.y >= 1000) {
                    it.velocity = (-it.velocity * jumpingK + acceleration)
                }
                it.y += it.velocity.toInt()
                it.y = it.y.coerceAtMost(1000)
            }
        }
        counter ++
        onUpdate(circles)
    }

}