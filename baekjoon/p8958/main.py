import sys

input = sys.stdin.readline

for _ in (range(int(input()))):
    input_values = input().rstrip()
    answer = 0
    count = 0

    for result in input_values:
        if result == 'O':
            count += 1
            answer += count
        elif result == 'X':
            count = 0
    print(answer)
