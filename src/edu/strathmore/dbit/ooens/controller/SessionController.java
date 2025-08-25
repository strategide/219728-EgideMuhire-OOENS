package edu.strathmore.dbit.ooens.controller;

/**
 *
 * @author strategide
 */
public class SessionController extends BaseController {

    private static final String TABLE = "session";

    public SessionController() {
        super(TABLE);
    }

    @Override
    protected String[] getCreateColumns() {
        return new String[] {
            "studentId TEXT NOT NULL",
            "token TEXT NOT NULL",
            "cookie TEXT NOT NULL",
        };
    }
}
