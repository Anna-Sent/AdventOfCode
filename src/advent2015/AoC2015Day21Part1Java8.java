package advent2015;

import java.util.ArrayList;
import java.util.List;

public class AoC2015Day21Part1Java8 {
    public static void main(String[] args) {
        int result;

        result = solve();
        System.out.println(result);
        assert result == 111;
    }

    private enum Type {
        WEAPON, ARMOR, RING
    }

    private static class Item {
        Type type;
        String name;
        int cost, damage, armor;

        public Item(Type type, String name, int cost, int damage, int armor) {
            this.type = type;
            this.name = name;
            this.cost = cost;
            this.damage = damage;
            this.armor = armor;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private static class Player {
        int hitPoints;
        int damage, armor;

        public Player(int hitPoints, int damage, int armor) {
            this.hitPoints = hitPoints;
            this.damage = damage;
            this.armor = armor;
        }
    }

    private static int solve() {
        List<Item> weapons = new ArrayList<>();
        weapons.add(new Item(Type.WEAPON, "Dagger", 8, 4, 0));
        weapons.add(new Item(Type.WEAPON, "Shortsword", 10, 5, 0));
        weapons.add(new Item(Type.WEAPON, "Warhammer", 25, 6, 0));
        weapons.add(new Item(Type.WEAPON, "Longsword", 40, 7, 0));
        weapons.add(new Item(Type.WEAPON, "Greataxe", 74, 8, 0));

        List<Item> armors = new ArrayList<>();
        armors.add(null);
        armors.add(new Item(Type.ARMOR, "Leather", 13, 0, 1));
        armors.add(new Item(Type.ARMOR, "Chainmail", 31, 0, 2));
        armors.add(new Item(Type.ARMOR, "Splintmail", 53, 0, 3));
        armors.add(new Item(Type.ARMOR, "Bandedmail", 75, 0, 4));
        armors.add(new Item(Type.ARMOR, "Platemail", 102, 0, 5));

        List<Item> rings = new ArrayList<>();
        rings.add(null);
        rings.add(new Item(Type.RING, "Damage +1", 25, 1, 0));
        rings.add(new Item(Type.RING, "Damage +2", 50, 2, 0));
        rings.add(new Item(Type.RING, "Damage +3", 100, 3, 0));
        rings.add(new Item(Type.RING, "Defense +1", 20, 0, 1));
        rings.add(new Item(Type.RING, "Defense +2", 40, 0, 2));
        rings.add(new Item(Type.RING, "Defense +3", 80, 0, 3));

        int minCost = Integer.MAX_VALUE;

        for (Item weapon : weapons) {
            for (Item armor : armors) {
                for (int i = 0; i < rings.size(); ++i) {
                    Item firstRing = rings.get(i);
                    for (int j = i; j < rings.size(); ++j) {
                        if (i != j || firstRing == null) {
                            Item secondRing = rings.get(j);
                            System.out.println(weapon + " " + armor + " " + firstRing + " " + secondRing);

                            int totalCost = weapon.cost + (armor == null ? 0 : armor.cost) + (firstRing == null ? 0 : firstRing.cost) + (secondRing == null ? 0 : secondRing.cost);
                            int totalDamage = weapon.damage + (armor == null ? 0 : armor.damage) + (firstRing == null ? 0 : firstRing.damage) + (secondRing == null ? 0 : secondRing.damage);
                            int totalArmor = weapon.armor + (armor == null ? 0 : armor.armor) + (firstRing == null ? 0 : firstRing.armor) + (secondRing == null ? 0 : secondRing.armor);

                            Player player = new Player(100, totalDamage, totalArmor);
                            Player boss = new Player(109, 8, 2);

                            int playerDamage = player.damage - boss.armor;
                            playerDamage = playerDamage > 0 ? playerDamage : 1;
                            int bossDamage = boss.damage - player.armor;
                            bossDamage = bossDamage > 0 ? bossDamage : 1;

                            int step = 0;
                            while (player.hitPoints > 0 && boss.hitPoints > 0) {
                                ++step;
                                if (step % 2 == 1) {
                                    boss.hitPoints -= playerDamage;
                                } else {
                                    player.hitPoints -= bossDamage;
                                }
                            }

                            if (player.hitPoints > 0 && boss.hitPoints <= 0) {
                                // player win
                                minCost = totalCost < minCost ? totalCost : minCost;
                            }
                        }
                    }
                }
            }
        }

        return minCost;
    }
}
