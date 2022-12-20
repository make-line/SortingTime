package org.example.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;

import javax.swing.*;
import java.awt.*;

public class Chart {
    static final int[] n = new int[]{50, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};

    public static JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Сортировки",
                "Значения n",                   // x-axis label
                "Время",                // y-axis label
                dataset);
        chart.setBackgroundPaint(Color.white);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        chart.getLegend().setFrame(BlockBorder.NONE);

        return chart;
    }

    public static JPanel createDemoPanel(long[][] arr) {
        JFreeChart chart = createChart(createDataset(arr));
        chart.setPadding(new RectangleInsets(4, 8, 5, 2));
        ChartPanel panel = new ChartPanel(chart);
        panel.setFillZoomRectangle(true);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(600, 300));
        return panel;
    }

    public static CategoryDataset createDataset(long[][] arr) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j += 2) {
                dataset.addValue(arr[i][j], "BubbleSort", Integer.toString(n[i]));
                dataset.addValue(arr[i][++j], "QuickSort", Integer.toString(n[i]));
                dataset.addValue(arr[i][++j], "InsertionSort", Integer.toString(n[i]));
                dataset.addValue(arr[i][++j], "SelectionSort", Integer.toString(n[i]));
                dataset.addValue(arr[i][++j], "HeapSort", Integer.toString(n[i]));
            }
        return dataset;
    }

}
