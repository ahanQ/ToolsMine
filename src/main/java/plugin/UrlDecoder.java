package plugin;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.jnativehook.NativeInputEvent;
import org.jnativehook.keyboard.NativeKeyEvent;

import util.SlipboardUtils;

/**
 * URL解码的工具，实现了{@link Plugin}的接口，{@link #execute()}方法里实现了将系统剪切板的文本内容进行URL解码的功能。<br/>
 * 主要步骤如下：
 * <li>获取剪切板的内容
 * <li>将获取回来的内容进行URL解码
 * <li>编码好的内容放回剪切板 <br/>
 * 该工具的快捷键为Ctrl+D
 * 
 * @author ahan
 *
 */
public class UrlDecoder extends Plugin {

  public UrlDecoder() {
    this(NativeInputEvent.CTRL_MASK, NativeKeyEvent.VC_D);
  }

  public UrlDecoder(int modifiers, int key) {
    super(modifiers, key);
  }

  @Override
  public void execute() {
    String contents = SlipboardUtils.getSlipboardContentsAsStringFlavor();
    if (contents != null) {
      try {
        SlipboardUtils.setSlipboardContents(URLDecoder.decode(contents, "UTF-8"));
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      }
    }
  }
}
