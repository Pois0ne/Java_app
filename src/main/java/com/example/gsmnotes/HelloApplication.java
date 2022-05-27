package com.example.gsmnotes;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class HelloApplication extends javafx.application.Application {


    public static DeviceService deviceService;

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        context = SpringApplication.run(HelloApplication.class);
        deviceService = context.getBean(DeviceService.class);

        stage.setTitle("GSM.Notes");

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainUi2.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void stop() throws Exception {
        super.stop();
        context.close();
    }

}