sealed class FireType {
    object SingleShotMode : FireType()
    data class BurstMode(val shotsSize: Int) : FireType()
}