open class TV (val brand: String, val model: String, val diagonal: Int, private val channelsList: List<MyChannel>) {

    var volume: Int = 0
    private var isTurnedOn: Boolean = false
    private val maxVolume: Int = 100
    private lateinit var currentChannel: String
    private val channelsQuantity = channelsList.size
    private var currentChannelNumber: Int = 0

    fun isOn ()
    {
        if (isTurnedOn) println ("\nThe TV is on")
        else println ("\nThe TV is off")
    }

    fun switchOnOff ()
    {
        isTurnedOn = !isTurnedOn
        isOn()
        println ("The TV has been toggled")
    }

    fun volumeTVUp (upN: Int)
    {
        if (this.isTurnedOn)
        {
            volume += upN
            if (volume > maxVolume) volume = maxVolume
            println("Volume: $volume")
        }
        println ("Volume has been turned up")
    }

    fun volumeTVDown (downN: Int)
    {
        if (this.isTurnedOn)
        {
            volume -= downN
            if (volume < 0) volume = 0
            println("Volume: $volume")
        }
        println ("Volume has been turned down")
    }

    fun switchToChannel (chNumber: Int)
    {
        if (this.isTurnedOn)
        {
            if ( (chNumber > 0) && (chNumber < channelsQuantity))
            {
                currentChannelNumber = chNumber
            }
        }
        println ("Channel has been changed")
        println (channelsList[currentChannelNumber].name)
    }

    fun switchToChannelUp ()
    {
        if (this.isTurnedOn)
        {
            this.currentChannelNumber++
            if (this.currentChannelNumber > this.channelsQuantity) this.currentChannelNumber = 0
        }
        println ("Channel has been turned up")
        println(channelsList[currentChannelNumber].name)
    }

    fun switchToChannelDown ()
    {
        if (this.isTurnedOn)
        {
            this.currentChannelNumber--
            if (this.currentChannelNumber < 0) this.currentChannelNumber = this.channelsQuantity
        }
        println ("Channel has been turned down")
        println(channelsList[currentChannelNumber].name)
    }

    fun showListOfChannels ()
    {
        if (this.isTurnedOn)
        {
            println("Channels list:")
            channelsList.forEach { myChannel: MyChannel -> println("    ${myChannel.name}")}
            println("Channels list finished\n")
        }
    }
}