package com.example.gsmnotes.gui;

import com.example.gsmnotes.DeviceService;
import com.example.gsmnotes.HelloApplication;
import com.example.gsmnotes.gui.DeviceTile;
import com.example.gsmnotes.entities.Device;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeviceController implements Initializable {

    @FXML
    private ListView deviceListView;
    DeviceService deviceService = HelloApplication.deviceService;
    public static final ObservableList<Device> devicesList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.deviceListView.setItems(devicesList);
        this.devicesList.addAll(this.deviceService.getAllDevices());

        this.deviceListView.setCellFactory(lv -> {
            ListCell<Device> cell = new ListCell<Device>() {
                @Override
                protected void updateItem(Device item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        return;
                    }
                    DeviceTile c = new DeviceTile();
                    c.setDevice(item);
                    setGraphic(c);
                }
            };
            cell.setOnMouseClicked(e -> {
                if (!cell.isEmpty()) {
                    try {
                        Device d = (Device) deviceListView.getSelectionModel().getSelectedItem();
                        this.deviceSelected(e, d);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    e.consume();
                }
            });
            return cell;
        });
    }



    // Здесь будем хранить идентификатор устройства, которое прямо сейчас редактирует пользователь
    Device selectedDevice = null;

    public void deviceSelected(MouseEvent mouseEvent, Device selectedItem) throws IOException {

        // TODO: реализуем логику сохранения данных об устройстве
        /*
            если устройство уже было открыто, то нужно сохранить изменения
        */
        if (selectedDevice != null) {
            // selectedDevice.setId( обращаемся к соответствующему элементу интерфейса .getText() );
            this.deviceService.updateDevice(selectedDevice);
        }


        // если мы сохранили все, что можем отрисовывать данные следующего устройства
        this.selectedDevice = selectedItem;

        // обращаемся к соответствующему элементу интерфейса .setText() ...


        System.out.println(selectedItem.getName());
    }

}

