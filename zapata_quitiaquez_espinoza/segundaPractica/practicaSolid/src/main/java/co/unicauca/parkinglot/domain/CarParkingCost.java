package co.unicauca.parkinglot.domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class CarParkingCost implements IParkingCost{
    //TODO: implementar el metodo calculateCost en CarParkingCost
    public long calculateCost(Vehicle veh, LocalDateTime input, LocalDateTime output) {
    	long hours = 0;
		long minutes = 0;
		long days = 0;
		long totalTime = 0;
		long total = Duration.between(input, output).toMinutes();
		
		days = total/1440;
		total-= days*1440;
		hours = total / 60;
		total -= hours*60;
		minutes = total;
		if(days==1) {
			totalTime = days*23*2000+4000;
		}else {
			if(days>0) {
				totalTime = 23*2000+4000;
				totalTime += (days-1)*24*2000;
			}
		}
		if(days==0) {
			if(hours==1) {
				totalTime =4000;
			}else {
				totalTime = 4000;
				totalTime += (hours-1) *2000;
			}
		}else {
			if(hours==1) {
				totalTime +=4000;
			}else {
				totalTime +=4000;
				totalTime += (hours-1) *2000;
			}
			
		}
		if(hours==0) {
			totalTime +=4000;
		}else {
			totalTime+= (minutes*2000)/60;
		}
		
		totalTime =  ((totalTime+100)/100)*100;
		return totalTime;
    }
    
}
