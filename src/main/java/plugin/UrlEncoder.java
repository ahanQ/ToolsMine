package plugin;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.jnativehook.NativeInputEvent;
import org.jnativehook.keyboard.NativeKeyEvent;

import util.SlipboardUtils;

/**
 * URL编码的工具，实现了{@link Plugin}的接口，{@link #execute()}方法里实现了将系统剪切板的文本内容进行URL编码的功能。<br/>
 * 主要步骤如下：
 * <li>获取剪切板的内容
 * <li>将获取回来的内容进行URL编码
 * <li>编码好的内容放回剪切板 <br/>
 * 该工具的快捷键为Ctrl+E
 * 
 * @author ahan
 *
 */
public class UrlEncoder implements Plugin {
  public static final int MODIFIERS = NativeInputEvent.CTRL_MASK;
  public static final int KEY = NativeKeyEvent.VC_E;

  public void execute() {
    String contents = SlipboardUtils.getSlipboardContentsAsStringFlavor();
    if (contents != null) {
      try {
        SlipboardUtils.setSlipboardContents(URLEncoder.encode(contents, "UTF-8"));
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      }
    }
  }

}
