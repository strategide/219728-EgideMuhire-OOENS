package edu.strathmore.dbit.ooens.utils.menu;

/**
 *
 * @author strategide
 */
public class MenuItem {
    private int choice;
    private String description;

    public MenuItem(int choice, String description) {
        this.choice = choice;
        this.description = description;
    }

    public int getChoice() {
        return choice;
    }

    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return choice + " - " + description;
    }
}
