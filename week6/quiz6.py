def kmp_search(pattern, text):

    m = len(pattern)
    n = len(text)

    if m == 0:
        return [0]

    if n == 0:
        return []


    f = [0] * m
    j = 0

    for i in range(1, m):
        while j > 0 and pattern[j] != pattern[i]:
            j = f[j - 1]

        if pattern[j] == pattern[i]:
            j += 1

        f[i] = j


    j = 0
    indices = []

    for i in range(n):
        while j > 0 and pattern[j] != text[i]:
            j = f[j - 1]

        if pattern[j] == text[i]:
            j += 1

        if j == m:
            indices.append(i - m + 1)
            j = f[j - 1]

    return indices


