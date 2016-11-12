package bluestacks;

import com.zentek.colorbot.client.api.desktop.window.ChildWindow;
import com.zentek.colorbot.client.api.desktop.window.ChildWindowNode;
import com.zentek.colorbot.client.api.image.BitmapStore;
import com.zentek.colorbot.client.api.image.ocr.FontStore;
import com.zentek.colorbot.client.api.script.DesktopLibrary;

public class BlueStacksLibrary extends DesktopLibrary {

    public Tabs tabs;

    public BlueStacksLibrary(final BitmapStore bitmapStore, final FontStore fontStore, final String username,
                             final String password) {
        super(bitmapStore, fontStore, username, password);

        this.tabs = new Tabs(this);

        final ChildWindowNode[] childeren = window.getChildren();
        for (ChildWindowNode child : childeren) {
	        final ChildWindow entry = child.getData();
            if (entry.getWindowTitle().equals("BlueStacks Android Plugin")) {
                window.redirectInput(entry.getReference());
            }
        }
    }
}
