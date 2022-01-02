import java.util.Calendar
object L1185 {

  private val arr = Array("", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

  def dayOfTheWeek(day: Int, month: Int, year: Int): String = {
    val c = Calendar.getInstance()
    c.set(Calendar.YEAR, year)
    c.set(Calendar.MONTH, month - 1)
    c.set(Calendar.DAY_OF_MONTH, day)
    arr(c.get(Calendar.DAY_OF_WEEK))
  }
}