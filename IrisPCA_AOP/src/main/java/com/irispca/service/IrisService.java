package com.irispca.service;

import com.irispca.model.IrisRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IrisService {

    public List<IrisRecord> loadData(String filePath)
            throws IOException {

        List<IrisRecord> data =
                new ArrayList<>();

        BufferedReader br =
                new BufferedReader(
                        new FileReader(filePath));

        String line;

        while ((line = br.readLine()) != null) {

            String[] values =
                    line.split(",");

            IrisRecord record =
                    new IrisRecord(
                            Double.parseDouble(values[0]),
                            Double.parseDouble(values[1]),
                            Double.parseDouble(values[2]),
                            Double.parseDouble(values[3]),
                            values[4]
                    );

            data.add(record);
        }

        br.close();

        return data;
    }
}