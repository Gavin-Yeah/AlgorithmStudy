package dynamicProgramming;

import java.util.List;

public class happy {
    public static class Employee {
        public int happy;
        public List<Employee> nexts;
    }
    public static class Info{
        public int comeMaxHappy;
        public int notComeMaxHappy;
        public Info(int come, int not){
            comeMaxHappy = come;
            notComeMaxHappy = not;
        }
    }
    public static Info process(Employee x){
        if(x.nexts.isEmpty()){
            return new Info(x.happy, 0);
        }
        int come = x.happy;
        int not = 0;
        for(Employee next: x.nexts){
            Info nextInfo = process(next);
            come += nextInfo.notComeMaxHappy;
            not += Math.max(nextInfo.comeMaxHappy, nextInfo.notComeMaxHappy);
        }
        return new Info(come, not);
    }
}
