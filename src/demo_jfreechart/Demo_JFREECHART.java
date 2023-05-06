package demo_jfreechart;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.category.CategoryDataset;


public class Demo_JFREECHART {

    private static PieDataset createPieDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Cây lương thực", new Double(8320.3));
        dataset.setValue("Cây công nghiệp", new Double(2337.3));
        dataset.setValue("Cây thực phẩm, cây ăn quả, cây khác", new Double(2173.8));
        return dataset;
    }

    private static JFreeChart createPieChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Biểu đồ về sự thay đổi cơ cấu diện tích gieo trồng".toUpperCase(),
                dataset, true, true, true);
        return chart;
    }

    private static DefaultCategoryDataset createBarChartDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(8320.3, "Cây lương thực", "");
        dataset.addValue(2337.3, "Cây công nghiệp", "");
        dataset.addValue(2173.8, "Cây thực phẩm, cây ăn quả, cây khác", "");
        return dataset;
    }

    private static JFreeChart createBarChart(CategoryDataset dataset) {
    JFreeChart chart = ChartFactory.createBarChart(
            "Biểu đồ về sự thay đổi cơ cấu diện tích gieo trồng".toUpperCase(),"", "Diện tích (ha)", dataset);
    return chart;
}

    public static void main(String[] args) {
        // Adding Pie Chart to the panel
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
PieDataset pieDataset = createPieDataset();
JFreeChart pieChart = createPieChart(pieDataset);
ChartPanel pieChartPanel = new ChartPanel(pieChart);
panel.add(pieChartPanel);

    // Adding Line Chart to the panel
    DefaultCategoryDataset lineDataset = createLineChartDataset();
    JFreeChart lineChart = createLineChart(lineDataset);
    ChartPanel lineChartPanel = new ChartPanel(lineChart);
    lineChartPanel.setVisible(false); // Hide initially
    panel.add(lineChartPanel);

    // Adding buttons to switch between charts
    JButton pieButton = new JButton("Biểu đồ tròn");
    pieButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pieChartPanel.setVisible(true);
            barChartPanel.setVisible(false);
            lineChartPanel.setVisible(false);
        }
    });
    panel.add(pieButton);

    JButton barButton = new JButton("Biểu đồ cột");
    barButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pieChartPanel.setVisible(false);
            barChartPanel.setVisible(true);
            lineChartPanel.setVisible(false);
        }
    });
    panel.add(barButton);

    // Adding panel to the frame
    frame.add(panel);

    // Setting up the frame
    frame.setSize(800, 600);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setVisible(true);
    }
}