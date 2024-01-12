package advent.advent2019;

import utils.Point3D;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2019Day12Part2 {

    public static void main(String[] args) {
        long result;

        System.out.println(80.21 * 100);
        System.out.println(Math.floor(80.21 * 100));
        // 8020.999999999999
        // 8020.0

        result = test("<x=-1, y=0, z=2>\n" +
                "<x=2, y=-10, z=-7>\n" +
                "<x=4, y=-8, z=8>\n" +
                "<x=3, y=5, z=-1>");
        assert result == 2772 : "unexpected result is " + result;
        System.out.println(result);

        result = test("<x=-8, y=-10, z=0>\n" +
                "<x=5, y=5, z=10>\n" +
                "<x=2, y=-7, z=3>\n" +
                "<x=9, y=-8, z=-3>");
        assert result == 4686774924L : "unexpected result is " + result;
        System.out.println(result);

        result = test("<x=12, y=0, z=-15>\n" +
                "<x=-8, y=-5, z=-10>\n" +
                "<x=7, y=-17, z=1>\n" +
                "<x=2, y=-11, z=-6>");
        assert result == 281691380235984L : "unexpected result is " + result;
        System.out.println(result);
    }

    private static final Pattern pattern = Pattern.compile("<x=(-?\\d+), y=(-?\\d+), z=(-?\\d+)>");

    private static long test(String s) {
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

        List<Moon> initialMoons = new ArrayList<>();
        for (Moon moon : moons) {
            Moon initialMoon = new Moon();
            initialMoon.p = new Point3D(moon.p);
            initialMoon.v = new Point3D(moon.v);
            initialMoons.add(initialMoon);
        }

        long xPeriod = -1, yPeriod = -1, zPeriod = -1;
        for (int i = 1; xPeriod == -1 || yPeriod == -1 || zPeriod == -1; ++i) {
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

            boolean x = true, y = true, z = true;
            for (int k = 0; k < moons.size(); ++k) {
                Moon initial = initialMoons.get(k);
                Moon moon = moons.get(k);
                x = x && initial.p.x == moon.p.x && initial.v.x == moon.v.x;
                y = y && initial.p.y == moon.p.y && initial.v.y == moon.v.y;
                z = z && initial.p.z == moon.p.z && initial.v.z == moon.v.z;
            }
            if (x && xPeriod == -1) {
                xPeriod = i;
            }
            if (y && yPeriod == -1) {
                yPeriod = i;
            }
            if (z && zPeriod == -1) {
                zPeriod = i;
            }
        }

        long a = gcd(xPeriod, yPeriod);
        a = xPeriod * yPeriod / a;
        long b = gcd(a, zPeriod);
        b = a * zPeriod / b;

        return b;
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static class Moon {
        Point3D p, v;
    }
}
