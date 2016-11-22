package bluestacks;

import com.zentek.colorbot.client.api.desktop.window.ChildWindow;

import java.util.ArrayList;
import java.util.List;

public final class Tabs {

    private final BlueStacksLibrary library;

    public Tabs(final BlueStacksLibrary library) {
        this.library = library;
    }

    public String[] getTabs() {
        final List<String> tabs = new ArrayList<>();
        final ChildWindow[] childeren = library.window.getChildren();
        for (ChildWindow child : childeren) {
            final String title = child.getWindowTitle();

            if (title != null && !title.equals("null") && child.getClassName()
                    .startsWith("WindowsForms10.Window.8.app.0.1ca0192")) {
                tabs.add(title);
            }
        }
        return tabs.toArray(new String[tabs.size()]);
    }
}
