import java.util.*;

public class Job_Sequencing{

    static class Job {
        int id;
        int profit;
        int deadline;

        public Job(int i, int d, int p){
            id =i;
            deadline = d;
            profit = p;
        }        
    }

    public static void main(String[] args) {
        int jobInfo[][] = {{4,20}, {1,10}, {1,40}, {1,30}};
        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        Collections.sort(jobs, (obj1,obj2) -> obj2.profit-obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time=0;

        for (int index = 0; index < jobs.size(); index++) {
            Job curr = jobs.get(index);

            if (curr.deadline > time) {
                time = curr.deadline;
                seq.add(curr.id);
            }
        }

        System.out.println("max jobs :" + seq.size());
        System.out.print("the jobs done are: ");
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }

    }
}