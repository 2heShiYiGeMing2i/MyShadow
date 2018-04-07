package tools

/**
  * 测试 编码解码
  * Created by zhaolei on 2018/4/7
  */
object CipherTest extends App {
  val text = "zhaolei"
  System.err.println(text)

//  MaskCode.setSeed()
  private val typeToIntToInt: Map[CodeType, Map[Byte, Byte]] =
    MaskCode.madeMask()
  Cipher(typeToIntToInt(CodeType.EncodeType),
         typeToIntToInt(CodeType.DecodeType))

  private val bytes: Array[Byte] = text.getBytes

  System.err.println(bytes.mkString(","))
  Cipher.encode(bytes)
  System.err.println(bytes.mkString(","))
  Cipher.decode(bytes)
  System.err.println(bytes.mkString(","))

}
