package plugin;

/**
 * 插件接口，添加到注册事件里的插件需要实现的接口，定义了一个执行方法{@link #execute()}。
 * 
 * @author ahan
 *
 */
public abstract class Plugin {

  private int modifiers;
  private int key;

  /**
   * 事件触发时的执行方法，主要实现功能在这个方法里。
   */
  public abstract void execute();

  public Plugin(int modifiers, int key) {
    this.modifiers = modifiers;
    this.key = key;
  }

  public int getModifiers() {
    return modifiers;
  }

  public void setModifiers(int modifiers) {
    this.modifiers = modifiers;
  }

  public int getKey() {
    return key;
  }

  public void setKey(int key) {
    this.key = key;
  }

}
