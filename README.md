# Reading Process Controller
We can pause, resume or terminate a long file reading process, at any instance of time

> Task : https://docs.google.com/document/d/1wma52BMH-07BOxpqWzqIUW5uKIXaCj0j6gPftiwLobE/edit

> Framework Stack Used : Spring MVC
> Server Used : tomcat
> Github : 
> Docker Image url : https://hub.docker.com/repository/docker/rehman0211/atlan_hiring
> Docker Pull Command : docker pull rehman0211/atlan_hiring:latest
> .war file : https://github.com/rehman0211/reading-process-controller/blob/main/spring-mvc-example.war


### How to Run on your System :
#### Using docker image :
> Put your port while running the Docker image at your system ( in my Case : localhost:8080 )

> Run Your server at http://localhost:8080/spring-mvc-example/

> Here you can select the CSV file and upload it.

> It will start reading the contents of your .csv file

> For reference, you can see the logs in your tomcat, By using : 
tail -f /tomcat/logs/catalina.out

> Now, we can pause/resume/terminate the long reading process

> For, your reference, I have recorded a demo for it, you may have a look on it:
https://drive.google.com/file/d/1KI9BmK7BfRqhVyC_vDcVyG6KznlKqLKi/view?usp=sharing

#### using .war file :
> Put the war file from github to your local tomcat server's webApp directory
> start your tomcatserver : ./bin/startUp.sh
> Follow the same steps above specified

### Concept Used : 
Threads and Consumer-Producer Problem in Operating System

In this task, I have learnt of things, and used the concepts studied in Operating System course-work during college.

#### For any further clarification or assistance, Please feel free to contact me.
