import java.util.*;
class Solution {

    public int toMinute(String x){
        int h = Integer.parseInt(x.split(":")[0]);
        int m = Integer.parseInt(x.split(":")[1]);
        return h * 60 + m;
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        StringBuilder sb = new StringBuilder();
        int len = toMinute(video_len);
        int now = toMinute(pos);
        int start = toMinute(op_start);
        int end = toMinute(op_end);
        
        if (now >= start && now <= end) now = end;
        
        for (String cmd : commands) {
            if (cmd.equals("next")){
                now += 10;
                if (now > len) now = len;
            }
            else{
                now -= 10;
                if (now < 0) now = 0;
            }
            if (now >= start && now <= end) now = end;
        }
        
        
        int h =  now / 60;
        int m = now % 60;
        if (h < 10) sb.append("0");
        sb.append(h);
        sb.append(":");
        if (m < 10) sb.append("0");
        sb.append(m);
        
        
        return sb.toString();
    }
}