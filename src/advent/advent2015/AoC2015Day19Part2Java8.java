package advent.advent2015;

import java.util.HashSet;
import java.util.Set;

public class AoC2015Day19Part2Java8 {
    public static void main(String[] args) {
        long result;

        result = solve1("HOH", "e => H\n" +
                "e => O\n" +
                "H => HO\n" +
                "H => OH\n" +
                "O => HH");
        System.out.println(result);
        assert result == 3;

        result = solve1("HOHOHO", "e => H\n" +
                "e => O\n" +
                "H => HO\n" +
                "H => OH\n" +
                "O => HH");
        System.out.println(result);
        assert result == 6;

        result = solve2("CRnSiRnCaPTiMgYCaPTiRnFArSiThFArCaSiThSiThPBCaCaSiRnSiRnTiTiMgArPBCaPMgYPTiRnFArFArCaSiRnBPMgArPRnCaPTiRnFArCaSiThCaCaFArPBCaCaPTiTiRnFArCaSiRnSiAlYSiThRnFArArCaSiRnBFArCaCaSiRnSiThCaCaCaFYCaPTiBCaSiThCaSiThPMgArSiRnCaPBFYCaCaFArCaCaCaCaSiThCaSiRnPRnFArPBSiThPRnFArSiRnMgArCaFYFArCaSiRnSiAlArTiTiTiTiTiTiTiRnPMgArPTiTiTiBSiRnSiAlArTiTiRnPMgArCaFYBPBPTiRnSiRnMgArSiThCaFArCaSiThFArPRnFArCaSiRnTiBSiThSiRnSiAlYCaFArPRnFArSiThCaFArCaCaSiThCaCaCaSiRnPRnCaFArFYPMgArCaPBCaPBSiRnFYPBCaFArCaSiAl");
        System.out.println(result);
        assert result == 200;
    }

    private static long solve2(String molecule) {
        long atoms = molecule.chars().mapToObj(c -> (char) c).filter(c -> c >= 'A' && c <= 'Z').count();
        long ra = molecule.chars().mapToObj(c -> (char) c).filter(c -> c == 'R' || c == 'r').count();
        long y = molecule.chars().mapToObj(c -> (char) c).filter(c -> c == 'Y').count();
        return atoms - ra - y * 2 - 1;
    }

    private static int solve1(String molecule, String s) {
        String[] replacements = s.split("\n");

        String initial = molecule;

        Set<String> closed = new HashSet<>();
        Set<String> opened = new HashSet<>();

        int count = 0;
        opened.add(initial);

        while (opened.size() > 0) {
            Set<String> achievable = new HashSet<>();
            for (String currentState : opened) {
                if (currentState.equals("e")) {
                    return count;
                }

                Set<String> set = generateMolecules(currentState, replacements);
                for (String nextState : set) {
                    if (!closed.contains(nextState)) {
                        achievable.add(nextState);
                    }
                }

                closed.add(currentState);
            }

            ++count;
            opened = achievable;
        }

        return -1;
    }

    private static Set<String> generateMolecules(String molecule, String[] replacements) {
        Set<String> molecules = new HashSet<>();

        for (String replacement : replacements) {
            String[] tokens = replacement.split(" => ");
            String to = tokens[0];
            String from = tokens[1];
            for (int i = 0; i <= molecule.length() - from.length(); ++i) {
                boolean found = true;
                for (int j = 0; found && j < from.length(); ++j) {
                    found = molecule.charAt(i + j) == from.charAt(j);
                }
                if (found) {
                    StringBuilder newMolecule = new StringBuilder();
                    newMolecule.append(molecule.substring(0, i));
                    newMolecule.append(to);
                    newMolecule.append(molecule.substring(i + from.length(), molecule.length()));
                    molecules.add(newMolecule.toString());
                }
            }
        }

        return molecules;
    }
}
