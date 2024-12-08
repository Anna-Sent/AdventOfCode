package advent.advent2022

import utils.Point
import kotlin.math.max
import kotlin.math.min

private var result = 0

fun main() {
    result = test("""
        498,4 -> 498,6 -> 496,6
        503,4 -> 502,4 -> 502,9 -> 494,9
    """.trimIndent())
    check(24, result)

    result = test("""
        521,171 -> 525,171
        497,147 -> 497,137 -> 497,147 -> 499,147 -> 499,146 -> 499,147 -> 501,147 -> 501,142 -> 501,147 -> 503,147 -> 503,144 -> 503,147 -> 505,147 -> 505,140 -> 505,147
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        476,63 -> 476,58 -> 476,63 -> 478,63 -> 478,55 -> 478,63 -> 480,63 -> 480,56 -> 480,63 -> 482,63 -> 482,57 -> 482,63 -> 484,63 -> 484,55 -> 484,63 -> 486,63 -> 486,55 -> 486,63
        503,109 -> 507,109
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        503,150 -> 503,154 -> 501,154 -> 501,162 -> 513,162 -> 513,154 -> 507,154 -> 507,150
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        503,150 -> 503,154 -> 501,154 -> 501,162 -> 513,162 -> 513,154 -> 507,154 -> 507,150
        481,79 -> 481,81 -> 478,81 -> 478,89 -> 490,89 -> 490,81 -> 485,81 -> 485,79
        488,38 -> 493,38
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        476,63 -> 476,58 -> 476,63 -> 478,63 -> 478,55 -> 478,63 -> 480,63 -> 480,56 -> 480,63 -> 482,63 -> 482,57 -> 482,63 -> 484,63 -> 484,55 -> 484,63 -> 486,63 -> 486,55 -> 486,63
        482,93 -> 496,93 -> 496,92
        476,63 -> 476,58 -> 476,63 -> 478,63 -> 478,55 -> 478,63 -> 480,63 -> 480,56 -> 480,63 -> 482,63 -> 482,57 -> 482,63 -> 484,63 -> 484,55 -> 484,63 -> 486,63 -> 486,55 -> 486,63
        497,29 -> 502,29
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        497,147 -> 497,137 -> 497,147 -> 499,147 -> 499,146 -> 499,147 -> 501,147 -> 501,142 -> 501,147 -> 503,147 -> 503,144 -> 503,147 -> 505,147 -> 505,140 -> 505,147
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        501,32 -> 506,32
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        490,16 -> 490,20 -> 484,20 -> 484,26 -> 499,26 -> 499,20 -> 494,20 -> 494,16
        503,115 -> 507,115
        524,173 -> 528,173
        481,79 -> 481,81 -> 478,81 -> 478,89 -> 490,89 -> 490,81 -> 485,81 -> 485,79
        486,47 -> 490,47
        497,147 -> 497,137 -> 497,147 -> 499,147 -> 499,146 -> 499,147 -> 501,147 -> 501,142 -> 501,147 -> 503,147 -> 503,144 -> 503,147 -> 505,147 -> 505,140 -> 505,147
        476,63 -> 476,58 -> 476,63 -> 478,63 -> 478,55 -> 478,63 -> 480,63 -> 480,56 -> 480,63 -> 482,63 -> 482,57 -> 482,63 -> 484,63 -> 484,55 -> 484,63 -> 486,63 -> 486,55 -> 486,63
        490,16 -> 490,20 -> 484,20 -> 484,26 -> 499,26 -> 499,20 -> 494,20 -> 494,16
        476,63 -> 476,58 -> 476,63 -> 478,63 -> 478,55 -> 478,63 -> 480,63 -> 480,56 -> 480,63 -> 482,63 -> 482,57 -> 482,63 -> 484,63 -> 484,55 -> 484,63 -> 486,63 -> 486,55 -> 486,63
        495,50 -> 499,50
        492,41 -> 496,41
        476,63 -> 476,58 -> 476,63 -> 478,63 -> 478,55 -> 478,63 -> 480,63 -> 480,56 -> 480,63 -> 482,63 -> 482,57 -> 482,63 -> 484,63 -> 484,55 -> 484,63 -> 486,63 -> 486,55 -> 486,63
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        497,147 -> 497,137 -> 497,147 -> 499,147 -> 499,146 -> 499,147 -> 501,147 -> 501,142 -> 501,147 -> 503,147 -> 503,144 -> 503,147 -> 505,147 -> 505,140 -> 505,147
        522,177 -> 522,178 -> 536,178 -> 536,177
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        503,121 -> 507,121
        503,150 -> 503,154 -> 501,154 -> 501,162 -> 513,162 -> 513,154 -> 507,154 -> 507,150
        515,121 -> 519,121
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        476,63 -> 476,58 -> 476,63 -> 478,63 -> 478,55 -> 478,63 -> 480,63 -> 480,56 -> 480,63 -> 482,63 -> 482,57 -> 482,63 -> 484,63 -> 484,55 -> 484,63 -> 486,63 -> 486,55 -> 486,63
        498,35 -> 503,35
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        503,171 -> 507,171
        509,121 -> 513,121
        494,12 -> 494,13 -> 507,13 -> 507,12
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        500,112 -> 504,112
        488,124 -> 488,126 -> 485,126 -> 485,129 -> 496,129 -> 496,126 -> 491,126 -> 491,124
        476,63 -> 476,58 -> 476,63 -> 478,63 -> 478,55 -> 478,63 -> 480,63 -> 480,56 -> 480,63 -> 482,63 -> 482,57 -> 482,63 -> 484,63 -> 484,55 -> 484,63 -> 486,63 -> 486,55 -> 486,63
        488,124 -> 488,126 -> 485,126 -> 485,129 -> 496,129 -> 496,126 -> 491,126 -> 491,124
        476,63 -> 476,58 -> 476,63 -> 478,63 -> 478,55 -> 478,63 -> 480,63 -> 480,56 -> 480,63 -> 482,63 -> 482,57 -> 482,63 -> 484,63 -> 484,55 -> 484,63 -> 486,63 -> 486,55 -> 486,63
        512,173 -> 516,173
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        502,38 -> 507,38
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        503,150 -> 503,154 -> 501,154 -> 501,162 -> 513,162 -> 513,154 -> 507,154 -> 507,150
        497,147 -> 497,137 -> 497,147 -> 499,147 -> 499,146 -> 499,147 -> 501,147 -> 501,142 -> 501,147 -> 503,147 -> 503,144 -> 503,147 -> 505,147 -> 505,140 -> 505,147
        497,147 -> 497,137 -> 497,147 -> 499,147 -> 499,146 -> 499,147 -> 501,147 -> 501,142 -> 501,147 -> 503,147 -> 503,144 -> 503,147 -> 505,147 -> 505,140 -> 505,147
        506,169 -> 510,169
        490,16 -> 490,20 -> 484,20 -> 484,26 -> 499,26 -> 499,20 -> 494,20 -> 494,16
        497,147 -> 497,137 -> 497,147 -> 499,147 -> 499,146 -> 499,147 -> 501,147 -> 501,142 -> 501,147 -> 503,147 -> 503,144 -> 503,147 -> 505,147 -> 505,140 -> 505,147
        503,150 -> 503,154 -> 501,154 -> 501,162 -> 513,162 -> 513,154 -> 507,154 -> 507,150
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        488,124 -> 488,126 -> 485,126 -> 485,129 -> 496,129 -> 496,126 -> 491,126 -> 491,124
        491,121 -> 495,121
        497,147 -> 497,137 -> 497,147 -> 499,147 -> 499,146 -> 499,147 -> 501,147 -> 501,142 -> 501,147 -> 503,147 -> 503,144 -> 503,147 -> 505,147 -> 505,140 -> 505,147
        518,173 -> 522,173
        501,50 -> 505,50
        497,115 -> 501,115
        498,47 -> 502,47
        476,63 -> 476,58 -> 476,63 -> 478,63 -> 478,55 -> 478,63 -> 480,63 -> 480,56 -> 480,63 -> 482,63 -> 482,57 -> 482,63 -> 484,63 -> 484,55 -> 484,63 -> 486,63 -> 486,55 -> 486,63
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        518,169 -> 522,169
        476,63 -> 476,58 -> 476,63 -> 478,63 -> 478,55 -> 478,63 -> 480,63 -> 480,56 -> 480,63 -> 482,63 -> 482,57 -> 482,63 -> 484,63 -> 484,55 -> 484,63 -> 486,63 -> 486,55 -> 486,63
        489,44 -> 493,44
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        481,79 -> 481,81 -> 478,81 -> 478,89 -> 490,89 -> 490,81 -> 485,81 -> 485,79
        509,167 -> 513,167
        476,63 -> 476,58 -> 476,63 -> 478,63 -> 478,55 -> 478,63 -> 480,63 -> 480,56 -> 480,63 -> 482,63 -> 482,57 -> 482,63 -> 484,63 -> 484,55 -> 484,63 -> 486,63 -> 486,55 -> 486,63
        487,133 -> 487,134 -> 501,134
        481,79 -> 481,81 -> 478,81 -> 478,89 -> 490,89 -> 490,81 -> 485,81 -> 485,79
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        512,118 -> 516,118
        490,16 -> 490,20 -> 484,20 -> 484,26 -> 499,26 -> 499,20 -> 494,20 -> 494,16
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        512,165 -> 516,165
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        491,35 -> 496,35
        500,173 -> 504,173
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        490,16 -> 490,20 -> 484,20 -> 484,26 -> 499,26 -> 499,20 -> 494,20 -> 494,16
        503,150 -> 503,154 -> 501,154 -> 501,162 -> 513,162 -> 513,154 -> 507,154 -> 507,150
        483,50 -> 487,50
        481,79 -> 481,81 -> 478,81 -> 478,89 -> 490,89 -> 490,81 -> 485,81 -> 485,79
        500,118 -> 504,118
        497,147 -> 497,137 -> 497,147 -> 499,147 -> 499,146 -> 499,147 -> 501,147 -> 501,142 -> 501,147 -> 503,147 -> 503,144 -> 503,147 -> 505,147 -> 505,140 -> 505,147
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        492,47 -> 496,47
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        497,147 -> 497,137 -> 497,147 -> 499,147 -> 499,146 -> 499,147 -> 501,147 -> 501,142 -> 501,147 -> 503,147 -> 503,144 -> 503,147 -> 505,147 -> 505,140 -> 505,147
        476,63 -> 476,58 -> 476,63 -> 478,63 -> 478,55 -> 478,63 -> 480,63 -> 480,56 -> 480,63 -> 482,63 -> 482,57 -> 482,63 -> 484,63 -> 484,55 -> 484,63 -> 486,63 -> 486,55 -> 486,63
        495,38 -> 500,38
        494,12 -> 494,13 -> 507,13 -> 507,12
        476,63 -> 476,58 -> 476,63 -> 478,63 -> 478,55 -> 478,63 -> 480,63 -> 480,56 -> 480,63 -> 482,63 -> 482,57 -> 482,63 -> 484,63 -> 484,55 -> 484,63 -> 486,63 -> 486,55 -> 486,63
        497,147 -> 497,137 -> 497,147 -> 499,147 -> 499,146 -> 499,147 -> 501,147 -> 501,142 -> 501,147 -> 503,147 -> 503,144 -> 503,147 -> 505,147 -> 505,140 -> 505,147
        494,118 -> 498,118
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        488,124 -> 488,126 -> 485,126 -> 485,129 -> 496,129 -> 496,126 -> 491,126 -> 491,124
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        497,147 -> 497,137 -> 497,147 -> 499,147 -> 499,146 -> 499,147 -> 501,147 -> 501,142 -> 501,147 -> 503,147 -> 503,144 -> 503,147 -> 505,147 -> 505,140 -> 505,147
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        488,124 -> 488,126 -> 485,126 -> 485,129 -> 496,129 -> 496,126 -> 491,126 -> 491,124
        509,115 -> 513,115
        497,147 -> 497,137 -> 497,147 -> 499,147 -> 499,146 -> 499,147 -> 501,147 -> 501,142 -> 501,147 -> 503,147 -> 503,144 -> 503,147 -> 505,147 -> 505,140 -> 505,147
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        506,173 -> 510,173
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        481,79 -> 481,81 -> 478,81 -> 478,89 -> 490,89 -> 490,81 -> 485,81 -> 485,79
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        505,35 -> 510,35
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        506,118 -> 510,118
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        503,150 -> 503,154 -> 501,154 -> 501,162 -> 513,162 -> 513,154 -> 507,154 -> 507,150
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        509,171 -> 513,171
        494,12 -> 494,13 -> 507,13 -> 507,12
        509,38 -> 514,38
        488,124 -> 488,126 -> 485,126 -> 485,129 -> 496,129 -> 496,126 -> 491,126 -> 491,124
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        476,63 -> 476,58 -> 476,63 -> 478,63 -> 478,55 -> 478,63 -> 480,63 -> 480,56 -> 480,63 -> 482,63 -> 482,57 -> 482,63 -> 484,63 -> 484,55 -> 484,63 -> 486,63 -> 486,55 -> 486,63
        495,44 -> 499,44
        482,93 -> 496,93 -> 496,92
        515,171 -> 519,171
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        481,79 -> 481,81 -> 478,81 -> 478,89 -> 490,89 -> 490,81 -> 485,81 -> 485,79
        522,177 -> 522,178 -> 536,178 -> 536,177
        476,63 -> 476,58 -> 476,63 -> 478,63 -> 478,55 -> 478,63 -> 480,63 -> 480,56 -> 480,63 -> 482,63 -> 482,57 -> 482,63 -> 484,63 -> 484,55 -> 484,63 -> 486,63 -> 486,55 -> 486,63
        497,147 -> 497,137 -> 497,147 -> 499,147 -> 499,146 -> 499,147 -> 501,147 -> 501,142 -> 501,147 -> 503,147 -> 503,144 -> 503,147 -> 505,147 -> 505,140 -> 505,147
        515,167 -> 519,167
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        506,112 -> 510,112
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        522,177 -> 522,178 -> 536,178 -> 536,177
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        488,124 -> 488,126 -> 485,126 -> 485,129 -> 496,129 -> 496,126 -> 491,126 -> 491,124
        487,133 -> 487,134 -> 501,134
        497,121 -> 501,121
        476,63 -> 476,58 -> 476,63 -> 478,63 -> 478,55 -> 478,63 -> 480,63 -> 480,56 -> 480,63 -> 482,63 -> 482,57 -> 482,63 -> 484,63 -> 484,55 -> 484,63 -> 486,63 -> 486,55 -> 486,63
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
        489,50 -> 493,50
        465,76 -> 465,71 -> 465,76 -> 467,76 -> 467,72 -> 467,76 -> 469,76 -> 469,68 -> 469,76 -> 471,76 -> 471,73 -> 471,76 -> 473,76 -> 473,71 -> 473,76 -> 475,76 -> 475,70 -> 475,76 -> 477,76 -> 477,71 -> 477,76 -> 479,76 -> 479,73 -> 479,76 -> 481,76 -> 481,74 -> 481,76 -> 483,76 -> 483,72 -> 483,76
        512,169 -> 516,169
        490,16 -> 490,20 -> 484,20 -> 484,26 -> 499,26 -> 499,20 -> 494,20 -> 494,16
        494,32 -> 499,32
        490,16 -> 490,20 -> 484,20 -> 484,26 -> 499,26 -> 499,20 -> 494,20 -> 494,16
        488,106 -> 488,97 -> 488,106 -> 490,106 -> 490,100 -> 490,106 -> 492,106 -> 492,101 -> 492,106 -> 494,106 -> 494,105 -> 494,106 -> 496,106 -> 496,96 -> 496,106 -> 498,106 -> 498,102 -> 498,106 -> 500,106 -> 500,101 -> 500,106 -> 502,106 -> 502,102 -> 502,106 -> 504,106 -> 504,100 -> 504,106
    """.trimIndent())
    check(913, result)
}

