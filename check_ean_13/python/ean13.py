def check_ean(code: str) -> bool:
    digits = [int(x) for x in code]
    return not (sum(digits[::2]) + 3 * sum(digits[1::2])) % 10
