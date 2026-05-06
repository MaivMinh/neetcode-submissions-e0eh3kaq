class Value {
    public String value;
    public int timestamp;
    public Value(String v, int t) {
        this.value = v;
        this.timestamp = t;
    }
}

class TimeMap {
    public Map<String, List<Value>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Value> list = map.get(key);
        if (list == null) {
            list = new ArrayList();
            list.add(new Value(value, timestamp));
            map.put(key, list);
        }   else {
            list.add(new Value(value, timestamp));
            map.put(key, list);
        }
    }
    
    public String get(String key, int timestamp) {
        List<Value> list = map.get(key);
        if (list == null || list.isEmpty()) return "";
        int n = list.size();
        int l = 0; 
        int r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            Value v = list.get(mid);
            if (v.timestamp == timestamp) {
                return v.value;
            }
            if (v.timestamp > timestamp) {
                r = mid - 1;
            }   else l = mid + 1;
        }
        return (r < 0)  ? "": list.get(r).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */