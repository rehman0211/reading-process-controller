package com.journaldev.spring.model;

public class RunningProcess {
    //the object that has been read from the CSV file
    private Object object;

    //for status
    private boolean running= true;
    private boolean paused = false;

    //start
    public synchronized void start(){

        while(!running || paused){
            try{
                wait();
            }catch (InterruptedException e) {

            }
        }
        running = true;
        paused=false;
        //notify all that process is running
        notifyAll();
    }

    //pause
    public synchronized void pause(){
        if(running){
            paused = true;
            notifyAll();
        }
    }

    //resume
    public synchronized void resume(){
        if(paused){
            System.out.println("in resume");
            paused=false;
            notifyAll();
        }
    }

    //terminate
    public synchronized void terminate(){
        running = false;
        paused = false;
        notifyAll();
    }
}
