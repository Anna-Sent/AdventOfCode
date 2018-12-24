package advent2018;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2018Day24Part2 {
    public static void main(String[] args) {
        int result;

        result = test(
                "17 units each with 5390 hit points (weak to radiation, bludgeoning) with an attack that does 4507 fire damage at initiative 2\n" +
                        "989 units each with 1274 hit points (immune to fire; weak to bludgeoning, slashing) with an attack that does 25 slashing damage at initiative 3",
                "801 units each with 4706 hit points (weak to radiation) with an attack that does 116 bludgeoning damage at initiative 1\n" +
                        "4485 units each with 2961 hit points (immune to radiation; weak to fire, cold) with an attack that does 12 slashing damage at initiative 4");
        assert result == 51 : "unexpected result is " + result;
        System.out.println(result);

        result = test(
                "7079 units each with 12296 hit points (weak to fire) with an attack that does 13 bludgeoning damage at initiative 14\n" +
                        "385 units each with 9749 hit points (weak to cold) with an attack that does 196 bludgeoning damage at initiative 16\n" +
                        "2232 units each with 1178 hit points (weak to cold, slashing) with an attack that does 4 fire damage at initiative 20\n" +
                        "917 units each with 2449 hit points (weak to bludgeoning; immune to fire, cold) with an attack that does 25 cold damage at initiative 15\n" +
                        "2657 units each with 2606 hit points (weak to slashing) with an attack that does 9 cold damage at initiative 13\n" +
                        "2460 units each with 7566 hit points with an attack that does 29 cold damage at initiative 8\n" +
                        "2106 units each with 6223 hit points with an attack that does 29 bludgeoning damage at initiative 2\n" +
                        "110 units each with 7687 hit points (weak to slashing; immune to radiation, fire) with an attack that does 506 slashing damage at initiative 19\n" +
                        "7451 units each with 9193 hit points (immune to cold) with an attack that does 12 radiation damage at initiative 6\n" +
                        "1167 units each with 3162 hit points (immune to bludgeoning; weak to fire) with an attack that does 23 fire damage at initiative 9",
                "2907 units each with 11244 hit points (immune to slashing) with an attack that does 7 fire damage at initiative 7\n" +
                        "7338 units each with 12201 hit points (immune to bludgeoning, slashing, cold) with an attack that does 3 radiation damage at initiative 4\n" +
                        "7905 units each with 59276 hit points (immune to fire) with an attack that does 12 cold damage at initiative 17\n" +
                        "1899 units each with 50061 hit points (weak to fire) with an attack that does 51 radiation damage at initiative 10\n" +
                        "2711 units each with 27602 hit points with an attack that does 17 cold damage at initiative 12\n" +
                        "935 units each with 38240 hit points (immune to slashing) with an attack that does 78 bludgeoning damage at initiative 1\n" +
                        "2783 units each with 17937 hit points (immune to cold, bludgeoning) with an attack that does 12 fire damage at initiative 11\n" +
                        "8046 units each with 13608 hit points (weak to fire, bludgeoning) with an attack that does 2 slashing damage at initiative 5\n" +
                        "2112 units each with 37597 hit points (immune to cold, slashing) with an attack that does 31 slashing damage at initiative 18\n" +
                        "109 units each with 50867 hit points (immune to slashing; weak to radiation) with an attack that does 886 cold damage at initiative 3");
        assert result == 2444 : "unexpected result is " + result;
        System.out.println(result);
    }

    public static int test(String immuneSystemString, String infectionSystemString) {
        for (int i = 1; i < 10000; ++i) {
            Result result = test(immuneSystemString, infectionSystemString, i);
            if (result.immuneWin) {
                return result.left;
            }
        }
        return -1;
    }

    public static Result test(String immuneSystemString, String infectionSystemString, int boost) {
        List<Group> immuneSystem = new ArrayList<>();
        parse(immuneSystem, immuneSystemString, Type.immune, boost);
        List<Group> infectionSystem = new ArrayList<>();
        parse(infectionSystem, infectionSystemString, Type.infection, 0);

        int previousImmuneUnits = 0;
        int previousInfectionUnits = 0;
        int immuneUnits = unitsCount(immuneSystem);
        int infectionUnits = unitsCount(infectionSystem);

        while (immuneUnits > 0 && infectionUnits > 0) {

            // target selection
            clearTarget(immuneSystem);
            clearTarget(infectionSystem);

            List<Group> groups = new ArrayList<>();
            groups.addAll(immuneSystem);
            groups.addAll(infectionSystem);
            sortForSelectTarget(groups);
            selectTarget(groups);

            // attacking
            groups = new ArrayList<>();
            groups.addAll(immuneSystem);
            groups.addAll(infectionSystem);
            sortByInitiative(groups);
            attack(groups);

            // remove groups with zero or less units
            clear(immuneSystem);
            clear(infectionSystem);

            immuneUnits = unitsCount(immuneSystem);
            infectionUnits = unitsCount(infectionSystem);
            if (immuneUnits == previousImmuneUnits && infectionUnits == previousInfectionUnits) {
                System.out.println("tie");
                break;
            }
            previousImmuneUnits = immuneUnits;
            previousInfectionUnits = infectionUnits;
//            System.out.println();
        }

//        System.out.println("immune " + immuneUnits + "; infection " + infectionUnits);
        Result result = new Result();
        result.immuneWin = immuneUnits > 0 && infectionUnits <= 0;
        result.left = immuneUnits;
        System.out.println("boost " + boost);
        return result;
    }

    private static void parse(List<Group> groups, String s, Type type, int boost) {
        final Pattern pattern = Pattern.compile("(\\d+) units each with (\\d+) hit points(.*) with an attack that does (\\d+) (.+) damage at initiative (\\d+)");
        final String IMMUNE_TO = "immune to ", WEAK_TO = "weak to ";
        String[] tokens = s.split("\n");
        int index = 1;
        for (String token : tokens) {
            Matcher matcher = pattern.matcher(token);
            assert matcher.matches() : "invalid input " + token;
            Group group = new Group();
            group.type = type;
            group.index = index++;
            group.unitsCount = Integer.parseInt(matcher.group(1));
            group.hitPoints = Integer.parseInt(matcher.group(2));
            String detail = matcher.group(3);
            detail = detail.replace("(", "").replace(")", "").trim();
            String immune = "", weak = "";
            if (!detail.isEmpty()) {
                String[] details = detail.split("; ");
                assert details.length == 1 || details.length == 2 : "invalid details " + details;
                if (details[0].startsWith(IMMUNE_TO)) {
                    immune = details[0];
                } else if (details[0].startsWith(WEAK_TO)) {
                    weak = details[0];
                } else {
                    assert false : "invalid details " + details[0];
                }
                if (details.length > 1) {
                    if (details[1].startsWith(WEAK_TO)) {
                        weak = details[1];
                    } else if (details[1].startsWith(IMMUNE_TO)) {
                        immune = details[1];
                    } else {
                        assert false : "invalid details " + details[1];
                    }
                }
            }
            group.immune = parseAttacks(immune.isEmpty() ? "" : immune.substring(IMMUNE_TO.length(), immune.length()));
            group.weak = parseAttacks(weak.isEmpty() ? "" : weak.substring(WEAK_TO.length(), weak.length()));
            group.damage = Integer.parseInt(matcher.group(4)) + boost;
            group.attack = Attack.valueOf(matcher.group(5));
            group.initiative = Integer.parseInt(matcher.group(6));
            groups.add(group);
        }
    }

    private static Set<Attack> parseAttacks(String s) {
        if (s.isEmpty()) {
            return EnumSet.noneOf(Attack.class);
        }
        Set<Attack> attacks = new HashSet<>();
        String[] tokens = s.split(", ");
        for (String token : tokens) {
            attacks.add(Attack.valueOf(token));
        }
        return attacks;
    }

    private static int unitsCount(List<Group> groups) {
        int unitsCount = 0;
        for (Group group : groups) {
            unitsCount += group.unitsCount;
        }
        return unitsCount;
    }

    private static void clearTarget(List<Group> groups) {
        for (Group group : groups) {
            group.target = null;
            group.selected = false;
        }
    }

    private static void sortByInitiative(List<Group> groups) {
        Collections.sort(groups, (g1, g2) -> -Integer.compare(g1.initiative, g2.initiative));
    }

    private static void sortForSelectTarget(List<Group> groups) {
        Collections.sort(groups, (g1, g2) -> {
            int result = -Integer.compare(g1.effectivePower(), g2.effectivePower());
            if (result == 0) {
                return -Integer.compare(g1.initiative, g2.initiative);
            }
            return result;
        });
    }

    private static void selectTarget(List<Group> groups) {
        for (Group attacking : groups) {
            List<Group> possibleTargets = new ArrayList<>();
            for (Group group : groups) {
                if (group.type != attacking.type && !group.selected) {
                    possibleTargets.add(group);
                }
            }
            Collections.sort(possibleTargets, (g1, g2) -> {
                int result = -Integer.compare(damage(attacking, g1), damage(attacking, g2));
                if (result == 0) {
                    result = -Integer.compare(g1.effectivePower(), g2.effectivePower());
                    if (result == 0) {
                        return -Integer.compare(g1.initiative, g2.initiative);
                    }
                }
                return result;
            });
            attacking.target = possibleTargets.isEmpty() ? null : possibleTargets.get(0);
            if (attacking.target != null) {
                if (damage(attacking, attacking.target) == 0) {
                    attacking.target = null;
                }
            }
            if (attacking.target != null) {
                attacking.target.selected = true;
            }
        }
    }

    private static void attack(List<Group> groups) {
        for (Group group : groups) {
            if (group.target == null || group.unitsCount <= 0) {
                continue;
            }
            int damage = damage(group, group.target);
            int unitsCount = damage / group.target.hitPoints;
            if (unitsCount > group.target.unitsCount) {
                unitsCount = group.target.unitsCount;
            }
            group.target.unitsCount -= unitsCount;
//            System.out.println(group.type + " " + group.index + " attacks " + group.target.index
//                    + ", killing " + unitsCount + " units");
        }
    }

    private static int damage(Group attacking, Group target) {
        if (target.immune.contains(attacking.attack)) {
            // no damage
            return 0;
        } else {
            return attacking.effectivePower() * (target.weak.contains(attacking.attack) ? 2 : 1);
        }
    }

    private static void clear(List<Group> groups) {
        Iterator<Group> iterator = groups.iterator();
        while (iterator.hasNext()) {
            Group group = iterator.next();
            if (group.unitsCount <= 0) {
                iterator.remove();
            }
        }
    }

    private enum Attack {
        fire, cold, slashing, bludgeoning, radiation
    }

    private enum Type {
        immune, infection
    }

    private static class Group {
        Type type;
        int index;
        int unitsCount;
        int hitPoints;
        Set<Attack> immune;
        Set<Attack> weak;
        int damage;
        int initiative;
        Attack attack;
        Group target;
        boolean selected;

        int effectivePower() {
            return unitsCount * damage;
        }
    }

    private static class Result {
        boolean immuneWin;
        int left;
    }
}
