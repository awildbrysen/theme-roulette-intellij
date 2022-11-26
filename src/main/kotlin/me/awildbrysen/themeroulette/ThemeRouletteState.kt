package me.awildbrysen.themeroulette

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@State(
    name = "me.awildbrysen.themeroulette.ThemeRouletteState",
    storages = [Storage("ThemeRoulettePluginSettings.xml")]
)
class ThemeRouletteState : PersistentStateComponent<ThemeRouletteState> {

    var showToolBarIcon = true

    companion object {
        fun getInstance(): ThemeRouletteState? {
            return ApplicationManager.getApplication().getService(ThemeRouletteState::class.java)
        }
    }

    override fun getState(): ThemeRouletteState {
        return this
    }

    override fun loadState(state: ThemeRouletteState) {
        XmlSerializerUtil.copyBean(state, this)
    }
}