package bluestacks;

import com.zentek.colorbot.client.api.desktop.window.ChildWindow;
import com.zentek.colorbot.client.api.desktop.window.ChildWindowNode;

import java.util.ArrayList;
import java.util.List;

public final class Tabs {

    private final BlueStacksLibrary library;

    public Tabs(final BlueStacksLibrary library) {
        this.library = library;
    }

    public String[] getTabs() {
        final List<String> tabs = new ArrayList<>();
        final ChildWindowNode[] childeren = library.window.getChildren();
        for (ChildWindowNode child : childeren) {
            final ChildWindow entry = child.getData();
            final String title = entry.getWindowTitle();

            if (title != null && !title.equals("null") && entry.getClassName()
                    .startsWith("WindowsForms10.Window.8.app.0.1ca0192")) {
                tabs.add(title);
            }
        }
        return tabs.toArray(new String[tabs.size()]);
    }
}
