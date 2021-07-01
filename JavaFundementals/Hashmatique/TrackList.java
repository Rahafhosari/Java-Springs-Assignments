import java.util.HashMap;

public class TrackList {
    public void trackList() {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Hello", "song"); //adding data to trackList
        trackList.put("Save your Self", "song");
        trackList.put("Fi Amal" ,"song");
        trackList.put("Aisha", "song");
        
        System.out.print("Title:"+trackList.get("Hello"));
        
        for(String key : trackList.keySet()) { //or define keys  Set<String> keys = userMap.keySet(); and put trackList.keys
            System.out.println(trackList.get(key));
        }
    }
}
