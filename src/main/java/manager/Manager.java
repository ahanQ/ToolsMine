package manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.keyboard.NativeKeyEvent;

import plugin.Plugin;
import plugin.UrlDecoder;
import plugin.UrlEncoder;
import util.PackageUtils;

/**
 * 插件管理类
 * 
 * @author ahan
 *
 */
public class Manager {
  /**
   * 插件持有的Map对象，键(Key)为插件的快捷键(如Ctrl+E，为CtrlE)的String值，值(value)为相应的{@link Plugin}插件对象。
   */
  private static final Map<String, Plugin> PLUGIN = new HashMap<String, Plugin>();

  /**
   * 注册插件方法
   */
  public static void register() {
    String packname = Plugin.class.getPackage().getName();
    Set<Class<?>> clazzs = PackageUtils.findFileClass(packname);
    for (Class<?> clazz : clazzs) {
      if (Plugin.class.isAssignableFrom(clazz)
          && !StringUtils.equals(Plugin.class.getName(), clazz.getName())) {
        // TODO 做注册插件功能
        // System.out.println(clazz.getName());
      }
    }

    // FIXME 完善注册插件功能后删除添加插件的临时代码
    PLUGIN.put(NativeInputEvent.getModifiersText(UrlEncoder.MODIFIERS) + "+"
        + NativeKeyEvent.getKeyText(UrlEncoder.KEY), new UrlEncoder());
    PLUGIN.put(NativeInputEvent.getModifiersText(UrlDecoder.MODIFIERS) + "+"
        + NativeKeyEvent.getKeyText(UrlDecoder.KEY), new UrlDecoder());
  }

  /**
   * 回调相应的插件
   * 
   * @param order
   */
  public void execute(String order) {
    Plugin plugin = PLUGIN.get(order);
    if (plugin == null)
      return;
    plugin.execute();
  }

}
