package com.irispca.service;

import com.irispca.model.IrisRecord;
import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.correlation.Covariance;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.List;

public class PCAService {

    public void applyPCA(List<IrisRecord> data) {

        double[][] matrix =
                new double[data.size()][4];

        for (int i = 0; i < data.size(); i++) {

            matrix[i] =
                    data.get(i).getFeatures();
        }

        RealMatrix realMatrix =
                MatrixUtils.createRealMatrix(matrix);

        Covariance covariance =
                new Covariance(realMatrix);

        RealMatrix covarianceMatrix =
                covariance.getCovarianceMatrix();

        EigenDecomposition eigen =
                new EigenDecomposition(covarianceMatrix);

        System.out.println("\nPCA Sonuçları");

        System.out.println(
                "1. Özdeğer: "
                        + eigen.getRealEigenvalue(0));

        System.out.println(
                "2. Özdeğer: "
                        + eigen.getRealEigenvalue(1));

        System.out.println(
                "3. Özdeğer: "
                        + eigen.getRealEigenvalue(2));

        System.out.println(
                "4. Özdeğer: "
                        + eigen.getRealEigenvalue(3));
        DefaultCategoryDataset dataset =
                new DefaultCategoryDataset();

        dataset.addValue(
                eigen.getRealEigenvalue(0),
                "Özdeğer",
                "PC1");

        dataset.addValue(
                eigen.getRealEigenvalue(1),
                "Özdeğer",
                "PC2");

        dataset.addValue(
                eigen.getRealEigenvalue(2),
                "Özdeğer",
                "PC3");

        dataset.addValue(
                eigen.getRealEigenvalue(3),
                "Özdeğer",
                "PC4");

        JFreeChart chart =
                ChartFactory.createBarChart(
                        "PCA Sonuçları",
                        "Bileşen",
                        "Özdeğer",
                        dataset
                );

        ChartFrame frame =
                new ChartFrame(
                        "PCA Grafiği",
                        chart
                );

        frame.pack();
        frame.setVisible(true);
    }
}