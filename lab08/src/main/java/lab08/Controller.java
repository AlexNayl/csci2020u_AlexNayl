package lab08;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import org.w3c.dom.Text;

import java.io.File;
import java.util.List;

public class Controller
{
	@FXML TableView mainTableView;
	@FXML TextField idField;
	@FXML TextField assignmentsField;
	@FXML TextField midtermField;
	@FXML TextField finalExamField;

	private ObservableList<StudentRecord> grades;
	private String currentFilename = "";

	private void refreshTable(){
		mainTableView.getItems().setAll( grades );
	}

	public void initialize(){
		//Load in default datasource
		grades = DataSource.getAllMarks();
		refreshTable();
	}

	public void handleAddButton( ActionEvent e ){
		String studentID = idField.getText();
		double midterm = Double.parseDouble(midtermField.getText());
		double assignments = Double.parseDouble(assignmentsField.getText());
		double finalExam = Double.parseDouble(finalExamField.getText());

		StudentRecord student = new StudentRecord( studentID, assignments, midterm, finalExam );
		grades.add(student);
		refreshTable();
	}

	public void handleNewMenu( ActionEvent e ){
		//delete all elements from the list
		grades.removeAll( grades );
		refreshTable();
	}

	public void handleOpenMenu( ActionEvent e ){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle( "Open" );
		fileChooser.setInitialDirectory( new File(".") );
		fileChooser.getExtensionFilters().add( new FileChooser.ExtensionFilter( "CSV", "*.csv" ) );
		File file = fileChooser.showOpenDialog( Main.stage );

		List<StudentRecord> newGrades = FileHelpers.open( file );
		if(newGrades == null){
			//File failed to load
			System.out.println("ERROR: File failed to load.");
		}else{
			currentFilename = file.getPath();
			grades.setAll( newGrades );
			refreshTable();
		}
	}

	public void handleSaveMenu( ActionEvent e ){
		if(currentFilename.isEmpty()){
			handleSaveAsMenu( e );
		}else{
			if(!FileHelpers.save(new File(currentFilename), grades)){
				//Saving to known file failed, try saveAs
				handleSaveAsMenu( e );
			}
		}
	}

	public void handleSaveAsMenu( ActionEvent e ){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle( "Save as" );
		fileChooser.setInitialDirectory( new File(".") );
		fileChooser.getExtensionFilters().add( new FileChooser.ExtensionFilter( "CSV", "*.csv" ) );
		File file = fileChooser.showSaveDialog( Main.stage );

		if(!FileHelpers.save( file, grades )){
			//file failed to save
			System.out.println("ERROR: File failed to save.");
		}
	}

	public void handleExitMenu( ActionEvent e ){
		System.exit(0);
	}

}
