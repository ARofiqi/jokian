function bubbleSort(npm, isAscending) {
  let digits = npm.split("");
  const n = digits.length;
  for (let i = 0; i < n - 1; i++) {
    for (let j = 0; j < n - i - 1; j++) {
      if ((isAscending && digits[j] > digits[j + 1]) || (!isAscending && digits[j] < digits[j + 1])) {
        const temp = digits[j];
        digits[j] = digits[j + 1];
        digits[j + 1] = temp;
      }
    }
  }
  return digits.join("");
}

function sortNpm(npm) {
  const lastDigit = parseInt(npm.charAt(npm.length - 1));
  const isAscending = lastDigit % 2 !== 0;
  return bubbleSort(npm.trim(), isAscending);
}

const npm = " 22612091196";
console.log("NPM " + npm + " setelah pengurutan: " + sortNpm(npm));
