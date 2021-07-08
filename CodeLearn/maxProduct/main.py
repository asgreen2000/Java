
def mod(n):
    sign = 1
    if n < 0:
        sign = -1
        n = -n
    return sign * (n % 1000000007)

def maxProduct(arr):
    n = len(arr)
    left = [0] * n
    right = [0] * n
    left[0] = arr[0]
    right[n - 1] = arr[n - 1]

    for i in range(1, n):
        left[i] = left[i - 1] * arr[i]
        right[i] = right[n - i] * arr[n - i - 1]

    ans = -1000000007

    for i in range(0, n - 1):
        if (left[i] + right[i + 1]) > ans:
            ans = left[i] + right[i + 1]

    return mod(ans)



if __name__ == "__main__":
    l = [2, 4, 1, 3]
    print(maxProduct((l)))