package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.LanguageHandler;
import br_0309.apps.languageTrainer.LanguageTrainer;
import br_0309.apps.languageTrainer.data.Statistics;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.util.Callback;

import java.net.URL;
import java.text.DateFormat;
import java.util.*;
import java.util.stream.Collectors;

// FIXME: Fix empty lists being shown
public class ControllerStatistics implements Initializable, IController {

    private final ArrayList<Statistics> allStatistics = new ArrayList<>();

    public ListView<Statistics> list;
    public LineChart<String, Number> lineChart;
    public PieChart pieChart;
    public StackedBarChart<String, Number> barChart;
    public TextField txtSearch;
    public CategoryAxis xAxisBar;
    public NumberAxis yAxisBar;
    public NumberAxis yAxisLine;

    private ResourceBundle BUNDLE;

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
            listData.setPredicate(s -> s.listName.trim().toLowerCase().contains(newValue.toLowerCase().trim()));
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
                    protected void updateItem(Statistics item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
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
        setupBarChart();
        yAxisLine.setUpperBound(100.0d);
        yAxisLine.setLowerBound(0.0d);
    }

    public void exit() {
        LanguageTrainer.showMenu();
    }

    public void setupBarChart() {
        HashMap<String, Integer> mapCorrect = new HashMap<>();
        HashMap<String, Integer> mapIncorrect = new HashMap<>();
        HashMap<String, Integer> mapCheated = new HashMap<>();
        HashMap<String, Integer> mapTotal = new HashMap<>();
        // Cycle through all statistics and add everything together
        for (Statistics stat : allStatistics) {
            // Add statistics to the totals
            String name;
            if (stat.langCodes.length == 2) {
                //noinspection HardcodedFileSeparator
                name = stat.listName + " " + Character.toUpperCase(stat.langCodes[0].charAt(0)) + "/" + Character.toUpperCase(stat.langCodes[1].charAt(0));
            } else {
                name = stat.listName + " " + Character.toUpperCase(stat.langCodes[0].charAt(0));
            }
            if (mapCorrect.containsKey(stat.listName)) {
                mapCorrect.put(name, mapCorrect.get(name) + stat.correct);
                mapIncorrect.put(name, mapIncorrect.get(name) + stat.incorrect);
                mapCheated.put(name, mapCheated.get(name) + stat.cheated);
                mapTotal.put(name, mapTotal.get(name) + stat.total);
            } else {
                // Add the statistics for the first time
                mapCorrect.put(name, stat.correct);
                mapIncorrect.put(name, stat.incorrect);
                mapCheated.put(name, stat.cheated);
                mapTotal.put(name, stat.total);
            }
        }

        // The three series
        XYChart.Series<String, Number> seriesCorrect = new XYChart.Series<>();
        seriesCorrect.setName(BUNDLE.getString("statistics.correct"));
        XYChart.Series<String, Number> seriesIncorrect = new XYChart.Series<>();
        seriesIncorrect.setName(BUNDLE.getString("statistics.incorrect"));
        XYChart.Series<String, Number> seriesCheated = new XYChart.Series<>();
        seriesCheated.setName(BUNDLE.getString("statistics.cheated"));
        // Cycle through all keys and make the bar chart
        for (String key : mapCorrect.keySet()) {
            seriesCorrect.getData().add(new XYChart.Data<>(key, ((double) mapCorrect.get(key) / mapTotal.get(key) * 100)));
            seriesIncorrect.getData().add(new XYChart.Data<>(key, ((double) mapIncorrect.get(key) / mapTotal.get(key) * 100)));
            seriesCheated.getData().add(new XYChart.Data<>(key, ((double) mapCheated.get(key) / mapTotal.get(key) * 100)));
        }

        barChart.getData().add(seriesCorrect);
        barChart.getData().add(seriesIncorrect);
        barChart.getData().add(seriesCheated);
    }

    public void prepareCharts(Statistics stat) {
        // Never called but fixes NPE?!
        if (stat == null) {
            list.getSelectionModel().selectFirst();
            return;
        }
        ArrayList<Statistics> stats = allStatistics.stream().filter(s -> s.listType == stat.listType && s.listName.equals(stat.listName) &&
                                                                         Arrays.equals(s.langCodes, stat.langCodes))
                                                   .collect(Collectors.toCollection(ArrayList::new));
        if (stats.isEmpty()) {
            return;
        }
        Collections.sort(stats);
        lineChart.getData().clear();
        pieChart.getData().clear();
        int totalCorrect = 0;
        int totalIncorrect = 0;
        int totalCheated = 0;
        XYChart.Series<String, Number> seriesCorrect = new XYChart.Series<>();
        seriesCorrect.setName(BUNDLE.getString("statistics.correct"));
        XYChart.Series<String, Number> seriesIncorrect = new XYChart.Series<>();
        seriesIncorrect.setName(BUNDLE.getString("statistics.incorrect"));
        XYChart.Series<String, Number> seriesCheated = new XYChart.Series<>();
        seriesCheated.setName(BUNDLE.getString("statistics.cheated"));

        DateFormat formatter = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
        int num = 1;
        for (Statistics s : stats) {
            if (s.correct == 0 && s.incorrect == 0 && s.cheated == 0) {
                continue;
            }
            totalCorrect += s.correct;
            totalIncorrect += s.incorrect;
            totalCheated += s.cheated;
            seriesCorrect.getData().add(new XYChart.Data<>(num + ": " + formatter.format(s.date), (double) s.correct / s.total * 100));
            seriesIncorrect.getData().add(new XYChart.Data<>(num + ": " + formatter.format(s.date), (double) s.incorrect / s.total * 100));
            seriesCheated.getData().add(new XYChart.Data<>(num + ": " + formatter.format(s.date), (double) s.cheated / s.total * 100));
            num++;
        }
        lineChart.getData().add(seriesCorrect);
        lineChart.getData().add(seriesIncorrect);
        lineChart.getData().add(seriesCheated);
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(new PieChart.Data(BUNDLE.getString("statistics.correct"), totalCorrect),
                                                                                  new PieChart.Data(BUNDLE.getString("statistics.incorrect"), totalIncorrect),
                                                                                  new PieChart.Data(BUNDLE.getString("statistics.cheated"), totalCheated));
        pieChart.getData().addAll(pieData);
    }

    @Override
    public void onExit() {

    }

    @Override
    public void onInsert(char c) {

    }
}
