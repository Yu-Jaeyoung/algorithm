for test_case in range(1, int(input()) + 1):
    N = int(input())
    nums = list(map(int, input().split()))

    max_num, min_num = nums[0], nums[0]

    for num in nums:
        if max_num < num:
            max_num = num

        if min_num > num:
            min_num = num

    ans = max_num - min_num
    print(f'#{test_case} {ans}')
