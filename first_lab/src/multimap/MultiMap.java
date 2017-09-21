package multimap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MultiMap<Key,Value> {
	
	public MultiMap() {}
	
	private HashMap<Key, List<Value>> m = new HashMap<Key,List<Value>>();
	
	public void put(Key key, Value value){
		if(!m.containsKey(key)){
			List<Value> l = new ArrayList<Value>();
			l.add(value);
			m.put(key, l);
		} else if (!m.get(key).contains(value)){
			m.get(key).add(value);
		}
	}
	
	public void remove(Key key, Value value){
		if(m.containsKey(key) && m.get(key).contains(value)){
			m.get(key).remove(value);
			if(m.get(key).isEmpty()){
				m.remove(key);
			}
		}
	}
	
	public Boolean contains(Key key, Value value){
		if(m.containsKey(key) && m.get(key).contains(value)){
			return true;
		}
		return false;
	}
	
	public void removeAll(Key key){
		if(m.containsKey(key)){
			m.remove(key);
		}
	}

}
