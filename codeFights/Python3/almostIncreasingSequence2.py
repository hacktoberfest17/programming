def almostIncreasingSequence(sequence):
    found = False
    for i in range(1, len(sequence)):
        if sequence[i] <= sequence[i - 1]:
            if found:
                return False
            found = True

            if i == 1 or i == len(sequence) - 1:
                continue
            elif sequence[i] > sequence[i - 2]:
                sequence[i - 1] = sequence[i - 2]
            elif sequence[i - 1] >= sequence[i + 1]:
                return False

    return True
