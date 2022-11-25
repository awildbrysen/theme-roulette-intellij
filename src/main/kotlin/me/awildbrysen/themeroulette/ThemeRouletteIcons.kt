package me.awildbrysen.themeroulette

import com.intellij.openapi.util.IconLoader
import com.intellij.ui.ExperimentalUI
import com.intellij.util.ui.UIUtil
import javax.swing.Icon

object ThemeRouletteIcons {
    @JvmField
    val OutlineLight = IconLoader.getIcon("outline-light.png", ThemeRouletteIcons::class.java.classLoader)
    @JvmField
    val OutlineDark = IconLoader.getIcon("outline-dark.png", ThemeRouletteIcons::class.java.classLoader)
    @JvmField
    val OutlineNewUI = IconLoader.getIcon("outline-new-ui.png", ThemeRouletteIcons::class.java.classLoader)

    fun getOutline(): Icon {
        @Suppress("UnstableApiUsage")
        if (ExperimentalUI.isNewUI()) return OutlineNewUI
        return if (UIUtil.isUnderDarcula()) {
            OutlineDark
        } else {
            OutlineLight
        }
    }
}