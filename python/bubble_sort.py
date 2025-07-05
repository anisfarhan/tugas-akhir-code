def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        for j in range(0, n-i-1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]

def main():
    # int(input("Enter the number of elements: "))
    int(input())
    # arr = list(map(int, input("Enter the elements: ").split()))
    arr = list(map(int, input().split()))

    bubble_sort(arr)

    # print("Sorted array: ")
    print(*arr)

if __name__ == "__main__":
    main()