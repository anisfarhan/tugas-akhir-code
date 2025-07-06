import random

n = input()
min_val = 0
max_val = 1000

numbers = [random.randint(min_val, max_val) for _ in range(int(n))]

print(n)
print(" ".join(map(str, numbers)))