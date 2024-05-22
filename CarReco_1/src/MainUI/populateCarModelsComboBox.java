
/*package MainUI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class populateCarModelsComboBox 
{

    private DatabaseManager databaseManager;

    public populateCarModelsComboBox () {
        
    }

    private void populateCarModels() {
        try {
            // SQL query to select unique car models
            String query = "SELECT DISTINCT model FROM cars";
            ResultSet resultSet = databaseManager.executeQuery(query);

            // Populate the combo box with unique car models
            ArrayList<String> carModelsList = new ArrayList<>();
            while (resultSet.next()) {
                carModelsList.add(resultSet.getString("model"));
            }
            
            // Convert the ArrayList to an array
            String[] carModelsArray = carModelsList.toArray(new String[0]);

            // Set the model for your combo box
            JComboBox<String> comboBox = carModel; // Replace chooseModel with the name of your combo box
            comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(carModelsArray));

        } catch (SQLException ex) {
            // Handle SQL exception
            ex.printStackTrace();
        }
    }

    // Other methods and UI components
}*/
 

