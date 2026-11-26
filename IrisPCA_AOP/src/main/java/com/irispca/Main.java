package com.irispca;

import com.irispca.model.IrisRecord;
import com.irispca.service.IrisService;
import com.irispca.service.PCAService;
import com.irispca.service.PerformanceMetrics;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        PerformanceMetrics metrics =
                new PerformanceMetrics();

        metrics.start();

        try {

            IrisService irisService =
                    new IrisService();

            List<IrisRecord> data =
                    irisService.loadData("iris.csv");

            System.out.println(
                    "Toplam Kayıt Sayısı: "
                            + data.size());
            PCAService pcaService =
                    new PCAService();

            pcaService.applyPCA(data);

        }

        catch (Exception e) {

            System.out.println(
                    "Hata: "
                            + e.getMessage());
        }
        metrics.stop();
        metrics.printMetrics();

    }
}