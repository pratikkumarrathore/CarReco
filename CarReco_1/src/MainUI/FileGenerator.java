
package MainUI;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;

public class FileGenerator {
    public static void generatePdf(JTable table) {
        // File path to the desktop on the C drive
        String filePath = "C:\\Users\\Pratik\\Desktop\\output.pdf";

        try (OutputStream outputStream = new FileOutputStream(filePath)) {
            // Write PDF file content...
            // This part will involve processing the data from the JTable and generating the PDF
            // For demonstration purposes, we'll just write some sample content to the PDF file
            StringBuilder content = new StringBuilder();
            content.append("PDF generated from JTable data:\n\n");

            // Iterate through the rows and columns of the JTable to get the data
            for (int i = 0; i < table.getRowCount(); i++) {
                for (int j = 0; j < table.getColumnCount(); j++) {
                    Object cellValue = table.getValueAt(i, j);
                    content.append(cellValue).append("\t");
                }
                content.append("\n");
            }

            // Write the content to the PDF file
            outputStream.write(content.toString().getBytes());

            // Show popup message
            JOptionPane.showMessageDialog(null, "PDF generated successfully!");
            
            // Open the PDF file
            Desktop.getDesktop().open(new File(filePath));

            System.out.println("PDF file created successfully!");
        } catch (IOException e) {
        }
    }
    
    public static void generateTxt(JTable table) {
        // File path to the desktop on the C drive
        String filePath = "C:\\Users\\Pratik\\Desktop\\output.txt";

        try (FileWriter writer = new FileWriter(filePath)) {
            // Write text file content...
            // This part will involve processing the data from the JTable and generating the text file
            // For demonstration purposes, we'll write a formatted text with the table data
            writer.write("Text generated from JTable data:\n\n");

            // Get column names
            for (int j = 0; j < table.getColumnCount(); j++) {
                writer.write(table.getColumnName(j) + "\t");
            }
            writer.write("\n");

            // Iterate through the rows of the JTable to get the data
            for (int i = 0; i < table.getRowCount(); i++) {
                for (int j = 0; j < table.getColumnCount(); j++) {
                    Object cellValue = table.getValueAt(i, j);
                    writer.write(cellValue + "\t");
                }
                writer.write("\n");
            }

            // Show popup message
            JOptionPane.showMessageDialog(null, "Text file generated successfully!");

            System.out.println("Text file created successfully!");
        } catch (IOException e) {
        }
    }
    
    public static void generateCsv(JTable table) {
    // File path to the desktop on the C drive
    String filePath = "C:\\Users\\Pratik\\Desktop\\output.csv";

    try (FileWriter writer = new FileWriter(filePath)) {
        // Write CSV file content...
        // This part will involve processing the data from the JTable and generating the CSV file
        // For demonstration purposes, we'll write the table data to the CSV file
        // Write header row
        for (int j = 0; j < table.getColumnCount(); j++) {
            writer.append(table.getColumnName(j));
            if (j < table.getColumnCount() - 1) {
                writer.append(",");
            }
        }
        writer.append("\n");

        // Write data rows
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                Object cellValue = table.getValueAt(i, j);
                writer.append(String.valueOf(cellValue));
                if (j < table.getColumnCount() - 1) {
                    writer.append(",");
                }
            }
            writer.append("\n");
        }

        // Show popup message
        JOptionPane.showMessageDialog(null, "CSV file generated successfully!");

        System.out.println("CSV file created successfully!");
    } catch (IOException e) {
    }
}
    
    public static void convertToImage(JTable table) {
        String desktopPath = System.getProperty("user.home") + "/Desktop/";
        String outputFilePath = desktopPath + "table_image.png";

        int width = table.getWidth();
        int height = table.getHeight();

        // Create a BufferedImage with the dimensions of the JTable
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        // Set background color and clear the image
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        // Render the table onto the image
        table.print(g2d);

        g2d.dispose();

        // Write the BufferedImage to a file
        File outputFile = new File(outputFilePath);
        try {
            ImageIO.write(image, "PNG", outputFile);
            System.out.println("Table converted to PNG image successfully. Image saved to: " + outputFilePath);
        } catch (IOException e) {
        }
    }


}

