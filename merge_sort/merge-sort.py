def merge(s1, s2, s):
    i = j = 0

    while i + j < len(s):
        if j == len(s2) or (i < len(s1) and s1[i] < s2[j]):
            s[i+j] = s1[i]              # ith of S1 as next item of S
            i += 1
        else:
            s[i+j] = s2[j]              # jth of S2 as next item of S
            j += 1

def merge_sort(s):
    n = len(s)
    if n<2:
        return              # already sorted
    # divide
    mid = n //2
    s1 = s[0:mid]
    s2 = s[mid:n]
    # conquer  - recursive
    merge_sort(s1)
    merge_sort(s2)

    merge(s1,s2,s)          # merge halfs back to s

array = [5,6,2,4,3,1,0,0]
print("before:", array)
merge_sort(array)
print("sorted:", array)
