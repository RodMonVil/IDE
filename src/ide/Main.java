package ide;

import ide.Controllers.MainController;

public class Main {
    
    public static void main(String args[]) {
        DatabaseManager.setConnectionData("jdbc:mysql://localhost:3306/", "projects", "root", "root");
        MainController mainController = new MainController();
    }
}