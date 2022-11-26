package me.awildbrysen.themeroulette

import com.intellij.openapi.options.Configurable
import java.awt.BorderLayout
import javax.swing.JCheckBox
import javax.swing.JComponent
import javax.swing.JPanel

class ThemeRouletteConfigurable : Configurable {

    val state = ThemeRouletteState.getInstance()
    val showToolBarIconCheckBox = JCheckBox("Show Theme Roulette icon in the tool bar")

    override fun createComponent(): JComponent {
        val pnl = JPanel(BorderLayout())
        showToolBarIconCheckBox.isSelected = state?.showToolBarIcon ?: true
        pnl.add(showToolBarIconCheckBox, BorderLayout.NORTH)
        return pnl
    }

    override fun isModified(): Boolean {
        return showToolBarIconCheckBox.isSelected != state?.showToolBarIcon
    }

    override fun apply() {
        state?.showToolBarIcon = showToolBarIconCheckBox.isSelected
    }

    override fun getDisplayName(): String {
        return "Theme Roulette Settings"
    }
}