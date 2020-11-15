package com.journaldev.spring.service;

import com.journaldev.spring.model.RunningProcess;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadService implements Runnable{

    RunningProcess runningProcess;
    InputStream inputStream;

    public ReadService(RunningProcess process, InputStream inputStream) {
        this.runningProcess = process;
        this.inputStream = inputStream;
    }

    public void run() {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            long rowNo=0;
            List records = new ArrayList();
            for (CSVRecord csvRecord : csvRecords) {
                rowNo++;
                List<String> row = new ArrayList<>();
                for(int i=0;i<csvRecord.size();i++){
                    row.add(csvRecord.get(i));
                }

                records.add(row);
                System.out.println("read row no : " + rowNo);
                System.out.println(row);
                System.out.println("--------------------------------");

                runningProcess.start();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
            }

        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}
