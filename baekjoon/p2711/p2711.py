for _ in range(int(input())):
    index, wrongWord = input().split()
    index = int(index)
    print(wrongWord[:index - 1] + wrongWord[index:])
