package tools

/**
  * 自动生成配置文件
  * Created by zhaolei on 2018/4/7
  */
object WriteToFileTest extends App {
  val contents = """app {
                     server {
                       localHostName = "127.0.0.1" // 本地监听地址
                       localPort = 8888 // 本地监听端口
                       password = "字符串md5加密"
                     }
                     client {
                       remoteHostName = "192.168.1.42" // 远端地址
                       remotePort = 8888 //远端 端口
                       localHostName = "127.0.0.1" // 监听地址
                       localPort = 7777 // 监听本地端口
                     }
                   }"""

  WriteToFile.write("application.conf",
                    "H:\\WorkSpace\\Z_TEST\\MyShadow\\src\\main\\resources",
                    contents)
}
