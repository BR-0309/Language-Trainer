package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.LanguageHandler;
import br_0309.apps.languageTrainer.LanguageTrainer;
import br_0309.apps.languageTrainer.data.Statistics;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.util.Callback;

import java.net.URL;
import java.text.DateFormat;
import java.util.*;
import java.util.stream.Collectors;

// FIXME: Make charts have the correct colors (ha ha)
// FIXME: Fix empty lists being shown
public class ControllerStatistics implements Initializable, IController {

    private ResourceBundle BUNDLE;
    @FXML
    public ListView<Statistics> list;
    @FXML
    public LineChart<String, Integer> lineChart;
    @FXML
    public PieChart pieChart;
    @FXML
    public BarChart<String, Integer> barChart;
    @FXML
    public TextField txtSearch;
    private final ArrayList<Statistics> allStatistics = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BUNDLE = resources;
        ArrayList<Statistics> tempList = new ArrayList<>();
        allStatistics.addAll(LanguageTrainer.userData.stats);

        for (Statistics stat : allStatistics) {
            boolean add = true;
            for (Statistics s : tempList) {
                if (s.listType == stat.listType && s.listName.equals(stat.listName) && Arrays.equals(s.langCodes, stat.langCodes)) add = false;
            }
            if (add) {
                tempList.add(stat);
            }
        }

        FilteredList<Statistics> listData = new FilteredList<>(FXCollections.observableList(tempList));
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            listData.setPredicate(s -> s.listName.trim().contains(newValue.toLowerCase().trim()));
        });
        list.setItems(listData);
        txtSearch.requestFocus();
        list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            prepareCharts(newValue);
        });
        list.getSelectionModel().selectFirst();
        list.setCellFactory(new Callback<ListView<Statistics>, ListCell<Statistics>>() {
            @Override
            public ListCell<Statistics> call(ListView<Statistics> param) {
                return new ListCell<Statistics>() {
                    final Label text = new Label();
                    final Label icon1 = new Label();
                    final Label icon2 = new Label();
                    // Render everything in a HBox
                    private final HBox cell;

                    {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        cell = new HBox();
                        HBox.setHgrow(icon1, Priority.ALWAYS);
                        icon1.setPadding(new Insets(0, 5, 0, 0));
                        cell.getChildren().add(icon1);
                        HBox.setHgrow(icon2, Priority.ALWAYS);
                        icon2.setPadding(new Insets(0, 5, 0, 0));
                        cell.getChildren().add(icon2);
                        cell.getChildren().add(text);
                    }

                    @Override
                    protected void updateItem(Statistics item, boolean isEmpty) {
                        super.updateItem(item, isEmpty);
                        if (item == null || isEmpty) {
                            setGraphic(null);
                        } else {
                            text.setText(item.listName);
                            icon1.setGraphic(new ImageView(LanguageHandler.getFlag(new Locale(item.langCodes[0]))));
                            if (item.listType) {
                                icon2.setGraphic(new ImageView(LanguageHandler.getFlag(new Locale(item.langCodes[1]))));
                            }
                            setGraphic(cell);
                        }
                    }
                };
            }
        });
    }

    public void exit() {
        LanguageTrainer.showMenu();
    }

    public void prepareCharts(Statistics stat) {
        ArrayList<Statistics> stats = allStatistics.stream().filter(s -> s.listType == stat.listType && s.listName.equals(stat.listName) &&
                                                                         Arrays.equals(s.langCodes, stat.langCodes))
                                                   .collect(Collectors.toCollection(ArrayList::new));
        if (stats.isEmpty()) {
            return;
        }
        Collections.sort(stats);
        lineChart.getData().clear();
        pieChart.getData().clear();
        barChart.getData().clear();
        int totalCorrect = 0;
        int totalIncorrect = 0;
        int totalCheated = 0;
        XYChart.Series<String, Integer> seriesCorrect = new XYChart.Series<>();
        XYChart.Series<String, Integer> seriesIncorrect = new XYChart.Series<>();
        XYChart.Series<String, Integer> seriesCheated = new XYChart.Series<>();


        DateFormat formatter = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
        for (Statistics s : stats) {
            totalCorrect += s.correct;
            totalIncorrect += s.incorrect;
            totalCheated += s.cheated;
            seriesCorrect.getData().add(new XYChart.Data<>(formatter.format(s.date), s.correct));
            seriesIncorrect.getData().add(new XYChart.Data<>(formatter.format(s.date), s.incorrect));
            seriesCheated.getData().add(new XYChart.Data<>(formatter.format(s.date), s.cheated));
        }
        //noinspection unchecked
        lineChart.getData().addAll(seriesCorrect, seriesIncorrect, seriesCheated);
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(new PieChart.Data(BUNDLE.getString("statistics.correct"), totalCorrect),
                                                                                  new PieChart.Data(BUNDLE.getString("statistics.incorrect"), totalIncorrect),
                                                                                  new PieChart.Data(BUNDLE.getString("statistics.cheated"), totalCheated));
        pieChart.getData().addAll(pieData);
        XYChart.Series<String, Integer> barSeriesCorrect = new XYChart.Series<>();
        barSeriesCorrect.getData().add(new XYChart.Data<>(BUNDLE.getString("statistics.correct"), totalCorrect));
        XYChart.Series<String, Integer> barSeriesIncorrect = new XYChart.Series<>();
        barSeriesIncorrect.getData().add(new XYChart.Data<>(BUNDLE.getString("statistics.incorrect"), totalIncorrect));
        XYChart.Series<String, Integer> barSeriesCheated = new XYChart.Series<>();
        barSeriesCheated.getData().add(new XYChart.Data<>(BUNDLE.getString("statistics.cheated"), totalCheated));
        //noinspection unchecked
        barChart.getData().addAll(barSeriesCorrect, barSeriesIncorrect, barSeriesCheated);
    }

    @Override
    public void onExit() {

    }

    @Override
    public void onInsert(char c) {

    }
}
