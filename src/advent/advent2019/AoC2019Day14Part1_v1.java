package advent.advent2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2019Day14Part1_v1 {

    public static void main(String[] args) {
        int result;

        result = test("10 ORE => 10 A\n" +
                "1 ORE => 1 B\n" +
                "7 A, 1 B => 1 C\n" +
                "7 A, 1 C => 1 D\n" +
                "7 A, 1 D => 1 E\n" +
                "7 A, 1 E => 1 FUEL");
        assert result == 31 : "unexpected result is " + result;
        System.out.println(result);

        result = test("9 ORE => 2 A\n" +
                "8 ORE => 3 B\n" +
                "7 ORE => 5 C\n" +
                "3 A, 4 B => 1 AB\n" +
                "5 B, 7 C => 1 BC\n" +
                "4 C, 1 A => 1 CA\n" +
                "2 AB, 3 BC, 4 CA => 1 FUEL");
        assert result == 165 : "unexpected result is " + result;
        System.out.println(result);

        //noinspection SpellCheckingInspection
        result = test("157 ORE => 5 NZVS\n" +
                "165 ORE => 6 DCFZ\n" +
                "44 XJWVT, 5 KHKGT, 1 QDVJ, 29 NZVS, 9 GPVTF, 48 HKGWZ => 1 FUEL\n" +
                "12 HKGWZ, 1 GPVTF, 8 PSHF => 9 QDVJ\n" +
                "179 ORE => 7 PSHF\n" +
                "177 ORE => 5 HKGWZ\n" +
                "7 DCFZ, 7 PSHF => 2 XJWVT\n" +
                "165 ORE => 2 GPVTF\n" +
                "3 DCFZ, 7 NZVS, 5 HKGWZ, 10 PSHF => 8 KHKGT");
        assert result == 13312 : "unexpected result is " + result;
        System.out.println(result);

        //noinspection SpellCheckingInspection
        result = test("2 VPVL, 7 FWMGM, 2 CXFTF, 11 MNCFX => 1 STKFG\n" +
                "17 NVRVD, 3 JNWZP => 8 VPVL\n" +
                "53 STKFG, 6 MNCFX, 46 VJHF, 81 HVMC, 68 CXFTF, 25 GNMV => 1 FUEL\n" +
                "22 VJHF, 37 MNCFX => 5 FWMGM\n" +
                "139 ORE => 4 NVRVD\n" +
                "144 ORE => 7 JNWZP\n" +
                "5 MNCFX, 7 RFSQX, 2 FWMGM, 2 VPVL, 19 CXFTF => 3 HVMC\n" +
                "5 VJHF, 7 MNCFX, 9 VPVL, 37 CXFTF => 6 GNMV\n" +
                "145 ORE => 6 MNCFX\n" +
                "1 NVRVD => 8 CXFTF\n" +
                "1 VJHF, 6 MNCFX => 4 RFSQX\n" +
                "176 ORE => 6 VJHF");
        assert result == 180697 : "unexpected result is " + result;
        System.out.println(result);

        //noinspection SpellCheckingInspection
        result = test("171 ORE => 8 CNZTR\n" +
                "7 ZLQW, 3 BMBT, 9 XCVML, 26 XMNCP, 1 WPTQ, 2 MZWV, 1 RJRHP => 4 PLWSL\n" +
                "114 ORE => 4 BHXH\n" +
                "14 VRPVC => 6 BMBT\n" +
                "6 BHXH, 18 KTJDG, 12 WPTQ, 7 PLWSL, 31 FHTLT, 37 ZDVW => 1 FUEL\n" +
                "6 WPTQ, 2 BMBT, 8 ZLQW, 18 KTJDG, 1 XMNCP, 6 MZWV, 1 RJRHP => 6 FHTLT\n" +
                "15 XDBXC, 2 LTCX, 1 VRPVC => 6 ZLQW\n" +
                "13 WPTQ, 10 LTCX, 3 RJRHP, 14 XMNCP, 2 MZWV, 1 ZLQW => 1 ZDVW\n" +
                "5 BMBT => 4 WPTQ\n" +
                "189 ORE => 9 KTJDG\n" +
                "1 MZWV, 17 XDBXC, 3 XCVML => 2 XMNCP\n" +
                "12 VRPVC, 27 CNZTR => 2 XDBXC\n" +
                "15 KTJDG, 12 BHXH => 5 XCVML\n" +
                "3 BHXH, 2 VRPVC => 7 MZWV\n" +
                "121 ORE => 7 VRPVC\n" +
                "7 XCVML => 6 RJRHP\n" +
                "5 BHXH, 4 VRPVC => 5 LTCX");
        assert result == 2210736 : "unexpected result is " + result;
        System.out.println(result);

        //noinspection SpellCheckingInspection
        result = test("11 TDFGK, 1 LKTZ => 5 DMLM\n" +
                "2 PLWS, 10 CQRWX, 1 DQRM, 1 DXDTM, 1 GBNH, 5 FKPL, 1 JCSDM => 4 LMPH\n" +
                "2 FXBZT, 1 VRZND => 5 QKCQW\n" +
                "3 VRZND => 4 LKTZ\n" +
                "15 FKPL, 6 DNXHG => 6 ZFBTC\n" +
                "7 QFBZN => 3 FXBZT\n" +
                "151 ORE => 1 QZNXC\n" +
                "16 WCHD, 15 LWBQL => 3 MBXSW\n" +
                "13 DXDTM => 6 RCNV\n" +
                "1 MSXF, 1 VRZND => 9 SWBRL\n" +
                "109 ORE => 9 LSLQW\n" +
                "5 DNXHG => 5 GBNH\n" +
                "2 DZXGB => 6 VRZND\n" +
                "1 FKPL, 1 XPGX, 2 RCNV, 1 LGXK, 3 QBVQ, 7 GBJC => 9 SCXQ\n" +
                "3 DVHQD => 3 QXWFM\n" +
                "1 XKXPK, 1 DMLM => 9 HGNW\n" +
                "1 TSMCQ, 6 ZFBTC, 1 WCHD, 3 QBVQ, 7 QXWFM, 14 LWBQL => 9 TFMNM\n" +
                "17 NBVPR, 7 LJQGC => 9 LWBQL\n" +
                "3 NBVPR => 4 ZGVC\n" +
                "4 DNXHG => 2 CQRWX\n" +
                "1 RCKS, 3 LWBQL => 3 TSMCQ\n" +
                "3 LJCR, 15 JBRG => 7 TWBN\n" +
                "7 WZSH, 4 QXWFM => 3 JMCQ\n" +
                "9 SWBRL, 8 LJCR, 33 NLJH => 3 JMVG\n" +
                "1 CQRWX => 4 FZVM\n" +
                "6 LJQGC, 12 DVHQD, 15 HGNW => 4 RCKS\n" +
                "3 WCHD => 3 XPGX\n" +
                "6 JBRG, 1 NQXZM, 1 LJCR => 2 LJQGC\n" +
                "16 SDQK => 9 PLWS\n" +
                "2 QFBZN, 2 LSLQW => 4 MSXF\n" +
                "8 QZNXC => 6 NBVPR\n" +
                "1 NBVPR, 1 LKTZ => 5 LJCR\n" +
                "11 SWBRL, 2 QKCQW => 7 JBRG\n" +
                "7 JMCQ, 7 DVHQD, 4 BXPB => 8 DXDTM\n" +
                "1 WCHD => 7 QBVQ\n" +
                "2 CQRWX => 5 GBJC\n" +
                "4 JMVG => 4 BXPB\n" +
                "7 WZSH => 8 TDFGK\n" +
                "5 XLNR, 10 ZGVC => 6 DNXHG\n" +
                "7 RCNV, 4 MLPH, 25 QBVQ => 2 LGXK\n" +
                "1 DMLM => 3 XLNR\n" +
                "6 FZVM, 4 BGKJ => 9 JCSDM\n" +
                "7 LWBQL, 1 JCSDM, 6 GBJC => 4 DQRM\n" +
                "2 FXBZT, 2 QKCQW => 5 XKXPK\n" +
                "3 LMPH, 33 NQXZM, 85 MBXSW, 15 LWBQL, 5 SCXQ, 13 QZNXC, 6 TFMNM, 7 MWQTH => 1 FUEL\n" +
                "8 NQXZM, 6 TDFGK => 4 DVHQD\n" +
                "5 NQXZM, 2 TWBN => 7 CFKF\n" +
                "132 ORE => 3 DZXGB\n" +
                "6 QZNXC, 10 QFBZN => 3 NLJH\n" +
                "15 SWBRL, 1 QZNXC, 4 NBVPR => 7 WZSH\n" +
                "20 DNXHG => 3 SDQK\n" +
                "1 LJCR, 1 JBRG, 1 LKTZ => 4 NQXZM\n" +
                "16 JMVG, 1 LJQGC => 9 BGKJ\n" +
                "4 TSMCQ => 3 FKPL\n" +
                "1 CFKF => 2 WCHD\n" +
                "162 ORE => 3 QFBZN\n" +
                "18 WCHD => 5 MLPH\n" +
                "13 LJQGC, 1 SDQK => 9 MWQTH");
        assert result == 522031 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static final Pattern pattern = Pattern.compile("(\\d+) ([A-Z]+)");

    private static int test(String s) {
        Map<String, Chemical> chemicals = readChemicals(s);
        Map<String, Integer> remains = new HashMap<>();
        return calculateOre(chemicals, "FUEL", 1, remains);
    }

    private static int calculateOre(Map<String, Chemical> chemicals,
                                    String name,
                                    int requiredCount,
                                    Map<String, Integer> remains) {
        if (name.equals("ORE")) {
            return requiredCount;
        }

        int remain = remains.getOrDefault(name, 0);
        if (remain >= requiredCount) {
            remains.put(name, remain - requiredCount);
            return 0;
        } else if (remain != 0) {
            remains.put(name, 0);
            requiredCount = requiredCount - remain;
        }

        Chemical chemical = chemicals.get(name);
        int total = 0;
        int multiplier = requiredCount / chemical.count + (requiredCount % chemical.count == 0 ? 0 : 1);
        for (Chemical ingredient : chemical.ingredients) {
            total += calculateOre(chemicals, ingredient.name, ingredient.count * multiplier, remains);
        }
        int producedCount = chemical.count * multiplier;
        if (producedCount > requiredCount) {
            remains.put(name, remains.getOrDefault(name, 0) + producedCount - requiredCount);
        }
        return total;
    }

    private static Map<String, Chemical> readChemicals(String s) {
        Map<String, Chemical> chemicals = new HashMap<>();
        for (String token : s.split("\n")) {
            String[] parts = token.split(" => ");
            assert parts.length == 2 : "invalid input";
            String[] items = parts[0].split(", ");
            assert items.length >= 1 : "invalid input";

            Chemical result = new Chemical();
            Matcher matcher = pattern.matcher(parts[1]);
            //noinspection AssertWithSideEffects
            assert matcher.matches() : "invalid input";
            result.count = Integer.parseInt(matcher.group(1));
            result.name = matcher.group(2);
            assert result.name.length() > 0 : "invalid input";
            assert result.count > 0 : "invalid input";

            result.ingredients = new ArrayList<>();
            for (String item : items) {
                Chemical ingredient = new Chemical();
                matcher = pattern.matcher(item);
                //noinspection AssertWithSideEffects
                assert matcher.matches() : "invalid input";
                ingredient.count = Integer.parseInt(matcher.group(1));
                ingredient.name = matcher.group(2);
                assert ingredient.name.length() > 0 : "invalid input";
                assert ingredient.count > 0 : "invalid input";
                result.ingredients.add(ingredient);
            }

            chemicals.put(result.name, result);
        }
        return chemicals;
    }

    private static class Chemical {

        String name;

        int count;

        List<Chemical> ingredients;

        @Override
        public String toString() {
            return "Chemical{" +
                    "name='" + name + '\'' +
                    ", count=" + count +
                    '}';
        }
    }
}
