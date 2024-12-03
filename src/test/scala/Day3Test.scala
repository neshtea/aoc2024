class Day3Test extends munit.FunSuite {

  test("part1") {
    val input =
      "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
    val puzzle = Day3.parseProgram(input)
    assertEquals(Day3.part1(puzzle), 161)
  }

  test("part1") {
    val input =
      "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"
    val puzzle = Day3.parseProgram(input)
    assertEquals(Day3.part2(puzzle), 48)
  }

}
