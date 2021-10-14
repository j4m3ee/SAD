package edu.parinya.softarchdesign.structural;

import java.util.Date;

public class TimeLoggingHealthcareWorker extends HealthcareWorkerDecorator {

    public TimeLoggingHealthcareWorker(HealthcareServiceable worker) {
        super(worker);
        System.out.println(" with TimeLogging");
    }

    public void service() {
        Date timeStamp = new Date();
        System.out.print(timeStamp.toString() + ":");
        super.service();
    }
}
