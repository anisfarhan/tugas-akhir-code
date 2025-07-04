def search(text, pattern):
    n = len(text)
    m = len(pattern)
    for i in range(n - m + 1):
        for j in range(m):
            if text[i + j] != pattern[j]:
                break
        else:
            return i
    return -1

if __name__ == "__main__":
    text = input("Enter a text to search in: ")
    pattern = input("Enter a pattern to search for: ")
    result = search(text, pattern)
    if result != -1:
        print(f"Pattern found at index: {result}")
    else:
        print("Pattern not found.")