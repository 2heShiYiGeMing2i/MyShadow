package tools

import java.io.File
import java.nio.file.{Files, StandardOpenOption}

import com.google.common.base.Charsets

/**
  * Created by zhaolei on 2018/4/7
  */
object WriteToFile {

  val fileName: String = "test.txt"
  val path: String = "config_file"

  /**
    * 将内容写到文件中去
    *
    * @param fileName 文件名
    * @param path     路径
    * @param content  内容
    */
  def write(fileName: String, path: String, content: String): Unit = {
    if (path.nonEmpty) {
      new File(path).mkdirs()
    }
    val file = new File(s"$path/$fileName")
    Files.write(file.toPath,
                content.getBytes(Charsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE)
  }

}
