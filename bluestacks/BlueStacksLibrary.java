package bluestacks;

import com.zentek.colorbot.client.api.desktop.window.ChildWindow;
import com.zentek.colorbot.client.api.image.BitmapStore;
import com.zentek.colorbot.client.api.image.ocr.FontStore;
import com.zentek.colorbot.client.api.script.DesktopLibrary;

public class BlueStacksLibrary extends DesktopLibrary {

    public Tabs tabs;

    public BlueStacksLibrary(final BitmapStore bitmapStore, final FontStore fontStore, final String username,
                             final String password) {
        super(bitmapStore, fontStore, username, password);

        this.tabs = new Tabs(this);

        final ChildWindow[] childeren = window.getChildren();
        for (ChildWindow child : childeren) {
            if (child.getWindowTitle().equals("BlueStacks Android Plugin")) {
                window.redirectInput(child);
            }
        }
        window.setAbsolutePositioning(true);
    }
}
