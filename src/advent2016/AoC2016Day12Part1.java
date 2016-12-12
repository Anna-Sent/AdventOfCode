package advent2016;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2016Day12Part1 {
	public static void main(String[] args) {
		int result;

		result = test("cpy 41 a" + "\r\n" + "inc a" + "\r\n" + "inc a" + "\r\n"
				+ "dec a" + "\r\n" + "jnz a 2" + "\r\n" + "dec a");
		assert (result == 42);
		System.out.println(result);

		result = test("cpy 1 a\r\ncpy 1 b\r\ncpy 26 d\r\njnz c 2\r\njnz 1 5\r\ncpy 7 c\r\ninc d\r\ndec c\r\njnz c -2\r\ncpy a c\r\ninc a\r\ndec b\r\njnz b -2\r\ncpy c b\r\ndec d\r\njnz d -6\r\ncpy 13 c\r\ncpy 14 d\r\ninc a\r\ndec d\r\njnz d -2\r\ndec c\r\njnz c -5");
		assert (result == 317993);
		System.out.println(result);
	}

	static Map<String, Integer> registers = new HashMap<>();

	public static int test(String s) {
		String[] instructions = s.split("\r\n");

		final Pattern cpy_reg = Pattern.compile("cpy (a|b|c|d) (a|b|c|d)");
		final Pattern cpy_val = Pattern.compile("cpy (-?\\d+) (a|b|c|d)");
		final Pattern inc = Pattern.compile("inc (a|b|c|d)");
		final Pattern dec = Pattern.compile("dec (a|b|c|d)");
		final Pattern jnz_reg_reg = Pattern.compile("jnz (a|b|c|d) (a|b|c|d)");
		final Pattern jnz_val_reg = Pattern.compile("jnz (-?\\d+) (a|b|c|d)");
		final Pattern jnz_reg_val = Pattern.compile("jnz (a|b|c|d) (-?\\d+)");
		final Pattern jnz_val_val = Pattern.compile("jnz (\\d+) (-?\\d+)");

		registers.put("a", 0);
		registers.put("b", 0);
		registers.put("c", 0);
		registers.put("d", 0);
		for (int i = 0; i < instructions.length;) {
			String instruction = instructions[i];
			Matcher m;
			m = cpy_reg.matcher(instruction);
			if (m.matches()) {
				String reg1 = m.group(1);
				String reg2 = m.group(2);
				registers.put(reg2, registers.get(reg1));
				++i;
				print(instruction);
				continue;
			}
			m = cpy_val.matcher(instruction);
			if (m.matches()) {
				int val = Integer.parseInt(m.group(1));
				String reg = m.group(2);
				registers.put(reg, Integer.valueOf(val));
				++i;
				print(instruction);
				continue;
			}
			m = inc.matcher(instruction);
			if (m.matches()) {
				String reg = m.group(1);
				registers.put(reg,
						Integer.valueOf(registers.get(reg).intValue() + 1));
				++i;
				print(instruction);
				continue;
			}
			m = dec.matcher(instruction);
			if (m.matches()) {
				String reg = m.group(1);
				registers.put(reg,
						Integer.valueOf(registers.get(reg).intValue() - 1));
				++i;
				print(instruction);
				continue;
			}
			m = jnz_reg_reg.matcher(instruction);
			if (m.matches()) {
				String reg1 = m.group(1);
				int val1 = registers.get(reg1).intValue();
				String reg2 = m.group(2);
				int val2 = registers.get(reg2).intValue();

				if (val1 != 0) {
					i += val2;
				} else {
					++i;
				}
				print(instruction);
				continue;
			}
			m = jnz_val_reg.matcher(instruction);
			if (m.matches()) {
				int val1 = Integer.parseInt(m.group(1));
				String reg2 = m.group(2);
				int val2 = registers.get(reg2).intValue();

				if (val1 != 0) {
					i += val2;
				} else {
					++i;
				}
				print(instruction);
				continue;
			}
			m = jnz_reg_val.matcher(instruction);
			if (m.matches()) {
				String reg1 = m.group(1);
				int val1 = registers.get(reg1).intValue();
				int val2 = Integer.parseInt(m.group(2));

				if (val1 != 0) {
					i += val2;
				} else {
					++i;
				}
				print(instruction);
				continue;
			}
			m = jnz_val_val.matcher(instruction);
			if (m.matches()) {
				int val1 = Integer.parseInt(m.group(1));
				int val2 = Integer.parseInt(m.group(2));

				if (val1 != 0) {
					i += val2;
				} else {
					++i;
				}
				print(instruction);
				continue;
			}
			throw new RuntimeException("unknown instruction");
		}

		return registers.get("a").intValue();
	}

	private static void print(String instruction) {
		System.out.print(instruction + " ");

		List<Map.Entry<String, Integer>> list = new LinkedList<>(
				registers.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1,
					Map.Entry<String, Integer> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		for (Map.Entry<String, Integer> entry : list) {
			System.out.print(entry.getKey() + "=" + entry.getValue() + " ");
		}
		System.out.println();
	}
}