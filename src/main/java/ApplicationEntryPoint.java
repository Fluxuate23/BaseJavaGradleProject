import gui.MainFormWrapper;

public class ApplicationEntryPoint {

    public static void main(String[] args) {
        System.out.println("Launching Application Entry Point");
        MainFormWrapper mainFormWrapper = new MainFormWrapper();
        mainFormWrapper.launchForm();
    }
}
