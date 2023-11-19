package fonts;

import java.awt.*;

public abstract class SideMenuFont {

    public static Font getDefaultFont() {
        return new Font("Arial", Font.PLAIN, 14);
    }

    public static Font getHoverFont() {
        return new Font("Arial", Font.BOLD, 16);
    }
}
