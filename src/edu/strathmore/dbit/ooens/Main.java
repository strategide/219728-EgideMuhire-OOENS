package edu.strathmore.dbit.ooens;

import edu.strathmore.dbit.ooens.controller.SessionController;
import edu.strathmore.dbit.ooens.db.Database;

/**
 *
 * @author strategide
 */
public class Main {
    public static void main(String[] args) {
        final Database db = Database.getInstance();
        SessionController session = new SessionController();
    }
}
