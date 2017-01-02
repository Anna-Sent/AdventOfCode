package advent2015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AoC2015Day22Java8 {
    public static void main(String[] args) {
        int result;

        Player player, boss;
        int count;
        Spell spell;

        // Magic Missile 0
        player = new Player(10, 0, 0, 0, getSpells());
        boss = new Player(10, 5, 0, 0, Collections.emptyList());
        spell = player.spells.get(0);
        spell.activate(player);
        assert player.getActiveSpells().size() > 0;
        player.cast(spell, boss);
        assert player.getActiveSpells().size() == 0;
        assert boss.hitPoints == 6;

        // Drain 1
        player = new Player(10, 0, 0, 0, getSpells());
        boss = new Player(10, 5, 0, 0, Collections.emptyList());
        spell = player.spells.get(1);
        spell.activate(player);
        assert player.getActiveSpells().size() > 0;
        player.cast(spell, boss);
        assert player.getActiveSpells().size() == 0;
        assert boss.hitPoints == 8;
        assert player.hitPoints == 12;

        // Shield 2
        player = new Player(10, 0, 0, 0, getSpells());
        boss = new Player(10, 5, 0, 0, Collections.emptyList());
        spell = player.spells.get(2);
        count = spell.timer;
        player.cast(spell, boss);
        for (int i = 1; i <= count; ++i) {
            assert player.getActiveSpells().size() > 0;
            assert i == 1 ? player.armor == 0 : player.armor == 7;
            player.castAll(boss);
            assert i == count ? player.armor == 0 : player.armor == 7;
        }
        assert player.armor == 0;
        assert player.getActiveSpells().size() == 0;

        // Poison 3
        player = new Player(10, 0, 0, 0, getSpells());
        boss = new Player(18, 5, 0, 0, Collections.emptyList());
        spell = player.spells.get(3);
        count = spell.timer;
        player.cast(spell, boss);
        for (int i = 1; i <= count; ++i) {
            assert player.getActiveSpells().size() > 0;
            player.castAll(boss);
        }
        assert boss.hitPoints == 0;
        assert player.getActiveSpells().size() == 0;

        // Recharge 4
        player = new Player(10, 0, 0, 0, getSpells());
        boss = new Player(18, 5, 0, 0, Collections.emptyList());
        spell = player.spells.get(4);
        count = spell.timer;
        player.cast(spell, boss);
        for (int i = 1; i <= count; ++i) {
            assert player.getActiveSpells().size() > 0;
            player.castAll(boss);
        }
        assert player.mana == 101 * 5 - 229;
        assert player.getActiveSpells().size() == 0;

        // first part -- first test
        player = new Player(10, 0, 0, 250, getSpells());
        boss = new Player(14, 8, 0, 0, Collections.emptyList());
        result = solve(false, player, boss);
        System.out.println(result);
        assert result == 641;

        // first part -- second test
        player = new Player(10, 0, 0, 250, getSpells());
        boss = new Player(13, 8, 0, 0, Collections.emptyList());
        result = solve(false, player, boss);
        System.out.println(result);
        assert result == 226;

        // first part
        player = new Player(50, 0, 0, 500, getSpells());
        boss = new Player(51, 9, 0, 0, Collections.emptyList());
        result = solve(false, player, boss);
        System.out.println(result);
        assert result == 900;

        // second part
        player = new Player(50, 0, 0, 500, getSpells());
        boss = new Player(51, 9, 0, 0, Collections.emptyList());
        result = solve(true, player, boss);
        System.out.println(result);
        assert result == 1216;
    }

    private static List<Spell> getSpells() {
        Spell magicMissile = new Spell("Magic Missile", 53, 1, 0, 4, 0, 0);
        Spell drain = new Spell("Drain", 73, 1, 2, 2, 0, 0);
        Spell shield = new Spell("Shield", 113, 6, 0, 0, 7, 0);
        Spell poison = new Spell("Poison", 173, 6, 0, 3, 0, 0);
        Spell recharge = new Spell("Recharge", 229, 5, 0, 0, 0, 101);
        List<Spell> spells = Arrays.asList(magicMissile, drain, shield, poison, recharge);
        return spells;
    }

    private static class Player {
        int hitPoints;
        int damage, armor;
        int mana;
        List<Spell> spells;

        public Player(int hitPoints, int damage, int armor, int mana, List<Spell> spells) {
            this.hitPoints = hitPoints;
            this.damage = damage;
            this.armor = armor;
            this.mana = mana;
            this.spells = spells;
        }

        public Player(Player player) {
            this(player.hitPoints, player.damage, player.armor, player.mana, copy(player.spells));
        }

        public void cast(Spell spell, Player otherPlayer) {
            mana -= spell.cost;
            spell.activate(this);
            if (spell.timer == 1)
                spell.cast(this, otherPlayer);
        }

        public void castAll(Player otherPlayer) {
            getActiveSpells().stream().forEach(spell -> spell.cast(this, otherPlayer));
        }

        public List<Spell> getActiveSpells() {
            return spells.stream().filter(spell -> spell.isActive()).collect(Collectors.toList());
        }

        public void beat(Player otherPlayer) {
            int damageFromMe = damage - otherPlayer.armor;
            damageFromMe = damageFromMe > 0 ? damageFromMe : 1;
            otherPlayer.hitPoints -= damageFromMe;
        }

        @Override
        public String toString() {
            return (spells.size() == 0 ? "Boss" : "Player") + '{' +
                    "hitPoints=" + hitPoints +
                    ", damage=" + damage +
                    ", armor=" + armor +
                    ", mana=" + mana +
                    ", spells=" + getActiveSpells() +
                    '}';
        }
    }

    private static class Spell {
        String name;
        int cost;
        int timer, timerCounter;
        int hitPoints;
        int damage;
        int armor, oldArmor;
        int mana;

        public Spell(String name, int cost, int timer, int hitPoints, int damage, int armor, int mana) {
            this.name = name;
            this.cost = cost;
            this.timer = timer;
            this.hitPoints = hitPoints;
            this.damage = damage;
            this.armor = armor;
            this.mana = mana;
        }

        public Spell(Spell spell) {
            this(spell.name, spell.cost, spell.timer, spell.hitPoints, spell.damage, spell.armor, spell.mana);
            timerCounter = spell.timerCounter;
            oldArmor = spell.oldArmor;
        }

        public boolean isActive() {
            return timerCounter > 0;
        }

        public void activate(Player player) {
            timerCounter = timer;
            if (armor != 0) {
                oldArmor = player.armor;
            }
        }

        public void cast(Player player, Player otherPlayer) {
            player.hitPoints += hitPoints;
            otherPlayer.hitPoints -= damage;
            if (armor != 0) {
                player.armor = oldArmor + armor;
            }
            player.mana += mana;
            --timerCounter;
            if (timerCounter == 0) {
                if (armor != 0) {
                    player.armor = oldArmor;
                    oldArmor = 0;
                }
            }
        }

        @Override
        public String toString() {
            return "Spell{" +
                    "name='" + name + '\'' +
                    ", timer=" + timer +
                    ", timerCounter=" + timerCounter +
                    '}';
        }
    }

    private static List<Spell> copy(List<Spell> spells) {
        List<Spell> result = new ArrayList<>();
        for (Spell spell : spells) {
            result.add(new Spell(spell));
        }
        return result;
    }

    private static int solve(boolean second, Player player, Player boss) {
        int minMana = Integer.MAX_VALUE;
        minMana = bf(second, player, boss, 0, minMana, 0);
        return minMana;
    }

    private static int bf(boolean second, Player player, Player boss, int manaSpent, int minMana, int lv) {
        for (int i = 0; i < player.spells.size(); ++i) {
            // starting new branch
            Player playerCopy = new Player(player);
            Player bossCopy = new Player(boss);

            // player turn
            if (second) {
                --playerCopy.hitPoints;
                if (playerCopy.hitPoints <= 0) {
                    // player loses, go to next branch
                    continue;
                }
            }

            // cast effects if active
            playerCopy.castAll(bossCopy);
            if (bossCopy.hitPoints <= 0) {
                // player wins, go to next branch
                minMana = Math.min(minMana, manaSpent);
                continue;
            }

            // choose spell if it's not active and we have enough money
            Spell spell = playerCopy.spells.get(i);
            if (!spell.isActive() && playerCopy.mana >= spell.cost) {
                // cast the spell
                playerCopy.cast(spell, bossCopy);
                if (bossCopy.hitPoints <= 0) {
                    // player wins, go to next branch
                    minMana = Math.min(minMana, manaSpent + spell.cost);
                    continue;
                }

                // boss turn
                // cast effects if active
                playerCopy.castAll(bossCopy);
                if (bossCopy.hitPoints <= 0) {
                    // player wins, go to next branch
                    minMana = Math.min(minMana, manaSpent + spell.cost);
                    continue;
                }

                // boss beats the player
                bossCopy.beat(playerCopy);
                if (playerCopy.hitPoints <= 0) {
                    // player loses
                    continue;
                }

                // cut off some branches
                if (manaSpent + spell.cost < minMana) {
                    minMana = bf(second, playerCopy, bossCopy, manaSpent + spell.cost, minMana, lv + 1);
                }
            }
        }
        return minMana;
    }
}
