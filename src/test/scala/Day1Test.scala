// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class Day1Test extends munit.FunSuite {
  val (lefts, rights) =
    Day1.parseInput("3   4\n4   3\n2   5\n1   3\n3   9\n3   3")

  test("part1") {
    assertEquals(Day1.part1(lefts, rights), 11)
  }

  test("part2") {
    assertEquals(Day1.part2(lefts, rights), 31)
  }
}
