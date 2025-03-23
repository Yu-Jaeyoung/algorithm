function mergeSort (
  arr,
  leftIndex : number,
  rightIndex : number,
) {
  if (leftIndex < rightIndex) { // 기저 조건
    let midIndex : number = Math.floor((leftIndex + rightIndex) / 2);
    mergeSort(arr, leftIndex, midIndex);
    mergeSort(arr, midIndex + 1, rightIndex);
    merge(arr, leftIndex, midIndex, rightIndex);
  }
}

function merge (
  arr,
  leftIndex,
  midIndex,
  rightIndex,
) {
  let leftAreaIndex = leftIndex;
  let rightAreaIndex = midIndex + 1;

  let tempArr = [];
  tempArr.length = rightIndex + 1;
  tempArr.fill(0, 0, rightIndex + 1);

  let tempArrIndex = leftIndex;

  while (leftAreaIndex <= midIndex && rightAreaIndex <= rightIndex) {
    if (arr[leftAreaIndex] <= arr[rightAreaIndex]) {
      tempArr[tempArrIndex] = arr[leftAreaIndex++];
    } else {
      tempArr[tempArrIndex] = arr[rightAreaIndex++];
    }
    tempArrIndex++;
  }

  if (leftAreaIndex > midIndex) {
    for (let i = rightAreaIndex; i <= rightIndex; i++) {
      tempArr[tempArrIndex++] = arr[i];
    }
  } else {
    for (let i = leftAreaIndex; i <= midIndex; i++) {
      tempArr[tempArrIndex++] = arr[i];
    }
  }

  for (let i = leftIndex; i <= rightIndex; i++) {
    arr[i] = tempArr[i];
  }
}

let arr = [ 5, 3, 4, 7, 1, 2, 6, 8 ];

console.info("=== 정렬 전 ===");
console.info(arr);

mergeSort(arr, 0, arr.length - 1);

console.info("=== 정렬 후 ===");
console.info(arr);
