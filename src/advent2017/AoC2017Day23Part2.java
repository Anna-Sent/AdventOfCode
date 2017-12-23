package advent2017;

public class AoC2017Day23Part2 {
    public static void main(String[] args) {
        int result;

        result = test();
        //assert result ==  : "unexpected result is " + result;
        System.out.println(result);
    }

    public static int test() {
        int h = 0;

        int b = 108100;
        int c = b + 17000;

        do {
            int d = 2;
            int f = 1;
            do {
                if (b % d == 0) {
                    f = 0;
                    break;
                }
                ++d;
            } while (d * d <= b);
            if (f == 0) {
                ++h;
            }
            b += 17;
        } while (b <= c);
/*
set b 81
set c b
jnz a 2
jnz 1 5
mul b 100
sub b -100000
set c b
sub c -17000
set f 1//3
set d 2
set e 2//2
set g d//1
mul g e
sub g b
jnz g 2
set f 0
sub e -1
set g e
sub g b
jnz g -8//1
sub d -1
set g d
sub g b
jnz g -13//2
jnz f 2
sub h -1
set g b
sub g c
jnz g 2
jnz 1 3
sub b -17
jnz 1 -23//3
*/
        return h;
    }
}
