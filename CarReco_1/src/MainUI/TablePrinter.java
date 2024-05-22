
package MainUI;


import javax.swing.JTable;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.PrintQuality;
import java.awt.print.PrinterJob;
import java.awt.print.PrinterException;
import javax.swing.JOptionPane;

public class TablePrinter {

    public static void printTable(JTable table) {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Table Print Job");

        PrintRequestAttributeSet printAttributes = new HashPrintRequestAttributeSet();
        printAttributes.add(OrientationRequested.LANDSCAPE);
        printAttributes.add(PrintQuality.HIGH);

        printerJob.setPrintable(table.getPrintable(
                JTable.PrintMode.FIT_WIDTH,
                null,
                null
        ));

        if (printerJob.printDialog(printAttributes)) {
            try {
                printerJob.print(printAttributes);
                JOptionPane.showMessageDialog(null, "Printing Sucessful!");
            } catch (PrinterException e) 
            {
                JOptionPane.showMessageDialog(null, "Error while Printing!");
            }
        }
    }
    
}

