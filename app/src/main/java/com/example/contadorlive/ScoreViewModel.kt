package ccom.example.contadorlive

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import java.util.*


class ScoreViewModel: BaseObservable() {
    var scoreTeamB: String = "0"
    var scoreTeamA: String = "0"
    @Bindable
    fun getScoreTeamB(): String {
        return scoreTeamB
    }

    fun setScoreTeamB(value: String) {
        // Avoids infinite loops.
        if (scoreTeamB != value) {
            scoreTeamB = value

            // React to the change

            // Notify observers of a new value.
            notifyPropertyChanged(BR.score)
        }
    }

}