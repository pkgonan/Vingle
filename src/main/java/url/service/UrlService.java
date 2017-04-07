package url.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UrlService {
    private Map<String, Long> ids = new ConcurrentHashMap<>();
    private Map<Long, String> urls = new ConcurrentHashMap<>();
    private Map<Long, Long> stats = new ConcurrentHashMap<>();
    private long key = 0;

    public synchronized long regist(String url){
        if(!isExist(url)) {
            key += 1;
            ids.put(url, key);
            urls.put(key, url);
            stats.put(key, Long.valueOf(0));

            return key;
        }
        return ids.get(url);
    }

    public boolean isExist(String url){
        if(ids.containsKey(url))
            return true;
        return false;
    }

    public String getUrl(long id){
        if(urls.containsKey(id) && stats.containsKey(id)) {
            stats.put(id, stats.get(id) + 1);
            return urls.get(id);
        }
        else throw new NullPointerException();
    }

    public long getStats(long id){
        if(stats.containsKey(id))
            return stats.get(id);
        else throw new NullPointerException();
    }
}