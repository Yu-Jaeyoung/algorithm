import sys

input = sys.stdin.readline
from collections import defaultdict

N = int(input())
# book_info = dict()
# value 값(default 값)을 지정할 수 있는 defaultdict
book_info = defaultdict(int)

for _ in range(N):
    name = input()

    # if name not in book_info:
    #     book_info[name] = 1
    # else:
    #     book_info[name] += 1

    # dict을 사용하는 방법
    # book_info[name] = book_info.get(name, 0) + 1

    # defaultdict 를 사용하는 방법
    book_info[name] += 1

sorted_books = sorted(book_info)
cnt = -1
ans = ''

for book_name in sorted_books:
    if book_info[book_name] > cnt:
        cnt = book_info[book_name]
        ans = book_name

print(ans)

