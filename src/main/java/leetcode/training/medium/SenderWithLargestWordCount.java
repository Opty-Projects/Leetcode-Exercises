package leetcode.training.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/sender-with-largest-word-count/
public class SenderWithLargestWordCount {

  public String largestWordCount(String[] messages, String[] senders) {
    Map<String, Integer> lengthTable = new HashMap<>();

    String sender = null;
    int maxLength = 0;
    for (int i = 0; i < messages.length; i++) {
      int length = messages[i].length() > 0 ? 1 : 0;
      for (char c : messages[i].toCharArray()) if (c == ' ') length++;

      int senderLength = length + lengthTable.getOrDefault(senders[i], 0);
      lengthTable.put(senders[i], senderLength);

      if (senderLength > maxLength
          || (senderLength == maxLength && (sender == null || sender.compareTo(senders[i]) < 0))) {
        sender = senders[i];
        maxLength = senderLength;
      }
    }

    return sender;
  }
}
