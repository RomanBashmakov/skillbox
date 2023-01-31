fun main(args: Array<String>) {

    val Channels = object {
        private val myChannelsList = List<MyChannel>(100){MyChannel("Channel ${it.toString()}")}
        fun getRandomChannels (quantity: Int): List<MyChannel>{
            return myChannelsList
                .shuffled()
                .take(quantity)
        }
    }

    val newTV1 = TV("LG", "bu1",10, Channels.getRandomChannels((0..100).random()))
    val newTV2 = TV("LG", "bu2",11, Channels.getRandomChannels((0..100).random()))
    val newTV3 = TV("LG", "bu3",12, Channels.getRandomChannels((0..100).random()))

    checkTV (newTV1)
    checkTV (newTV2)
    checkTV (newTV3)

}

fun checkTV (checkedTV: TV)
{
    //When TV is off
    checkedTV.isOn()
    checkedTV.showListOfChannels()
    checkedTV.switchToChannelUp()
    checkedTV.switchToChannelDown()
    for (i in 0..10) checkedTV.volumeTVUp(i)
    for (i in 0..10) checkedTV.volumeTVDown(i)
    for (i in 0..10) checkedTV.switchToChannel(i)

    //When TV is on
    checkedTV.switchOnOff()
    checkedTV.showListOfChannels()
    checkedTV.switchToChannelUp()
    checkedTV.switchToChannelDown()
    for (i in 0..10) checkedTV.volumeTVUp(i)
    for (i in 0..10) checkedTV.volumeTVDown(i)
    for (i in 0..10) checkedTV.switchToChannel(i)
}