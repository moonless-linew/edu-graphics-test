import kotlinx.coroutines.*

class Ticker(private val action: () -> Unit) {

    companion object{

        const val TICK = 8L
    }

    private var tickerJob: Job? = null
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    fun startTicker(){
        tickerJob = coroutineScope.launch {
            while (isActive) {
                delay(TICK)
                action.invoke()
            }
        }
    }

    fun stopTicker(){
        tickerJob?.cancel()
        tickerJob = null
    }

}