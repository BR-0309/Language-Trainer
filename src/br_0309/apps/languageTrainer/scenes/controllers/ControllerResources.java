package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.Reference;
import br_0309.apps.languageTrainer.data.ResourceData;
import br_0309.apps.languageTrainer.util.FXUtil;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class ControllerResources implements Initializable {

    public TableView<ResourceData> table;
    private String cc0;
    private String cca;
    private String pd;
    private ResourceBundle BUNDLE;

    @SuppressWarnings("unchecked")
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BUNDLE = resources;
        cc0 = resources.getString("about.cc0");
        cca = resources.getString("about.cca");
        pd = resources.getString("about.publicDomain");
        table.setItems(initData());

        TableColumn columnTitle = (TableColumn) table.getColumns().get(0);
        //noinspection Convert2Lambda
        columnTitle.setCellValueFactory(new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures param) {
                ResourceData data = (ResourceData) param.getValue();
                return new ReadOnlyStringWrapper(data.file);
            }
        });
        TableColumn columnAuthor = (TableColumn) table.getColumns().get(1);
        //noinspection Convert2Lambda
        columnAuthor.setCellValueFactory(new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures param) {
                ResourceData data = (ResourceData) param.getValue();
                return new ReadOnlyStringWrapper(data.author);
            }
        });
        TableColumn columnLicense = (TableColumn) table.getColumns().get(2);
        //noinspection Convert2Lambda
        columnLicense.setCellValueFactory(new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures param) {
                ResourceData data = (ResourceData) param.getValue();
                return new ReadOnlyStringWrapper(data.license);
            }
        });
        columnLicense.setCellFactory(column -> new TableCell<ResourceData, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setStyle("");
                } else {
                    if (item.equals(cc0)) {
                        setText(item);
                        setStyle("-fx-background-color: green");
                    } else if (item.equals(cca)) {
                        setText(item);
                        setStyle("-fx-background-color: orange");
                    } else if (item.equals(pd)) {
                        setText(item);
                        setStyle("-fx-background-color: lime");
                    } else {
                        setText(item);
                        setStyle("");
                    }
                }
            }
        });
        TableColumn columnNotes = (TableColumn) table.getColumns().get(3);
        //noinspection Convert2Lambda
        columnNotes.setCellValueFactory(new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures param) {
                ResourceData data = (ResourceData) param.getValue();
                return new ReadOnlyStringWrapper(data.notes);
            }
        });


        TableColumn columnLink = (TableColumn) table.getColumns().get(4);
        //noinspection Convert2Lambda
        columnLink.setCellValueFactory(new Callback<TableColumn.CellDataFeatures, ObservableValue>() {
            @Override
            public ObservableValue call(TableColumn.CellDataFeatures param) {
                return new ReadOnlyObjectWrapper(param.getValue());
            }
        });
        columnLink.setCellFactory(new Callback<TableColumn<ResourceData, ResourceData>, TableCell<ResourceData, ResourceData>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TableCell<ResourceData, ResourceData>() {
                    final Button button = new Button();

                    @Override
                    protected void updateItem(ResourceData item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            button.setText("");
                            setGraphic(null);
                        } else {
                            button.setText(BUNDLE.getString("about.visitLink"));
                            button.setStyle("-fx-background-color: transparent; -fx-text-fill: #54b9f8; -fx-underline: true");
                            button.setOnMouseEntered(event -> button.getScene().setCursor(Cursor.HAND));
                            button.setOnMouseExited(event -> button.getScene().setCursor(Cursor.DEFAULT));
                            button.setOnAction(event -> {
                                if (Desktop.isDesktopSupported()) {
                                    try {
                                        Desktop.getDesktop().browse(new URI(item.link));
                                    } catch (IOException | URISyntaxException e) {
                                        e.printStackTrace();
                                        // FIXME: Add message & expand
                                        FXUtil.showExceptionDialog("", "", e);
                                    }
                                }
                            });
                            setGraphic(button);
                        }
                    }
                };
            }
        });
    }

    private ObservableList<ResourceData> initData() {
        ArrayList<ResourceData> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(getClass().getResourceAsStream(Reference.COPYRIGHTS_BASE_NAME + Locale.getDefault().getLanguage() +
                                                                         Reference.COPYRIGHTS_END)));
            String line = reader.readLine();
            reader.close();

            String[] resources = line.split("¬");
            for (String s : resources) {
                String[] info = s.split(";");
                list.add(new ResourceData(info[0], info[1], info[2], info[3], info[4]));
            }

        } catch (IOException e) {
            e.printStackTrace();
            // FIXME: Add message
            FXUtil.showExceptionDialog("", "", e);
        }
        return FXCollections.observableArrayList(list);
    }

    public void onCC0() {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("https://creativecommons.org/publicdomain/zero/1.0/"));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
                // FIXME: Add message & expand
                FXUtil.showExceptionDialog("", "", e);
            }
        }
    }

    public void onCCA() {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI("https://creativecommons.org/licenses/by/3.0/"));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
                // FIXME: Add message & expand
                FXUtil.showExceptionDialog("", "", e);
            }
        }
    }

    public void onPublicDomain() {
        String URI;
        if (Locale.getDefault().getLanguage().equals("de")) {
            URI = "https://de.wikipedia.org/wiki/Gemeinfreiheit";
        } else {
            URI = "https://en.wikipedia.org/wiki/Public_domain";
        }
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(URI));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
                // FIXME: Add message & expand
                FXUtil.showExceptionDialog("", "", e);
            }
        }
    }

    public void onOk() {
        Stage stage = (Stage) table.getScene().getWindow();
        stage.close();
    }

}
