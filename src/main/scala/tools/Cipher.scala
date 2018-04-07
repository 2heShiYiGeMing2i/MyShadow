package tools

/**
  * 编码器
  * Created by zhaolei on 2018/4/7
  */
object Cipher {

  /**
    * 要先进行初始化
    */
  def apply(encodeMap: Map[Byte, Byte], decodeMap: Map[Byte, Byte]): Unit = {
    this.encodeMap = encodeMap
    this.decodeMap = decodeMap
  }

  var encodeMap: Map[Byte, Byte] = Map.empty[Byte, Byte]
  var decodeMap: Map[Byte, Byte] = Map.empty[Byte, Byte]

  /** 解码 */
  def decode(source: Array[Byte]): Array[Byte] = {
    change(decodeMap, source)
  }

  /** 编码 */
  def encode(source: Array[Byte]): Array[Byte] = {
    change(encodeMap, source)
  }

  /** 转换 */
  def change(map: Map[Byte, Byte], source: Array[Byte]): Array[Byte] = {
    for (i <- source.indices) {
      source.update(i, map(source(i)))
    }
    source
  }
}
