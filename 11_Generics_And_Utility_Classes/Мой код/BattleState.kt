sealed class BattleState{
    object Progress : BattleState()
    object WinThe1st : BattleState()
    object WinThe2nd : BattleState()
    object Draw : BattleState()
}