/*
Written by Alexander Naylor 100696151
IntelliJ javaFx template used as starting point
*/

package lab05;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lab 5");

        TableView tableView = new TableView();

        TableColumn<StudentRecord, String> studentIDColumn = new TableColumn<>("Student ID");
        studentIDColumn.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        tableView.getColumns().add(studentIDColumn);

        TableColumn<StudentRecord, String> assignmentsColumn = new TableColumn<>("Assignments");
        assignmentsColumn.setCellValueFactory(new PropertyValueFactory<>("assignments"));
        tableView.getColumns().add(assignmentsColumn);

        TableColumn<StudentRecord, String> midtermColumn = new TableColumn<>("Midterm");
        midtermColumn.setCellValueFactory(new PropertyValueFactory<>("midterm"));
        tableView.getColumns().add(midtermColumn);

        TableColumn<StudentRecord, String> finalExamColumn = new TableColumn<>("Final Exam");
        finalExamColumn.setCellValueFactory(new PropertyValueFactory<>("finalExam"));
        tableView.getColumns().add(finalExamColumn);

        TableColumn<StudentRecord, String> finalMarkColumn = new TableColumn<>("Final Mark");
        finalMarkColumn.setCellValueFactory(new PropertyValueFactory<>("finalMark"));
        tableView.getColumns().add(finalMarkColumn);

        TableColumn<StudentRecord, String> letterGradeColumn = new TableColumn<>("Letter Grade");
        letterGradeColumn.setCellValueFactory(new PropertyValueFactory<>("letterGrade"));
        tableView.getColumns().add(letterGradeColumn);

        ObservableList<StudentRecord> grades = DataSource.getAllMarks();

        tableView.getItems().addAll(grades);

        VBox vbox = new VBox(tableView);
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
