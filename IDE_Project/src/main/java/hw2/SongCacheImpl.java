package hw2;
import org.junit.Assert;
import org.junit.Test;
import java.util.*;



class TestDemo{
    public static void main(String[] args) {
        SongCache cache = new SongCacheImpl();
        cache.recordSongPlays("ID-1", 3);
        cache.recordSongPlays("ID-1", 1);
        cache.recordSongPlays("ID-2", 2);
        cache.recordSongPlays("ID-3", 5);
        cache.recordSongPlays("ID-1", 2);
        cache.recordSongPlays("ID-3", 2);

        System.out.println("ID-1 of plays: " + cache.getPlaysForSong("ID-1"));
        System.out.println("Top 2 song played "+ cache.getTopNSongsPlayed(2));
    }
}

interface SongCache {

    /**
     * Record number of plays for a song
     */
    void recordSongPlays(String songId, int numPlays);

    /**
     * Fetch the number of plays for a song
     *
     * @return the number of plays, or -1 if the song ID is unknown
     */
    int getPlaysForSong(String songId);

    /**
     * Return the top N songs played, in descending order of number of plays.
     */
    List<String> getTopNSongsPlayed(int n);

}

class SongCacheImpl implements SongCache {

    private Map<String, Integer> songs;
    private Map<String, Integer> sortedMap;

    public SongCacheImpl() {
        songs = new HashMap<>();
        sortedMap = new TreeMap<>(new ValueComparator(songs));//using TreeMap to make it sorted results
    }

    @Override
    synchronized public void recordSongPlays(String songId, int numPlays) {
        if (songs.containsKey(songId)) {
            songs.put(songId, songs.get(songId) + numPlays); // to record numbers of play
        } else {
            songs.put(songId, numPlays);
        }
    }

    @Override
    synchronized public int getPlaysForSong(String songId) {
        // using the getOrDefault of the Map interface implement by HashMap
        // get key, and if no key or specified key return -1
        return songs.getOrDefault(songId, -1);
    }

    @Override
    public List<String> getTopNSongsPlayed(int n) {
        sortedMap.putAll(songs);

        List<String> topNSongs = new ArrayList<>();
        Iterator<Map.Entry<String, Integer>> itr = sortedMap.entrySet().iterator();

        while (itr.hasNext() && n != 0) { // check if it is empty
            synchronized (SongCacheImpl.class){ // I'm using singleton double check solution
                while (itr.hasNext() && n != 0){
                    Map.Entry<String, Integer> entry = itr.next();
                    topNSongs.add(entry.getKey());
                    n--;
                }
            }
        }
        return topNSongs;
    }

}

/**
 *  I'm using Comparator to compare the song which is the most popular and make it sorted.
 */
class ValueComparator implements Comparator<String> {

    Map<String, Integer> base;

    public ValueComparator(Map<String, Integer> base) {
        this.base = base;
    }

    @Override
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        }
    }
}

class TT{
    public static void main(String[] args) {
        List l = new ArrayList();
        l.add("aa");
        l.add("dd");
        l.add("cc");
        l.add("bb");
        for (Iterator iter = l.iterator(); iter.hasNext();) {
            String str = (String)iter.next();
            System.out.println(str);
        }
    }
}



