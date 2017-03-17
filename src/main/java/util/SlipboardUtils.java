package util;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * 操作系统剪切板的工具类
 * 
 * @author ahan
 *
 */
public class SlipboardUtils {
  private static Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

  /**
   * 私有构造子，工具类不需要实例化。
   */
  private SlipboardUtils() {
  }

  /**
   * 获取系统剪切板的文本内容
   * 
   * @return 如果系统剪切板内的内容不为文本或在获取过程中出了错，则会返回 null，否则返回相应的文本内容。
   */
  public static String getSlipboardContentsAsStringFlavor() {
    // 获取剪切板中的内容
    Transferable transferable = clipboard.getContents(null);
    if (transferable != null) {
      // 检查内容是否是文本类型
      if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
        try {
          return (String) transferable.getTransferData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }

  /**
   * 将文本的内容设置到系统剪切板
   * 
   * @param contents
   *          需要设置到系统剪切板的内容
   */
  public static void setSlipboardContents(String contents) {
    Transferable transferable = new StringSelection(contents);
    clipboard.setContents(transferable, null);
  }

}
