package mytest.chartbuilder;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineChartEx extends JFrame {
  
		private int[] xAxie = {1,2,3,0,10};
		private int[] yAxie = {1,2,3,0,1};
		
		private String nameChart="";
		private String nameX="";
		private String nameY="";
		
    public LineChartEx() {

        initUI();
    }

    public LineChartEx(int[] dx,int[] dy) {
    	xAxie = dx;
    	yAxie = dy;
        initUI();
    }
    
    public LineChartEx(String nameChart,String nameX, String nameY,int[] dx,int[] dy) {
    	this.nameChart= nameChart;
    	this.nameX= nameX;
    	this.nameY= nameY;
    	xAxie = dx;
    	yAxie = dy;
        initUI();
    }    
    
    private void initUI() {

        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle(" ");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private XYDataset createDataset() {

        XYSeries series = new XYSeries("");
        for (int i=0;i<xAxie.length;i++){
        	int x = xAxie[i];
        	int y = yAxie[i];
        	series.add(x,y);
        }
        

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
        		nameChart, 
        		nameX, 
        		nameY, 
                dataset, 
                PlotOrientation.VERTICAL,
                true, 
                true, 
                false 
        );

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle(nameChart,
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );

        return chart;

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            LineChartEx ex = new LineChartEx();
            ex.setVisible(true);
        });
    }
}