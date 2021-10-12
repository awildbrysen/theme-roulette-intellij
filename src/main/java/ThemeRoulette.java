import com.intellij.ide.actions.QuickChangeLookAndFeel;
import com.intellij.ide.ui.LafManager;
import com.intellij.notification.*;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Random;

public class ThemeRoulette extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        LafManager lafMan = LafManager.getInstance();
        UIManager.LookAndFeelInfo[] lfs = lafMan.getInstalledLookAndFeels();

        int l = lfs.length;
        Random random = new Random();
        int i = random.nextInt(l);
        UIManager.LookAndFeelInfo theme = lfs[i];
        System.out.println("Changing to theme: " + theme.getName());
        QuickChangeLookAndFeel.switchLafAndUpdateUI(lafMan, theme, false);

        String content = "Theme Roulette switched your theme to: " + theme.getName();
        NotificationGroupManager.getInstance()
                .getNotificationGroup("Theme Roulette Notification Group")
                .createNotification(content, NotificationType.INFORMATION)
                .notify(null);
    }
}
