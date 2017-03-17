package plugin;

/**
 * 插件接口，添加到注册事件里的插件需要实现的接口，定义了一个执行方法{@link #execute()}。
 * 
 * @author ahan
 *
 */
public interface Plugin {
  /**
   * 事件触发时的执行方法，主要实现功能在这个方法里。
   */
  void execute();
}
