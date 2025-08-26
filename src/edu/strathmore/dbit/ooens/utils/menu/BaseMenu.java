package edu.strathmore.dbit.ooens.utils.menu;

import edu.strathmore.dbit.ooens.utils.log.Log;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author strategide
 */
public abstract class BaseMenu {

    private static final String SPACE = "  ";

    private String title;
    private List<MenuItem> items;
    private final Scanner input;

    public BaseMenu() {
        this.input = new Scanner(System.in);
        init();
    }

    private void init() {
        title = createTitle();
        items = createMenu();
        final int choice = getChoice();
        onChoice(choice);
    }

    private int getChoice() {
        int choice;

        do {
            showMenu();
            choice = input.nextInt();
        } while (!isValidChoice(choice));

        return choice;
    }

    protected abstract void onChoice(int choice);

    private boolean isValidChoice(int choice) {
        for (MenuItem item : items) {
            if (item.getChoice() == choice) {
                return true;
            }
        }

        Log.re("Invalid choice. Please try again.\n");

        return false;
    }

    protected MenuItem createItem(int choice, String description) {
        return new MenuItem(choice, description);
    }

    protected abstract String createTitle();

    protected abstract List<MenuItem> createMenu();

    private void showMenu() {
        Log.r(title);
        final int length = title.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append("-");
        }
        
        Log.r(builder.toString());

        for (MenuItem item : items) {
            String formatted = String.format("%s%s", SPACE, item.toString());
            Log.r(formatted);
        }
        System.out.printf("%s>: ", SPACE);
    }
}
