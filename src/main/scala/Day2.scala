object Day2:
  type Level = Int
  type Report = Seq[Level]
  type Puzzle = Seq[Report]
  type Tolerance = Int

  def dampen[T](seq: Seq[T]): Seq[Seq[T]] =
    seq.indices.map(i => seq.patch(i, Nil, 1))

  def checkDirection(report: Report): Boolean =
    val sorted = report.sorted()
    sorted == report || sorted == report.reverse

  def checkStep(pair: (Int, Int)): Boolean =
    val distance = Day1.distance(pair._1, pair._2)
    (1 <= distance && distance <= 3)

  def isSafe(tolerance: Tolerance)(report: Report): Boolean =
    if (tolerance < 0) return false
    else
      report
        .zip(report.tail)
        .foldLeft(true)(_ && checkStep(_))
      && checkDirection(report)
      ||
      // Try with lower tolerance and dampendend reports
      dampen(report).foldLeft(false)((acc, report) =>
        acc || isSafe(tolerance - 1)(report)
      )

  def parseInput(input: String): Puzzle =
    input
      .split("\\\n")
      .map((line) => line.split("\\ ").map(_.toInt).toSeq)
      .toSeq

  def part1(puzzle: Puzzle): Int =
    puzzle.filter(isSafe(0)).length

  def part2(puzzle: Puzzle): Int =
    puzzle.filter(isSafe(1)).length

@main def runDay2(): Unit =
  val input = scala.io.Source.fromFile("./resources/day2part1.input").mkString
  val puzzle = Day2.parseInput(input)
  println(Day2.part1(puzzle))
  println(Day2.part2(puzzle))
