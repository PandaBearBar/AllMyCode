package com.project.project2.service.dailyTask;

import com.project.project2.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DailyEliminateJob {
    private final CouponRepository couponRepository;
    private final int DAY = 1000*60*60*24;

    @Scheduled(fixedRate = DAY)
    public void CouponEliminator(){
        couponRepository.deleteAllByEndDateLessThan(Date.valueOf(LocalDate.now()));
    }
}
