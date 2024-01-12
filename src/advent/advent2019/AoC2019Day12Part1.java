package advent.advent2019;

import utils.Point3D;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2019Day12Part1 {

    public static void main(String[] args) {
        int result;

        result = test(10, "<x=-1, y=0, z=2>\n" +
                "<x=2, y=-10, z=-7>\n" +
                "<x=4, y=-8, z=8>\n" +
                "<x=3, y=5, z=-1>");
        assert result == 179 : "unexpected result is " + result;
        System.out.println(result);

        result = test(100, "<x=-8, y=-10, z=0>\n" +
                "<x=5, y=5, z=10>\n" +
                "<x=2, y=-7, z=3>\n" +
                "<x=9, y=-8, z=-3>");
        assert result == 1940 : "unexpected result is " + result;
        System.out.println(result);

        result = test(1000, "<x=12, y=0, z=-15>\n" +
                "<x=-8, y=-5, z=-10>\n" +
                "<x=7, y=-17, z=1>\n" +
                "<x=2, y=-11, z=-6>");
        assert result == 7636 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static final Pattern pattern = Pattern.compile("<x=(-?\\d+), y=(-?\\d+), z=(-?\\d+)>");

    private static int test(int steps, String s) {
        List<Moon> moons = new ArrayList<>();
        for (String token : s.split("\n")) {
            Matcher matcher = pattern.matcher(token);
            assert matcher.matches() : "not matches " + token;
            Point3D p = new Point3D();
            p.x = Integer.parseInt(matcher.group(1));
            p.y = Integer.parseInt(matcher.group(2));
            p.z = Integer.parseInt(matcher.group(3));
            Moon moon = new Moon();
            moon.p = p;
            moon.v = new Point3D();
            moons.add(moon);
        }

        for (int i = 0; i < steps; ++i) {
            for (int j = 0; j < moons.size(); ++j) {
                for (int k = j + 1; k < moons.size(); ++k) {
                    Moon moon1 = moons.get(j);
                    Moon moon2 = moons.get(k);
                    if (moon1.p.x < moon2.p.x) {
                        ++moon1.v.x;
                        --moon2.v.x;
                    } else if (moon1.p.x > moon2.p.x) {
                        --moon1.v.x;
                        ++moon2.v.x;
                    }
                    if (moon1.p.y < moon2.p.y) {
                        ++moon1.v.y;
                        --moon2.v.y;
                    } else if (moon1.p.y > moon2.p.y) {
                        --moon1.v.y;
                        ++moon2.v.y;
                    }
                    if (moon1.p.z < moon2.p.z) {
                        ++moon1.v.z;
                        --moon2.v.z;
                    } else if (moon1.p.z > moon2.p.z) {
                        --moon1.v.z;
                        ++moon2.v.z;
                    }
                }
            }
            for (Moon moon : moons) {
                moon.p.x += moon.v.x;
                moon.p.y += moon.v.y;
                moon.p.z += moon.v.z;
            }
        }

        int sum = 0;
        for (Moon moon : moons) {
            int pot = Math.abs(moon.p.x) + Math.abs(moon.p.y) + Math.abs(moon.p.z);
            int kin = Math.abs(moon.v.x) + Math.abs(moon.v.y) + Math.abs(moon.v.z);
            sum += pot * kin;
        }
        return sum;
    }

    private static class Moon {
        Point3D p, v;
    }
}
