function InsertionSort (arr) {
  for (let i = 1; i < arr.length; i++) {
    let insertingData = arr[i];
    let j;
    for (j = i - 1; j >= 0; j--) {
      if (arr[j] > insertingData) {
        arr[j + 1] = arr[j];
      } else {
        break;
      }
    }
    arr[j + 1] = insertingData;
  }

  return arr;
}

let arr = [ 5, 3, 4, 1, 2, 6 ];

console.info("=== 정렬 전 ===");
console.info(arr);

InsertionSort(arr)

console.info("=== 정렬 후 ===");
console.info(arr);
