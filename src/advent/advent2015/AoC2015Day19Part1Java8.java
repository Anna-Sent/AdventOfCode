package advent.advent2015;

import java.util.HashSet;
import java.util.Set;

public class AoC2015Day19Part1Java8 {
    public static void main(String[] args) {
        int result;

        result = test("HOH",
                "H => HO\n" +
                        "H => OH\n" +
                        "O => HH");
        System.out.println(result);
        assert result == 4;

        result = test("HOHOHO",
                "H => HO\n" +
                        "H => OH\n" +
                        "O => HH");
        System.out.println(result);
        assert result == 7;

        result = test("CRnSiRnCaPTiMgYCaPTiRnFArSiThFArCaSiThSiThPBCaCaSiRnSiRnTiTiMgArPBCaPMgYPTiRnFArFArCaSiRnBPMgArPRnCaPTiRnFArCaSiThCaCaFArPBCaCaPTiTiRnFArCaSiRnSiAlYSiThRnFArArCaSiRnBFArCaCaSiRnSiThCaCaCaFYCaPTiBCaSiThCaSiThPMgArSiRnCaPBFYCaCaFArCaCaCaCaSiThCaSiRnPRnFArPBSiThPRnFArSiRnMgArCaFYFArCaSiRnSiAlArTiTiTiTiTiTiTiRnPMgArPTiTiTiBSiRnSiAlArTiTiRnPMgArCaFYBPBPTiRnSiRnMgArSiThCaFArCaSiThFArPRnFArCaSiRnTiBSiThSiRnSiAlYCaFArPRnFArSiThCaFArCaCaSiThCaCaCaSiRnPRnCaFArFYPMgArCaPBCaPBSiRnFYPBCaFArCaSiAl",
                "Al => ThF\n" +
                        "Al => ThRnFAr\n" +
                        "B => BCa\n" +
                        "B => TiB\n" +
                        "B => TiRnFAr\n" +
                        "Ca => CaCa\n" +
                        "Ca => PB\n" +
                        "Ca => PRnFAr\n" +
                        "Ca => SiRnFYFAr\n" +
                        "Ca => SiRnMgAr\n" +
                        "Ca => SiTh\n" +
                        "F => CaF\n" +
                        "F => PMg\n" +
                        "F => SiAl\n" +
                        "H => CRnAlAr\n" +
                        "H => CRnFYFYFAr\n" +
                        "H => CRnFYMgAr\n" +
                        "H => CRnMgYFAr\n" +
                        "H => HCa\n" +
                        "H => NRnFYFAr\n" +
                        "H => NRnMgAr\n" +
                        "H => NTh\n" +
                        "H => OB\n" +
                        "H => ORnFAr\n" +
                        "Mg => BF\n" +
                        "Mg => TiMg\n" +
                        "N => CRnFAr\n" +
                        "N => HSi\n" +
                        "O => CRnFYFAr\n" +
                        "O => CRnMgAr\n" +
                        "O => HP\n" +
                        "O => NRnFAr\n" +
                        "O => OTi\n" +
                        "P => CaP\n" +
                        "P => PTi\n" +
                        "P => SiRnFAr\n" +
                        "Si => CaSi\n" +
                        "Th => ThCa\n" +
                        "Ti => BP\n" +
                        "Ti => TiTi\n" +
                        "e => HF\n" +
                        "e => NAl\n" +
                        "e => OMg");
        System.out.println(result);
        assert result == 518;
    }

    private static int test(String molecule, String s) {
        Set<String> molecules = new HashSet<>();

        String[] replacements = s.split("\n");
        for (String replacement : replacements) {
            String[] tokens = replacement.split(" => ");
            String from = tokens[0];
            String to = tokens[1];
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

        return molecules.size();
    }
}