private fun test(input: String): Int {
    val rocks = mutableSetOf<Point>()
    val sand = mutableSetOf<Point>()
    val allPoints = mutableSetOf<Point>()

    for (line in input.split("\n")) {
        val points = line.split(" -> ").map { s1 ->
            val (x, y) = s1.split(",").map { s2 -> s2.toInt() }
            Point(x, y)
        }
        var from = points[0]
        for (to in points.subList(1, points.size)) {

            if (from.x == to.x) {
                for (y in min(from.y, to.y)..max(from.y, to.y)) {
                    rocks += Point(from.x, y)
                }
            } else if (from.y == to.y) {
                for (x in min(from.x, to.x)..max(from.x, to.x)) {
                    rocks += Point(x, from.y)
                }
            } else {
                throw IllegalStateException("neither x nor y")
            }

            from = to
        }
    }

    allPoints += rocks
    val floorY = rocks.maxBy { it.y }!!.y

    fun printAllPoints() {
        val minX = allPoints.minBy { it.x }!!.x
        val minY = allPoints.minBy { it.y }!!.y
        val maxX = allPoints.maxBy { it.x }!!.x
        val maxY = allPoints.maxBy { it.y }!!.y

        for (y in minY..maxY) {
            for (x in minX..maxX) {
                when (Point(x, y)) {
                    in rocks -> print("#")
                    in sand -> print("o")
                    else -> print(".")
                }
            }
            println()
        }
        println()
    }

    fun moveDownIfPossible(start: Point): Point? {
        val next = Point(start.x, start.y + 1)
        return if (next in allPoints) null else next
    }

    fun moveDownLeftIfPossible(start: Point): Point? {
        val next = Point(start.x - 1, start.y + 1)
        return if (next in allPoints) null else next
    }

    fun moveDownRightIfPossible(start: Point): Point? {
        val next = Point(start.x + 1, start.y + 1)
        return if (next in allPoints) null else next
    }

    fun moveIfPossible(start: Point): Point? {
        var next = moveDownIfPossible(start)
        if (next == null) {
            next = moveDownLeftIfPossible(start)
            if (next == null) {
                next = moveDownRightIfPossible(start)
            }
        }
        return next
    }

    val source = Point(500, 0)
    var count = 0
    while (true) {
        var next: Point? = source
        var prev: Point? = source

        var finish = false

        while (next != null && !finish) {
            prev = next
            next = moveIfPossible(next!!)

            if (next != null && next!!.y > floorY) {
                finish = true
            }
        }

        if (finish) break

        sand += prev!!
        allPoints += prev!!

        ++count
        println("count $count ${sand.size}")
        printAllPoints()
    }

    println("count $count ${sand.size}")
    printAllPoints()
    return sand.size
}