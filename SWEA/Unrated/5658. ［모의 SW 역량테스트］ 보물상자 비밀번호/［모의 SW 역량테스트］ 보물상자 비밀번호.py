t = int(input())
for test_case in range(1,t+1):
    password_set = set()
    n, k = map(int, input().split())
    numbers = input()
    for i in range(n):
        password_set.add(int(''.join(numbers[j] for j in range(i-n//4, i)), 16))
    print(f"#{test_case} {sorted(list(password_set), reverse=True)[k-1]}")
    
