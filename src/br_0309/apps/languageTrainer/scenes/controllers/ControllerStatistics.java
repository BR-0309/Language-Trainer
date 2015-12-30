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
// FIXME: Make line chart show percentages
public class ControllerStatistics implements Initializable, IController {

    private final ArrayList<Statistics> allStatistics = new ArrayList<>();
    @FXML
    public ListView<Statistics> list;
    @FXML
    public LineChart<String, Number> lineChart;
    @FXML
    public PieChart pieChart;
    @FXML
    public StackedBarChart<String, Number> barChart;
    @FXML
    public TextField txtSearch;
    @FXML
    public CategoryAxis xAxisBar;
    @FXML
    public NumberAxis yAxisBar;
    @FXML
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
        // Set up bar chart
        ArrayList<ArrayList<Statistics>> list = new ArrayList<>();
        for (Statistics stat : allStatistics) {
            boolean cont = false;
            for (ArrayList<Statistics> l : list) {
                for (Statistics s : l) {
                    if (s.listName.equals(stat.listName) && Arrays.equals(s.langCodes, stat.langCodes)) {
                        l.add(stat);
                        cont = true;
                        break;
                    }
                }
                if (cont) {
                    break;
                }
            }
            if (!cont) {
                ArrayList<Statistics> l = new ArrayList<>();
                l.add(stat);
                list.add(l);
            }
        }
        XYChart.Series<String, Number> seriesCorrect = new XYChart.Series<>();
        seriesCorrect.setName(BUNDLE.getString("statistics.correct"));
        XYChart.Series<String, Number> seriesIncorrect = new XYChart.Series<>();
        seriesIncorrect.setName(BUNDLE.getString("statistics.incorrect"));
        XYChart.Series<String, Number> seriesCheated = new XYChart.Series<>();
        seriesCheated.setName(BUNDLE.getString("statistics.cheated"));
        Set<String> categories = new HashSet<>();
        for (ArrayList<Statistics> l : list) {
            int total, correct = 0, incorrect = 0, cheated = 0;
            for (Statistics stat : l) {
                correct += stat.correct;
                incorrect += stat.incorrect;
                cheated += stat.cheated;
            }
            total = correct + incorrect + cheated;
            Statistics stat = l.get(0);
            String title = stat.listName + " " + Character.toUpperCase(stat.langCodes[0].charAt(0)) + "/" + Character.toUpperCase(stat.langCodes[1].charAt(0));
            seriesCorrect.getData().add(new XYChart.Data<>(title, ((double) correct / total) * 100));
            seriesIncorrect.getData().add(new XYChart.Data<>(title, ((double) incorrect / total) * 100));
            seriesCheated.getData().add(new XYChart.Data<>(title, ((double) cheated / total) * 100));
            categories.add(title);
        }
        xAxisBar.setCategories(FXCollections.observableArrayList(categories));
        yAxisBar.setUpperBound(100d);
        yAxisBar.setLowerBound(0d);
        //noinspection unchecked
        barChart.getData().addAll(seriesCorrect, seriesIncorrect, seriesCheated);
        yAxisLine.setUpperBound(100d);
        yAxisLine.setLowerBound(0d);
    }

    public void exit() {
        LanguageTrainer.showMenu();
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
            int total = s.correct + s.incorrect + s.cheated;
            seriesCorrect.getData().add(new XYChart.Data<>(num + ": " + formatter.format(s.date), (double) s.correct / total * 100));
            seriesIncorrect.getData().add(new XYChart.Data<>(num + ": " + formatter.format(s.date), (double) s.incorrect / total * 100));
            seriesCheated.getData().add(new XYChart.Data<>(num + ": " + formatter.format(s.date), (double) s.cheated / total * 100));
            num++;
        }
        //noinspection unchecked
        lineChart.getData().addAll(seriesCorrect, seriesIncorrect, seriesCheated);
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
