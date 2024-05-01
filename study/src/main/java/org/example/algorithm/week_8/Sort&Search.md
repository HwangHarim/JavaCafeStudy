# 정렬 탐색

---

## 1. 정렬

---


### 1-1 버블정렬(bubble sort), 선팩 정렬(selection sort)

> 1. 서로 인접한 두 원소를 검사하여 정렬하는 알고리즘
> 2. 선택 정렬과 기본 개념이 유사하다
> 3. 평균 및 최악 실행 시간: O(n^2), 메모리: O(1)
> ![img.png](https://gmlwjd9405.github.io/images/algorithm-bubble-sort/bubble-sort.png)


- 버블정렬
```java
void bubbleSort(int[] arr) {
    int temp = 0;
	for(int i = 0; i < arr.length - 1; i++) {
		for(int j= 1 ; j < arr.length-i; j++) {
			if(arr[j]<arr[j-1]) {
				temp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = temp;
			}
		}
	}
	System.out.println(Arrays.toString(arr));
}

```

- 선택 정렬

```java
void selectionSort(int[] list) {
    int indexMin, temp;

    for (int i = 0; i < list.length - 1; i++) {
        indexMin = i;
        for (int j = i + 1; j < list.length; j++) {
            if (list[j] < list[indexMin]) {
                indexMin = j;
            }
        }
        temp = list[indexMin];
        list[indexMin] = list[i];
        list[i] = temp;
    }
}
```

### 1-2 병합 정렬(merge sort)

> 1. 하나의 리스트를 두 개의 균등한 크기로 분할 하고 분할된 부분 리스트를 정렬한 다음, 두 개의 정렬된 부분 리스트를 합하여 전체가 정렬된 리스트가 되게 하는방법
> 2. 합병 정렬은 
>       - 분할 : 입력 배열을 같은 크기의 2개의 부분 배열로 분할
>       - 정복 : 부분 배열은 정렬한다. 부분 배열의 크기가 충분히 작지 않으면 순환 호출을 이용하여 다시 정복 방법 적용
>       - 결합 : 정렬된 부분 배열들을 하나의 배열에 병합한다.
> 3. 평균 및 최악 실행 시간: O(n logn), 메모리: 상황에 따라 다름
> ![image](https://gmlwjd9405.github.io/images/algorithm-merge-sort/merge-sort-concepts.png)


````java

void mergesort(int[] array) {
    int[] helper = new int[array.length];
    mergesort(array, helper, 0, array.length - 1);
}

void mergesort(int[] array, int[] helper, int low, int high) {
    if (low < high) {
        int middle = (low + high) / 2;
        mergesort(array, helper, low, middle); // 왼쪽 절반 정렬 
        mergesort(array, helper, middle + 1, high); // 오른쪽 절반 정렬 
        merge(array, helper, low, middle, high); // 병합
    }
}


void merge(int[] array, int[] helper, int low, int middle, int high) {
    /* 절반짜리 두 배열을 helper 배열에 복사한다. */
    for (int i = low; i <= high; i++) {
        helper[i] = array[i];
        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;
        /* helper 배열 순회. 왼쪽 절반과 오른쪽 절반을 비교하여 작은 원소를
         * 원래 배열에 복사해 넣는다. */
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else { // 오른쪽 원소가 왼쪽 원소보다 작으면 
                array[current] = helper[helperRight];
                helperRight++;
            }
            Current++;
        }
    /* 왼쪽 절반 배열에 남은 원소들올 원래 배열에 복사해 넣는다. */
        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        } 
    }
}
````


### 1-3 퀵 정렬

> 1.  무작위로 선정된 한 원소를 사용하여 배열을 분할
> 2. 선정된 원소 보다 작은 원소들은 앞에 , 큰 원소들은 뒤로 보낸다
> 3.  분할에 사용되는 원소가 중간값(median)， 적어도 중간값에
      가까운 값이 되리라는 보장이 없기 때문에， 정렬 알고리즘이 느리게 통작할 수도
      있다.
> 4. 평균 O(n log n), 최악 O(n2). 메모리: O(log n)
> ![image](https://gmlwjd9405.github.io/images/algorithm-quick-sort/quick-sort.png)
```java
void quickSort(int[] arr, int left, int right) {
      int index = partition(arr, left, right);
      if (left < index - 1) { // 왼쪽 절반 정렬 
            quickSort(arr, left, index - 1);
      }
      if (index < right) {
            // 오른쪽 절반 정렬 
            quickSort(arr, index, right);
      }
}

int partition(int[] arr, int left, int right) {
      int pivot = arr[(left + right) / 2]; // 분힐 기준 원소 선정 
      while (left <= right) {
            // 왼쪽에서 오른쪽으로 옮겨야 하는 원소 담색 
            while (arr[left] < pivot) left++;
            // 오른쪽에서 왼쪽으로 옳격야 하는 원소 탐색 
            while (arr[right] > pivot) right--;
            // 원소를 스윌한 뒤 left와 right롤 이동 
            if (left <= right) {
                  swap(arr, left, right); // 스윌 
                  Left++;
                  Right--;
            }
      }
      return left;
}
```

### 1-4 탐색 알고리즘(이진 탐색)

```java

int binarySearch(int[] a, int x) {
      int low = 0;
      int high = a.length - 1;
      int mid;
      while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] < x) {
                  low = mid + 1;
            } else if (a[mid] > x) {
                  high = mid - 1;
            } else {
                  return mid;
            }
      }
      return -1; // 에러
}

int binarySearchRecursive(int[] a, int x, int low, int high) {
      if (low > high) return -1; // 어|러 
      int mid = (low + high) / 2;
      if (a[mid] < x) {
            return binarySearchRecursive(a, x, mid + 1, high);
      } else if (a[mid] > x) {
            return binarySearchRecursive(a, x, low, mid - 1);
      } else {
            return mid;
      }
} 
```