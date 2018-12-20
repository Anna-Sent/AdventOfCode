package advent2018;

public class AoC2018Day20Part1 {
    public static void main(String[] args) {
        int result;

        result = test("^WNE$");
        assert result == 3 : "unexpected result is " + result;
        System.out.println(result);
// #####
// #.|.#
// #-###
// #.|X#
// #####

        result = test("^ENWWW(NEEE|SSE(EE|N))$");
        assert result == 10 : "unexpected result is " + result;
        System.out.println(result);
// #########
// #.|.|.|.#
// #-#######
// #.|.|.|.#
// #-#####-#
// #.#.#X|.#
// #-#-#####
// #.|.|.|.#
// #########

        result = test("^ENNWSWW(NEWS|)SSSEEN(WNSE|)EE(SWEN|)NNN$");
        assert result == 18 : "unexpected result is " + result;
        System.out.println(result);
// ###########
// #.|.#.|.#.#
// #-###-#-#-#
// #.|.|.#.#.#
// #-#####-#-#
// #.#.#X|.#.#
// #-#-#####-#
// #.#.|.|.|.#
// #-###-###-#
// #.|.|.#.|.#
// ###########

        result = test("^ESSWWN(E|NNENN(EESS(WNSE|)SSS|WWWSSSSE(SW|NNNE)))$");
        assert result == 23 : "unexpected result is " + result;
        System.out.println(result);
// #############
// #.|.|.|.|.|.#
// #-#####-###-#
// #.#.|.#.#.#.#
// #-#-###-#-#-#
// #.#.#.|.#.|.#
// #-#-#-#####-#
// #.#.#.#X|.#.#
// #-#-#-###-#-#
// #.|.#.|.#.#.#
// ###-#-###-#-#
// #.|.#.|.|.#.#
// #############

        result = test("^WSSEESWWWNW(S|NENNEEEENN(ESSSSW(NWSW|SSEN)|WSWWN(E|WWS(E|SS))))$");
        assert result == 31 : "unexpected result is " + result;
        System.out.println(result);
// ###############
// #.|.|.|.#.|.|.#
// #-###-###-#-#-#
// #.|.#.|.|.#.#.#
// #-#########-#-#
// #.#.|.|.|.|.#.#
// #-#-#########-#
// #.#.#.|X#.|.#.#
// ###-#-###-#-#-#
// #.|.#.#.|.#.|.#
// #-###-#####-###
// #.|.#.|.|.#.#.#
// #-#-#####-#-#-#
// #.#.|.|.|.#.|.#
// ###############

        result = test("");
        // assert result ==  : "unexpected result is " + result;
        System.out.println(result);
    }

    public static int test(String s) {
        int sum = 0;
        return sum;
    }
}
