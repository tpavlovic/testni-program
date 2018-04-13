package raf.kalendar;

import java.util.ArrayList;
import java.util.Scanner;

import raf.kalendar.impl.ScheduleLoaderJsonImpl;
import raf.kalendar.impl.ScheduleSynchronizerGoogleImpl;
import raf.kalendar.model.Schedule;
import raf.kalendar.spec.ScheduleLoader;
import raf.kalendar.spec.ScheduleSynchronizer;

public class Test {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in); //  C:\Users\Tamara\Desktop\raspored.json
		System.out.println("Unesite putanju do fajla");
		String path = scanner.nextLine();
		ScheduleLoader loader = new ScheduleLoaderJsonImpl();
		ArrayList<Schedule> list = loader.load(path);
		
		ScheduleSynchronizer synchronizer = new ScheduleSynchronizerGoogleImpl();
		synchronizer.synchronize(list);
		
		scanner.close();
	}

}
