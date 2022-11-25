package me.awildbrysen.themeroulette

import com.intellij.ide.actions.QuickChangeLookAndFeel
import com.intellij.ide.ui.LafManager
import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAwareAction
import java.util.*

class ThemeRoulette : DumbAwareAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val lafManager = LafManager.getInstance()
        val lfs = lafManager.installedLookAndFeels

        val theme = lfs[Random().nextInt(lfs.size)]
        println("Changing to theme: " + theme.name)

        QuickChangeLookAndFeel.switchLafAndUpdateUI(lafManager, theme, false)
        val content = "Theme Roulette switched your theme to: " + theme.name
        NotificationGroupManager.getInstance()
                .getNotificationGroup("Theme Roulette Notification Group")
                .createNotification(content, NotificationType.INFORMATION)
                .notify(null)
    }
}