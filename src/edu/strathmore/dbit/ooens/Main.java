package edu.strathmore.dbit.ooens;

import edu.strathmore.dbit.ooens.controller.SessionController;
import edu.strathmore.dbit.ooens.db.Database;
import edu.strathmore.dbit.ooens.menu.SessionMenu;

/**
 *
 * @author strategide
 */
public class Main {
    public static void main(String[] args) {
        final Database db = Database.getInstance();
        SessionController session = new SessionController();
        
        SessionMenu menu = new SessionMenu();
    }
}
