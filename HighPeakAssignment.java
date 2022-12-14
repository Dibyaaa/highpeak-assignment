package ProgrammingSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Dibya
 *
 *         Logic to calculate the jobs and earnings
 */
public class HighPeakAssignment {

	/**
	 * @param args starting poit main method
	 */
	public static void main(String[] args) {
		/* to read the value from the user from the console */
		Scanner scanner = new Scanner(System.in);
		int noOfJobs = scanner.nextInt();

		List<Jobs> jobList = new ArrayList<>();

		/* checks the job is less than 100 */
		if (noOfJobs <= 100) {

			/* to read the job details for the number of jobs to be created */
			for (int i = 0; i < noOfJobs; i++) {

				System.out.println("------------------Please enter the job details-----------------------");
				
				System.out.println("------------------Enter Start Time -----------------------");
				int startTime = scanner.nextInt();
				
				System.out.println("------------------Enter End Time -----------------------");
				int endTime = scanner.nextInt();
				
				System.out.println("------------------Enter Profit  -----------------------");
				int profit = scanner.nextInt();
				
				jobList.add(jobDetails(startTime, endTime, profit));
			}

			/* filter the job details based on start and end time criteria */
			List<Jobs> filteredList = jobList.stream().filter((e1) -> e1.getStartTime() < e1.getEndTime())
					.collect(Collectors.toList());
			filteredList.remove(filteredList.stream().max((e1, e2) -> e1.getProfit() - e2.getProfit()).get());

			int size = filteredList.size();
			int totalProfit = 0;

			/* to calculate the remaing jobs and the earnings */
			for (int i = 0; i < size; i++) {
				Jobs j = filteredList.get(i);
				totalProfit = totalProfit + j.getProfit();
			}

			/* the final reuired output */
			int[] arr = { size, totalProfit };
			System.out.println(arr[0]);
			System.out.println(arr[1]);

		} else {
			System.out.println("no of Jobs is greater than limit");
		}
	}

	/**
	 * This method takes starttime , endtime and profit as input parameter and
	 * creates new job object and return.
	 * 
	 * @param startTime : int
	 * @param endTime   : int
	 * @param profit    :int
	 * @return {@link Jobs} object
	 */
	public static Jobs jobDetails(int startTime, int endTime, int profit) {
		Jobs jobs = new Jobs();
		jobs.setStartTime(startTime);
		jobs.setEndTime(endTime);
		jobs.setProfit(profit);
		return jobs;

	}

}

/**
 * Job class
 */
class Jobs {

	/* start time parameter of type int */
	private int startTime;

	/* end time parameter of type int */
	private int endTime;

	/* profit parameter of type int */
	private int profit;

	/* return the value of start time */
	public int getStartTime() {
		return startTime;
	}

	/* set the value of start time */
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	/* return the value of end time */
	public int getEndTime() {
		return endTime;
	}

	/* set the value of end time */
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	/* return the value of profit */
	public int getProfit() {
		return profit;
	}

	/* set the value of profit */
	public void setProfit(int profit) {
		this.profit = profit;
	}
}
