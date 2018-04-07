package tools

import java.util
import java.util.concurrent.ThreadLocalRandom

/**
  * Created by zhaolei on 2018/4/7
  */
object MaskCode {
  val passWordLength = 256
  private val random = ThreadLocalRandom.current()

  // 生成map 导出到文件
  def madeMask(): Map[CodeType, Map[Byte, Byte]] = {
    var encodeMap = Map.empty[Byte, Byte]
    var decodeMap = Map.empty[Byte, Byte]
    val ints = madeRandomSeed(0, passWordLength - 1)
    for (i <- 0 until passWordLength) {
      encodeMap += (i.toByte -> ints.get(i))
      decodeMap += (ints.get(i) -> i.toByte)
    }
    Map.apply(CodeType.EncodeType -> encodeMap,
              CodeType.DecodeType -> decodeMap)
  }

  /**
    * @param start 生成随机数的开始位置(包括)
    * @param end   生成随机数的结束位置(包括)
    */
  def madeRandomSeed(start: Int, end: Int): util.ArrayList[Byte] = {
    val ints = new util.ArrayList[Byte]()
    val outs = new util.ArrayList[Byte]()
    start to end foreach (i => ints.add(i.toByte))
    while (ints.size() > 0) {
      val i = random.nextInt(ints.size())
      outs.add(ints.get(i))
      ints remove i
    }
    outs
  }

}
