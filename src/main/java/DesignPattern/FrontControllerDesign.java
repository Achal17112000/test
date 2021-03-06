package DesignPattern;
class HomeView {
    public void show() {
        System.out.println("*******Displaying Home Page*******");
    }
}
class StudentView {
    public void show() {
        System.out.println("*******Displaying Student Page*******");
    }
}
class Dispatcher {
    private  StudentView studentView;
    private HomeView homeView;

    public Dispatcher() {
        studentView = new StudentView();
        homeView = new HomeView();
    }

    public void dispatch(String request) {
        if(request.equalsIgnoreCase("STUDENT"))
            studentView.show();
        else
            homeView.show();
    }
}
class FrontController {
    private Dispatcher dispatcher;

    public FrontController() {
        dispatcher = new Dispatcher();
    }

    private boolean isAuthenticate() {
        System.out.println("User is authenticated successfully");
        return true;
    }

    private void trackRequest(String request) {
        System.out.println("Page requested: " + request);
    }

    public void dispatchRequest(String request) {
        //log each request
        trackRequest(request);

        //authenticate the user
        if(isAuthenticate()) {
            dispatcher.dispatch(request);
        }
    }
}
public class FrontControllerDesign {
    public static void main(String[] args) {
        FrontController frontController = new FrontController();
        frontController.dispatchRequest("Home");
        frontController.dispatchRequest("Student");
    }
}