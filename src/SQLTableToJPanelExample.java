import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

class SQLTableToJPanelExample {

    public static void main(String[] args) {
        // Connect to the SQL database
        try {
            String url = "jdbc:mysql://localhost:3306/sql12601094";
            String user = "root";
            String password = "3vhlrEGNSd";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM itemMenu";
            ResultSet rs = stmt.executeQuery(sql);

            // Set look and feel to Nimbus
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            // Create a JFrame and JPanel
            JFrame frame = new JFrame("SQL Table to JPanel Example");
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20)); // Change the row gap to 20 and column gap to 10
            panel.setPreferredSize(new Dimension(400, 800));
            panel.setBackground(Color.WHITE);

            // Create a JTable and populate it with data from the SQL table
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            Vector<String> columnNames = new Vector<String>();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }
            while (rs.next()) {
                Vector<Object> row = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getObject(i));
                }
                data.add(row);
            }
            TableModel tableModel = new DefaultTableModel(data, columnNames);
            JTable table = new JTable(tableModel);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            table.setRowHeight(30);
            table.setGridColor(new Color(192, 192, 192));
            table.setSelectionBackground(new Color(220, 220, 220));
            table.setSelectionForeground(Color.BLACK);
            table.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
            table.getTableHeader().setBackground(new Color(240, 240, 240));
            table.getTableHeader().setForeground(Color.BLACK);
            JTableHeader header = table.getTableHeader();
            header.setBorder(BorderFactory.createLineBorder(new Color(192, 192, 192)));
            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(40);
            columnModel.getColumn(1).setPreferredWidth(200);
            columnModel.getColumn(2).setPreferredWidth(100);
            JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            //scrollPane.getVerticalScrollBar().setBackground(new Color(240, 240, 240));
            scrollPane.getHorizontalScrollBar().setBackground(new Color(240, 240, 240));

            // Add the JTable to the JPanel
            panel.add(scrollPane);

            // Add the JPanel to the JFrame and display it
            frame.add(panel);
            frame.setSize(800, 800);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // Close the database connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
