def max_subarray_sum(arr):
    n = len(arr)
    max_sum = float('-inf')  # Initialize to negative infinity
    for i in range(n):
        current_sum = 0
        for j in range(i, n):
            current_sum += arr[j]  # Add the current element to the sum
            max_sum = max(max_sum, current_sum)  # Update max_sum if needed
    return max_sum

arr = [-5 ,2, -2, 7, -1, 8]
result = max_subarray_sum(arr)
print("Maximum Subarray Sum:", result)
