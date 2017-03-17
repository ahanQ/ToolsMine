package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import manager.Manager;

/**
 * 这是一套系统的键盘监听的工具，可以自由地将插件添加到本工具中。监听键盘事件从而实现你想要的功能。<br/>
 * 这是整个程序的入口
 * 
 * @version 1.0
 * @author ahan
 *
 */
public class Starter {
  // 获取"org.jnativehook"的logger
  private static final Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
  static {
    // 将logger设置为warning级别
    logger.setLevel(Level.OFF);
    logger.setUseParentHandlers(false);
  }

  public static void main(String[] args) {

    // 启用线程池
    ExecutorService executors = Executors.newFixedThreadPool(1);

    // 线程池开始运行
    executors.execute(new Runnable() {

      public void run() {
        try {
          GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
          System.err.println("There was a problem registering the native hook.");
          System.err.println(ex.getMessage());
          System.exit(1);
        }
        Manager.register();
        GlobalScreen.addNativeKeyListener(new NativeHook());
      }
    });

  }

}
