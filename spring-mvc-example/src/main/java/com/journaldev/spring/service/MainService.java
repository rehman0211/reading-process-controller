package com.journaldev.spring.service;

import com.journaldev.spring.model.RunningProcess;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class MainService {
    public static String TYPE = "text/csv";
    private RunningProcess process;
    private Thread thread;

    public boolean isCSV(MultipartFile file){
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public void save(MultipartFile file) throws IOException {
        process = new RunningProcess();
        ReadService readService = new ReadService(process, file.getInputStream());
        thread = new Thread(readService);
        thread.start();
    }

    public void pause() {
        if(process!=null){
            process.pause();
        }
    }

    public void resume() {
        if (process != null) {
            process.resume();
        }
    }

    public void terminate() {
        if (process != null) {
            process.terminate();
        }
        thread.interrupt();
    }
}
