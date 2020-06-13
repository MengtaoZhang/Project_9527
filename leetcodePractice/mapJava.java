// Map用于存储具有映射关系的数据，map中存储了两组数据（key， value），它们都可以是任何引用
// 类型的数据，key不能重复，k == > value
// 面试中常用的实现类是 HashMap and TreeMap

public class Solution {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		for (int i = 5; i > 0; i --) {
			map.put(i + "", i + "");
		}
		map.put("1", "1"); // key无重复
		map.put("11", "1"); // value可以重复
		map.put(null, null); //可以为空
		for (Iterator i = map.keySet().iterator(); i.hasNext();) {
			String key = (String)i.next();
			String value = map.get(key);
			System.out.println("key = " + key + ", value = " + value);
		}
	}
}

//输出顺序与输入顺序无关


// TreeMap
public class Solution{
	public static void main(String[] args) {
		Map<String, String> map = new TreeMap<>();
		for (int i = 5; i > 0; i --) {
			map.put(i + "", i + "");
		}
		map.put("1", "1"); // key无重复
		map.put("11", "1"); // value可以重复
		// map.put(null, null);// 不可以为空
		for (Iterator i = map.keySet().iterator(); i.hasNext(); ){
			String key = (String)i.next();
			String value = map.get(key);
			System.out.println("key = " + key + ", value = " + value);
		}
	}
}
// 输出有序
		
