package View;
import Model.Model;
import Model.AllModels;
import ViewModel.ViewModel;
import ViewModel.AllViewModels;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        AllModels model = new Model();
        AllViewModels viewModel = new ViewModel((Model)model);
        model.addObserver(viewModel);
        FXMLLoader fxml = new FXMLLoader();
        fxml.setLocation(getClass().getResource("App.fxml"));
        Parent root = fxml.load();
        Controller mwc = fxml.getController(); // View
        mwc.setViewModel((ViewModel) viewModel);
        viewModel.addObserver(mwc);
        primaryStage.setTitle("Flight Simulator");
        primaryStage.setScene(new Scene(root, 797, 571));
        primaryStage.getScene().getStylesheets().add(getClass().getResource("charts.css").toExternalForm());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}