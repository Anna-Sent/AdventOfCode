package advent2015;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2015Day16Part2 {
    public static void main(String[] args) {
        int result;

        result = test("Sue 1: cars: 9, akitas: 3, goldfish: 0\r\nSue 2: akitas: 9, children: 3, samoyeds: 9\r\nSue 3: trees: 6, cars: 6, children: 4\r\nSue 4: trees: 4, vizslas: 4, goldfish: 9\r\nSue 5: akitas: 9, vizslas: 7, cars: 5\r\nSue 6: vizslas: 6, goldfish: 6, akitas: 3\r\nSue 7: pomeranians: 5, samoyeds: 0, perfumes: 10\r\nSue 8: cars: 10, pomeranians: 7, goldfish: 8\r\nSue 9: trees: 2, vizslas: 7, samoyeds: 6\r\nSue 10: perfumes: 5, pomeranians: 4, children: 9\r\nSue 11: vizslas: 5, perfumes: 8, cars: 10\r\nSue 12: children: 10, cars: 6, perfumes: 5\r\nSue 13: cats: 4, samoyeds: 7, pomeranians: 8\r\nSue 14: perfumes: 6, goldfish: 10, children: 7\r\nSue 15: perfumes: 4, pomeranians: 3, cars: 6\r\nSue 16: perfumes: 7, cars: 9, pomeranians: 6\r\nSue 17: goldfish: 3, cars: 6, vizslas: 7\r\nSue 18: perfumes: 6, cars: 7, goldfish: 3\r\nSue 19: trees: 0, akitas: 3, pomeranians: 8\r\nSue 20: goldfish: 6, trees: 2, akitas: 6\r\nSue 21: pomeranians: 9, akitas: 9, samoyeds: 9\r\nSue 22: vizslas: 2, cars: 9, perfumes: 5\r\nSue 23: goldfish: 10, samoyeds: 8, children: 9\r\nSue 24: akitas: 4, goldfish: 1, vizslas: 5\r\nSue 25: goldfish: 10, trees: 8, perfumes: 6\r\nSue 26: vizslas: 5, akitas: 8, trees: 1\r\nSue 27: trees: 3, cars: 6, perfumes: 2\r\nSue 28: goldfish: 8, trees: 7, akitas: 10\r\nSue 29: children: 5, trees: 1, goldfish: 10\r\nSue 30: vizslas: 3, perfumes: 8, akitas: 3\r\nSue 31: cars: 6, children: 10, perfumes: 7\r\nSue 32: cars: 10, perfumes: 3, goldfish: 10\r\nSue 33: perfumes: 9, vizslas: 3, akitas: 4\r\nSue 34: perfumes: 10, vizslas: 7, children: 8\r\nSue 35: cars: 5, perfumes: 5, vizslas: 9\r\nSue 36: trees: 9, cars: 9, akitas: 7\r\nSue 37: samoyeds: 9, perfumes: 2, cars: 10\r\nSue 38: akitas: 7, cars: 5, trees: 5\r\nSue 39: goldfish: 8, trees: 9, cars: 10\r\nSue 40: trees: 0, cats: 1, pomeranians: 1\r\nSue 41: pomeranians: 6, perfumes: 9, samoyeds: 1\r\nSue 42: vizslas: 6, akitas: 3, pomeranians: 1\r\nSue 43: vizslas: 2, perfumes: 3, pomeranians: 6\r\nSue 44: akitas: 5, pomeranians: 0, vizslas: 10\r\nSue 45: vizslas: 4, goldfish: 1, cars: 5\r\nSue 46: cars: 4, vizslas: 8, cats: 0\r\nSue 47: cats: 5, children: 8, pomeranians: 2\r\nSue 48: vizslas: 3, perfumes: 6, cats: 0\r\nSue 49: akitas: 7, perfumes: 0, trees: 7\r\nSue 50: trees: 4, akitas: 10, vizslas: 2\r\nSue 51: goldfish: 10, cars: 9, trees: 4\r\nSue 52: cars: 5, children: 9, perfumes: 0\r\nSue 53: vizslas: 5, cars: 3, cats: 8\r\nSue 54: cars: 5, akitas: 1, goldfish: 10\r\nSue 55: akitas: 10, vizslas: 2, cars: 6\r\nSue 56: cats: 6, trees: 0, cars: 4\r\nSue 57: vizslas: 1, akitas: 1, samoyeds: 7\r\nSue 58: samoyeds: 6, vizslas: 1, akitas: 7\r\nSue 59: akitas: 9, cars: 8, vizslas: 1\r\nSue 60: cars: 6, vizslas: 7, goldfish: 0\r\nSue 61: pomeranians: 5, akitas: 6, vizslas: 2\r\nSue 62: samoyeds: 2, cats: 8, goldfish: 7\r\nSue 63: vizslas: 10, goldfish: 7, samoyeds: 9\r\nSue 64: perfumes: 2, trees: 1, akitas: 6\r\nSue 65: cars: 8, perfumes: 10, vizslas: 9\r\nSue 66: akitas: 8, vizslas: 8, perfumes: 8\r\nSue 67: goldfish: 7, cars: 9, samoyeds: 9\r\nSue 68: perfumes: 2, children: 7, akitas: 1\r\nSue 69: perfumes: 7, vizslas: 9, akitas: 1\r\nSue 70: samoyeds: 3, vizslas: 1, trees: 1\r\nSue 71: vizslas: 8, goldfish: 7, trees: 9\r\nSue 72: goldfish: 8, cars: 6, trees: 9\r\nSue 73: perfumes: 5, cars: 10, samoyeds: 7\r\nSue 74: pomeranians: 4, perfumes: 3, cars: 5\r\nSue 75: samoyeds: 1, perfumes: 1, pomeranians: 1\r\nSue 76: goldfish: 4, cats: 6, akitas: 7\r\nSue 77: perfumes: 5, akitas: 4, vizslas: 8\r\nSue 78: perfumes: 4, cats: 3, children: 4\r\nSue 79: vizslas: 5, pomeranians: 9, samoyeds: 7\r\nSue 80: cars: 3, samoyeds: 5, pomeranians: 7\r\nSue 81: vizslas: 2, samoyeds: 4, perfumes: 2\r\nSue 82: trees: 1, akitas: 10, vizslas: 9\r\nSue 83: vizslas: 0, akitas: 2, samoyeds: 5\r\nSue 84: perfumes: 5, vizslas: 7, children: 8\r\nSue 85: cats: 3, children: 2, trees: 0\r\nSue 86: cars: 3, perfumes: 2, goldfish: 2\r\nSue 87: trees: 1, akitas: 7, vizslas: 0\r\nSue 88: trees: 1, akitas: 2, samoyeds: 1\r\nSue 89: cars: 4, vizslas: 8, akitas: 1\r\nSue 90: perfumes: 5, cats: 3, vizslas: 0\r\nSue 91: samoyeds: 7, cats: 6, goldfish: 8\r\nSue 92: samoyeds: 10, cats: 0, cars: 7\r\nSue 93: cars: 6, akitas: 7, samoyeds: 2\r\nSue 94: perfumes: 0, goldfish: 6, trees: 9\r\nSue 95: cars: 6, pomeranians: 2, samoyeds: 8\r\nSue 96: cars: 2, trees: 9, samoyeds: 4\r\nSue 97: goldfish: 5, trees: 1, children: 0\r\nSue 98: akitas: 9, goldfish: 7, children: 6\r\nSue 99: goldfish: 9, akitas: 0, pomeranians: 0\r\nSue 100: samoyeds: 6, children: 8, vizslas: 5\r\nSue 101: vizslas: 6, cars: 5, goldfish: 4\r\nSue 102: vizslas: 6, akitas: 2, perfumes: 6\r\nSue 103: samoyeds: 3, akitas: 7, children: 4\r\nSue 104: cars: 3, perfumes: 10, cats: 6\r\nSue 105: vizslas: 9, pomeranians: 0, cars: 1\r\nSue 106: cats: 6, samoyeds: 8, pomeranians: 5\r\nSue 107: cars: 7, trees: 4, akitas: 10\r\nSue 108: perfumes: 3, vizslas: 1, goldfish: 9\r\nSue 109: trees: 6, cars: 8, goldfish: 5\r\nSue 110: pomeranians: 2, children: 1, vizslas: 7\r\nSue 111: akitas: 0, vizslas: 8, cars: 0\r\nSue 112: goldfish: 3, vizslas: 6, akitas: 2\r\nSue 113: akitas: 10, pomeranians: 7, perfumes: 7\r\nSue 114: cars: 10, cats: 2, vizslas: 8\r\nSue 115: akitas: 8, trees: 1, vizslas: 2\r\nSue 116: vizslas: 2, akitas: 7, perfumes: 1\r\nSue 117: goldfish: 0, vizslas: 10, trees: 9\r\nSue 118: trees: 3, cars: 0, goldfish: 0\r\nSue 119: perfumes: 7, goldfish: 5, trees: 9\r\nSue 120: children: 9, vizslas: 3, trees: 5\r\nSue 121: vizslas: 1, goldfish: 7, akitas: 10\r\nSue 122: perfumes: 1, cars: 6, trees: 1\r\nSue 123: akitas: 2, vizslas: 0, goldfish: 7\r\nSue 124: vizslas: 10, pomeranians: 7, akitas: 0\r\nSue 125: perfumes: 4, cats: 5, vizslas: 2\r\nSue 126: cars: 6, samoyeds: 8, akitas: 3\r\nSue 127: trees: 9, goldfish: 7, akitas: 9\r\nSue 128: cars: 8, trees: 0, perfumes: 2\r\nSue 129: pomeranians: 7, vizslas: 2, perfumes: 6\r\nSue 130: vizslas: 9, pomeranians: 3, trees: 6\r\nSue 131: vizslas: 7, cars: 9, perfumes: 1\r\nSue 132: akitas: 2, pomeranians: 9, vizslas: 7\r\nSue 133: trees: 9, pomeranians: 10, samoyeds: 0\r\nSue 134: children: 4, akitas: 10, perfumes: 4\r\nSue 135: vizslas: 1, cats: 1, trees: 8\r\nSue 136: samoyeds: 7, cars: 8, goldfish: 5\r\nSue 137: perfumes: 0, children: 1, pomeranians: 10\r\nSue 138: vizslas: 4, perfumes: 5, cars: 5\r\nSue 139: trees: 2, perfumes: 8, goldfish: 0\r\nSue 140: cars: 10, akitas: 5, goldfish: 7\r\nSue 141: children: 4, trees: 3, goldfish: 8\r\nSue 142: cars: 8, perfumes: 6, trees: 7\r\nSue 143: akitas: 6, goldfish: 0, trees: 10\r\nSue 144: akitas: 7, pomeranians: 10, perfumes: 10\r\nSue 145: trees: 10, vizslas: 3, goldfish: 4\r\nSue 146: samoyeds: 4, akitas: 3, perfumes: 6\r\nSue 147: akitas: 8, perfumes: 2, pomeranians: 10\r\nSue 148: cars: 2, perfumes: 0, goldfish: 8\r\nSue 149: goldfish: 6, akitas: 7, perfumes: 6\r\nSue 150: cars: 2, pomeranians: 5, perfumes: 4\r\nSue 151: goldfish: 1, cars: 5, trees: 0\r\nSue 152: pomeranians: 4, cars: 7, children: 1\r\nSue 153: goldfish: 8, cars: 1, children: 10\r\nSue 154: cars: 6, perfumes: 8, trees: 1\r\nSue 155: akitas: 4, perfumes: 6, pomeranians: 2\r\nSue 156: pomeranians: 5, cars: 4, akitas: 1\r\nSue 157: cats: 5, cars: 9, goldfish: 8\r\nSue 158: vizslas: 5, samoyeds: 1, children: 7\r\nSue 159: vizslas: 1, perfumes: 3, akitas: 1\r\nSue 160: goldfish: 10, pomeranians: 9, perfumes: 5\r\nSue 161: samoyeds: 3, trees: 7, cars: 2\r\nSue 162: cars: 2, pomeranians: 1, vizslas: 6\r\nSue 163: vizslas: 3, perfumes: 5, akitas: 6\r\nSue 164: vizslas: 1, trees: 0, akitas: 5\r\nSue 165: vizslas: 5, cars: 6, pomeranians: 8\r\nSue 166: cars: 10, perfumes: 2, trees: 9\r\nSue 167: cars: 10, pomeranians: 6, perfumes: 4\r\nSue 168: akitas: 7, trees: 10, goldfish: 7\r\nSue 169: akitas: 1, perfumes: 10, cars: 10\r\nSue 170: akitas: 5, samoyeds: 8, vizslas: 6\r\nSue 171: children: 3, akitas: 2, vizslas: 3\r\nSue 172: goldfish: 5, vizslas: 5, perfumes: 9\r\nSue 173: perfumes: 5, goldfish: 10, trees: 5\r\nSue 174: akitas: 5, vizslas: 2, children: 7\r\nSue 175: perfumes: 5, cars: 7, samoyeds: 2\r\nSue 176: cars: 8, vizslas: 10, akitas: 7\r\nSue 177: perfumes: 7, children: 8, goldfish: 7\r\nSue 178: cars: 1, pomeranians: 9, samoyeds: 0\r\nSue 179: perfumes: 6, cars: 2, trees: 6\r\nSue 180: trees: 3, vizslas: 7, children: 3\r\nSue 181: vizslas: 8, samoyeds: 2, trees: 9\r\nSue 182: perfumes: 3, cats: 1, children: 5\r\nSue 183: akitas: 9, cats: 6, children: 3\r\nSue 184: pomeranians: 9, cars: 6, perfumes: 8\r\nSue 185: vizslas: 9, trees: 0, akitas: 9\r\nSue 186: perfumes: 6, cars: 5, goldfish: 5\r\nSue 187: perfumes: 4, cats: 7, vizslas: 2\r\nSue 188: akitas: 7, cars: 4, children: 10\r\nSue 189: akitas: 0, goldfish: 7, vizslas: 5\r\nSue 190: akitas: 5, cars: 5, cats: 6\r\nSue 191: cars: 6, children: 0, perfumes: 3\r\nSue 192: cats: 2, perfumes: 10, goldfish: 7\r\nSue 193: trees: 1, perfumes: 0, cars: 8\r\nSue 194: perfumes: 9, children: 4, cats: 6\r\nSue 195: akitas: 7, trees: 3, goldfish: 6\r\nSue 196: goldfish: 8, cars: 8, samoyeds: 0\r\nSue 197: cats: 0, akitas: 10, vizslas: 0\r\nSue 198: goldfish: 1, perfumes: 3, cars: 8\r\nSue 199: akitas: 10, vizslas: 5, samoyeds: 6\r\nSue 200: pomeranians: 9, goldfish: 9, samoyeds: 7\r\nSue 201: samoyeds: 0, goldfish: 7, akitas: 6\r\nSue 202: vizslas: 0, goldfish: 2, akitas: 1\r\nSue 203: goldfish: 3, children: 0, vizslas: 8\r\nSue 204: cars: 8, trees: 2, perfumes: 2\r\nSue 205: cars: 4, perfumes: 5, goldfish: 8\r\nSue 206: vizslas: 3, trees: 2, akitas: 1\r\nSue 207: cars: 7, goldfish: 5, trees: 1\r\nSue 208: goldfish: 1, cars: 6, vizslas: 8\r\nSue 209: cats: 4, trees: 1, children: 0\r\nSue 210: cats: 10, children: 0, perfumes: 0\r\nSue 211: cars: 4, pomeranians: 7, samoyeds: 5\r\nSue 212: cars: 2, pomeranians: 10, trees: 1\r\nSue 213: trees: 10, cats: 5, cars: 10\r\nSue 214: perfumes: 5, trees: 1, vizslas: 1\r\nSue 215: akitas: 10, vizslas: 8, samoyeds: 8\r\nSue 216: vizslas: 2, cats: 5, pomeranians: 3\r\nSue 217: akitas: 10, perfumes: 0, cats: 10\r\nSue 218: trees: 8, cats: 5, vizslas: 2\r\nSue 219: goldfish: 10, perfumes: 8, children: 2\r\nSue 220: samoyeds: 9, trees: 8, vizslas: 7\r\nSue 221: children: 7, trees: 6, cars: 6\r\nSue 222: cats: 4, akitas: 5, pomeranians: 0\r\nSue 223: trees: 8, goldfish: 2, perfumes: 8\r\nSue 224: pomeranians: 9, cars: 8, akitas: 5\r\nSue 225: akitas: 10, vizslas: 0, trees: 2\r\nSue 226: akitas: 8, cats: 6, cars: 7\r\nSue 227: trees: 1, akitas: 3, goldfish: 4\r\nSue 228: pomeranians: 6, cats: 3, goldfish: 3\r\nSue 229: trees: 10, perfumes: 3, vizslas: 7\r\nSue 230: perfumes: 8, cars: 7, akitas: 0\r\nSue 231: perfumes: 10, goldfish: 4, cars: 6\r\nSue 232: goldfish: 7, trees: 3, cats: 2\r\nSue 233: perfumes: 6, trees: 4, akitas: 4\r\nSue 234: goldfish: 9, cats: 4, cars: 7\r\nSue 235: pomeranians: 6, vizslas: 0, akitas: 6\r\nSue 236: samoyeds: 5, cars: 5, children: 4\r\nSue 237: vizslas: 10, cars: 4, goldfish: 4\r\nSue 238: goldfish: 3, samoyeds: 7, akitas: 2\r\nSue 239: cats: 8, children: 2, vizslas: 7\r\nSue 240: cars: 9, perfumes: 4, trees: 9\r\nSue 241: trees: 8, vizslas: 2, goldfish: 5\r\nSue 242: cars: 6, trees: 3, vizslas: 3\r\nSue 243: cats: 6, children: 7, cars: 4\r\nSue 244: cats: 10, perfumes: 2, goldfish: 7\r\nSue 245: akitas: 8, cats: 10, perfumes: 8\r\nSue 246: vizslas: 8, akitas: 5, perfumes: 10\r\nSue 247: goldfish: 2, vizslas: 5, akitas: 7\r\nSue 248: akitas: 3, perfumes: 0, trees: 10\r\nSue 249: cats: 4, vizslas: 5, pomeranians: 6\r\nSue 250: children: 3, vizslas: 7, perfumes: 2\r\nSue 251: cars: 0, pomeranians: 10, perfumes: 0\r\nSue 252: akitas: 0, goldfish: 9, cars: 6\r\nSue 253: perfumes: 7, cars: 4, samoyeds: 5\r\nSue 254: akitas: 9, trees: 10, cars: 4\r\nSue 255: samoyeds: 10, children: 6, akitas: 7\r\nSue 256: trees: 8, goldfish: 8, perfumes: 8\r\nSue 257: goldfish: 3, akitas: 2, perfumes: 6\r\nSue 258: cats: 7, trees: 0, vizslas: 1\r\nSue 259: perfumes: 7, cars: 7, akitas: 7\r\nSue 260: goldfish: 0, vizslas: 0, samoyeds: 2\r\nSue 261: vizslas: 2, children: 2, cats: 3\r\nSue 262: vizslas: 2, pomeranians: 9, samoyeds: 3\r\nSue 263: cats: 1, akitas: 3, vizslas: 1\r\nSue 264: pomeranians: 10, trees: 2, goldfish: 7\r\nSue 265: samoyeds: 5, trees: 7, perfumes: 4\r\nSue 266: perfumes: 10, cars: 1, pomeranians: 3\r\nSue 267: trees: 6, goldfish: 1, cars: 0\r\nSue 268: cars: 6, samoyeds: 4, pomeranians: 5\r\nSue 269: goldfish: 3, vizslas: 3, akitas: 3\r\nSue 270: children: 5, cats: 0, cars: 4\r\nSue 271: goldfish: 3, perfumes: 8, pomeranians: 7\r\nSue 272: samoyeds: 6, cars: 7, perfumes: 10\r\nSue 273: trees: 4, cars: 2, vizslas: 7\r\nSue 274: samoyeds: 10, perfumes: 9, goldfish: 6\r\nSue 275: cars: 4, trees: 2, perfumes: 7\r\nSue 276: akitas: 3, perfumes: 9, cars: 9\r\nSue 277: akitas: 8, vizslas: 2, cats: 6\r\nSue 278: trees: 5, goldfish: 7, akitas: 3\r\nSue 279: perfumes: 9, cars: 8, vizslas: 2\r\nSue 280: trees: 3, vizslas: 0, children: 0\r\nSue 281: cars: 7, trees: 2, cats: 5\r\nSue 282: vizslas: 4, cars: 10, cats: 3\r\nSue 283: akitas: 10, cats: 3, samoyeds: 9\r\nSue 284: trees: 7, children: 5, goldfish: 6\r\nSue 285: cars: 2, perfumes: 5, cats: 7\r\nSue 286: samoyeds: 5, trees: 10, goldfish: 6\r\nSue 287: goldfish: 10, perfumes: 4, trees: 7\r\nSue 288: vizslas: 9, trees: 9, perfumes: 0\r\nSue 289: trees: 4, goldfish: 9, vizslas: 8\r\nSue 290: vizslas: 3, cars: 3, trees: 2\r\nSue 291: goldfish: 2, akitas: 2, trees: 2\r\nSue 292: children: 1, cars: 0, vizslas: 5\r\nSue 293: trees: 5, akitas: 4, goldfish: 6\r\nSue 294: akitas: 3, vizslas: 7, pomeranians: 5\r\nSue 295: goldfish: 10, vizslas: 3, trees: 1\r\nSue 296: cars: 2, trees: 1, akitas: 0\r\nSue 297: akitas: 10, vizslas: 6, samoyeds: 2\r\nSue 298: children: 5, trees: 1, samoyeds: 9\r\nSue 299: perfumes: 9, trees: 6, vizslas: 1\r\nSue 300: akitas: 7, pomeranians: 6, vizslas: 6\r\nSue 301: cats: 7, children: 6, vizslas: 7\r\nSue 302: trees: 2, vizslas: 7, samoyeds: 4\r\nSue 303: goldfish: 0, samoyeds: 10, cars: 4\r\nSue 304: pomeranians: 9, children: 3, vizslas: 5\r\nSue 305: akitas: 8, vizslas: 4, cars: 5\r\nSue 306: akitas: 0, perfumes: 2, pomeranians: 10\r\nSue 307: akitas: 9, cars: 0, trees: 2\r\nSue 308: vizslas: 10, goldfish: 8, akitas: 6\r\nSue 309: trees: 0, cats: 6, perfumes: 2\r\nSue 310: vizslas: 10, cars: 1, trees: 4\r\nSue 311: goldfish: 8, perfumes: 6, cats: 3\r\nSue 312: goldfish: 0, children: 1, akitas: 2\r\nSue 313: pomeranians: 10, trees: 6, samoyeds: 6\r\nSue 314: vizslas: 5, akitas: 4, pomeranians: 2\r\nSue 315: goldfish: 7, trees: 0, akitas: 5\r\nSue 316: goldfish: 4, vizslas: 5, cars: 7\r\nSue 317: perfumes: 7, cats: 10, cars: 4\r\nSue 318: samoyeds: 10, cars: 9, trees: 7\r\nSue 319: pomeranians: 8, vizslas: 6, cars: 3\r\nSue 320: cars: 4, cats: 9, akitas: 4\r\nSue 321: cars: 6, trees: 2, perfumes: 6\r\nSue 322: goldfish: 1, cats: 2, perfumes: 4\r\nSue 323: akitas: 6, cats: 5, cars: 8\r\nSue 324: cats: 4, vizslas: 9, akitas: 0\r\nSue 325: children: 8, samoyeds: 9, trees: 4\r\nSue 326: vizslas: 2, samoyeds: 10, perfumes: 7\r\nSue 327: goldfish: 7, pomeranians: 4, akitas: 10\r\nSue 328: perfumes: 8, cats: 4, akitas: 10\r\nSue 329: trees: 0, cars: 9, goldfish: 3\r\nSue 330: trees: 5, samoyeds: 7, perfumes: 8\r\nSue 331: cars: 4, perfumes: 2, goldfish: 0\r\nSue 332: vizslas: 4, pomeranians: 7, akitas: 1\r\nSue 333: akitas: 4, goldfish: 3, perfumes: 0\r\nSue 334: samoyeds: 3, akitas: 10, vizslas: 0\r\nSue 335: goldfish: 1, akitas: 7, vizslas: 6\r\nSue 336: perfumes: 1, goldfish: 1, pomeranians: 8\r\nSue 337: children: 5, cars: 4, cats: 4\r\nSue 338: vizslas: 5, cars: 10, cats: 3\r\nSue 339: trees: 2, goldfish: 3, cars: 1\r\nSue 340: trees: 10, goldfish: 6, perfumes: 2\r\nSue 341: akitas: 5, trees: 6, cats: 3\r\nSue 342: cars: 10, children: 8, goldfish: 0\r\nSue 343: cats: 2, akitas: 0, pomeranians: 4\r\nSue 344: perfumes: 1, vizslas: 3, cars: 3\r\nSue 345: samoyeds: 8, cats: 5, perfumes: 8\r\nSue 346: cars: 5, akitas: 10, trees: 2\r\nSue 347: vizslas: 9, akitas: 9, cars: 3\r\nSue 348: cars: 3, perfumes: 1, pomeranians: 9\r\nSue 349: akitas: 1, cars: 4, perfumes: 0\r\nSue 350: perfumes: 8, vizslas: 2, trees: 6\r\nSue 351: pomeranians: 5, akitas: 9, cats: 8\r\nSue 352: pomeranians: 8, vizslas: 3, goldfish: 10\r\nSue 353: trees: 2, pomeranians: 0, goldfish: 6\r\nSue 354: cats: 5, akitas: 7, goldfish: 6\r\nSue 355: goldfish: 6, children: 4, trees: 10\r\nSue 356: children: 1, trees: 3, akitas: 7\r\nSue 357: trees: 2, samoyeds: 10, goldfish: 3\r\nSue 358: samoyeds: 10, cats: 0, goldfish: 0\r\nSue 359: perfumes: 3, children: 6, pomeranians: 1\r\nSue 360: cars: 10, pomeranians: 1, samoyeds: 5\r\nSue 361: samoyeds: 9, pomeranians: 7, perfumes: 6\r\nSue 362: goldfish: 6, trees: 8, perfumes: 9\r\nSue 363: samoyeds: 10, pomeranians: 9, children: 10\r\nSue 364: perfumes: 3, goldfish: 7, cars: 9\r\nSue 365: cats: 3, children: 4, samoyeds: 8\r\nSue 366: trees: 0, cars: 10, vizslas: 10\r\nSue 367: pomeranians: 10, children: 8, perfumes: 2\r\nSue 368: cars: 5, vizslas: 0, samoyeds: 3\r\nSue 369: trees: 1, goldfish: 8, cars: 8\r\nSue 370: vizslas: 0, cars: 2, perfumes: 5\r\nSue 371: trees: 2, cars: 3, vizslas: 8\r\nSue 372: trees: 10, children: 9, cats: 1\r\nSue 373: pomeranians: 3, perfumes: 1, vizslas: 0\r\nSue 374: vizslas: 0, perfumes: 6, trees: 0\r\nSue 375: vizslas: 7, pomeranians: 1, akitas: 10\r\nSue 376: vizslas: 8, trees: 2, cars: 10\r\nSue 377: perfumes: 9, cats: 5, goldfish: 5\r\nSue 378: cats: 0, akitas: 10, perfumes: 9\r\nSue 379: cars: 4, akitas: 1, trees: 1\r\nSue 380: cars: 4, perfumes: 5, trees: 3\r\nSue 381: goldfish: 3, akitas: 5, samoyeds: 9\r\nSue 382: goldfish: 7, perfumes: 5, trees: 5\r\nSue 383: akitas: 4, cats: 6, cars: 8\r\nSue 384: children: 6, goldfish: 10, akitas: 7\r\nSue 385: akitas: 7, vizslas: 5, perfumes: 10\r\nSue 386: children: 7, vizslas: 10, akitas: 10\r\nSue 387: goldfish: 6, akitas: 7, trees: 2\r\nSue 388: vizslas: 6, trees: 1, akitas: 2\r\nSue 389: cars: 5, vizslas: 3, akitas: 7\r\nSue 390: vizslas: 4, cats: 8, perfumes: 7\r\nSue 391: akitas: 3, trees: 0, children: 2\r\nSue 392: cats: 7, cars: 3, children: 9\r\nSue 393: trees: 10, vizslas: 3, goldfish: 7\r\nSue 394: perfumes: 0, goldfish: 7, akitas: 4\r\nSue 395: cats: 6, cars: 7, vizslas: 0\r\nSue 396: vizslas: 4, perfumes: 6, goldfish: 5\r\nSue 397: pomeranians: 8, trees: 1, akitas: 9\r\nSue 398: goldfish: 7, pomeranians: 6, samoyeds: 9\r\nSue 399: perfumes: 10, cars: 1, trees: 8\r\nSue 400: trees: 0, goldfish: 9, children: 6\r\nSue 401: trees: 1, cars: 6, pomeranians: 8\r\nSue 402: perfumes: 9, cars: 0, vizslas: 10\r\nSue 403: samoyeds: 4, akitas: 1, vizslas: 9\r\nSue 404: perfumes: 0, trees: 2, cars: 4\r\nSue 405: akitas: 0, perfumes: 5, samoyeds: 4\r\nSue 406: akitas: 8, vizslas: 6, children: 2\r\nSue 407: children: 1, trees: 8, goldfish: 10\r\nSue 408: pomeranians: 4, trees: 10, cars: 9\r\nSue 409: perfumes: 5, vizslas: 5, akitas: 4\r\nSue 410: trees: 1, akitas: 10, vizslas: 6\r\nSue 411: samoyeds: 0, goldfish: 9, perfumes: 7\r\nSue 412: goldfish: 7, samoyeds: 10, trees: 1\r\nSue 413: samoyeds: 0, pomeranians: 10, vizslas: 6\r\nSue 414: children: 2, cars: 10, samoyeds: 2\r\nSue 415: trees: 2, goldfish: 8, cars: 0\r\nSue 416: samoyeds: 4, goldfish: 9, trees: 2\r\nSue 417: trees: 8, akitas: 10, perfumes: 3\r\nSue 418: samoyeds: 9, goldfish: 2, cars: 1\r\nSue 419: akitas: 2, perfumes: 8, trees: 2\r\nSue 420: children: 3, goldfish: 6, perfumes: 5\r\nSue 421: akitas: 8, perfumes: 2, samoyeds: 6\r\nSue 422: vizslas: 10, akitas: 4, pomeranians: 3\r\nSue 423: cats: 8, perfumes: 3, trees: 4\r\nSue 424: cars: 2, children: 4, pomeranians: 8\r\nSue 425: pomeranians: 4, samoyeds: 2, goldfish: 4\r\nSue 426: perfumes: 6, cars: 4, goldfish: 4\r\nSue 427: akitas: 0, goldfish: 7, perfumes: 5\r\nSue 428: perfumes: 4, cars: 3, akitas: 5\r\nSue 429: trees: 0, vizslas: 0, goldfish: 1\r\nSue 430: perfumes: 4, vizslas: 2, cars: 7\r\nSue 431: goldfish: 7, pomeranians: 8, trees: 0\r\nSue 432: goldfish: 7, children: 9, trees: 3\r\nSue 433: akitas: 1, vizslas: 10, trees: 2\r\nSue 434: perfumes: 2, cars: 4, goldfish: 10\r\nSue 435: pomeranians: 6, vizslas: 9, trees: 1\r\nSue 436: cars: 9, trees: 0, goldfish: 0\r\nSue 437: trees: 1, goldfish: 1, vizslas: 8\r\nSue 438: goldfish: 7, samoyeds: 8, children: 2\r\nSue 439: children: 1, cats: 7, vizslas: 8\r\nSue 440: cats: 2, pomeranians: 6, goldfish: 4\r\nSue 441: perfumes: 7, cats: 3, vizslas: 6\r\nSue 442: akitas: 4, samoyeds: 5, cars: 2\r\nSue 443: akitas: 3, perfumes: 3, cats: 9\r\nSue 444: perfumes: 10, akitas: 6, trees: 0\r\nSue 445: cars: 5, children: 9, perfumes: 8\r\nSue 446: vizslas: 10, cars: 3, perfumes: 5\r\nSue 447: children: 9, perfumes: 1, cars: 10\r\nSue 448: akitas: 0, goldfish: 8, trees: 3\r\nSue 449: cars: 7, akitas: 8, children: 3\r\nSue 450: cars: 4, akitas: 9, cats: 0\r\nSue 451: perfumes: 4, samoyeds: 5, goldfish: 6\r\nSue 452: perfumes: 10, akitas: 1, cars: 7\r\nSue 453: trees: 1, goldfish: 3, vizslas: 6\r\nSue 454: goldfish: 8, pomeranians: 6, trees: 10\r\nSue 455: akitas: 5, vizslas: 8, goldfish: 10\r\nSue 456: cats: 5, trees: 4, samoyeds: 0\r\nSue 457: perfumes: 8, cars: 0, cats: 3\r\nSue 458: akitas: 1, trees: 10, vizslas: 2\r\nSue 459: vizslas: 6, akitas: 3, children: 10\r\nSue 460: perfumes: 7, trees: 9, goldfish: 8\r\nSue 461: children: 6, vizslas: 4, perfumes: 5\r\nSue 462: vizslas: 6, akitas: 8, perfumes: 9\r\nSue 463: goldfish: 8, cars: 4, trees: 10\r\nSue 464: pomeranians: 8, cars: 5, vizslas: 0\r\nSue 465: cats: 10, goldfish: 7, akitas: 1\r\nSue 466: cats: 2, children: 1, cars: 6\r\nSue 467: perfumes: 3, samoyeds: 6, cars: 0\r\nSue 468: samoyeds: 10, pomeranians: 6, trees: 2\r\nSue 469: children: 2, perfumes: 2, pomeranians: 4\r\nSue 470: cats: 1, perfumes: 5, vizslas: 9\r\nSue 471: vizslas: 5, perfumes: 2, akitas: 7\r\nSue 472: samoyeds: 8, goldfish: 6, cats: 1\r\nSue 473: goldfish: 10, perfumes: 9, cars: 4\r\nSue 474: samoyeds: 0, cars: 4, vizslas: 4\r\nSue 475: trees: 2, cars: 7, akitas: 8\r\nSue 476: vizslas: 3, perfumes: 5, goldfish: 1\r\nSue 477: cats: 7, cars: 4, trees: 1\r\nSue 478: vizslas: 8, akitas: 3, goldfish: 0\r\nSue 479: cars: 6, cats: 3, perfumes: 2\r\nSue 480: goldfish: 1, children: 9, vizslas: 3\r\nSue 481: pomeranians: 5, vizslas: 1, cars: 10\r\nSue 482: children: 5, perfumes: 5, cats: 1\r\nSue 483: perfumes: 2, goldfish: 7, trees: 6\r\nSue 484: akitas: 2, goldfish: 4, perfumes: 10\r\nSue 485: samoyeds: 3, goldfish: 0, akitas: 1\r\nSue 486: trees: 8, vizslas: 9, goldfish: 0\r\nSue 487: goldfish: 8, samoyeds: 0, trees: 0\r\nSue 488: perfumes: 7, cars: 5, trees: 0\r\nSue 489: vizslas: 3, pomeranians: 2, perfumes: 5\r\nSue 490: cars: 5, perfumes: 5, akitas: 5\r\nSue 491: children: 8, trees: 1, pomeranians: 4\r\nSue 492: pomeranians: 0, akitas: 1, vizslas: 8\r\nSue 493: akitas: 10, perfumes: 10, samoyeds: 8\r\nSue 494: perfumes: 6, vizslas: 4, cats: 6\r\nSue 495: children: 6, pomeranians: 5, samoyeds: 4\r\nSue 496: vizslas: 1, trees: 5, akitas: 1\r\nSue 497: vizslas: 10, perfumes: 10, pomeranians: 3\r\nSue 498: samoyeds: 3, trees: 2, cars: 5\r\nSue 499: cats: 6, children: 3, perfumes: 0\r\nSue 500: pomeranians: 10, cats: 3, vizslas: 5");
        assert result == 260;
        System.out.println(result);
    }

    public static int test(String s) {
        Sue sue0 = new Sue();
        sue0.children = 3;
        sue0.cats = 7;
        sue0.samoyeds = 2;
        sue0.pomeranians = 3;
        sue0.akitas = 0;
        sue0.vizslas = 0;
        sue0.goldfish = 5;
        sue0.trees = 3;
        sue0.cars = 2;
        sue0.perfumes = 1;

        List<Sue> sues = new ArrayList<>();
        String[] parts = s.split("\r\n");
        for (String part : parts) {
            Pattern p = Pattern.compile("Sue (\\d+): (.*)");
            Matcher m = p.matcher(part);
            if (m.matches()) {
                int num = Integer.parseInt(m.group(1));
                Sue sue = new Sue();
                sue.num = num;
                String tail = m.group(2);
                String[] tokens = tail.split(", ");
                for (int i = 0; i < tokens.length; ++i) {
                    String[] compound = tokens[i].split(": ");
                    sue.addCompound(compound[0], Integer.parseInt(compound[1]));
                }
                sue.compare(sue0);
                sues.add(sue);
            }
        }

        Collections.sort(sues, new Comparator<Sue>() {
            @Override
            public int compare(Sue o1, Sue o2) {
                return Integer.compare(o1.score, o2.score);
            }
        });
        return sues.get(sues.size() - 1).num;
    }

    static class Sue {
        Integer num;
        Integer children;
        Integer cats;
        Integer samoyeds;
        Integer pomeranians;
        Integer akitas;
        Integer vizslas;
        Integer goldfish;
        Integer trees;
        Integer cars;
        Integer perfumes;
        int score;

        void addCompound(String compound, int value) {
            if (compound.equals("children")) {
                children = Integer.valueOf(value);
            } else if (compound.equals("cats")) {
                cats = Integer.valueOf(value);
            } else if (compound.equals("samoyeds")) {
                samoyeds = Integer.valueOf(value);
            } else if (compound.equals("pomeranians")) {
                pomeranians = Integer.valueOf(value);
            } else if (compound.equals("akitas")) {
                akitas = Integer.valueOf(value);
            } else if (compound.equals("vizslas")) {
                vizslas = Integer.valueOf(value);
            } else if (compound.equals("goldfish")) {
                goldfish = Integer.valueOf(value);
            } else if (compound.equals("trees")) {
                trees = Integer.valueOf(value);
            } else if (compound.equals("cars")) {
                cars = Integer.valueOf(value);
            } else if (compound.equals("perfumes")) {
                perfumes = Integer.valueOf(value);
            }
        }

        void compare(Sue other) {
            score = 0;
            if (children != null && children == other.children) {
                ++score;
            }
            if (cats != null && cats > other.cats) {
                ++score;
            }
            if (samoyeds != null && samoyeds == other.samoyeds) {
                ++score;
            }
            if (pomeranians != null && pomeranians < other.pomeranians) {
                ++score;
            }
            if (akitas != null && akitas == other.akitas) {
                ++score;
            }
            if (vizslas != null && vizslas == other.vizslas) {
                ++score;
            }
            if (goldfish != null && goldfish < other.goldfish) {
                ++score;
            }
            if (trees != null && trees > other.trees) {
                ++score;
            }
            if (cars != null && cars == other.cars) {
                ++score;
            }
            if (perfumes != null && perfumes == other.perfumes) {
                ++score;
            }
        }

        @Override
        public String toString() {
            return String.valueOf(score);
        }

        void print() {
            System.out.println("num = " + num);
            System.out.println("\tchildren = " + children);
            System.out.println("\tcats = " + cats);
            System.out.println("\tsamoyeds = " + samoyeds);
            System.out.println("\tpomeranians = " + pomeranians);
            System.out.println("\takitas = " + akitas);
            System.out.println("\tvizslas = " + vizslas);
            System.out.println("\tgoldfish = " + goldfish);
            System.out.println("\ttrees = " + trees);
            System.out.println("\tcars = " + cars);
            System.out.println("\tperfumes = " + perfumes);
        }
    }
}