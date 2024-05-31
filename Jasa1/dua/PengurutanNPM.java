public class PengurutanNPM {

  public static String bubbleSort(String npm, boolean isAscending) {
    char[] digits = npm.toCharArray();
    int n = digits.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (
          (isAscending && digits[j] > digits[j + 1]) ||
          (!isAscending && digits[j] < digits[j + 1])
        ) {
          char temp = digits[j];
          digits[j] = digits[j + 1];
          digits[j + 1] = temp;
        }
      }
    }
    return new String(digits);
  }

  public static String sortNpm(String npm) {
    char lastDigit = npm.charAt(npm.length() - 1);
    boolean isAscending = (lastDigit - '0') % 2 != 0;
    return bubbleSort(npm, isAscending);
  }

  public static void main(String[] args) {
    String npm = " 22612091196";
    
    System.out.println("NPM " + npm + " setelah pengurutan: " + sortNpm(npm));
  }
}
