package Operations;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String [] args) {
		List<Integer> mi_s = new ArrayList<Integer>();
		mi_s.add(37);
		mi_s.add(49);
		List<Integer> mapping = CRT.getMapping(973, mi_s);
		int res = CRT.execute(973, 678, mi_s, '+');
		List<Integer> mapping_2 = CRT.getMapping(res, mi_s);
		System.out.println(res);
		for(Integer x : mapping_2)
			System.out.println(x);
		for(Integer x : mapping)
			System.out.println(x);
		System.out.println(CRT.deMap(mapping, mi_s));
		System.out.println(CRT.execute(973, 678, 1813, '+'));
	}
}
