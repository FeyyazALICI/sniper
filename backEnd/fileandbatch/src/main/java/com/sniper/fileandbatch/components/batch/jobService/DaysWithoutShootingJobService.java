package com.sniper.fileandbatch.components.batch.jobService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sniper.fileandbatch.components.file.bussiness.service.DaysWithoutShootingService;
import com.sniper.fileandbatch.components.file.bussiness.service.ViewService;
import com.sniper.fileandbatch.components.file.dao.entity.DaysWithoutShooting;
import com.sniper.fileandbatch.components.file.dao.entity.ShootingWithWeapon;

@Service
public class DaysWithoutShootingJobService {

    private final DaysWithoutShootingService daysWithoutShootingService;
    private final ViewService viewService;

    public DaysWithoutShootingJobService(
        DaysWithoutShootingService daysWithoutShootingService,
        ViewService viewService
    ){
        this.daysWithoutShootingService = daysWithoutShootingService;
        this.viewService                = viewService;
    }

    public void findRestDays() throws Exception{
        List<ShootingWithWeapon> swwList = this.viewService.getAllShootingWithWeaponsRaw();
        List<DaysWithoutShooting> dwsList = this.daysWithoutShootingService.getAllDaysWithoutShooting();
        HashSet<Date> swwHashSet = new HashSet<>();
        HashSet<Date> dwsHashSet = new HashSet<>();

        // finding the days wşth shooting
        if(swwList!=null && swwList.size()>0){
            for(ShootingWithWeapon e: swwList){
                swwHashSet.add(e.getDateOfShooting());
            }
        }

        // finding the rest days
        if(dwsList!=null && dwsList.size()>0){
            for(DaysWithoutShooting e: dwsList){
                dwsHashSet.add(e.getDateOfRest());
            }
        }

        // getting the earliest date of shooting
        Date earliestDateOfShooting = this.viewService.getEarlistDateOfShooting();
        if( earliestDateOfShooting==null){
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            earliestDateOfShooting = sdf.parse("01.01.2025");
        }

        HashSet<Date> rs = daysUpToCurrentDate( earliestDateOfShooting, swwHashSet, dwsHashSet);

        for(Date e: rs){
            DaysWithoutShooting dataToAdd = new DaysWithoutShooting();
            dataToAdd.setDateOfRest(e);
            this.daysWithoutShootingService.insertDaysWithoutShooting(dataToAdd);
        }
    }

    public HashSet<Date> daysUpToCurrentDate(Date entry, HashSet<Date> swwvHashSet, HashSet<Date> dwsHashSet){
        HashSet<Date> dataList = new HashSet<>();

        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(entry);

        Calendar today = Calendar.getInstance();
        today.setTime(new Date());

        while( !startCalendar.after(today) ){
            Date dateToAdd = startCalendar.getTime();
            if( !swwvHashSet.contains(dateToAdd) && !dwsHashSet.contains(dateToAdd) ){
                dataList.add(dateToAdd);
            }
            startCalendar.add(Calendar.DATE, 1);
        }
        return dataList;
    }
}
