package org.example.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration
public class PrintSchedule {

    @Scheduled(cron = "0/10 * * * * ? ")
    private void cancelTimeOutOrder() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.err.println(localDateTime + "----this is a printSchedule test!!!");
    }
}
