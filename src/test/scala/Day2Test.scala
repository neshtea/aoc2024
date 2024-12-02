class Day2Test extends munit.FunSuite {

  val input = """7 6 4 2 1
                |1 2 7 8 9
                |9 7 6 2 1
                |1 3 2 4 5
                |8 6 4 4 1
                |1 3 6 7 9""".stripMargin('|')
  val puzzle = Day2.parseInput(input)

  test("part1") {
    assertEquals(Day2.part1(puzzle), 2)
  }

  test("part2") {
    assertEquals(Day2.part2(puzzle), 4)
  }
}
