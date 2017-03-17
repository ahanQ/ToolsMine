package main;

import org.jnativehook.NativeInputEvent;
import org.jnativehook.keyboard.NativeKeyAdapter;
import org.jnativehook.keyboard.NativeKeyEvent;

import manager.Manager;

/**
 * 利用jnativehook实现的键盘监听，当键盘事件发生时回调插件管理，从而调用相应的插件。
 * 
 * @author ahan
 *
 */
public class NativeHook extends NativeKeyAdapter {

  public static final Manager manager = new Manager();

  @Override
  public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
    String modifiersText = NativeInputEvent.getModifiersText(nativeEvent.getModifiers());
    String keyText = NativeKeyEvent.getKeyText((nativeEvent.getKeyCode()));
    manager.execute(modifiersText + "+" + keyText);
  }

}
