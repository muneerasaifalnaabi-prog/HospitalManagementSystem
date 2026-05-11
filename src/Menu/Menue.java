package Menu;

import Utiles.MenuMessege;

public class Menue implements MenuInterface {
    @Override
    public void displayMenu() {
        System.out.print(MenuMessege.MAIN_MENU_MESSEGE);
    }

    @Override
    public void exitMenu() {

    }



}
