package Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Example1 {
	public static void main(String[] args) {
		List<String> arrayList = new ArrayList<String>();
		arrayList.add("PHP");
		arrayList.add("Python");
		arrayList.add("Java");
		arrayList.add("C++");
		arrayList.add("Ruby");
		System.out.print("--Các phần tử của ArrayList: ");
		for(String arrList : arrayList )	{
			System.out.print(arrList + " , ");
		}
		
		System.out.print("\n--Các phần tử của ArrayList: ");
		Iterator<String> itr = arrayList.iterator();
		while(itr.hasNext())	{
			System.out.print(itr.next() + " , ");
		}

		List<String> linkedList = new LinkedList<String>();
		linkedList.add("PHP");
		linkedList.add("Python");
		linkedList.add("Java");
		linkedList.add("C++");
		linkedList.add("Ruby");
		System.out.println("\n--Các phần tử của ArrayList: ");
		System.out.println("\t" + linkedList + "\n");

		Set<String> hashSet = new HashSet<String>();
		hashSet.add("PHP");
		hashSet.add("Python");
		hashSet.add("Java");
		hashSet.add("C++");
		hashSet.add("C");
		System.out.println("--Các phần tử của ArrayList: ");
		System.out.println("\t" + hashSet + "\n");

		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("Windows", "2000");
		hashMap.put("Windows", "XP");
		hashMap.put("Language2", "Java");
		hashMap.put("Language1", ".Net");
		System.out.println("Các phần tử của Map");
		System.out.print("\t" + hashMap);
	}
}
