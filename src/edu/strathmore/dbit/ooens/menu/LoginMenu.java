package edu.strathmore.dbit.ooens.menu;

import edu.strathmore.dbit.ooens.utils.menu.BaseMenu;
import edu.strathmore.dbit.ooens.utils.menu.MenuItem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author strategide
 */
public class LoginMenu extends BaseMenu {
    private static final String TITLE = "Enter Your Credentials";
    
    @Override
    protected void onChoice(int choice) {
    }

    @Override
    protected String createTitle() {
        return TITLE;
    }

    @Override
    protected List<MenuItem> createMenu() {
        final List<MenuItem> list = new ArrayList<>();
        
        return list;
    }
}
