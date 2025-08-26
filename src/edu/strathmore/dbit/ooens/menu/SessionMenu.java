package edu.strathmore.dbit.ooens.menu;

import edu.strathmore.dbit.ooens.utils.menu.BaseMenu;
import edu.strathmore.dbit.ooens.utils.menu.MenuItem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author strategide
 */
public class SessionMenu extends BaseMenu {

    private static final String TITLE = "Welcome to OOENS!";

    @Override
    protected void onChoice(int choice) {
        System.out.println("You have selected " + choice);
    }

    @Override
    protected List<MenuItem> createMenu() {
        final List<MenuItem> items = new ArrayList<>();

        items.add(createItem(1, "Login"));
        items.add(createItem(2, "Register"));

        return items;
    }

    @Override
    protected String createTitle() {
        return TITLE;
    }
}
