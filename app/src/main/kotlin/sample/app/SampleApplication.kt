package sample.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.ConfigurableApplicationContext
import java.io.File
import java.lang.management.ManagementFactory
import kotlin.system.exitProcess

@SpringBootApplication
open class SampleApplication : ApplicationContextAware {
    companion object {
        lateinit var args: Array<String>
        lateinit var applicationContext: ConfigurableApplicationContext

        fun restart() {
            val thread = Thread {
                applicationContext.close()

                // 获取Java命令的路径
                val javaPath = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java"

                // 获取JVM参数和主类信息
                val vmArgs = ManagementFactory.getRuntimeMXBean().inputArguments
                val mainClass = System.getProperty("sun.java.command")

                // 构建新的命令
                val processBuilder = ProcessBuilder()
                processBuilder.command(javaPath)

                // 添加JVM参数
                processBuilder.command().addAll(vmArgs)

                // 添加主类名
                processBuilder.command().add("-cp")
                processBuilder.command().add(System.getProperty("java.class.path"))
                processBuilder.command().add(mainClass)
                processBuilder.command().add("restart") // 添加自定义参数

                // 启动新进程
                processBuilder.inheritIO() // 将输入输出继承到当前控制台
                val process = processBuilder.start()

                // 终止当前进程
                exitProcess(0)
            }

            thread.isDaemon = false
            thread.start()
        }
    }

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        SampleApplication.applicationContext = applicationContext as ConfigurableApplicationContext
    }
}

fun main(args: Array<String>) {
    SampleApplication.args = args
    runApplication<SampleApplication>(*args)
}
