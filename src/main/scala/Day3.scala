object Day3 {
  enum Instruction {
    case Do
    case Dont
    case Memory(a: Int, b: Int)
  }

  type Program = Seq[Instruction]

  def parseProgram(memory: String): Program =
    val pattern = raw"(mul\((\d+),(\d+)\)|do\(\)|don't\(\))".r
    pattern
      .findAllMatchIn(memory)
      .map { m =>
        m.matched match {
          case "do()"    => Instruction.Do
          case "don't()" => Instruction.Dont
          case _ if m.group(2) != null && m.group(3) != null =>
            Instruction.Memory(m.group(2).toInt, m.group(3).toInt)
        }
      }
      .toList

  def part1(prog: Program): Int =
    prog.foldLeft(0)((acc, instr) =>
      instr match {
        case Instruction.Do           => acc
        case Instruction.Dont         => acc
        case Instruction.Memory(a, b) => acc + a * b
      }
    )

  enum Mode {
    case Enable
    case Disable
  }

  def part2(prog: Program): Int =
    prog
      .foldLeft((0, Mode.Enable))((acc, instr) =>
        (acc._2, instr) match {
          case (_, Instruction.Do)   => (acc._1, Mode.Enable)
          case (_, Instruction.Dont) => (acc._1, Mode.Disable)
          case (Mode.Disable, _)     => (acc._1, Mode.Disable)
          case (Mode.Enable, Instruction.Memory(a, b)) =>
            (acc._1 + a * b, acc._2)
        }
      )
      ._1
}

@main def runDay3(): Unit =
  val input = scala.io.Source.fromFile("./resources/day3part1.input").mkString
  val puzzle = Day3.parseProgram(input)
  println(Day3.part1(puzzle))
  println(Day3.part2(puzzle))
