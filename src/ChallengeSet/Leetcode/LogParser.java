package ChallengeSet.Leetcode;

import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class LogParser {
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        String filename = "C:/Users/yang liu/workspace/Interview2017/src/pocketGems/test1.txt";
        if (args.length > 0) {
            filename = args[0];
        }

        
        String answer = parseFile(filename);
        System.out.println(answer);
    }
    
    static String parseFile(String filename)
            throws FileNotFoundException, IOException{
        BufferedReader input = new BufferedReader(new FileReader(filename));
        List<String> allLines = new ArrayList<String>();
        String line = "";
        while ((line = input.readLine()) != null) {
            allLines.add(line);
        }
        input.close();
        return parseLines(allLines.toArray(new String[allLines.size()]));
    }
    
    static String parseLines(String[] lines) {
        Map<String, Integer> status = new HashMap<String, Integer>();

        status.put("START", 0);
        status.put("CONNECTED", 1);
        status.put("DISCONNECTED", -1);
        status.put("SHUTDOWN", -2);
        
        long totalTime = 0;
        long connectTime = 0;
        boolean isConnected = false;
        Date lastConnectMoment = new Date();
        Date startMoment = new Date();
        Date shutMoment = new Date();
        
        for (String line : lines) {
            String[] lineSplit = line.split(" :: ");
            String event = lineSplit[1];
            if (!status.containsKey(event)) continue;
            
            String cur = lineSplit[0];
            Date currentTime = parseTime(cur.substring(1, cur.length()-1));

            
            int eventID = status.get(event);
            if (eventID > 0) {
                if (!isConnected)
                    lastConnectMoment = currentTime;
                isConnected = true;
            }
            else if (eventID < 0) {
                if (isConnected)
                    connectTime += currentTime.getTime() - lastConnectMoment.getTime();
                isConnected = false;
            }
            if (eventID == 0) startMoment = currentTime;
            if (eventID == -2) shutMoment = currentTime;
        }
        totalTime = shutMoment.getTime() - startMoment.getTime();
        
        double ratio = (double)connectTime/totalTime * 100;
        return String.format("%d%s", (int)ratio, "%");
    }
    
    static Date parseTime(String timeStr) {
        Date time = new Date();
        DateFormat dft = new SimpleDateFormat("MM/dd/yyyy-hh:mm:ss");
        try {
            time = dft.parse(timeStr);
        }catch (ParseException ignored) {}
        return time;
    }
}