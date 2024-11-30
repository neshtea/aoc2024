object Day1 {
  def sortedPairs(is: Seq[Int], js: Seq[Int]): Seq[(Int, Int)] =
    is.sorted().sorted.zip(js.sorted())

  def distance(i: Int, j: Int): Int = Math.abs(i - j)

  def distances(pairs: Seq[(Int, Int)]): Seq[Int] = pairs.map(distance)

  def parseInput(input: String): (Seq[Int], Seq[Int]) =
    input
      .split("\\n")
      .map(_.split("\\s+").map(_.toInt) match {
        case Array(a, b) => (a, b)
      })
      .toSeq
      .unzip

  def sum(is: Seq[Int]): Int = is.foldLeft(0)(_ + _)
  def part1(lefts: Seq[Int], rights: Seq[Int]): Int =
    sum(distances(sortedPairs(lefts, rights)))

  def score(i: Int, is: Seq[Int]): Int = 
    i * is.filter(_ == i).length

  def part2(lefts: Seq[Int], rights: Seq[Int]): Int =
    sum(lefts.map(score(_, rights)))
}

@main def runPart1(): Unit =
  val input = scala.io.Source.fromFile("./resources/day1part1.input").mkString
  val (lefts, rights) = Day1.parseInput(input)
  println(Day1.part1(lefts, rights))
  println(Day1.part2(lefts, rights))
