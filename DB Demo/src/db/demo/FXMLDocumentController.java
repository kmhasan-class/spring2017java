/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.demo;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField studentIdField;
    @FXML
    private TextField studentNameField;
    @FXML
    private TextField cgpaField;
    @FXML
    private ListView<Student> studentsListView;
    private ObservableList<Student> studentsList;
    @FXML
    private Label statusLabel;
    @FXML
    private TableColumn<Student, Number> idColumn;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, Number> cgpaColumn;
    @FXML
    private TableView<Student> studentsTableView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        studentsList = FXCollections.observableArrayList();
        studentsListView.setItems(studentsList);
        studentsTableView.setItems(studentsList);
        
        // lambda expression
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStudentName()));
        idColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getStudentId()));
        cgpaColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getCgpa()));
        
        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://172.17.0.119/spring2017db",
                            "javauser",
                            "java");
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM student";

            ResultSet resultSet = statement.executeQuery(query);
            int rows = 0;
            while (resultSet.next()) {
                int id = resultSet.getInt("studentId");
                String name = resultSet.getString("studentName");
                double cgpa = resultSet.getDouble("cgpa");
                Student student = new Student(id, name, cgpa);
                studentsList.add(student);
                rows++;
            }
            statusLabel.setText("Successfully loaded " + rows + " records from the database");
        } catch (SQLException sqle) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setContentText("Could not connect to the database");
            alert.showAndWait();
            System.exit(0);
            System.err.println("Could not connect to the database");
        }
    }

    @FXML
    private void handleAddStudentAction(ActionEvent event) {
        int studentId = 0;
        try {
            studentId = Integer.parseInt(studentIdField.getText());
        } catch (NumberFormatException nfe) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText("Incorrect student Id");
            alert.setContentText("Student Id has to be an integer in the range[1, 1000]");
            alert.showAndWait();
            return;
        }
        String studentName = studentNameField.getText();
        double cgpa = Double.parseDouble(cgpaField.getText());

        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://172.17.0.119/spring2017db",
                            "javauser",
                            "java");
            Statement statement = connection.createStatement();
            String query = "INSERT INTO student VALUES(" + studentId
                    + ", '" + studentName + "', " + cgpa + ")";
            System.out.println(query);
            statement.executeUpdate(query);
            Student student = new Student(studentId, studentName, cgpa);
            studentsList.add(student);
            statusLabel.setText("Added a new entry for " + studentName);
            studentIdField.clear();
            studentNameField.clear();
            cgpaField.clear();
        } catch (SQLException sqle) {

        }

    }

    @FXML
    private void handleListClickAction(MouseEvent event) {
        Student student = studentsListView.getSelectionModel().getSelectedItem();
        studentIdField.setText(student.getStudentId() + "");
        studentNameField.setText(student.getStudentName());
        cgpaField.setText(student.getCgpa() + "");
    }

    // HOMETASK
    // Implement CRUD operations - Create, Retrieve, Update, Delete

    @FXML
    private void handleExitAction(ActionEvent event) {
        System.exit(0);
    }
    
    // HOMETASK
    // Show developer and product information through Help->About
}
