package advent.advent2023

import utils.Point
import utils.plus

private var result = 0L

fun main() {
    result = test(
        """
            R 6 (#70c710)
            D 5 (#0dc571)
            L 2 (#5713f0)
            D 2 (#d2c081)
            R 2 (#59c680)
            D 2 (#411b91)
            L 5 (#8ceee2)
            U 2 (#caa173)
            L 1 (#1b58a2)
            U 2 (#caa171)
            R 2 (#7807d2)
            U 3 (#a77fa3)
            L 2 (#015232)
            U 2 (#7a21e3)
    """.trimIndent()
    )
    check(952408144115, result)

    result = test(
        """
            R 5 (#58a492)
            U 5 (#630fe3)
            L 3 (#7087b2)
            U 5 (#5f3ee1)
            L 3 (#313202)
            U 5 (#03d101)
            L 10 (#7c5562)
            U 4 (#404f43)
            L 3 (#412982)
            U 7 (#79c1c3)
            L 6 (#12d412)
            U 4 (#083683)
            L 4 (#775942)
            U 6 (#030323)
            L 6 (#0c9622)
            U 8 (#6cdc33)
            L 6 (#03d682)
            U 2 (#0e9c53)
            L 5 (#493272)
            U 2 (#03d643)
            L 2 (#3305b2)
            U 9 (#244203)
            L 6 (#6c6a70)
            U 4 (#341f73)
            L 8 (#28bb00)
            U 3 (#74c533)
            R 4 (#3cfdb0)
            U 3 (#3fd773)
            R 3 (#52a350)
            U 9 (#3c2073)
            R 3 (#316de0)
            U 6 (#3c4213)
            R 6 (#0b7720)
            U 5 (#3734e3)
            R 2 (#929370)
            U 7 (#372c31)
            R 7 (#503d70)
            U 7 (#27d791)
            R 5 (#4cac80)
            U 6 (#24f401)
            R 3 (#4c95a0)
            U 6 (#43bb01)
            R 5 (#2ff3b2)
            U 4 (#2fb481)
            R 2 (#7c5eb2)
            U 2 (#141aa1)
            R 9 (#1259d2)
            U 4 (#4e9531)
            R 4 (#2ad362)
            U 3 (#27d1b1)
            R 9 (#149920)
            U 3 (#0b0163)
            R 4 (#65fc30)
            U 4 (#5f54e3)
            R 3 (#473e00)
            U 4 (#0d0da3)
            R 8 (#327d60)
            U 3 (#187fc3)
            L 8 (#66f6c0)
            U 3 (#6981f3)
            L 3 (#42b9d0)
            U 4 (#6f32f3)
            L 3 (#42b9d2)
            U 7 (#16b7a3)
            L 5 (#66f6c2)
            D 7 (#0298a3)
            L 8 (#29c4a0)
            D 2 (#4f2473)
            L 4 (#266862)
            D 10 (#436fd1)
            L 4 (#3482b2)
            U 5 (#30fad3)
            L 4 (#6ac712)
            U 6 (#30fad1)
            L 2 (#4ee392)
            U 4 (#436fd3)
            R 6 (#59ff52)
            U 4 (#73a323)
            L 4 (#20ba82)
            U 8 (#5e5873)
            L 4 (#578df2)
            D 7 (#47e4f3)
            L 2 (#6a4792)
            D 8 (#2a00b3)
            L 6 (#854930)
            U 8 (#594903)
            L 3 (#854932)
            D 3 (#53db83)
            L 2 (#19e4f0)
            D 8 (#7c7af3)
            L 5 (#5062a0)
            U 4 (#2d3db3)
            L 3 (#2fe132)
            U 7 (#7059f3)
            L 3 (#4cc5b2)
            U 5 (#2a28a1)
            R 3 (#6d89e2)
            U 3 (#4398a1)
            R 3 (#09b672)
            U 11 (#4a32e1)
            R 3 (#0d6002)
            D 10 (#3ece11)
            R 2 (#81a642)
            D 4 (#096ba1)
            R 5 (#31df02)
            U 8 (#7ccf71)
            R 5 (#6239a2)
            U 7 (#6584c1)
            R 6 (#6c1fe0)
            U 4 (#1e1b01)
            L 3 (#5fbee0)
            U 2 (#5bfc41)
            L 12 (#49e020)
            U 4 (#48a6d1)
            R 8 (#6814a2)
            U 2 (#226a71)
            R 7 (#6814a0)
            U 4 (#436dc1)
            R 5 (#2a2f92)
            D 4 (#28eaf3)
            R 9 (#25ab52)
            D 3 (#22bd81)
            R 2 (#83aa92)
            D 3 (#22bd83)
            L 5 (#159182)
            D 2 (#0387c3)
            L 6 (#3599c2)
            D 4 (#4e6413)
            R 5 (#48f562)
            D 7 (#564e23)
            R 6 (#46fbf2)
            U 6 (#1e12d3)
            R 4 (#0bd062)
            U 5 (#1ffbb3)
            R 3 (#5fbb82)
            U 3 (#2d0803)
            R 6 (#101d70)
            U 8 (#11b903)
            R 6 (#9af6c0)
            D 6 (#11b901)
            R 9 (#1b70a0)
            U 6 (#479173)
            R 7 (#15cc02)
            D 2 (#0aa953)
            R 9 (#858072)
            D 3 (#3e60f3)
            R 3 (#2b3862)
            D 3 (#1f4af3)
            R 7 (#40b892)
            D 3 (#4f9151)
            R 3 (#343292)
            D 5 (#0ec741)
            R 6 (#549592)
            D 3 (#7e9611)
            R 5 (#0215c2)
            D 6 (#57bdb3)
            R 3 (#6964c2)
            D 6 (#38c523)
            R 4 (#172242)
            D 2 (#80a643)
            R 8 (#21dee0)
            D 2 (#1a89e3)
            R 8 (#5ea820)
            D 2 (#2baab3)
            R 4 (#6d2bb0)
            D 5 (#4bfb93)
            L 10 (#1f13e0)
            D 5 (#4fa9d3)
            R 10 (#8c3f92)
            D 5 (#014b33)
            R 4 (#0786d2)
            D 5 (#713641)
            R 5 (#30eb92)
            D 5 (#4591f3)
            R 4 (#44fef2)
            U 3 (#4591f1)
            R 2 (#5636e2)
            U 9 (#0cfbb1)
            L 5 (#2ded32)
            U 4 (#06c881)
            L 3 (#5c8ab0)
            U 7 (#5ba411)
            R 8 (#362110)
            U 5 (#023861)
            R 3 (#92abc2)
            D 6 (#423051)
            R 5 (#3bdda2)
            D 4 (#59ab71)
            R 2 (#103492)
            D 4 (#1bc8b1)
            R 5 (#739582)
            D 5 (#4591d1)
            R 3 (#03a662)
            U 12 (#0934f1)
            R 4 (#2a4662)
            D 5 (#2b07d1)
            R 3 (#49fd52)
            D 7 (#6b8561)
            R 3 (#18d152)
            D 3 (#573fa1)
            L 3 (#57c6b2)
            D 2 (#664a03)
            L 10 (#190712)
            D 4 (#34c2b3)
            R 3 (#21f322)
            D 3 (#25dc13)
            R 3 (#4be7d2)
            D 11 (#469a13)
            L 4 (#437350)
            D 8 (#1a9503)
            R 4 (#456d20)
            D 4 (#49d533)
            R 4 (#88e072)
            U 3 (#250333)
            R 8 (#4be7d0)
            U 3 (#16f773)
            R 3 (#8c07b2)
            U 5 (#53ad91)
            R 3 (#54b682)
            U 3 (#3b3621)
            R 3 (#54b680)
            U 3 (#5bb551)
            R 5 (#05def2)
            U 5 (#2241f1)
            R 4 (#7a0222)
            U 2 (#0e6b23)
            R 3 (#4b2592)
            U 5 (#936c13)
            R 2 (#48da12)
            U 7 (#727bb3)
            L 5 (#072a52)
            U 2 (#5c9f13)
            L 3 (#4592b0)
            U 4 (#3eb493)
            L 3 (#9828d0)
            U 7 (#3eb491)
            L 4 (#108bb0)
            U 2 (#88ff83)
            L 3 (#043dd0)
            U 2 (#88ff81)
            L 5 (#3ccdf0)
            U 3 (#29f651)
            L 5 (#3b58f0)
            U 9 (#1dfe43)
            L 3 (#3707e0)
            U 7 (#1dfe41)
            L 5 (#335470)
            U 2 (#29f653)
            L 3 (#0d04b0)
            U 3 (#045723)
            R 2 (#3df010)
            U 6 (#1eaaa3)
            R 6 (#390270)
            U 5 (#1e73d1)
            R 7 (#672f40)
            D 5 (#1e73d3)
            R 6 (#83a5d0)
            D 6 (#50dd53)
            R 2 (#48d590)
            D 3 (#5e3bf3)
            R 5 (#4064a0)
            D 11 (#08fa63)
            L 5 (#3f2af0)
            D 5 (#3f7793)
            R 5 (#6d57f0)
            U 2 (#135f33)
            R 3 (#445122)
            U 10 (#5285b3)
            R 3 (#3dc912)
            U 6 (#5285b1)
            R 4 (#355342)
            U 2 (#53a883)
            R 6 (#4c4be0)
            U 8 (#0303f3)
            R 4 (#6b2190)
            U 4 (#62c1b3)
            R 7 (#3241e0)
            D 4 (#057a23)
            R 3 (#692490)
            D 3 (#0eadb3)
            R 8 (#526c20)
            D 4 (#5721d3)
            R 4 (#33dd40)
            D 3 (#4a6513)
            R 2 (#1c8770)
            D 5 (#0db573)
            L 7 (#2a30a2)
            D 6 (#186ba3)
            R 7 (#788af2)
            D 7 (#186ba1)
            R 5 (#001542)
            D 5 (#3830c3)
            R 3 (#32b480)
            D 9 (#73a7a3)
            R 5 (#5b0230)
            D 5 (#562d53)
            R 8 (#7e0d30)
            D 3 (#059e93)
            L 6 (#3284d0)
            D 3 (#373711)
            L 2 (#4de350)
            D 7 (#6179f1)
            L 2 (#57f0b0)
            D 6 (#4cd0b1)
            L 6 (#6a0260)
            D 3 (#4cd0b3)
            R 4 (#47ed90)
            D 8 (#4e4a61)
            R 4 (#029330)
            D 3 (#56c261)
            R 4 (#029332)
            U 11 (#08aee1)
            R 4 (#3f9e40)
            D 3 (#124841)
            R 5 (#6af022)
            D 10 (#189be1)
            R 2 (#4058d2)
            D 3 (#6cd791)
            R 8 (#2c43c2)
            D 5 (#36a191)
            R 6 (#2c43c0)
            U 5 (#3fff21)
            R 3 (#4058d0)
            U 8 (#06ad11)
            R 4 (#6af020)
            D 3 (#487a71)
            R 3 (#77aa00)
            D 10 (#335cc1)
            R 4 (#445960)
            U 5 (#36c3f1)
            R 3 (#5d13b0)
            U 9 (#1f2761)
            R 2 (#49e9e0)
            U 3 (#7eb501)
            R 4 (#578e30)
            U 2 (#66dd31)
            R 7 (#469130)
            U 4 (#7f9823)
            R 6 (#1e1e90)
            U 5 (#127fa3)
            R 5 (#14ac40)
            D 6 (#130523)
            R 3 (#07a7b0)
            D 6 (#5f7be3)
            R 8 (#4fff10)
            D 6 (#1ad8f1)
            R 2 (#32df80)
            D 5 (#57a811)
            R 7 (#084830)
            D 4 (#127fa1)
            R 10 (#1fa950)
            D 6 (#70fee3)
            R 5 (#04f0e2)
            D 2 (#4052d3)
            R 5 (#3f7cc2)
            D 6 (#8a1e13)
            R 4 (#3be9a2)
            D 4 (#8a1e11)
            R 7 (#49c392)
            D 3 (#4052d1)
            L 6 (#1b27c2)
            D 3 (#4ae683)
            L 7 (#109120)
            D 3 (#634013)
            L 5 (#19bbb0)
            D 6 (#21de43)
            L 4 (#15dd60)
            D 5 (#4b3bc3)
            L 4 (#691db2)
            D 5 (#2f3753)
            L 4 (#0ed142)
            D 5 (#4d2823)
            L 5 (#378122)
            D 4 (#5b8733)
            L 3 (#35bdc2)
            U 6 (#2d1093)
            L 6 (#54e720)
            U 8 (#12e8d1)
            L 4 (#8bb140)
            U 4 (#12e8d3)
            R 6 (#049570)
            U 4 (#01c483)
            L 6 (#15dd62)
            U 6 (#5d8b23)
            R 4 (#4e5940)
            U 7 (#92cae1)
            L 8 (#1a3a50)
            U 3 (#0f4801)
            L 6 (#326690)
            U 4 (#01c2a1)
            L 5 (#051e00)
            D 7 (#61eb71)
            L 7 (#459650)
            D 2 (#9994f1)
            L 3 (#471090)
            D 8 (#0e7a31)
            L 2 (#550610)
            D 8 (#194501)
            R 6 (#4b09c0)
            D 4 (#8e6791)
            R 6 (#4b09c2)
            D 6 (#0bd3d1)
            L 8 (#4527f0)
            D 7 (#30e601)
            L 6 (#14a132)
            D 3 (#795df1)
            L 7 (#60edd2)
            D 4 (#056141)
            L 4 (#41dbc2)
            D 3 (#488971)
            R 8 (#38fef0)
            D 4 (#2cb3b1)
            R 3 (#38fef2)
            D 3 (#369c41)
            L 6 (#3e5bd2)
            D 4 (#19bcb3)
            L 4 (#173b32)
            D 4 (#0de2b3)
            L 12 (#377942)
            D 3 (#899b43)
            L 3 (#3e99b2)
            D 3 (#00b211)
            L 3 (#4b5ad2)
            D 5 (#1f0501)
            L 8 (#4abb70)
            D 4 (#7f6001)
            L 5 (#4abb72)
            D 3 (#20c3d1)
            L 7 (#1d68a0)
            D 9 (#471091)
            L 4 (#4c8650)
            D 3 (#25ab01)
            L 10 (#35f0b0)
            D 2 (#695131)
            L 10 (#051850)
            D 5 (#60dd93)
            L 9 (#567cc0)
            D 4 (#2e1ea3)
            L 5 (#2ffa30)
            D 5 (#22b051)
            L 5 (#911430)
            D 4 (#396521)
            L 4 (#11ec70)
            D 3 (#356891)
            R 8 (#6e13c0)
            D 4 (#4d3291)
            R 3 (#277462)
            D 5 (#57f681)
            R 3 (#2f8dc0)
            D 3 (#020321)
            R 9 (#628620)
            D 6 (#152051)
            L 6 (#9213e2)
            D 5 (#4ec671)
            L 6 (#277460)
            D 8 (#13c7b1)
            L 5 (#1b3e00)
            U 6 (#5e57f1)
            L 4 (#4a7b20)
            U 6 (#5e57f3)
            L 4 (#437f90)
            U 3 (#020143)
            L 4 (#034420)
            D 9 (#152c63)
            L 3 (#2296b2)
            D 2 (#771a63)
            L 4 (#2296b0)
            D 5 (#251a83)
            R 10 (#034422)
            D 5 (#6b7823)
            L 10 (#19c8c0)
            D 3 (#87f251)
            L 5 (#53ad40)
            U 7 (#534f61)
            L 7 (#3ee5c0)
            U 6 (#0c6d71)
            L 4 (#2d8ba0)
            D 6 (#29a941)
            L 5 (#0a35f0)
            U 6 (#2e83e1)
            L 2 (#0a35f2)
            U 11 (#45afc1)
            L 3 (#2a9d30)
            U 3 (#366473)
            L 8 (#1e5c90)
            U 6 (#73e5e3)
            R 8 (#01d790)
            U 4 (#3b0e81)
            L 2 (#155640)
            U 4 (#0f5351)
            L 8 (#608130)
            U 2 (#7af281)
            L 3 (#332700)
            U 4 (#05b091)
            L 2 (#0faf80)
            U 9 (#0091e1)
            R 3 (#0b3210)
            U 6 (#1ee971)
            L 7 (#24f6d2)
            U 4 (#519181)
            R 7 (#5e5392)
            U 3 (#3f1351)
            R 3 (#022282)
            U 4 (#857db1)
            R 9 (#09a712)
            U 4 (#3c1341)
            R 4 (#025442)
            D 8 (#69a253)
            R 4 (#767622)
            D 7 (#69a251)
            R 6 (#4267a2)
            D 4 (#320361)
            R 5 (#3c5870)
            U 7 (#267773)
            R 8 (#4b2b40)
            U 4 (#267771)
            R 4 (#3f77e0)
            U 8 (#32f0d1)
            R 3 (#834a60)
            U 5 (#2e98c1)
            R 3 (#635c80)
            D 6 (#1e7241)
            R 4 (#36a5c0)
            D 9 (#3c5311)
            R 3 (#0907f0)
            U 6 (#394291)
            R 2 (#952cc0)
            U 9 (#394293)
            R 4 (#6b81a0)
            D 5 (#592621)
            R 4 (#59ea50)
            U 8 (#4ef493)
            R 7 (#3e3f10)
            U 3 (#514253)
            L 7 (#3e3f12)
            U 9 (#23e503)
            L 3 (#3eb3b0)
            U 5 (#2e6433)
            L 3 (#67c590)
            D 5 (#77b101)
            L 3 (#21c682)
            D 11 (#754aa1)
            L 3 (#21c680)
            U 6 (#058471)
            L 3 (#0ec8c0)
            U 10 (#76bdd3)
            L 6 (#07fb80)
            U 7 (#386853)
            R 8 (#55a690)
            D 4 (#02f453)
            R 8 (#2fb280)
            U 4 (#4e8811)
            R 5 (#7c2910)
            U 3 (#639261)
            L 4 (#471b80)
            U 5 (#592623)
            L 5 (#42bc00)
            U 9 (#62c471)
            L 7 (#6a8c32)
            D 4 (#13d861)
            L 4 (#94bb72)
            D 6 (#13d863)
            L 5 (#2e3ba2)
            D 3 (#24ee61)
            L 4 (#888a22)
            D 9 (#366271)
            L 4 (#1201a2)
            D 6 (#238401)
            L 2 (#246412)
            D 7 (#1c23f1)
            L 4 (#41d152)
            D 3 (#6b5d81)
            L 6 (#659b22)
            U 3 (#6f1a03)
            L 3 (#32db02)
            U 4 (#186773)
            L 3 (#0043e2)
            U 7 (#295c31)
            L 3 (#3bd622)
            U 8 (#25f1c1)
            L 3 (#52ea70)
            D 5 (#302c41)
            L 4 (#52ea72)
            D 5 (#4cb371)
            R 4 (#0062e2)
            D 6 (#016ab1)
            L 4 (#6511c2)
            D 3 (#1fae91)
            L 3 (#5ca060)
            U 7 (#6daef1)
            L 5 (#5ca062)
            U 7 (#4904a1)
            L 7 (#6cc852)
            U 3 (#0e2451)
            L 3 (#109dd2)
            U 5 (#5b3813)
            R 8 (#6cb452)
            U 2 (#25f353)
            R 2 (#6cb450)
            U 5 (#4bd743)
            L 5 (#609a42)
            U 4 (#774593)
            L 3 (#609a40)
            D 2 (#6dd693)
            L 7 (#138f72)
            D 7 (#37ed73)
            L 7 (#0ad4c2)
            U 6 (#32a9f3)
            L 8 (#859122)
            U 4 (#143d73)
            L 11 (#64f202)
            U 2 (#18d5c3)
            L 3 (#24cb12)
            D 10 (#2e7523)
            L 2 (#461b52)
            D 2 (#5d9883)
            L 3 (#6ae660)
            D 5 (#1ac423)
            R 11 (#2c9fe2)
            D 3 (#2e1f33)
            L 11 (#8686b2)
            D 5 (#0bbc53)
            R 3 (#232a62)
            D 6 (#3f85d3)
            R 3 (#787172)
            D 9 (#20eda3)
            R 3 (#404292)
            D 3 (#3ab463)
            R 3 (#22a182)
            D 6 (#08f6e3)
            L 2 (#776202)
            D 2 (#4f3193)
            L 5 (#549e22)
            D 2 (#5cf443)
            L 5 (#549e20)
            D 5 (#4e5523)
            R 6 (#6f6852)
            D 3 (#00e383)
            R 10 (#4f9722)
            D 5 (#24e003)
            R 8 (#138892)
            D 3 (#782033)
            R 10 (#02bf92)
            D 4 (#0d0ad3)
            L 8 (#5a8342)
            D 2 (#244f11)
            L 3 (#182ce0)
            D 4 (#6c4331)
            L 9 (#140250)
            D 5 (#325901)
            L 3 (#033dc0)
            D 3 (#0c7231)
            L 11 (#54fbe0)
            D 4 (#094653)
            L 4 (#76ee60)
            D 11 (#094651)
            L 3 (#00f3f0)
            D 8 (#0c7233)
            L 4 (#255340)
            D 5 (#332281)
            L 3 (#487c52)
            D 3 (#70ada1)
            L 10 (#508b12)
            U 5 (#1e0d21)
            L 6 (#825812)
            U 7 (#2f5771)
            L 7 (#063ef2)
            U 5 (#34f4c1)
            L 5 (#1fa462)
            U 7 (#74be53)
            L 3 (#3c4402)
            U 4 (#837ef1)
            L 10 (#4fb490)
            U 2 (#573091)
            L 2 (#408920)
            U 5 (#3969e3)
            L 3 (#77eff0)
            U 5 (#3969e1)
            L 7 (#2bec10)
            U 4 (#7ac481)
            R 8 (#0b7162)
            U 2 (#0d6aa1)
            R 5 (#502642)
            U 3 (#5169c3)
            R 12 (#674d02)
            U 3 (#5169c1)
            L 5 (#713512)
            U 7 (#6bd621)
            L 7 (#69b9f2)
            U 3 (#749153)
    """.trimIndent()
    )
    check(52885384955882, result)

    result = test(
        """
            R 4 (#185fd2)
            U 10 (#b6aa53)
            L 4 (#5cdb02)
            U 3 (#b6aa51)
            L 4 (#530592)
            U 5 (#65a913)
            L 2 (#051d62)
            U 6 (#153e33)
            L 4 (#3f1372)
            D 4 (#9095e3)
            L 10 (#3f1370)
            D 6 (#58c163)
            R 5 (#7850b2)
            D 2 (#28f7f1)
            R 4 (#3f0392)
            D 9 (#743623)
            R 4 (#34f1f2)
            D 7 (#899b13)
            L 4 (#95ffa2)
            D 6 (#899b11)
            L 9 (#57ac62)
            D 3 (#86c073)
            L 4 (#0b4b92)
            U 4 (#0d1711)
            L 4 (#1cc472)
            U 5 (#be33a1)
            L 6 (#1cc470)
            U 4 (#2fabe1)
            L 6 (#290df2)
            U 9 (#28f7f3)
            L 6 (#17a9f2)
            U 2 (#450843)
            L 10 (#21ad12)
            U 3 (#2f46a3)
            R 8 (#8debe2)
            U 3 (#4bede3)
            R 5 (#3affd2)
            U 4 (#5bbe23)
            R 9 (#131872)
            U 3 (#5712a3)
            L 5 (#3ae040)
            U 3 (#33c033)
            L 7 (#52e450)
            U 4 (#7e71b3)
            R 6 (#444d50)
            U 5 (#20ea63)
            R 6 (#9571f0)
            U 2 (#9f5c11)
            R 4 (#368710)
            U 5 (#0f5ca3)
            R 5 (#1b8710)
            U 3 (#3014c3)
            L 5 (#0c2610)
            U 5 (#0591d3)
            R 5 (#964490)
            U 3 (#597ac3)
            R 5 (#1da130)
            D 3 (#3731b3)
            R 3 (#0df070)
            D 8 (#2a3db3)
            R 4 (#0936c0)
            U 6 (#3e59a1)
            R 3 (#146fe2)
            U 5 (#608691)
            R 7 (#146fe0)
            U 7 (#51b081)
            R 3 (#0a0a30)
            U 5 (#5329d3)
            L 8 (#4d41b0)
            U 4 (#c3abc3)
            L 3 (#5b0fa0)
            U 4 (#216e53)
            L 2 (#58f470)
            U 7 (#a49b53)
            R 10 (#54efb0)
            U 2 (#27c9e3)
            L 10 (#22dc80)
            U 6 (#6af783)
            L 7 (#4590f0)
            U 6 (#398293)
            L 5 (#4590f2)
            D 4 (#9b27e3)
            L 2 (#23ff42)
            D 9 (#822a73)
            L 5 (#23ff40)
            D 3 (#11cd93)
            L 2 (#ad67c2)
            D 10 (#6ffb73)
            L 7 (#2001e2)
            D 3 (#356fe3)
            L 4 (#485f62)
            U 7 (#4d4103)
            L 8 (#5d7130)
            U 6 (#020903)
            L 3 (#37cc32)
            U 5 (#7cb833)
            L 5 (#37cc30)
            D 5 (#73ad53)
            L 4 (#6337e0)
            D 6 (#6b0281)
            L 3 (#0d8452)
            U 11 (#5d1e21)
            L 3 (#0d8450)
            D 4 (#2a4de1)
            L 5 (#551ff0)
            D 5 (#37e513)
            L 3 (#685900)
            D 9 (#1d9d01)
            L 3 (#103ec0)
            U 9 (#52c7a1)
            L 3 (#3525f2)
            U 2 (#6ccdd1)
            L 4 (#3525f0)
            U 9 (#049991)
            L 8 (#670f40)
            U 4 (#1fc543)
            R 4 (#6554b2)
            U 6 (#69c9b3)
            R 4 (#01e560)
            U 6 (#2977c3)
            R 7 (#01e562)
            U 3 (#517d43)
            R 11 (#6554b0)
            U 6 (#200223)
            R 8 (#0743a0)
            U 8 (#2c3ca3)
            R 4 (#190d00)
            U 8 (#266011)
            R 4 (#73fd30)
            U 8 (#7b4b31)
            R 3 (#492cd0)
            U 4 (#4fff11)
            R 5 (#9e1f20)
            U 6 (#5f1861)
            R 2 (#489440)
            U 2 (#28f5a3)
            R 5 (#36a720)
            U 3 (#b8d663)
            R 7 (#51ce60)
            U 5 (#480693)
            R 6 (#1ae5f0)
            U 4 (#0972a3)
            R 5 (#b54870)
            D 4 (#0972a1)
            R 8 (#175720)
            U 4 (#480691)
            R 5 (#0b55d0)
            U 6 (#7e1633)
            R 7 (#968ee2)
            U 9 (#02ec63)
            R 2 (#27cc00)
            U 10 (#0d0613)
            R 3 (#6d6f40)
            U 5 (#0d0611)
            R 10 (#3eeae0)
            D 3 (#1c4293)
            L 5 (#0ef560)
            D 7 (#2e6c53)
            L 5 (#9cd4f2)
            D 11 (#6ada23)
            R 5 (#9cd4f0)
            D 4 (#4db983)
            R 5 (#151be0)
            D 4 (#21f9c3)
            R 8 (#205bc2)
            D 4 (#36ab51)
            R 6 (#a20722)
            U 8 (#36ab53)
            L 5 (#35d482)
            U 11 (#2ed133)
            R 5 (#723852)
            U 5 (#134f63)
            L 5 (#1b4082)
            U 3 (#575003)
            R 5 (#b739f2)
            U 4 (#16d793)
            R 5 (#0d0642)
            U 2 (#8d4163)
            R 7 (#8080f2)
            D 7 (#47e6c3)
            R 6 (#390742)
            D 9 (#5e0ce3)
            L 8 (#b98830)
            D 7 (#72baa3)
            R 8 (#80b432)
            D 8 (#0c6133)
            R 3 (#187e62)
            U 3 (#573d13)
            R 3 (#c327d2)
            U 6 (#573d11)
            R 7 (#2444c2)
            U 4 (#157c83)
            L 4 (#92b8d2)
            U 3 (#200c93)
            L 5 (#457272)
            U 7 (#027273)
            R 3 (#a1e732)
            U 7 (#083993)
            R 6 (#47d112)
            U 4 (#a93863)
            R 4 (#04d492)
            U 2 (#6d7973)
            R 6 (#a38da0)
            D 5 (#1323b3)
            R 6 (#117310)
            D 3 (#2113c3)
            R 4 (#6c8140)
            D 5 (#9db833)
            L 4 (#710bd0)
            D 4 (#0a8b73)
            L 6 (#4b16c0)
            D 9 (#031c13)
            L 7 (#2fdeb0)
            D 3 (#2556b3)
            R 4 (#558ef0)
            D 4 (#0c4823)
            R 4 (#3f8970)
            D 8 (#96b223)
            R 3 (#828d60)
            U 4 (#1da791)
            R 2 (#01d990)
            U 8 (#3289f1)
            R 4 (#b6ed00)
            D 7 (#55ce81)
            R 6 (#6054f0)
            U 10 (#82a943)
            L 6 (#8c81e0)
            U 5 (#2356c3)
            R 6 (#2a57d0)
            U 9 (#7d8313)
            R 2 (#04b760)
            U 7 (#0f9583)
            R 5 (#8e74b0)
            U 6 (#58f5f3)
            R 8 (#700842)
            D 6 (#6542a3)
            R 3 (#2323d2)
            U 6 (#065ee3)
            R 10 (#3a80f0)
            U 4 (#82cbc3)
            R 10 (#53c160)
            U 2 (#4e4a43)
            R 2 (#c00090)
            U 6 (#41db93)
            R 7 (#0027e0)
            U 5 (#9025d1)
            R 3 (#3faf50)
            D 5 (#75ccf1)
            R 6 (#9b4870)
            D 5 (#597e03)
            R 3 (#4ddd22)
            D 10 (#5cfda3)
            R 6 (#4ddd20)
            D 11 (#952873)
            R 4 (#5d49f2)
            D 5 (#01da53)
            R 7 (#5f2932)
            D 10 (#b9f063)
            R 5 (#1fa7d0)
            D 8 (#4666c3)
            R 3 (#9ccb50)
            D 3 (#769c93)
            R 5 (#1fe970)
            D 7 (#144e01)
            R 4 (#798f60)
            D 7 (#3ec073)
            L 4 (#3569f0)
            D 8 (#94c3f3)
            R 4 (#747dd0)
            D 5 (#20d6d3)
            R 7 (#077540)
            D 3 (#254691)
            R 4 (#495f10)
            D 2 (#434111)
            R 4 (#2e51f0)
            U 4 (#8bd391)
            R 6 (#30bf90)
            U 4 (#b02ad1)
            R 4 (#5c3450)
            D 4 (#478d41)
            R 6 (#5da972)
            U 7 (#904281)
            R 6 (#54e912)
            U 3 (#2ac801)
            L 4 (#209b32)
            U 3 (#445131)
            L 9 (#726c32)
            U 3 (#445133)
            L 6 (#4ac932)
            U 9 (#2ac803)
            L 3 (#155922)
            U 6 (#2d8331)
            R 8 (#89d512)
            D 3 (#97ff31)
            R 5 (#312010)
            D 2 (#062981)
            R 5 (#0e0a80)
            D 7 (#5b0221)
            R 8 (#8b68d0)
            D 2 (#5b0223)
            R 4 (#4dda80)
            D 3 (#062983)
            R 4 (#4acf40)
            D 8 (#62a721)
            R 2 (#31ef70)
            D 6 (#82c8e3)
            L 5 (#69d920)
            D 8 (#82c8e1)
            L 6 (#631940)
            D 4 (#3a7881)
            L 5 (#45e4f0)
            D 5 (#5dc8c1)
            R 4 (#ab2bc0)
            D 5 (#5dc8c3)
            L 4 (#0e37c0)
            D 5 (#b73991)
            L 5 (#65f6d0)
            U 3 (#b73993)
            L 7 (#66d670)
            U 4 (#687961)
            R 7 (#6176a0)
            U 5 (#98c8a1)
            L 3 (#3dedc0)
            U 3 (#319cf1)
            L 5 (#285a10)
            U 4 (#33a483)
            L 6 (#5b47e0)
            D 9 (#96c113)
            R 4 (#2de480)
            D 8 (#8c8d81)
            L 3 (#019d20)
            U 4 (#ab8881)
            L 8 (#175860)
            D 4 (#51da61)
            L 8 (#4023f0)
            D 7 (#523121)
            R 7 (#349840)
            D 5 (#a08b91)
            R 6 (#7dd070)
            D 4 (#5d8601)
            R 3 (#7cf760)
            U 9 (#0c26f1)
            R 3 (#2a7d30)
            D 5 (#82e861)
            R 5 (#3e46c0)
            D 10 (#2f8121)
            R 7 (#55f470)
            U 8 (#4b1a31)
            R 2 (#1bb7c0)
            U 5 (#63b3d1)
            R 5 (#007722)
            U 2 (#3f3a81)
            R 4 (#007720)
            U 7 (#4d03a1)
            R 2 (#29ee20)
            U 8 (#175c81)
            R 3 (#086db0)
            D 3 (#1d6631)
            R 3 (#9b9da0)
            D 11 (#959c71)
            R 5 (#465862)
            U 3 (#8df221)
            R 6 (#2a2642)
            U 5 (#601fb1)
            L 6 (#146a62)
            U 5 (#99e261)
            R 2 (#9524f2)
            U 4 (#35b8a1)
            R 7 (#05bcf2)
            U 4 (#74cfe1)
            R 9 (#122a82)
            U 7 (#283ec1)
            R 5 (#98a4e2)
            D 5 (#4e9363)
            R 6 (#2a4b92)
            D 4 (#3c9093)
            R 6 (#7f7b02)
            U 2 (#ac7ce3)
            R 3 (#7f7b00)
            U 7 (#266ad3)
            R 6 (#2a4b90)
            D 5 (#528973)
            R 5 (#6b7e32)
            D 5 (#0a92d3)
            R 4 (#c3b802)
            U 5 (#352e03)
            R 6 (#bf7462)
            D 3 (#65cfb3)
            R 4 (#8c2af2)
            D 3 (#0495e3)
            R 3 (#832dd2)
            D 10 (#022e51)
            R 7 (#07c5d2)
            D 4 (#041c01)
            R 10 (#26ed22)
            D 3 (#b00f91)
            R 6 (#66d172)
            D 3 (#6f4921)
            R 6 (#888172)
            D 11 (#10de41)
            R 3 (#1ae2a2)
            D 7 (#243b83)
            R 6 (#1be9f0)
            D 5 (#5874b3)
            L 6 (#06ae32)
            D 10 (#207c23)
            L 7 (#06ae30)
            D 9 (#4ca443)
            L 4 (#1be9f2)
            U 9 (#4cb0b3)
            L 4 (#1e0de2)
            U 10 (#5cb0a1)
            L 5 (#2e4fb2)
            U 8 (#705f51)
            L 3 (#b41bc2)
            U 4 (#7c63f1)
            L 7 (#901670)
            U 9 (#0c7fa1)
            L 4 (#240550)
            U 4 (#5f23d1)
            L 5 (#58a592)
            D 4 (#152b71)
            L 10 (#58a590)
            D 2 (#5af221)
            L 3 (#5a1fe0)
            D 9 (#82c2b1)
            R 7 (#a3fca0)
            D 9 (#45bd61)
            L 7 (#144cc0)
            D 9 (#a38ef1)
            L 7 (#4bd0d0)
            D 4 (#6fbe01)
            L 3 (#983b90)
            D 7 (#394ea1)
            L 7 (#6a8f70)
            U 9 (#638b63)
            L 3 (#b84420)
            U 7 (#458143)
            L 3 (#1f79e0)
            D 3 (#a6c921)
            L 4 (#218680)
            D 5 (#16b981)
            L 2 (#453fe0)
            D 10 (#608851)
            L 3 (#5973f0)
            U 5 (#5591d1)
            L 8 (#7647b0)
            U 2 (#3c2cd1)
            R 8 (#3ed7b2)
            U 5 (#3df061)
            L 4 (#90e3f2)
            U 6 (#226a71)
            L 3 (#453fe2)
            D 7 (#910ce1)
            L 5 (#0782e0)
            D 4 (#3fdca1)
            L 6 (#787f72)
            D 8 (#3faa51)
            L 4 (#3f8002)
            D 3 (#67ebc3)
            L 2 (#6b6672)
            D 9 (#402f81)
            L 4 (#47d1b2)
            D 9 (#a110f1)
            L 2 (#5693d0)
            D 3 (#998b41)
            L 5 (#5693d2)
            D 3 (#556501)
            L 10 (#47d1b0)
            D 6 (#51cc51)
            R 10 (#8b8ab2)
            D 3 (#00e693)
            L 2 (#1ac042)
            D 3 (#0f57c3)
            L 2 (#1348f2)
            D 6 (#c0c063)
            L 4 (#1348f0)
            D 3 (#042dd3)
            L 4 (#0d24f2)
            D 9 (#5f4103)
            L 7 (#3ed3c2)
            D 2 (#3e1d23)
            L 4 (#181272)
            U 11 (#ae42f3)
            L 3 (#8585d2)
            U 2 (#012f73)
            L 4 (#305e92)
            D 8 (#67ebc1)
            L 3 (#240c42)
            D 5 (#6b0ba1)
            L 5 (#4aa9a2)
            U 5 (#215963)
            L 3 (#2960e2)
            U 6 (#bba0d3)
            L 5 (#579652)
            U 5 (#45b791)
            L 4 (#53f582)
            U 10 (#883c81)
            L 4 (#53f580)
            U 5 (#0f0621)
            R 9 (#302402)
            U 3 (#25f621)
            L 9 (#7dd240)
            U 4 (#06a081)
            L 2 (#a51cf0)
            U 4 (#556b01)
            L 5 (#222ef0)
            U 4 (#2945e1)
            L 3 (#862360)
            U 6 (#8e5051)
            L 7 (#55d172)
            D 6 (#70b7b1)
            L 3 (#6d8f32)
            U 6 (#c1d1d1)
            L 4 (#0d7442)
            U 3 (#03cf71)
            R 9 (#0ee642)
            U 4 (#1c5e23)
            R 7 (#160452)
            U 6 (#b57503)
            L 6 (#160450)
            U 2 (#6485d3)
            L 5 (#600a62)
            U 6 (#090a91)
            L 5 (#478692)
            U 3 (#0bc7b1)
            L 4 (#821af2)
            D 2 (#69ccf1)
            L 9 (#821af0)
            D 8 (#4ec5b1)
            L 8 (#399ca2)
            D 8 (#0f7e41)
            L 5 (#0a58d2)
            D 6 (#1b28d1)
            L 11 (#6fab02)
            D 3 (#3267b1)
            R 7 (#5a1742)
            D 3 (#51a271)
            R 4 (#12cfc0)
            D 4 (#17e2b3)
            L 5 (#1522b0)
            D 5 (#373ee1)
            R 4 (#9a7000)
            U 2 (#373ee3)
            R 6 (#17ca10)
            U 8 (#17e2b1)
            R 7 (#05b8b0)
            D 4 (#8e8ea1)
            R 3 (#11e000)
            D 6 (#24b8e1)
            R 3 (#84f220)
            D 5 (#05baf1)
            L 4 (#60fa82)
            D 5 (#691b81)
            L 5 (#31bf92)
            D 3 (#5ff001)
            R 8 (#73a822)
            D 6 (#61b511)
            R 3 (#5f3e20)
            D 3 (#358521)
            L 3 (#5de030)
            D 6 (#8f1391)
            L 8 (#4943e0)
            D 4 (#9b41e1)
            L 4 (#16a272)
            U 9 (#1a1601)
            L 5 (#3a5d12)
            U 5 (#95ede1)
            R 5 (#579db2)
            U 4 (#295691)
            L 5 (#4e92d2)
            U 4 (#41ad01)
            L 5 (#7f8752)
            D 8 (#07aeb1)
            L 6 (#32de52)
            D 5 (#559a73)
            L 9 (#9bffa2)
            D 2 (#56f793)
            L 3 (#bc5802)
            U 5 (#605113)
            L 9 (#77c880)
            U 8 (#3494a3)
            L 9 (#0e2d90)
            U 8 (#a52503)
            R 7 (#0e2d92)
            U 6 (#050f83)
            L 7 (#5f6800)
            U 6 (#474531)
            L 7 (#471ff0)
            U 6 (#145321)
            L 5 (#5770f0)
            U 4 (#8330d1)
            R 3 (#019e30)
            U 4 (#b32b93)
            R 6 (#8293f0)
            D 4 (#305133)
            R 5 (#316ad2)
            U 4 (#865e83)
            R 4 (#6489c2)
            D 4 (#5890c3)
            R 3 (#7276d2)
            U 7 (#42c2d3)
            L 6 (#8e0cb2)
            U 6 (#696303)
            L 4 (#637b72)
            U 3 (#401103)
            L 3 (#324492)
            U 5 (#b686e3)
            L 4 (#1befb2)
            U 5 (#6c04c3)
            L 3 (#201172)
            U 9 (#3717a1)
            L 4 (#7eb7b2)
            D 10 (#9a97f1)
            L 7 (#72fb12)
            D 4 (#50dc11)
            L 7 (#16a842)
            D 5 (#156ec3)
            L 2 (#13d402)
            D 2 (#735093)
            L 3 (#8a1ae2)
            U 6 (#735091)
            L 4 (#54de72)
            D 6 (#2b32a3)
            L 6 (#4611e0)
            D 3 (#762253)
            R 5 (#59e090)
            D 7 (#389f93)
            L 4 (#70ab50)
            D 3 (#166283)
            L 3 (#247e92)
            D 8 (#91ca63)
            R 6 (#9ddeb2)
            D 6 (#1f7f03)
            R 3 (#4e4082)
            D 7 (#697043)
            R 5 (#c308e2)
            U 11 (#21c073)
            R 5 (#13fef2)
            D 11 (#a06563)
            R 6 (#61b5d2)
            D 3 (#1cd9c3)
            R 2 (#4f0852)
            D 3 (#60fcc3)
            L 6 (#98bf82)
            D 7 (#214541)
            L 9 (#6688f0)
            U 4 (#80bad1)
            L 2 (#621f30)
            U 3 (#9b27a1)
            L 10 (#621f32)
            D 3 (#6aa341)
            R 7 (#4da592)
            D 5 (#a3edf1)
            L 11 (#91d450)
            D 5 (#880101)
            L 5 (#0fdba0)
            D 5 (#339fe1)
            R 8 (#a1aff2)
            D 3 (#8766f1)
            R 8 (#4da590)
            D 4 (#32d0e1)
            L 5 (#6688f2)
            D 4 (#53a7c1)
            L 4 (#084142)
            D 3 (#19c573)
            L 4 (#686872)
            D 9 (#35f161)
            L 3 (#8a3bf2)
            U 7 (#35f163)
            L 2 (#00f612)
            U 5 (#1d9613)
            L 7 (#215cf2)
            U 5 (#8ef363)
            L 3 (#152312)
            U 6 (#298013)
    """.trimIndent()
    )
    check(201398068194715, result)
}

private fun test(input: String): Long {
    val lines = input.split("\n")
    val map = mutableListOf<Point>()

    var point = Point(0, 0)
    map += point

    var loopCount = 0L

    for (line in lines) {
        val tokens = line.split(" ")
        val hex = tokens[2].removePrefix("(#").removeSuffix(")")
        val count = hex.substring(0, 5).toInt(16)
        val command = when (hex.substring(5, 6)) {
            "0" -> 'R'
            "1" -> 'D'
            "2" -> 'L'
            "3" -> 'U'
            else -> throw IllegalStateException("hex $hex")
        }
        when (command) {
            'R' -> {
                point = point.plus(count, 0)
                map += point
                loopCount += count
            }

            'L' -> {
                point = point.plus(-count, 0)
                map += point
                loopCount += count
            }

            'U' -> {
                point = point.plus(0, -count)
                map += point
                loopCount += count
            }

            'D' -> {
                point = point.plus(0, count)
                map += point
                loopCount += count
            }
        }
    }

    var areaCount = 0L
    for (i in 0 until map.lastIndex) {
        areaCount += map[i].x * map[i + 1].y.toLong() - map[i + 1].x * map[i].y.toLong()
    }
    return areaCount / 2 + loopCount / 2 + 1
}
